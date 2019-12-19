// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

// Referenced classes of package com.google.appinventor.components.runtime:
//            FirebaseDB

class this._cls1
    implements com.firebase.client.sultHandler
{

    final this._cls1 this$1;

    public void onAuthenticated(AuthData authdata)
    {
        Log.i("Firebase", "Auth Successful.");
    }

    public void onAuthenticationError(FirebaseError firebaseerror)
    {
        Log.e("Firebase", (new StringBuilder()).append("Auth Failed: ").append(firebaseerror.getMessage()).toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/FirebaseDB$2

/* anonymous class */
    class FirebaseDB._cls2
        implements com.firebase.client.Firebase.AuthStateListener
    {

        final FirebaseDB this$0;

        public void onAuthStateChanged(AuthData authdata)
        {
            Log.i("Firebase", (new StringBuilder()).append("onAuthStateChanged: data = ").append(authdata).toString());
            if (authdata == null)
            {
                FirebaseDB.access$200(FirebaseDB.this).authWithCustomToken(FirebaseDB.access$100(FirebaseDB.this), new FirebaseDB._cls2._cls1());
            }
        }

            
            {
                this$0 = FirebaseDB.this;
                super();
            }
    }

}
