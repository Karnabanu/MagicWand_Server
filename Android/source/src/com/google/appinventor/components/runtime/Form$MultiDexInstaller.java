// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.AsyncTask;
import android.util.Log;
import com.google.appinventor.components.runtime.multidex.MultiDex;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Form

private static class <init> extends AsyncTask
{

    Form ourForm;

    protected transient Boolean doInBackground(Form aform[])
    {
        ourForm = aform[0];
        Log.d("Form", "Doing Full MultiDex Install");
        MultiDex.install(ourForm, true);
        return Boolean.valueOf(true);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Form[])aobj);
    }

    protected void onPostExecute(Boolean boolean1)
    {
        ourForm.onCreateFinish();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
