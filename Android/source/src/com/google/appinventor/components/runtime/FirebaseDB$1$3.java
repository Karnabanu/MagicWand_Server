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

class val.snapshot
    implements Runnable
{

    final val.snapshot this$1;
    final DataSnapshot val$snapshot;

    public void run()
    {
        DataChanged(val$snapshot.getKey(), val$snapshot.getValue());
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$snapshot = DataSnapshot.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/FirebaseDB$1

/* anonymous class */
    class FirebaseDB._cls1
        implements ChildEventListener
    {

        final FirebaseDB this$0;

        public void onCancelled(final FirebaseError error)
        {
            FirebaseDB.access$000(FirebaseDB.this).post(new FirebaseDB._cls1._cls2());
        }

        public void onChildAdded(final DataSnapshot snapshot, String s)
        {
            FirebaseDB.access$000(FirebaseDB.this).post(new FirebaseDB._cls1._cls1());
        }

        public void onChildChanged(DataSnapshot datasnapshot, String s)
        {
            FirebaseDB.access$000(FirebaseDB.this).post(datasnapshot. new FirebaseDB._cls1._cls3());
        }

        public void onChildMoved(DataSnapshot datasnapshot, String s)
        {
        }

        public void onChildRemoved(final DataSnapshot snapshot)
        {
            FirebaseDB.access$000(FirebaseDB.this).post(new FirebaseDB._cls1._cls4());
        }

            
            {
                this$0 = FirebaseDB.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/FirebaseDB$1$1

/* anonymous class */
        class FirebaseDB._cls1._cls1
            implements Runnable
        {

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
        }


        // Unreferenced inner class com/google/appinventor/components/runtime/FirebaseDB$1$2

/* anonymous class */
        class FirebaseDB._cls1._cls2
            implements Runnable
        {

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
        }


        // Unreferenced inner class com/google/appinventor/components/runtime/FirebaseDB$1$4

/* anonymous class */
        class FirebaseDB._cls1._cls4
            implements Runnable
        {

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
        }

    }

}
