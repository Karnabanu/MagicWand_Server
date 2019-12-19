// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.common.version;


public final class GitBuildId
{

    public static final String ACRA_URI = "${acra.uri}";
    public static final String ANT_BUILD_DATE = "February 17 2016";
    public static final String GIT_BUILD_FINGERPRINT = "25fa081c20d12eecd8fc774e361a3745b2c151d0";
    public static final String GIT_BUILD_VERSION = "nb147";

    private GitBuildId()
    {
    }

    public static String getAcraUri()
    {
        if ("${acra.uri}".equals("${acra.uri}"))
        {
            return "";
        } else
        {
            return "${acra.uri}".trim();
        }
    }

    public static String getDate()
    {
        return "February 17 2016";
    }

    public static String getFingerprint()
    {
        return "25fa081c20d12eecd8fc774e361a3745b2c151d0";
    }

    public static String getVersion()
    {
        String s = "nb147";
        if ("nb147" == "" || "nb147".contains(" "))
        {
            s = "none";
        }
        return s;
    }
}
