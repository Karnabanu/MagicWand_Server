// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, Form

public final class Image extends AndroidViewComponent
{

    private String picturePath;
    private double rotationAngle;
    private int scalingMode;
    private final ImageView view;

    public Image(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        picturePath = "";
        rotationAngle = 0.0D;
        scalingMode = 0;
        view = new ImageView(componentcontainer.$context()) {

            final Image this$0;

            public boolean verifyDrawable(Drawable drawable)
            {
                super.verifyDrawable(drawable);
                return true;
            }

            
            {
                this$0 = Image.this;
                super(context);
            }
        };
        view.setFocusable(true);
        componentcontainer.$add(this);
    }

    public void Animation(String s)
    {
        AnimationUtil.ApplyAnimation(view, s);
    }

    public String Picture()
    {
        return picturePath;
    }

    public void Picture(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        picturePath = s1;
        try
        {
            s = MediaUtil.getBitmapDrawable(container.$form(), picturePath);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Image", (new StringBuilder()).append("Unable to load ").append(picturePath).toString());
            s = null;
        }
        ViewUtil.setImage(view, s);
    }

    public double RotationAngle()
    {
        return rotationAngle;
    }

    public void RotationAngle(double d)
    {
        if (rotationAngle == d)
        {
            return;
        }
        if (SdkLevel.getLevel() < 11)
        {
            container.$form().dispatchErrorOccurredEvent(this, "RotationAngle", 3001, new Object[0]);
            return;
        } else
        {
            HoneycombUtil.viewSetRotate(view, d);
            rotationAngle = d;
            return;
        }
    }

    public void ScalePictureToFit(boolean flag)
    {
        if (flag)
        {
            view.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            return;
        } else
        {
            view.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
            return;
        }
    }

    public int Scaling()
    {
        return scalingMode;
    }

    public void Scaling(int i)
    {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 51
    //                   1 67;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentError((new StringBuilder()).append("Illegal scaling mode: ").append(i).toString());
_L2:
        view.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
_L5:
        scalingMode = i;
        return;
_L3:
        view.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public View getView()
    {
        return view;
    }
}
