// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Deleteable, OnPauseListener, OnResumeListener, 
//            ComponentContainer, Form, EventDispatcher

public class GyroscopeSensor extends AndroidNonvisibleComponent
    implements SensorEventListener, Deleteable, OnPauseListener, OnResumeListener
{

    private boolean enabled;
    private final Sensor gyroSensor;
    private boolean listening;
    private final SensorManager sensorManager;
    private float xAngularVelocity;
    private float yAngularVelocity;
    private float zAngularVelocity;

    public GyroscopeSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        sensorManager = (SensorManager)form.getSystemService("sensor");
        gyroSensor = sensorManager.getDefaultSensor(4);
        form.registerForOnResume(this);
        form.registerForOnPause(this);
        Enabled(true);
    }

    private void startListening()
    {
        if (!listening)
        {
            sensorManager.registerListener(this, gyroSensor, 0);
            listening = true;
        }
    }

    private void stopListening()
    {
        if (listening)
        {
            sensorManager.unregisterListener(this);
            listening = false;
            xAngularVelocity = 0.0F;
            yAngularVelocity = 0.0F;
            zAngularVelocity = 0.0F;
        }
    }

    public boolean Available()
    {
        return sensorManager.getSensorList(4).size() > 0;
    }

    public void Enabled(boolean flag)
    {
label0:
        {
            if (enabled != flag)
            {
                enabled = flag;
                if (!flag)
                {
                    break label0;
                }
                startListening();
            }
            return;
        }
        stopListening();
    }

    public boolean Enabled()
    {
        return enabled;
    }

    public void GyroscopeChanged(float f, float f1, float f2, long l)
    {
        EventDispatcher.dispatchEvent(this, "GyroscopeChanged", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2), Long.valueOf(l)
        });
    }

    public float XAngularVelocity()
    {
        return xAngularVelocity;
    }

    public float YAngularVelocity()
    {
        return yAngularVelocity;
    }

    public float ZAngularVelocity()
    {
        return zAngularVelocity;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onDelete()
    {
        stopListening();
    }

    public void onPause()
    {
        stopListening();
    }

    public void onResume()
    {
        if (enabled)
        {
            startListening();
        }
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        if (enabled)
        {
            xAngularVelocity = (float)Math.toDegrees(sensorevent.values[0]);
            yAngularVelocity = (float)Math.toDegrees(sensorevent.values[1]);
            zAngularVelocity = (float)Math.toDegrees(sensorevent.values[2]);
            GyroscopeChanged(xAngularVelocity, yAngularVelocity, zAngularVelocity, sensorevent.timestamp);
        }
    }
}
