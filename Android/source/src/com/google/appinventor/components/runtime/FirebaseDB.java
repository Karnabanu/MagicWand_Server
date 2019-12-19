// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, Notifier, 
//            EventDispatcher

public class FirebaseDB extends AndroidNonvisibleComponent
    implements Component
{

    private static final String LOG_TAG = "Firebase";
    private final Activity activity;
    private Handler androidUIHandler;
    private com.firebase.client.Firebase.AuthStateListener authListener;
    private ChildEventListener childListener;
    private String defaultURL;
    private String developerBucket;
    private String firebaseToken;
    private String firebaseURL;
    private Firebase myFirebase;
    private String projectBucket;
    private boolean useDefault;

    public FirebaseDB(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        firebaseURL = null;
        defaultURL = null;
        useDefault = true;
        androidUIHandler = new Handler();
        activity = componentcontainer.$context();
        Firebase.setAndroidContext(activity);
        developerBucket = "";
        projectBucket = "";
        firebaseToken = "";
        childListener = new ChildEventListener() {

            final FirebaseDB this$0;

            public void onCancelled(FirebaseError firebaseerror)
            {
                androidUIHandler.post(firebaseerror. new Runnable() {

                    final _cls1 this$1;
                    final FirebaseError val$error;

                    public void run()
                    {
                        FirebaseDB.this.FirebaseError(error.getMessage());
                    }

            
            {
                this$1 = final__pcls1;
                error = FirebaseError.this;
                super();
            }
                });
            }

            public void onChildAdded(DataSnapshot datasnapshot, String s)
            {
                androidUIHandler.post(datasnapshot. new Runnable() {

                    final _cls1 this$1;
                    final DataSnapshot val$snapshot;

                    public void run()
                    {
                        DataChanged(snapshot.getKey(), snapshot.getValue());
                    }

            
            {
                this$1 = final__pcls1;
                snapshot = DataSnapshot.this;
                super();
            }
                });
            }

            public void onChildChanged(DataSnapshot datasnapshot, String s)
            {
                androidUIHandler.post(datasnapshot. new Runnable() {

                    final _cls1 this$1;
                    final DataSnapshot val$snapshot;

                    public void run()
                    {
                        DataChanged(snapshot.getKey(), snapshot.getValue());
                    }

            
            {
                this$1 = final__pcls1;
                snapshot = DataSnapshot.this;
                super();
            }
                });
            }

            public void onChildMoved(DataSnapshot datasnapshot, String s)
            {
            }

            public void onChildRemoved(DataSnapshot datasnapshot)
            {
                androidUIHandler.post(datasnapshot. new Runnable() {

                    final _cls1 this$1;
                    final DataSnapshot val$snapshot;

                    public void run()
                    {
                        DataChanged(snapshot.getKey(), null);
                    }

            
            {
                this$1 = final__pcls1;
                snapshot = DataSnapshot.this;
                super();
            }
                });
            }

            
            {
                this$0 = FirebaseDB.this;
                super();
            }
        };
        authListener = new com.firebase.client.Firebase.AuthStateListener() {

            final FirebaseDB this$0;

            public void onAuthStateChanged(AuthData authdata)
            {
                Log.i("Firebase", (new StringBuilder()).append("onAuthStateChanged: data = ").append(authdata).toString());
                if (authdata == null)
                {
                    myFirebase.authWithCustomToken(firebaseToken, new com.firebase.client.Firebase.AuthResultHandler() {

                        final _cls2 this$1;

                        public void onAuthenticated(AuthData authdata)
                        {
                            Log.i("Firebase", "Auth Successful.");
                        }

                        public void onAuthenticationError(FirebaseError firebaseerror)
                        {
                            Log.e("Firebase", (new StringBuilder()).append("Auth Failed: ").append(firebaseerror.getMessage()).toString());
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = FirebaseDB.this;
                super();
            }
        };
    }

    private void connectFirebase()
    {
        if (SdkLevel.getLevel() < 10)
        {
            Notifier.oneButtonAlert(activity, "The version of Android on this device is too old to use Firebase.", "Android Too Old", "OK");
            return;
        }
        if (useDefault)
        {
            myFirebase = new Firebase((new StringBuilder()).append(firebaseURL).append("developers/").append(developerBucket).append(projectBucket).toString());
        } else
        {
            myFirebase = new Firebase((new StringBuilder()).append(firebaseURL).append(projectBucket).toString());
        }
        myFirebase.addChildEventListener(childListener);
        myFirebase.addAuthStateListener(authListener);
    }

    private void resetListener()
    {
        if (myFirebase != null)
        {
            myFirebase.removeEventListener(childListener);
            myFirebase.removeAuthStateListener(authListener);
        }
        myFirebase = null;
        connectFirebase();
    }

    public void DataChanged(String s, Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = obj;
            try
            {
                if (obj instanceof String)
                {
                    obj1 = JsonUtil.getObjectFromJson((String)obj);
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new YailRuntimeError("Value failed to convert from JSON.", "JSON Retrieval Error.");
            }
        }
        EventDispatcher.dispatchEvent(this, "DataChanged", new Object[] {
            s, obj1
        });
    }

    public void DefaultURL(String s)
    {
        defaultURL = s;
        if (useDefault)
        {
            firebaseURL = defaultURL;
            resetListener();
        }
    }

    public String DeveloperBucket()
    {
        return developerBucket;
    }

    public void DeveloperBucket(String s)
    {
        developerBucket = s;
        resetListener();
    }

    public void FirebaseError(String s)
    {
        Log.e("Firebase", s);
        EventDispatcher.dispatchEvent(this, "FirebaseError", new Object[] {
            s
        });
    }

    public String FirebaseToken()
    {
        return firebaseToken;
    }

    public void FirebaseToken(String s)
    {
        firebaseToken = s;
        resetListener();
    }

    public String FirebaseURL()
    {
        if (useDefault)
        {
            return "DEFAULT";
        } else
        {
            return firebaseURL;
        }
    }

    public void FirebaseURL(String s)
    {
        if (!s.equals("DEFAULT")) goto _L2; else goto _L1
_L1:
        if (useDefault) goto _L4; else goto _L3
_L3:
        useDefault = true;
        if (defaultURL != null) goto _L6; else goto _L5
_L5:
        Log.d("Firebase", "FirebaseURL called before DefaultURL (should not happen!)");
_L8:
        return;
_L6:
        firebaseURL = defaultURL;
        resetListener();
        return;
_L4:
        firebaseURL = defaultURL;
        return;
_L2:
        useDefault = false;
        if (!firebaseURL.equals(s))
        {
            firebaseURL = s;
            useDefault = false;
            resetListener();
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void GetValue(final String tag, final Object valueIfTagNotThere)
    {
        myFirebase.child(tag).addListenerForSingleValueEvent(new ValueEventListener() {

            final FirebaseDB this$0;
            final String val$tag;
            final Object val$valueIfTagNotThere;

            public void onCancelled(FirebaseError firebaseerror)
            {
                androidUIHandler.post(firebaseerror. new Runnable() {

                    final _cls3 this$1;
                    final FirebaseError val$error;

                    public void run()
                    {
                        FirebaseDB.this.FirebaseError(error.getMessage());
                    }

            
            {
                this$1 = final__pcls3;
                error = FirebaseError.this;
                super();
            }
                });
            }

            public void onDataChange(DataSnapshot datasnapshot)
            {
                AtomicReference atomicreference = new AtomicReference();
                if (!datasnapshot.exists()) goto _L2; else goto _L1
_L1:
                atomicreference.set(datasnapshot.getValue());
_L4:
                androidUIHandler.post(atomicreference. new Runnable() {

                    final _cls3 this$1;
                    final AtomicReference val$value;

                    public void run()
                    {
                        GotValue(tag, value.get());
                    }

            
            {
                this$1 = final__pcls3;
                value = AtomicReference.this;
                super();
            }
                });
                return;
_L2:
                try
                {
                    atomicreference.set(JsonUtil.getJsonRepresentation(valueIfTagNotThere));
                }
                // Misplaced declaration of an exception variable
                catch (DataSnapshot datasnapshot)
                {
                    throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = FirebaseDB.this;
                valueIfTagNotThere = obj;
                tag = s;
                super();
            }
        });
    }

    public void GotValue(String s, Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = obj;
            try
            {
                if (obj instanceof String)
                {
                    obj1 = JsonUtil.getObjectFromJson((String)obj);
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new YailRuntimeError("Value failed to convert from JSON.", "JSON Retrieval Error.");
            }
        }
        EventDispatcher.dispatchEvent(this, "GotValue", new Object[] {
            s, obj1
        });
    }

    public String ProjectBucket()
    {
        return projectBucket;
    }

    public void ProjectBucket(String s)
    {
        if (!projectBucket.equals(s))
        {
            projectBucket = s;
            resetListener();
        }
    }

    public void StoreValue(String s, Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            try
            {
                obj1 = JsonUtil.getJsonRepresentation(obj);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
            }
        }
        myFirebase.child(s).setValue(obj1);
    }

    public void Unauthenticate()
    {
        if (myFirebase == null)
        {
            connectFirebase();
        }
        myFirebase.unauth();
    }



}
