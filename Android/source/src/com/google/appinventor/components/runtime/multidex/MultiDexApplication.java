// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.multidex;

import android.app.Application;
import android.content.Context;

// Referenced classes of package com.google.appinventor.components.runtime.multidex:
//            MultiDex

public class MultiDexApplication extends Application
{

    public static boolean installed = false;

    public MultiDexApplication()
    {
    }

    protected void attachBaseContext(Context context)
    {
        super.attachBaseContext(context);
        MultiDex.install(this, true);
    }

}
