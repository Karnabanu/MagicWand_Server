// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.multidex;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;

class ZipEntryReader
{

    private static final long CENSIG = 0x2014b50L;
    private static final int GPBF_ENCRYPTED_FLAG = 1;
    private static final int GPBF_UNSUPPORTED_MASK = 1;
    static final Charset UTF_8 = Charset.forName("UTF-8");

    ZipEntryReader()
    {
    }

    private static long getTime(int i, int j)
    {
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.set(14, 0);
        gregoriancalendar.set((j >> 9 & 0x7f) + 1980, (j >> 5 & 0xf) - 1, j & 0x1f, i >> 11 & 0x1f, i >> 5 & 0x3f, (i & 0x1f) << 1);
        return gregoriancalendar.getTime().getTime();
    }

    static ZipEntry readEntry(ByteBuffer bytebuffer)
        throws IOException
    {
        if ((long)bytebuffer.getInt() != 0x2014b50L)
        {
            throw new ZipException("Central Directory Entry not found");
        }
        bytebuffer.position(8);
        int i = bytebuffer.getShort() & 0xffff;
        if ((i & 1) != 0)
        {
            throw new ZipException((new StringBuilder()).append("Invalid General Purpose Bit Flag: ").append(i).toString());
        }
        i = bytebuffer.getShort();
        short word0 = bytebuffer.getShort();
        short word1 = bytebuffer.getShort();
        long l = bytebuffer.getInt();
        long l1 = bytebuffer.getInt();
        long l2 = bytebuffer.getInt();
        short word2 = bytebuffer.getShort();
        int j = bytebuffer.getShort() & 0xffff;
        int k = bytebuffer.getShort() & 0xffff;
        bytebuffer.position(42);
        long l3 = bytebuffer.getInt();
        byte abyte0[] = new byte[word2 & 0xffff];
        bytebuffer.get(abyte0, 0, abyte0.length);
        ZipEntry zipentry = new ZipEntry(new String(abyte0, 0, abyte0.length, UTF_8));
        zipentry.setMethod(i & 0xffff);
        zipentry.setTime(getTime(word0 & 0xffff, word1 & 0xffff));
        zipentry.setCrc(l & 0xffffffffL);
        zipentry.setCompressedSize(l1 & 0xffffffffL);
        zipentry.setSize(l2 & 0xffffffffL);
        if (k > 0)
        {
            byte abyte1[] = new byte[k];
            bytebuffer.get(abyte1, 0, k);
            zipentry.setComment(new String(abyte1, 0, abyte1.length, UTF_8));
        }
        if (j > 0)
        {
            byte abyte2[] = new byte[j];
            bytebuffer.get(abyte2, 0, j);
            zipentry.setExtra(abyte2);
        }
        return zipentry;
    }

}
