// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package appinventor.ai_karnabanuk123.BTClient2;

import com.google.appinventor.components.runtime.BluetoothClient;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

public class Screen1 extends Form
    implements Runnable
{

    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("Screen1")).readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("getMessage")).readResolve();
    static final SimpleSymbol Lit10 = (SimpleSymbol)(new SimpleSymbol("ShowAlert")).readResolve();
    static final PairWithPosition Lit100;
    static final SimpleSymbol Lit101 = (SimpleSymbol)(new SimpleSymbol("ReceiveSigned2ByteNumber")).readResolve();
    static final IntNum Lit102 = IntNum.make(3);
    static final PairWithPosition Lit103;
    static final SimpleSymbol Lit104 = (SimpleSymbol)(new SimpleSymbol("ReceiveSigned4ByteNumber")).readResolve();
    static final IntNum Lit105 = IntNum.make(4);
    static final PairWithPosition Lit106;
    static final SimpleSymbol Lit107 = (SimpleSymbol)(new SimpleSymbol("Clock1$Timer")).readResolve();
    static final SimpleSymbol Lit108 = (SimpleSymbol)(new SimpleSymbol("Timer")).readResolve();
    static final FString Lit109 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final PairWithPosition Lit11;
    static final FString Lit110 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit111 = (SimpleSymbol)(new SimpleSymbol("android-log-form")).readResolve();
    static final SimpleSymbol Lit112 = (SimpleSymbol)(new SimpleSymbol("add-to-form-environment")).readResolve();
    static final SimpleSymbol Lit113 = (SimpleSymbol)(new SimpleSymbol("lookup-in-form-environment")).readResolve();
    static final SimpleSymbol Lit114 = (SimpleSymbol)(new SimpleSymbol("is-bound-in-form-environment")).readResolve();
    static final SimpleSymbol Lit115 = (SimpleSymbol)(new SimpleSymbol("add-to-global-var-environment")).readResolve();
    static final SimpleSymbol Lit116 = (SimpleSymbol)(new SimpleSymbol("add-to-events")).readResolve();
    static final SimpleSymbol Lit117 = (SimpleSymbol)(new SimpleSymbol("add-to-components")).readResolve();
    static final SimpleSymbol Lit118 = (SimpleSymbol)(new SimpleSymbol("add-to-global-vars")).readResolve();
    static final SimpleSymbol Lit119 = (SimpleSymbol)(new SimpleSymbol("add-to-form-do-after-creation")).readResolve();
    static final SimpleSymbol Lit12 = (SimpleSymbol)(new SimpleSymbol("Screen1$Initialize")).readResolve();
    static final SimpleSymbol Lit120 = (SimpleSymbol)(new SimpleSymbol("send-error")).readResolve();
    static final SimpleSymbol Lit121 = (SimpleSymbol)(new SimpleSymbol("dispatchEvent")).readResolve();
    static final SimpleSymbol Lit122 = (SimpleSymbol)(new SimpleSymbol("lookup-handler")).readResolve();
    static final SimpleSymbol Lit123;
    static final SimpleSymbol Lit13 = (SimpleSymbol)(new SimpleSymbol("Initialize")).readResolve();
    static final SimpleSymbol Lit14 = (SimpleSymbol)(new SimpleSymbol("lblStatus")).readResolve();
    static final SimpleSymbol Lit15 = (SimpleSymbol)(new SimpleSymbol("Text")).readResolve();
    static final PairWithPosition Lit16;
    static final SimpleSymbol Lit17 = (SimpleSymbol)(new SimpleSymbol("Screen1$ErrorOccurred")).readResolve();
    static final SimpleSymbol Lit18 = (SimpleSymbol)(new SimpleSymbol("ErrorOccurred")).readResolve();
    static final FString Lit19 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit2 = (SimpleSymbol)(new SimpleSymbol("*the-null-value*")).readResolve();
    static final SimpleSymbol Lit20 = (SimpleSymbol)(new SimpleSymbol("lpConnect")).readResolve();
    static final FString Lit21 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit22 = (SimpleSymbol)(new SimpleSymbol("Elements")).readResolve();
    static final SimpleSymbol Lit23 = (SimpleSymbol)(new SimpleSymbol("AddressesAndNames")).readResolve();
    static final SimpleSymbol Lit24 = (SimpleSymbol)(new SimpleSymbol("list")).readResolve();
    static final SimpleSymbol Lit25 = (SimpleSymbol)(new SimpleSymbol("lpConnect$BeforePicking")).readResolve();
    static final SimpleSymbol Lit26 = (SimpleSymbol)(new SimpleSymbol("BeforePicking")).readResolve();
    static final SimpleSymbol Lit27 = (SimpleSymbol)(new SimpleSymbol("Connect")).readResolve();
    static final SimpleSymbol Lit28 = (SimpleSymbol)(new SimpleSymbol("Selection")).readResolve();
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit3 = (SimpleSymbol)(new SimpleSymbol("AppName")).readResolve();
    static final SimpleSymbol Lit30 = (SimpleSymbol)(new SimpleSymbol("SendText")).readResolve();
    static final PairWithPosition Lit31;
    static final SimpleSymbol Lit32 = (SimpleSymbol)(new SimpleSymbol("lpConnect$AfterPicking")).readResolve();
    static final SimpleSymbol Lit33 = (SimpleSymbol)(new SimpleSymbol("AfterPicking")).readResolve();
    static final FString Lit34 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit35 = (SimpleSymbol)(new SimpleSymbol("HorizontalArrangement1")).readResolve();
    static final FString Lit36 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit37 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit38 = (SimpleSymbol)(new SimpleSymbol("btnSendText")).readResolve();
    static final FString Lit39 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit40 = (SimpleSymbol)(new SimpleSymbol("IsConnected")).readResolve();
    static final SimpleSymbol Lit41 = (SimpleSymbol)(new SimpleSymbol("txbTextToSend")).readResolve();
    static final PairWithPosition Lit42;
    static final SimpleSymbol Lit43 = (SimpleSymbol)(new SimpleSymbol("btnSendText$Click")).readResolve();
    static final SimpleSymbol Lit44 = (SimpleSymbol)(new SimpleSymbol("Click")).readResolve();
    static final FString Lit45 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final SimpleSymbol Lit46 = (SimpleSymbol)(new SimpleSymbol("Hint")).readResolve();
    static final FString Lit47 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final FString Lit48 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit49 = (SimpleSymbol)(new SimpleSymbol("HorizontalArrangement2")).readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol)(new SimpleSymbol("Title")).readResolve();
    static final FString Lit50 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit51 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit52 = (SimpleSymbol)(new SimpleSymbol("Label4")).readResolve();
    static final SimpleSymbol Lit53 = (SimpleSymbol)(new SimpleSymbol("HasMargins")).readResolve();
    static final SimpleSymbol Lit54;
    static final FString Lit55 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit56 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit57 = (SimpleSymbol)(new SimpleSymbol("lblCommandReceived")).readResolve();
    static final FString Lit58 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit59 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit6 = (SimpleSymbol)(new SimpleSymbol("BluetoothClient1")).readResolve();
    static final SimpleSymbol Lit60 = (SimpleSymbol)(new SimpleSymbol("HorizontalArrangement3")).readResolve();
    static final FString Lit61 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit62 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit63 = (SimpleSymbol)(new SimpleSymbol("Label3")).readResolve();
    static final FString Lit64 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit65 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit66 = (SimpleSymbol)(new SimpleSymbol("lblDataReceived")).readResolve();
    static final FString Lit67 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit68 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit69 = (SimpleSymbol)(new SimpleSymbol("btnDisconnect")).readResolve();
    static final SimpleSymbol Lit7 = (SimpleSymbol)(new SimpleSymbol("Enabled")).readResolve();
    static final FString Lit70 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit71 = (SimpleSymbol)(new SimpleSymbol("Disconnect")).readResolve();
    static final SimpleSymbol Lit72 = (SimpleSymbol)(new SimpleSymbol("btnDisconnect$Click")).readResolve();
    static final FString Lit73 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit74 = (SimpleSymbol)(new SimpleSymbol("HorizontalArrangement4")).readResolve();
    static final FString Lit75 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit76 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit77 = (SimpleSymbol)(new SimpleSymbol("Label1")).readResolve();
    static final FString Lit78 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit79 = new FString("com.google.appinventor.components.runtime.Label");
    static final PairWithPosition Lit8;
    static final SimpleSymbol Lit80 = (SimpleSymbol)(new SimpleSymbol("FontItalic")).readResolve();
    static final SimpleSymbol Lit81 = (SimpleSymbol)(new SimpleSymbol("TextAlignment")).readResolve();
    static final IntNum Lit82 = IntNum.make(1);
    static final SimpleSymbol Lit83;
    static final FString Lit84 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit85 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit86 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit87 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit88 = (SimpleSymbol)(new SimpleSymbol("Clock1")).readResolve();
    static final FString Lit89 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit9 = (SimpleSymbol)(new SimpleSymbol("Notifier1")).readResolve();
    static final IntNum Lit90 = IntNum.make(0);
    static final SimpleSymbol Lit91 = (SimpleSymbol)(new SimpleSymbol("BytesAvailableToReceive")).readResolve();
    static final PairWithPosition Lit92;
    static final PairWithPosition Lit93;
    static final SimpleSymbol Lit94 = (SimpleSymbol)(new SimpleSymbol("ReceiveSigned1ByteNumber")).readResolve();
    static final PairWithPosition Lit95;
    static final PairWithPosition Lit96;
    static final SimpleSymbol Lit97 = (SimpleSymbol)(new SimpleSymbol("ReceiveText")).readResolve();
    static final PairWithPosition Lit98;
    static final IntNum Lit99 = IntNum.make(2);
    public static Screen1 Screen1;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn10;
    static final ModuleMethod lambda$Fn11;
    static final ModuleMethod lambda$Fn12;
    static final ModuleMethod lambda$Fn13;
    static final ModuleMethod lambda$Fn14;
    static final ModuleMethod lambda$Fn15;
    static final ModuleMethod lambda$Fn16;
    static final ModuleMethod lambda$Fn17;
    static final ModuleMethod lambda$Fn18;
    static final ModuleMethod lambda$Fn19;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn20;
    static final ModuleMethod lambda$Fn21;
    static final ModuleMethod lambda$Fn22;
    static final ModuleMethod lambda$Fn3;
    static final ModuleMethod lambda$Fn4;
    static final ModuleMethod lambda$Fn5;
    static final ModuleMethod lambda$Fn6;
    static final ModuleMethod lambda$Fn7;
    static final ModuleMethod lambda$Fn8;
    static final ModuleMethod lambda$Fn9;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public BluetoothClient BluetoothClient1;
    public Clock Clock1;
    public final ModuleMethod Clock1$Timer;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public HorizontalArrangement HorizontalArrangement3;
    public HorizontalArrangement HorizontalArrangement4;
    public Label Label1;
    public Label Label3;
    public Label Label4;
    public Notifier Notifier1;
    public final ModuleMethod Screen1$ErrorOccurred;
    public final ModuleMethod Screen1$Initialize;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public Button btnDisconnect;
    public final ModuleMethod btnDisconnect$Click;
    public Button btnSendText;
    public final ModuleMethod btnSendText$Click;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public Label lblCommandReceived;
    public Label lblDataReceived;
    public Label lblStatus;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public ListPicker lpConnect;
    public final ModuleMethod lpConnect$AfterPicking;
    public final ModuleMethod lpConnect$BeforePicking;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;
    public TextBox txbTextToSend;

    public Screen1()
    {
        ModuleInfo.register(this);
        frame frame1 = new frame();
        frame1.main = this;
        android$Mnlog$Mnform = new ModuleMethod(frame1, 1, Lit111, 4097);
        add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame1, 2, Lit112, 8194);
        lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame1, 3, Lit113, 8193);
        is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame1, 5, Lit114, 4097);
        add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame1, 6, Lit115, 8194);
        add$Mnto$Mnevents = new ModuleMethod(frame1, 7, Lit116, 8194);
        add$Mnto$Mncomponents = new ModuleMethod(frame1, 8, Lit117, 16388);
        add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame1, 9, Lit118, 8194);
        add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame1, 10, Lit119, 4097);
        send$Mnerror = new ModuleMethod(frame1, 11, Lit120, 4097);
        process$Mnexception = new ModuleMethod(frame1, 12, "process-exception", 4097);
        dispatchEvent = new ModuleMethod(frame1, 13, Lit121, 16388);
        lookup$Mnhandler = new ModuleMethod(frame1, 14, Lit122, 8194);
        ModuleMethod modulemethod = new ModuleMethod(frame1, 15, null, 0);
        modulemethod.setProperty("source-location", "/tmp/runtime8241787824357287889.scm:542");
        lambda$Fn1 = modulemethod;
        $define = new ModuleMethod(frame1, 16, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame1, 17, null, 0);
        Screen1$Initialize = new ModuleMethod(frame1, 18, Lit12, 0);
        Screen1$ErrorOccurred = new ModuleMethod(frame1, 19, Lit17, 16388);
        lambda$Fn3 = new ModuleMethod(frame1, 20, null, 0);
        lambda$Fn4 = new ModuleMethod(frame1, 21, null, 0);
        lpConnect$BeforePicking = new ModuleMethod(frame1, 22, Lit25, 0);
        lpConnect$AfterPicking = new ModuleMethod(frame1, 23, Lit32, 0);
        lambda$Fn5 = new ModuleMethod(frame1, 24, null, 0);
        lambda$Fn6 = new ModuleMethod(frame1, 25, null, 0);
        btnSendText$Click = new ModuleMethod(frame1, 26, Lit43, 0);
        lambda$Fn7 = new ModuleMethod(frame1, 27, null, 0);
        lambda$Fn8 = new ModuleMethod(frame1, 28, null, 0);
        lambda$Fn9 = new ModuleMethod(frame1, 29, null, 0);
        lambda$Fn10 = new ModuleMethod(frame1, 30, null, 0);
        lambda$Fn11 = new ModuleMethod(frame1, 31, null, 0);
        lambda$Fn12 = new ModuleMethod(frame1, 32, null, 0);
        lambda$Fn13 = new ModuleMethod(frame1, 33, null, 0);
        lambda$Fn14 = new ModuleMethod(frame1, 34, null, 0);
        lambda$Fn15 = new ModuleMethod(frame1, 35, null, 0);
        lambda$Fn16 = new ModuleMethod(frame1, 36, null, 0);
        lambda$Fn17 = new ModuleMethod(frame1, 37, null, 0);
        lambda$Fn18 = new ModuleMethod(frame1, 38, null, 0);
        btnDisconnect$Click = new ModuleMethod(frame1, 39, Lit72, 0);
        lambda$Fn19 = new ModuleMethod(frame1, 40, null, 0);
        lambda$Fn20 = new ModuleMethod(frame1, 41, null, 0);
        lambda$Fn21 = new ModuleMethod(frame1, 42, null, 0);
        lambda$Fn22 = new ModuleMethod(frame1, 43, null, 0);
        Clock1$Timer = new ModuleMethod(frame1, 44, Lit107, 0);
    }

    static Object lambda10()
    {
        runtime.setAndCoerceProperty$Ex(Lit52, Lit53, Boolean.FALSE, Lit54);
        return runtime.setAndCoerceProperty$Ex(Lit52, Lit15, "Command received:", Lit4);
    }

    static Object lambda11()
    {
        runtime.setAndCoerceProperty$Ex(Lit52, Lit53, Boolean.FALSE, Lit54);
        return runtime.setAndCoerceProperty$Ex(Lit52, Lit15, "Command received:", Lit4);
    }

    static Object lambda12()
    {
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit53, Boolean.FALSE, Lit54);
    }

    static Object lambda13()
    {
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit53, Boolean.FALSE, Lit54);
    }

    static Object lambda14()
    {
        runtime.setAndCoerceProperty$Ex(Lit63, Lit53, Boolean.FALSE, Lit54);
        return runtime.setAndCoerceProperty$Ex(Lit63, Lit15, "Data received:", Lit4);
    }

    static Object lambda15()
    {
        runtime.setAndCoerceProperty$Ex(Lit63, Lit53, Boolean.FALSE, Lit54);
        return runtime.setAndCoerceProperty$Ex(Lit63, Lit15, "Data received:", Lit4);
    }

    static Object lambda16()
    {
        return runtime.setAndCoerceProperty$Ex(Lit66, Lit53, Boolean.FALSE, Lit54);
    }

    static Object lambda17()
    {
        return runtime.setAndCoerceProperty$Ex(Lit66, Lit53, Boolean.FALSE, Lit54);
    }

    static Object lambda18()
    {
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit15, "Disconnect", Lit4);
    }

    static Object lambda19()
    {
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit15, "Disconnect", Lit4);
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object aobj[])
    {
        Object obj = LList.makeList(aobj, 0);
        gnu.kawa.functions.Apply apply = Scheme.apply;
        ModuleMethod modulemethod = strings.string$Mnappend;
        aobj = LList.Empty;
        do
        {
            if (obj == LList.Empty)
            {
                aobj = ((Object []) (apply.apply2(modulemethod, LList.reverseInPlace(((Object) (aobj))))));
                Object obj1;
                Symbol symbol;
                try
                {
                    obj = (CharSequence)aobj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "string->symbol", 1, ((Object) (aobj)));
                }
                return misc.string$To$Symbol(((CharSequence) (obj)));
            }
            try
            {
                obj1 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "arg0", -2, obj);
            }
            obj = ((Pair) (obj1)).getCdr();
            obj1 = ((Pair) (obj1)).getCar();
            try
            {
                symbol = (Symbol)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "symbol->string", 1, obj1);
            }
            aobj = Pair.make(misc.symbol$To$String(symbol), ((Object) (aobj)));
        } while (true);
    }

    static Object lambda2()
    {
        return null;
    }

    static Object lambda20()
    {
        runtime.setAndCoerceProperty$Ex(Lit77, Lit53, Boolean.FALSE, Lit54);
        return runtime.setAndCoerceProperty$Ex(Lit77, Lit15, "Link status:", Lit4);
    }

    static Object lambda21()
    {
        runtime.setAndCoerceProperty$Ex(Lit77, Lit53, Boolean.FALSE, Lit54);
        return runtime.setAndCoerceProperty$Ex(Lit77, Lit15, "Link status:", Lit4);
    }

    static Object lambda22()
    {
        runtime.setAndCoerceProperty$Ex(Lit14, Lit80, Boolean.TRUE, Lit54);
        runtime.setAndCoerceProperty$Ex(Lit14, Lit53, Boolean.FALSE, Lit54);
        runtime.setAndCoerceProperty$Ex(Lit14, Lit15, "Status", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit14, Lit81, Lit82, Lit83);
    }

    static Object lambda23()
    {
        runtime.setAndCoerceProperty$Ex(Lit14, Lit80, Boolean.TRUE, Lit54);
        runtime.setAndCoerceProperty$Ex(Lit14, Lit53, Boolean.FALSE, Lit54);
        runtime.setAndCoerceProperty$Ex(Lit14, Lit15, "Status", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit14, Lit81, Lit82, Lit83);
    }

    static Object lambda3()
    {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "BTClient2", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit5, "Bluetooth Client Demo - Text and Numbers", Lit4);
    }

    static Object lambda4()
    {
        return runtime.setAndCoerceProperty$Ex(Lit20, Lit15, "Connect to device", Lit4);
    }

    static Object lambda5()
    {
        return runtime.setAndCoerceProperty$Ex(Lit20, Lit15, "Connect to device", Lit4);
    }

    static Object lambda6()
    {
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit15, "Send the following text:", Lit4);
    }

    static Object lambda7()
    {
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit15, "Send the following text:", Lit4);
    }

    static Object lambda8()
    {
        runtime.setAndCoerceProperty$Ex(Lit41, Lit46, "Hint for TextBox1", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit41, Lit15, "Sample client text to send", Lit4);
    }

    static Object lambda9()
    {
        runtime.setAndCoerceProperty$Ex(Lit41, Lit46, "Hint for TextBox1", Lit4);
        return runtime.setAndCoerceProperty$Ex(Lit41, Lit15, "Sample client text to send", Lit4);
    }

    public void $define()
    {
        Object obj;
        Object obj1;
        Language.setDefaults(Scheme.getInstance());
        try
        {
            run();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            androidLogForm(((Exception) (obj)).getMessage());
            processException(obj);
        }
        Screen1 = this;
        addToFormEnvironment(Lit0, this);
        obj = events$Mnto$Mnregister;
_L12:
        if (obj != LList.Empty) goto _L2; else goto _L1
_L1:
        addToGlobalVars(Lit2, lambda$Fn1);
        obj = lists.reverse(global$Mnvars$Mnto$Mncreate);
_L13:
        if (obj != LList.Empty) goto _L4; else goto _L3
_L3:
        obj = lists.reverse(form$Mndo$Mnafter$Mncreation);
_L14:
        if (obj != LList.Empty) goto _L6; else goto _L5
_L5:
        obj = lists.reverse(components$Mnto$Mncreate);
        obj1 = obj;
_L15:
        if (obj1 != LList.Empty) goto _L8; else goto _L7
_L7:
        obj1 = obj;
_L16:
        if (obj1 != LList.Empty) goto _L10; else goto _L9
_L9:
        obj1 = LList.Empty;
        if (obj == obj1)
        {
            return;
        }
          goto _L11
_L2:
        ClassCastException classcastexception;
        Object obj2;
        Object obj3;
        Object obj4;
        Symbol symbol;
        try
        {
            obj2 = (Pair)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "arg0", -2, obj);
        }
        obj1 = ((Pair) (obj2)).getCar();
        obj = lists.car.apply1(obj1);
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        obj1 = lists.cdr.apply1(obj1);
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = obj1.toString();
        }
        EventDispatcher.registerEventForDelegation(this, ((String) (obj)), ((String) (obj1)));
        obj = ((Pair) (obj2)).getCdr();
          goto _L12
_L4:
        try
        {
            obj1 = (Pair)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            try
            {
                throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                processException(obj);
            }
            return;
        }
        obj2 = ((Pair) (obj1)).getCar();
        obj = lists.car.apply1(obj2);
        obj2 = lists.cadr.apply1(obj2);
        obj3 = (Symbol)obj;
        addToGlobalVarEnvironment(((Symbol) (obj3)), Scheme.applyToArgs.apply1(obj2));
        obj = ((Pair) (obj1)).getCdr();
          goto _L13
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "add-to-global-var-environment", 0, obj);
_L6:
        obj1 = (Pair)obj;
        misc.force(((Pair) (obj1)).getCar());
        obj = ((Pair) (obj1)).getCdr();
          goto _L14
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
_L8:
        obj2 = (Pair)obj1;
        obj4 = ((Pair) (obj2)).getCar();
        obj1 = lists.caddr.apply1(obj4);
        lists.cadddr.apply1(obj4);
        obj3 = lists.cadr.apply1(obj4);
        obj4 = lists.car.apply1(obj4);
        symbol = (Symbol)obj4;
        obj4 = lookupInFormEnvironment(symbol);
        obj3 = Invoke.make.apply2(obj3, obj4);
        SlotSet.set$Mnfield$Ex.apply3(this, obj1, obj3);
        obj4 = (Symbol)obj1;
        addToFormEnvironment(((Symbol) (obj4)), obj3);
        obj1 = ((Pair) (obj2)).getCdr();
          goto _L15
        obj;
        throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj1);
        obj;
        throw new WrongType(((ClassCastException) (obj)), "lookup-in-form-environment", 0, obj4);
        obj;
        throw new WrongType(((ClassCastException) (obj)), "add-to-form-environment", 0, obj1);
_L10:
        obj2 = (Pair)obj1;
        obj1 = ((Pair) (obj2)).getCar();
        lists.caddr.apply1(obj1);
        obj1 = lists.cadddr.apply1(obj1);
        if (obj1 != Boolean.FALSE)
        {
            Scheme.applyToArgs.apply1(obj1);
        }
        obj1 = ((Pair) (obj2)).getCdr();
          goto _L16
        obj;
        throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj1);
_L11:
        obj1 = (Pair)obj;
        obj = ((Pair) (obj1)).getCar();
        obj2 = lists.caddr.apply1(obj);
        lists.cadddr.apply1(obj);
        callInitialize(SlotGet.field.apply2(this, obj2));
        obj = ((Pair) (obj1)).getCdr();
          goto _L9
        classcastexception;
        throw new WrongType(classcastexception, "arg0", -2, obj);
          goto _L12
    }

    public Object Clock1$Timer()
    {
        runtime.setThisForm();
        IntNum intnum = Lit90;
        intnum = Lit90;
        if (runtime.getProperty$1(Lit6, Lit40) != Boolean.FALSE)
        {
            Object obj = runtime.callComponentMethod(Lit6, Lit91, LList.Empty, LList.Empty);
            runtime.setAndCoerceProperty$Ex(Lit14, Lit15, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("Bytes Available: ", obj), Lit92, "join"), Lit4);
            if (runtime.callYailPrimitive(Scheme.numGrt, LList.list2(obj, Lit90), Lit93, ">") != Boolean.FALSE)
            {
                Object obj1 = runtime.callComponentMethod(Lit6, Lit94, LList.Empty, LList.Empty);
                runtime.setAndCoerceProperty$Ex(Lit57, Lit15, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("Command byte:", obj1), Lit95, "join"), Lit4);
                if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(obj1, Lit82), Lit96, "=") != Boolean.FALSE)
                {
                    return runtime.setAndCoerceProperty$Ex(Lit66, Lit15, runtime.callComponentMethod(Lit6, Lit97, LList.list1(runtime.callComponentMethod(Lit6, Lit91, LList.Empty, LList.Empty)), Lit98), Lit4);
                }
                if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(obj1, Lit99), Lit100, "=") != Boolean.FALSE)
                {
                    return runtime.setAndCoerceProperty$Ex(Lit66, Lit15, runtime.callComponentMethod(Lit6, Lit101, LList.Empty, LList.Empty), Lit4);
                }
                if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(obj1, Lit102), Lit103, "=") != Boolean.FALSE)
                {
                    return runtime.setAndCoerceProperty$Ex(Lit66, Lit15, runtime.callComponentMethod(Lit6, Lit104, LList.Empty, LList.Empty), Lit4);
                }
                if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(obj1, Lit105), Lit106, "=") != Boolean.FALSE)
                {
                    return runtime.setAndCoerceProperty$Ex(Lit66, Lit15, runtime.callComponentMethod(Lit6, Lit94, LList.Empty, LList.Empty), Lit4);
                } else
                {
                    return Values.empty;
                }
            } else
            {
                return Values.empty;
            }
        } else
        {
            return Values.empty;
        }
    }

    public Object Screen1$ErrorOccurred(Object obj, Object obj1, Object obj2, Object obj3)
    {
        obj = runtime.sanitizeComponentData(obj);
        obj1 = runtime.sanitizeComponentData(obj1);
        obj2 = runtime.sanitizeComponentData(obj2);
        obj3 = runtime.sanitizeComponentData(obj3);
        runtime.setThisForm();
        SimpleSymbol simplesymbol = Lit14;
        SimpleSymbol simplesymbol1 = Lit15;
        ModuleMethod modulemethod = strings.string$Mnappend;
        Pair pair = LList.list1("Error:");
        LList.chain1(LList.chain1(LList.chain1(LList.chain4(pair, obj, ", ", obj2, ", "), obj1), ", "), obj3);
        return runtime.setAndCoerceProperty$Ex(simplesymbol, simplesymbol1, runtime.callYailPrimitive(modulemethod, pair, Lit16, "join"), Lit4);
    }

    public Object Screen1$Initialize()
    {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnnot, LList.list1(runtime.getProperty$1(Lit6, Lit7)), Lit8, "not") != Boolean.FALSE)
        {
            return runtime.callComponentMethod(Lit9, Lit10, LList.list1("Bluetooth is not enabled - use Settings to turn BT on"), Lit11);
        } else
        {
            return Values.empty;
        }
    }

    public void addToComponents(Object obj, Object obj1, Object obj2, Object obj3)
    {
        components$Mnto$Mncreate = lists.cons(LList.list4(obj, obj1, obj2, obj3), components$Mnto$Mncreate);
    }

    public void addToEvents(Object obj, Object obj1)
    {
        events$Mnto$Mnregister = lists.cons(lists.cons(obj, obj1), events$Mnto$Mnregister);
    }

    public void addToFormDoAfterCreation(Object obj)
    {
        form$Mndo$Mnafter$Mncreation = lists.cons(obj, form$Mndo$Mnafter$Mncreation);
    }

    public void addToFormEnvironment(Symbol symbol, Object obj)
    {
        androidLogForm(Format.formatToString(0, new Object[] {
            "Adding ~A to env ~A with value ~A", symbol, form$Mnenvironment, obj
        }));
        form$Mnenvironment.put(symbol, obj);
    }

    public void addToGlobalVarEnvironment(Symbol symbol, Object obj)
    {
        androidLogForm(Format.formatToString(0, new Object[] {
            "Adding ~A to env ~A with value ~A", symbol, global$Mnvar$Mnenvironment, obj
        }));
        global$Mnvar$Mnenvironment.put(symbol, obj);
    }

    public void addToGlobalVars(Object obj, Object obj1)
    {
        global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(obj, obj1), global$Mnvars$Mnto$Mncreate);
    }

    public void androidLogForm(Object obj)
    {
    }

    public Object btnDisconnect$Click()
    {
        runtime.setThisForm();
        runtime.callComponentMethod(Lit6, Lit71, LList.Empty, LList.Empty);
        return runtime.setAndCoerceProperty$Ex(Lit14, Lit15, "Disconnected", Lit4);
    }

    public Object btnSendText$Click()
    {
        runtime.setThisForm();
        if (runtime.getProperty$1(Lit6, Lit40) != Boolean.FALSE)
        {
            runtime.callComponentMethod(Lit6, Lit30, LList.list1(runtime.getProperty$1(Lit41, Lit15)), Lit42);
            return runtime.setAndCoerceProperty$Ex(Lit14, Lit15, "Message Sent", Lit4);
        } else
        {
            return Values.empty;
        }
    }

    public boolean dispatchEvent(Component component, String s, String s1, Object aobj[])
    {
        boolean flag = false;
        SimpleSymbol simplesymbol = misc.string$To$Symbol(s);
        if (isBoundInFormEnvironment(simplesymbol))
        {
            if (lookupInFormEnvironment(simplesymbol) == component)
            {
                component = ((Component) (lookupHandler(s, s1)));
                try
                {
                    Scheme.apply.apply2(component, LList.makeList(aobj, 0));
                }
                // Misplaced declaration of an exception variable
                catch (Component component)
                {
                    androidLogForm(component.getMessage());
                    component.printStackTrace();
                    processException(component);
                    return false;
                }
                flag = true;
            }
            return flag;
        } else
        {
            EventDispatcher.unregisterEventForDelegation(this, s, s1);
            return false;
        }
    }

    public boolean isBoundInFormEnvironment(Symbol symbol)
    {
        return form$Mnenvironment.isBound(symbol);
    }

    public Object lookupHandler(Object obj, Object obj1)
    {
        Object obj2 = null;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        if (obj1 == null)
        {
            obj1 = obj2;
        } else
        {
            obj1 = obj1.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(((String) (obj)), ((String) (obj1)))));
    }

    public Object lookupInFormEnvironment(Symbol symbol)
    {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public Object lookupInFormEnvironment(Symbol symbol, Object obj)
    {
        int i;
        if (form$Mnenvironment == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i = i + 1 & 1;
        if (i == 0 ? i != 0 : form$Mnenvironment.isBound(symbol))
        {
            obj = form$Mnenvironment.get(symbol);
        }
        return obj;
    }

    public Object lpConnect$AfterPicking()
    {
        runtime.setThisForm();
        if (runtime.callComponentMethod(Lit6, Lit27, LList.list1(runtime.getProperty$1(Lit20, Lit28)), Lit29) != Boolean.FALSE)
        {
            runtime.callComponentMethod(Lit6, Lit30, LList.list1("Client connected"), Lit31);
            return runtime.setAndCoerceProperty$Ex(Lit14, Lit15, "Client connected", Lit4);
        } else
        {
            return Values.empty;
        }
    }

    public Object lpConnect$BeforePicking()
    {
        runtime.setThisForm();
        return runtime.setAndCoerceProperty$Ex(Lit20, Lit22, runtime.getProperty$1(Lit6, Lit23), Lit24);
    }

    public void processException(Object obj)
    {
        Object obj1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(obj, Lit1));
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = obj1.toString();
        }
        if (obj instanceof YailRuntimeError)
        {
            obj = ((YailRuntimeError)obj).getErrorType();
        } else
        {
            obj = "Runtime Error";
        }
        RuntimeErrorAlert.alert(this, ((String) (obj1)), ((String) (obj)), "End Application");
    }

    public void run()
    {
        CallContext callcontext;
        gnu.lists.Consumer consumer;
        callcontext = CallContext.getInstance();
        consumer = callcontext.consumer;
        callcontext.consumer = VoidConsumer.instance;
        run(callcontext);
        Throwable throwable = null;
_L2:
        ModuleBody.runCleanup(callcontext, throwable, consumer);
        return;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void run(CallContext callcontext)
    {
        gnu.lists.Consumer consumer = callcontext.consumer;
        callcontext = ((CallContext) (require.find("com.google.youngandroid.runtime")));
        Runnable runnable;
        try
        {
            runnable = (Runnable)callcontext;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "java.lang.Runnable.run()", 1, callcontext);
        }
        runnable.run();
        $Stdebug$Mnform$St = Boolean.FALSE;
        form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
        callcontext = strings.stringAppend(new Object[] {
            misc.symbol$To$String(Lit0), "-global-vars"
        });
        if (callcontext == null)
        {
            callcontext = null;
        } else
        {
            callcontext = callcontext.toString();
        }
        global$Mnvar$Mnenvironment = Environment.make(callcontext);
        Screen1 = null;
        form$Mnname$Mnsymbol = Lit0;
        events$Mnto$Mnregister = LList.Empty;
        components$Mnto$Mncreate = LList.Empty;
        global$Mnvars$Mnto$Mncreate = LList.Empty;
        form$Mndo$Mnafter$Mncreation = LList.Empty;
        callcontext = ((CallContext) (require.find("com.google.youngandroid.runtime")));
        try
        {
            runnable = (Runnable)callcontext;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "java.lang.Runnable.run()", 1, callcontext);
        }
        runnable.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit3, "BTClient2", Lit4);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit5, "Bluetooth Client Demo - Text and Numbers", Lit4), consumer);
        } else
        {
            addToFormDoAfterCreation(new Promise(lambda$Fn2));
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit12, Screen1$Initialize);
        } else
        {
            addToFormEnvironment(Lit12, Screen1$Initialize);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Screen1", "Initialize");
        } else
        {
            addToEvents(Lit0, Lit13);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit17, Screen1$ErrorOccurred);
        } else
        {
            addToFormEnvironment(Lit17, Screen1$ErrorOccurred);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Screen1", "ErrorOccurred");
        } else
        {
            addToEvents(Lit0, Lit18);
        }
        lpConnect = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit19, Lit20, lambda$Fn3), consumer);
        } else
        {
            addToComponents(Lit0, Lit21, Lit20, lambda$Fn4);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit25, lpConnect$BeforePicking);
        } else
        {
            addToFormEnvironment(Lit25, lpConnect$BeforePicking);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "lpConnect", "BeforePicking");
        } else
        {
            addToEvents(Lit20, Lit26);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit32, lpConnect$AfterPicking);
        } else
        {
            addToFormEnvironment(Lit32, lpConnect$AfterPicking);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "lpConnect", "AfterPicking");
        } else
        {
            addToEvents(Lit20, Lit33);
        }
        HorizontalArrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit34, Lit35, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit36, Lit35, Boolean.FALSE);
        }
        btnSendText = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit35, Lit37, Lit38, lambda$Fn5), consumer);
        } else
        {
            addToComponents(Lit35, Lit39, Lit38, lambda$Fn6);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit43, btnSendText$Click);
        } else
        {
            addToFormEnvironment(Lit43, btnSendText$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "btnSendText", "Click");
        } else
        {
            addToEvents(Lit38, Lit44);
        }
        txbTextToSend = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit35, Lit45, Lit41, lambda$Fn7), consumer);
        } else
        {
            addToComponents(Lit35, Lit47, Lit41, lambda$Fn8);
        }
        HorizontalArrangement2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit48, Lit49, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit50, Lit49, Boolean.FALSE);
        }
        Label4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit51, Lit52, lambda$Fn9), consumer);
        } else
        {
            addToComponents(Lit49, Lit55, Lit52, lambda$Fn10);
        }
        lblCommandReceived = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit56, Lit57, lambda$Fn11), consumer);
        } else
        {
            addToComponents(Lit49, Lit58, Lit57, lambda$Fn12);
        }
        HorizontalArrangement3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit59, Lit60, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit61, Lit60, Boolean.FALSE);
        }
        Label3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit60, Lit62, Lit63, lambda$Fn13), consumer);
        } else
        {
            addToComponents(Lit60, Lit64, Lit63, lambda$Fn14);
        }
        lblDataReceived = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit60, Lit65, Lit66, lambda$Fn15), consumer);
        } else
        {
            addToComponents(Lit60, Lit67, Lit66, lambda$Fn16);
        }
        btnDisconnect = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit68, Lit69, lambda$Fn17), consumer);
        } else
        {
            addToComponents(Lit0, Lit70, Lit69, lambda$Fn18);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit72, btnDisconnect$Click);
        } else
        {
            addToFormEnvironment(Lit72, btnDisconnect$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "btnDisconnect", "Click");
        } else
        {
            addToEvents(Lit69, Lit44);
        }
        HorizontalArrangement4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit73, Lit74, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit75, Lit74, Boolean.FALSE);
        }
        Label1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit74, Lit76, Lit77, lambda$Fn19), consumer);
        } else
        {
            addToComponents(Lit74, Lit78, Lit77, lambda$Fn20);
        }
        lblStatus = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit74, Lit79, Lit14, lambda$Fn21), consumer);
        } else
        {
            addToComponents(Lit74, Lit84, Lit14, lambda$Fn22);
        }
        BluetoothClient1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit85, Lit6, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit86, Lit6, Boolean.FALSE);
        }
        Clock1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit87, Lit88, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit89, Lit88, Boolean.FALSE);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit107, Clock1$Timer);
        } else
        {
            addToFormEnvironment(Lit107, Clock1$Timer);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Clock1", "Timer");
        } else
        {
            addToEvents(Lit88, Lit108);
        }
        Notifier1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit109, Lit9, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit110, Lit9, Boolean.FALSE);
        }
        runtime.initRuntime();
    }

    public void sendError(Object obj)
    {
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        RetValManager.sendError(((String) (obj)));
    }

    static 
    {
        Lit123 = (SimpleSymbol)(new SimpleSymbol("any")).readResolve();
        Lit106 = PairWithPosition.make(Lit123, PairWithPosition.make(Lit123, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d725), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d720);
        Lit103 = PairWithPosition.make(Lit123, PairWithPosition.make(Lit123, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d614), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d60f);
        Lit100 = PairWithPosition.make(Lit123, PairWithPosition.make(Lit123, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d503), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d4fe);
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("number")).readResolve();
        Lit83 = simplesymbol;
        Lit98 = PairWithPosition.make(simplesymbol, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d489);
        Lit96 = PairWithPosition.make(Lit123, PairWithPosition.make(Lit123, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d39d), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d398);
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("text")).readResolve();
        Lit4 = simplesymbol;
        Lit95 = PairWithPosition.make(simplesymbol, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d329), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d323);
        Lit93 = PairWithPosition.make(Lit83, PairWithPosition.make(Lit83, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d1fa), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d1f2);
        Lit92 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d18a), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x8d184);
        Lit54 = (SimpleSymbol)(new SimpleSymbol("boolean")).readResolve();
        Lit42 = PairWithPosition.make(Lit4, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x2a0ad);
        Lit31 = PairWithPosition.make(Lit4, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x1c0e3);
        Lit29 = PairWithPosition.make(Lit4, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x1c076);
        Lit16 = PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, PairWithPosition.make(Lit4, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x11115), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x11110), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x1110b), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x11106), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x11101), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x110fc), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x110f7), "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 0x110f1);
        Lit11 = PairWithPosition.make(Lit4, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 61692);
        Lit8 = PairWithPosition.make(Lit54, LList.Empty, "/tmp/1458048835321_0.8880071447356849-0/youngandroidproject/../src/appinventor/ai_karnabanuk123/BTClient2/Screen1.yail", 61543);
    }

    private class frame extends ModuleBody
    {

        Screen1 $main;

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            case 19: // '\023'
            default:
                return super.apply0(modulemethod);

            case 15: // '\017'
                return Screen1.lambda2();

            case 16: // '\020'
                $main.$define();
                return Values.empty;

            case 17: // '\021'
                return Screen1.lambda3();

            case 18: // '\022'
                return $main.Screen1$Initialize();

            case 20: // '\024'
                return Screen1.lambda4();

            case 21: // '\025'
                return Screen1.lambda5();

            case 22: // '\026'
                return $main.lpConnect$BeforePicking();

            case 23: // '\027'
                return $main.lpConnect$AfterPicking();

            case 24: // '\030'
                return Screen1.lambda6();

            case 25: // '\031'
                return Screen1.lambda7();

            case 26: // '\032'
                return $main.btnSendText$Click();

            case 27: // '\033'
                return Screen1.lambda8();

            case 28: // '\034'
                return Screen1.lambda9();

            case 29: // '\035'
                return Screen1.lambda10();

            case 30: // '\036'
                return Screen1.lambda11();

            case 31: // '\037'
                return Screen1.lambda12();

            case 32: // ' '
                return Screen1.lambda13();

            case 33: // '!'
                return Screen1.lambda14();

            case 34: // '"'
                return Screen1.lambda15();

            case 35: // '#'
                return Screen1.lambda16();

            case 36: // '$'
                return Screen1.lambda17();

            case 37: // '%'
                return Screen1.lambda18();

            case 38: // '&'
                return Screen1.lambda19();

            case 39: // '\''
                return $main.btnDisconnect$Click();

            case 40: // '('
                return Screen1.lambda20();

            case 41: // ')'
                return Screen1.lambda21();

            case 42: // '*'
                return Screen1.lambda22();

            case 43: // '+'
                return Screen1.lambda23();

            case 44: // ','
                return $main.Clock1$Timer();
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            switch (modulemethod.selector)
            {
            case 2: // '\002'
            case 4: // '\004'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            default:
                return super.apply1(modulemethod, obj);

            case 1: // '\001'
                $main.androidLogForm(obj);
                return Values.empty;

            case 3: // '\003'
                modulemethod = $main;
                Symbol symbol;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
                }
                return modulemethod.lookupInFormEnvironment(symbol);

            case 5: // '\005'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "is-bound-in-form-environment", 1, obj);
                }
                if (modulemethod.isBoundInFormEnvironment(symbol))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }

            case 10: // '\n'
                $main.addToFormDoAfterCreation(obj);
                return Values.empty;

            case 11: // '\013'
                $main.sendError(obj);
                return Values.empty;

            case 12: // '\f'
                $main.processException(obj);
                return Values.empty;
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            switch (modulemethod.selector)
            {
            case 4: // '\004'
            case 5: // '\005'
            case 8: // '\b'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            default:
                return super.apply2(modulemethod, obj, obj1);

            case 2: // '\002'
                modulemethod = $main;
                Symbol symbol;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "add-to-form-environment", 1, obj);
                }
                modulemethod.addToFormEnvironment(symbol, obj1);
                return Values.empty;

            case 3: // '\003'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
                }
                return modulemethod.lookupInFormEnvironment(symbol, obj1);

            case 6: // '\006'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "add-to-global-var-environment", 1, obj);
                }
                modulemethod.addToGlobalVarEnvironment(symbol, obj1);
                return Values.empty;

            case 7: // '\007'
                $main.addToEvents(obj, obj1);
                return Values.empty;

            case 9: // '\t'
                $main.addToGlobalVars(obj, obj1);
                return Values.empty;

            case 14: // '\016'
                return $main.lookupHandler(obj, obj1);
            }
        }

        public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply4(modulemethod, obj, obj1, obj2, obj3);

            case 8: // '\b'
                $main.addToComponents(obj, obj1, obj2, obj3);
                return Values.empty;

            case 13: // '\r'
                modulemethod = $main;
                Component component;
                try
                {
                    component = (Component)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 1, obj);
                }
                try
                {
                    obj = (String)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 2, obj1);
                }
                try
                {
                    obj1 = (String)obj2;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 3, obj2);
                }
                try
                {
                    obj2 = ((Object) ((Object[])obj3));
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 4, obj3);
                }
                if (modulemethod.dispatchEvent(component, ((String) (obj)), ((String) (obj1)), ((Object []) (obj2))))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }

            case 19: // '\023'
                return $main.Screen1$ErrorOccurred(obj, obj1, obj2, obj3);
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 19: // '\023'
            default:
                return super.match0(modulemethod, callcontext);

            case 44: // ','
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 43: // '+'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 42: // '*'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 41: // ')'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 40: // '('
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 39: // '\''
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 38: // '&'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 37: // '%'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 36: // '$'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 35: // '#'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 34: // '"'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 33: // '!'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 32: // ' '
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 31: // '\037'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 30: // '\036'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 29: // '\035'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 28: // '\034'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 27: // '\033'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 26: // '\032'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 25: // '\031'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 24: // '\030'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 23: // '\027'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 22: // '\026'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 21: // '\025'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 20: // '\024'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 18: // '\022'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 17: // '\021'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 16: // '\020'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 15: // '\017'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            int i = 0xfff40001;
            modulemethod.selector;
            JVM INSTR tableswitch 1 12: default 72
        //                       1 190
        //                       2 72
        //                       3 166
        //                       4 72
        //                       5 142
        //                       6 72
        //                       7 72
        //                       8 72
        //                       9 72
        //                       10 125
        //                       11 108
        //                       12 84;
               goto _L1 _L2 _L1 _L3 _L1 _L4 _L1 _L1 _L1 _L1 _L5 _L6 _L7
_L1:
            i = super.match1(modulemethod, obj, callcontext);
_L9:
            return i;
_L7:
            if (!(obj instanceof Screen1)) goto _L9; else goto _L8
_L8:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L6:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L5:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L4:
            if (!(obj instanceof Symbol)) goto _L9; else goto _L10
_L10:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L3:
            if (!(obj instanceof Symbol)) goto _L9; else goto _L11
_L11:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L2:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 4: // '\004'
            case 5: // '\005'
            case 8: // '\b'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            default:
                return super.match2(modulemethod, obj, obj1, callcontext);

            case 14: // '\016'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 9: // '\t'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 7: // '\007'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 6: // '\006'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.value2 = obj1;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 2;
                    return 0;
                }

            case 3: // '\003'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.value2 = obj1;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 2;
                    return 0;
                }

            case 2: // '\002'
                break;
            }
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }

        public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

            case 19: // '\023'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;

            case 13: // '\r'
                if (!(obj instanceof Screen1))
                {
                    return 0xfff40001;
                }
                callcontext.value1 = obj;
                if (!(obj1 instanceof Component))
                {
                    return 0xfff40002;
                }
                callcontext.value2 = obj1;
                if (!(obj2 instanceof String))
                {
                    return 0xfff40003;
                }
                callcontext.value3 = obj2;
                if (!(obj3 instanceof String))
                {
                    return 0xfff40004;
                } else
                {
                    callcontext.value4 = obj3;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 4;
                    return 0;
                }

            case 8: // '\b'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            }
        }

        public frame()
        {
        }
    }

}
