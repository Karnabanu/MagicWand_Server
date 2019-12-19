// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.JsonUtil;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            FirebaseDB

class val.tag
    implements ValueEventListener
{

    final FirebaseDB this$0;
    final String val$tag;
    final Object val$valueIfTagNotThere;

    public void onCancelled(final FirebaseError error)
    {
        FirebaseDB.access$000(FirebaseDB.this).post(new Runnable() {

            final FirebaseDB._cls3 this$1;
            final FirebaseError val$error;

            public void run()
            {
                FirebaseDB.this.FirebaseError(error.getMessage());
            }

            
            {
                this$1 = FirebaseDB._cls3.this;
                error = firebaseerror;
                super();
            }
        });
    }

    public void onDataChange(DataSnapshot datasnapshot)
    {
        final AtomicReference value = new AtomicReference();
        if (!datasnapshot.exists()) goto _L2; else goto _L1
_L1:
        value.set(datasnapshot.getValue());
_L4:
        FirebaseDB.access$000(FirebaseDB.this).post(new Runnable() {

            final FirebaseDB._cls3 this$1;
            final AtomicReference val$value;

            public void run()
            {
                GotValue(tag, value.get());
            }

            
            {
                this$1 = FirebaseDB._cls3.this;
                value = atomicreference;
                super();
            }
        });
        return;
_L2:
        try
        {
            value.set(JsonUtil.getJsonRepresentation(val$valueIfTagNotThere));
        }
        // Misplaced declaration of an exception variable
        catch (DataSnapshot datasnapshot)
        {
            throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    _cls2.val.error()
    {
        this$0 = final_firebasedb;
        val$valueIfTagNotThere = obj;
        val$tag = String.this;
        super();
    }
}
