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

class this._cls0
    implements com.firebase.client.StateListener
{

    final FirebaseDB this$0;

    public void onAuthStateChanged(AuthData authdata)
    {
        Log.i("Firebase", (new StringBuilder()).append("onAuthStateChanged: data = ").append(authdata).toString());
        if (authdata == null)
        {
            FirebaseDB.access$200(FirebaseDB.this).authWithCustomToken(FirebaseDB.access$100(FirebaseDB.this), new com.firebase.client.Firebase.AuthResultHandler() {

                final FirebaseDB._cls2 this$1;

                public void onAuthenticated(AuthData authdata1)
                {
                    Log.i("Firebase", "Auth Successful.");
                }

                public void onAuthenticationError(FirebaseError firebaseerror)
                {
                    Log.e("Firebase", (new StringBuilder()).append("Auth Failed: ").append(firebaseerror.getMessage()).toString());
                }

            
            {
                this$1 = FirebaseDB._cls2.this;
                super();
            }
            });
        }
    }

    _cls1.this._cls1()
    {
        this$0 = FirebaseDB.this;
        super();
    }
}
