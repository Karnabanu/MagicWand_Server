// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.ModuleManager;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import java.io.PrintStream;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            require

public class ImportFromLibrary extends Syntax
{

    private static final String BUILTIN = "";
    private static final String MISSING = null;
    static final String SRFI97Map[][];
    public static final ImportFromLibrary instance = new ImportFromLibrary();
    public String classPrefixPath[] = {
        "", "kawa.lib."
    };

    public ImportFromLibrary()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return null;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Procedure procedure;
        String s;
        Object obj;
        Object obj2;
        Object obj3;
        int l;
        s = null;
        pair = ((Pair) (pair.getCdr()));
        if (!(pair instanceof Pair))
        {
            return false;
        }
        pair = (Pair)pair;
        obj = pair.getCar();
        if (LList.listLength(obj, false) <= 0)
        {
            translator.error('e', "expected <library reference> which must be a list");
            return false;
        }
        pair = ((Pair) (pair.getCdr()));
        procedure = s;
        if (pair instanceof Pair)
        {
            procedure = s;
            if (((Pair)pair).getCar() instanceof Procedure)
            {
                procedure = (Procedure)((Pair)pair).getCar();
            }
        }
        pair = null;
        s = null;
        obj3 = new StringBuffer();
        while (obj instanceof Pair) 
        {
            obj = (Pair)obj;
            Object obj1 = ((Pair) (obj)).getCar();
            obj = ((Pair) (obj)).getCdr();
            if (obj1 instanceof Pair)
            {
                if (pair != null)
                {
                    translator.error('e', (new StringBuilder()).append("duplicate version reference - was ").append(pair).toString());
                }
                pair = ((Pair) (obj1));
                System.err.println((new StringBuilder()).append("import version ").append(obj1).toString());
            } else
            if (obj1 instanceof String)
            {
                if (obj instanceof Pair)
                {
                    translator.error('e', "source specifier must be last elemnt in library reference");
                }
                s = (String)obj1;
            } else
            {
                if (((StringBuffer) (obj3)).length() > 0)
                {
                    ((StringBuffer) (obj3)).append('.');
                }
                ((StringBuffer) (obj3)).append(Compilation.mangleNameIfNeeded(obj1.toString()));
            }
        }
        pair = null;
        if (s != null)
        {
            obj = require.lookupModuleFromSourcePath(s, scopeexp);
            pair = ((Pair) (obj));
            if (obj == null)
            {
                translator.error('e', (new StringBuilder()).append("malformed URL: ").append(s).toString());
                return false;
            }
        }
        obj = ((StringBuffer) (obj3)).toString();
        s = ((String) (obj));
        if (!((String) (obj)).startsWith("srfi."))
        {
            break MISSING_BLOCK_LABEL_710;
        }
        obj3 = Compilation.demangleName(((String) (obj)).substring(5));
        int i = ((String) (obj3)).indexOf('.');
        if (i < 0)
        {
            s = null;
            i = ((String) (obj3)).length();
        } else
        {
            s = ((String) (obj3)).substring(i + 1);
        }
        obj2 = null;
        if (i >= 2) goto _L2; else goto _L1
_L1:
        obj = obj2;
        if (((String) (obj3)).charAt(0) != ':') goto _L3; else goto _L2
_L2:
        l = 1;
_L8:
        if (l != i) goto _L5; else goto _L4
_L4:
        obj = ((String) (obj3)).substring(1, i);
_L3:
        if (obj == null)
        {
            translator.error('e', "SRFI library reference must have the form: (srfi :NNN [name])");
            return false;
        }
        break; /* Loop/switch isn't completed */
_L5:
        obj = obj2;
        if (Character.digit(((String) (obj3)).charAt(l), 10) < 0) goto _L3; else goto _L6
_L6:
        l++;
        if (true) goto _L8; else goto _L7
_L7:
        int j = SRFI97Map.length;
        do
        {
            l = j - 1;
            if (l < 0)
            {
                translator.error('e', (new StringBuilder()).append("unknown SRFI number '").append(((String) (obj))).append("' in SRFI library reference").toString());
                return false;
            }
            j = l;
        } while (!SRFI97Map[l][0].equals(obj));
        String s2 = SRFI97Map[l][1];
        String s1 = SRFI97Map[l][2];
        if (s != null && !s.equals(s2))
        {
            translator.error('w', (new StringBuilder()).append("the name of SRFI ").append(((String) (obj))).append(" should be '").append(s2).append('\'').toString());
        }
        if (s1 == "")
        {
            return true;
        }
        if (s1 == MISSING)
        {
            translator.error('e', (new StringBuilder()).append("sorry - Kawa does not support SRFI ").append(((String) (obj))).append(" (").append(s2).append(')').toString());
            return false;
        }
        s = s1;
        int k;
        l = classPrefixPath.length;
        k = 0;
_L10:
        if (k >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (new StringBuilder()).append(classPrefixPath[k]).append(s).toString();
        obj = ModuleManager.getInstance().findWithClassName(((String) (obj)));
        pair = ((Pair) (obj));
_L11:
        k++;
        if (true) goto _L10; else goto _L9
        Exception exception;
        exception;
          goto _L11
_L9:
        if (pair == null)
        {
            translator.error('e', (new StringBuilder()).append("unknown class ").append(s).toString());
            return false;
        } else
        {
            require.importDefinitions(null, pair, procedure, vector, scopeexp, translator);
            return true;
        }
    }

    static 
    {
        String as[] = {
            "1", "lists", "gnu.kawa.slib.srfi1"
        };
        String as1[] = {
            "2", "and-let*", "gnu.kawa.slib.srfi2"
        };
        String s = MISSING;
        String as2[] = {
            "6", "basic-string-ports", ""
        };
        String as3[] = {
            "13", "strings", "gnu.kawa.slib.srfi13"
        };
        String s1 = MISSING;
        String as4[] = {
            "16", "case-lambda", ""
        };
        String as5[] = {
            "18", "multithreading", MISSING
        };
        String s2 = MISSING;
        String as6[] = {
            "21", "real-time-multithreading", MISSING
        };
        String as7[] = {
            "26", "cut", ""
        };
        String as8[] = {
            "27", "random-bits", MISSING
        };
        String as9[] = {
            "29", "localization", MISSING
        };
        String s3 = MISSING;
        String as10[] = {
            "38", "with-shared-structure", MISSING
        };
        String as11[] = {
            "39", "parameters", ""
        };
        String s4 = MISSING;
        String s5 = MISSING;
        String s6 = MISSING;
        String s7 = MISSING;
        String s8 = MISSING;
        String s9 = MISSING;
        String as12[] = {
            "47", "arrays", MISSING
        };
        String as13[] = {
            "48", "intermediate-format-strings", MISSING
        };
        String s10 = MISSING;
        String s11 = MISSING;
        String as14[] = {
            "57", "records", MISSING
        };
        String as15[] = {
            "59", "vicinities", MISSING
        };
        String as16[] = {
            "60", "integer-bits", MISSING
        };
        String as17[] = {
            "61", "cond", MISSING
        };
        String s12 = MISSING;
        String as18[] = {
            "66", "octet-vectors", MISSING
        };
        String as19[] = {
            "67", "compare-procedures", MISSING
        };
        String s13 = MISSING;
        String s14 = MISSING;
        String as20[] = {
            "78", "lightweight-testing", MISSING
        };
        String s15 = MISSING;
        String as21[] = {
            "87", "case", MISSING
        };
        String as22[] = {
            "95", "sorting-and-merging", "kawa.lib.srfi95"
        };
        SRFI97Map = (new String[][] {
            as, as1, new String[] {
                "5", "let", s
            }, as2, new String[] {
                "8", "receive", ""
            }, new String[] {
                "9", "records", ""
            }, new String[] {
                "11", "let-values", ""
            }, as3, new String[] {
                "14", "char-sets", s1
            }, as4, 
            new String[] {
                "17", "generalized-set!", ""
            }, as5, new String[] {
                "19", "time", s2
            }, as6, new String[] {
                "23", "error", ""
            }, new String[] {
                "25", "multi-dimensional-arrays", ""
            }, as7, as8, new String[] {
                "28", "basic-format-strings", ""
            }, as9, 
            new String[] {
                "31", "rec", s3
            }, as10, as11, new String[] {
                "41", "streams", s4
            }, new String[] {
                "42", "eager-comprehensions", s5
            }, new String[] {
                "43", "vectors", s6
            }, new String[] {
                "44", "collections", s7
            }, new String[] {
                "45", "lazy", s8
            }, new String[] {
                "46", "syntax-rules", s9
            }, as12, 
            as13, new String[] {
                "51", "rest-values", s10
            }, new String[] {
                "54", "cat", s11
            }, as14, as15, as16, as17, new String[] {
                "63", "arrays", s12
            }, new String[] {
                "64", "testing", "gnu.kawa.slib.testing"
            }, as18, 
            as19, new String[] {
                "69", "basic-hash-tables", "gnu.kawa.slib.srfi69"
            }, new String[] {
                "71", "let", s13
            }, new String[] {
                "74", "blobs", s14
            }, as20, new String[] {
                "86", "mu-and-nu", s15
            }, as21, as22
        });
    }
}
