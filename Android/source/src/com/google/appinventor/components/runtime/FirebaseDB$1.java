// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;

// Referenced classes of package com.google.appinventor.components.runtime:
//            FirebaseDB

class this._cls0
    implements ChildEventListener
{

    final FirebaseDB this$0;

    public void onCancelled(final FirebaseError error)
    {
        FirebaseDB.access$000(FirebaseDB.this).post(new Runnable() {

            final FirebaseDB._cls1 this$1;
            final FirebaseError val$error;

            public void run()
            {
                FirebaseDB.this.FirebaseError(error.getMessage());
            }

            
            {
                this$1 = FirebaseDB._cls1.this;
                error = firebaseerror;
                super();
            }
        });
    }

    public void onChildAdded(final DataSnapshot snapshot, String s)
    {
        FirebaseDB.access$000(FirebaseDB.this).post(new Runnable() {

            final FirebaseDB._cls1 this$1;
            final DataSnapshot val$snapshot;

            public void run()
            {
                DataChanged(snapshot.getKey(), snapshot.getValue());
            }

            
            {
                this$1 = FirebaseDB._cls1.this;
                snapshot = datasnapshot;
                super();
            }
        });
    }

    public void onChildChanged(final DataSnapshot snapshot, String s)
    {
        FirebaseDB.access$000(FirebaseDB.this).post(new Runnable() {

            final FirebaseDB._cls1 this$1;
            final DataSnapshot val$snapshot;

            public void run()
            {
                DataChanged(snapshot.getKey(), snapshot.getValue());
            }

            
            {
                this$1 = FirebaseDB._cls1.this;
                snapshot = datasnapshot;
                super();
            }
        });
    }

    public void onChildMoved(DataSnapshot datasnapshot, String s)
    {
    }

    public void onChildRemoved(final DataSnapshot snapshot)
    {
        FirebaseDB.access$000(FirebaseDB.this).post(new Runnable() {

            final FirebaseDB._cls1 this$1;
            final DataSnapshot val$snapshot;

            public void run()
            {
                DataChanged(snapshot.getKey(), null);
            }

            
            {
                this$1 = FirebaseDB._cls1.this;
                snapshot = datasnapshot;
                super();
            }
        });
    }

    _cls4.val.snapshot()
    {
        this$0 = FirebaseDB.this;
        super();
    }
}
