// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class Dates
{

    public static final int DATE_APRIL = 3;
    public static final int DATE_AUGUST = 7;
    public static final int DATE_DAY = 5;
    public static final int DATE_DECEMBER = 11;
    public static final int DATE_FEBRUARY = 1;
    public static final int DATE_FRIDAY = 6;
    public static final int DATE_HOUR = 11;
    public static final int DATE_JANUARY = 0;
    public static final int DATE_JULY = 6;
    public static final int DATE_JUNE = 5;
    public static final int DATE_MARCH = 2;
    public static final int DATE_MAY = 4;
    public static final int DATE_MILLISECOND = 14;
    public static final int DATE_MINUTE = 12;
    public static final int DATE_MONDAY = 2;
    public static final int DATE_MONTH = 2;
    public static final int DATE_NOVEMBER = 10;
    public static final int DATE_OCTOBER = 9;
    public static final int DATE_SATURDAY = 7;
    public static final int DATE_SECOND = 13;
    public static final int DATE_SEPTEMBER = 8;
    public static final int DATE_SUNDAY = 1;
    public static final int DATE_THURSDAY = 5;
    public static final int DATE_TUESDAY = 3;
    public static final int DATE_WEDNESDAY = 4;
    public static final int DATE_WEEK = 3;
    public static final int DATE_YEAR = 1;

    private Dates()
    {
    }

    public static long ConvertDuration(long l, int i)
    {
        switch (i)
        {
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        default:
            throw new IllegalArgumentException("illegal date/time interval kind in function Duration()");

        case 3: // '\003'
            return l / 1000L / 60L / 60L / 24L / 7L;

        case 5: // '\005'
            return l / 1000L / 60L / 60L / 24L;

        case 11: // '\013'
            return l / 1000L / 60L / 60L;

        case 12: // '\f'
            return l / 1000L / 60L;

        case 13: // '\r'
            return l / 1000L;
        }
    }

    public static void DateAdd(Calendar calendar, int i, int j)
    {
        switch (i)
        {
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        default:
            throw new IllegalArgumentException("illegal date/time interval kind in function DateAdd()");

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 5: // '\005'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
            calendar.add(i, j);
            break;
        }
    }

    public static void DateAddInMillis(Calendar calendar, long l)
    {
        calendar.setTimeInMillis(calendar.getTimeInMillis() + l);
    }

    public static Calendar DateInstant(int i, int j, int k)
    {
        String s1 = String.valueOf(j);
        String s2 = String.valueOf(k);
        String s = s1;
        if (j < 10)
        {
            s = (new StringBuilder()).append("0").append(s1).toString();
        }
        s1 = s2;
        if (k < 10)
        {
            s1 = (new StringBuilder()).append("0").append(s2).toString();
        }
        return DateValue((new StringBuilder()).append(s).append("/").append(s1).append("/").append(String.valueOf(i)).toString());
    }

    public static Calendar DateValue(String s)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        try
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            simpledateformat.setLenient(true);
            gregoriancalendar.setTime(simpledateformat.parse(s));
        }
        catch (ParseException parseexception)
        {
            try
            {
                SimpleDateFormat simpledateformat1 = new SimpleDateFormat("MM/dd/yyyy");
                simpledateformat1.setLenient(true);
                gregoriancalendar.setTime(simpledateformat1.parse(s));
            }
            catch (ParseException parseexception1)
            {
                try
                {
                    SimpleDateFormat simpledateformat2 = new SimpleDateFormat("HH:mm");
                    simpledateformat2.setLenient(true);
                    gregoriancalendar.setTime(simpledateformat2.parse(s));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new IllegalArgumentException("illegal date/time format in function DateValue()");
                }
                return gregoriancalendar;
            }
            return gregoriancalendar;
        }
        return gregoriancalendar;
    }

    public static int Day(Calendar calendar)
    {
        return calendar.get(5);
    }

    public static String FormatDate(Calendar calendar, String s)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat();
        if (s.length() == 0)
        {
            simpledateformat.applyPattern("MMM d, yyyy");
        } else
        {
            simpledateformat.applyPattern(s);
        }
        return simpledateformat.format(calendar.getTime());
    }

    public static String FormatDateTime(Calendar calendar, String s)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat();
        if (s.length() == 0)
        {
            simpledateformat.applyPattern("MMM d, yyyy HH:mm:ss a");
        } else
        {
            simpledateformat.applyPattern(s);
        }
        return simpledateformat.format(calendar.getTime());
    }

    public static String FormatTime(Calendar calendar)
    {
        return DateFormat.getTimeInstance(2).format(calendar.getTime());
    }

    public static int Hour(Calendar calendar)
    {
        return calendar.get(11);
    }

    public static int Minute(Calendar calendar)
    {
        return calendar.get(12);
    }

    public static int Month(Calendar calendar)
    {
        return calendar.get(2);
    }

    public static String MonthName(Calendar calendar)
    {
        return String.format("%1$tB", new Object[] {
            calendar
        });
    }

    public static Calendar Now()
    {
        return new GregorianCalendar();
    }

    public static int Second(Calendar calendar)
    {
        return calendar.get(13);
    }

    public static Calendar TimeInstant(int i, int j)
    {
        String s1 = String.valueOf(i);
        String s2 = String.valueOf(j);
        String s = s1;
        if (i < 10)
        {
            s = (new StringBuilder()).append("0").append(s1).toString();
        }
        s1 = s2;
        if (j < 10)
        {
            s1 = (new StringBuilder()).append("0").append(s2).toString();
        }
        return DateValue((new StringBuilder()).append(s).append(":").append(s1).toString());
    }

    public static long Timer()
    {
        return System.currentTimeMillis();
    }

    public static int Weekday(Calendar calendar)
    {
        return calendar.get(7);
    }

    public static String WeekdayName(Calendar calendar)
    {
        return String.format("%1$tA", new Object[] {
            calendar
        });
    }

    public static int Year(Calendar calendar)
    {
        return calendar.get(1);
    }
}
