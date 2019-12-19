.class public Lcom/google/appinventor/components/runtime/FirebaseDB;
.super Lcom/google/appinventor/components/runtime/AndroidNonvisibleComponent;
.source "FirebaseDB.java"

# interfaces
.implements Lcom/google/appinventor/components/runtime/Component;


# annotations
.annotation runtime Lcom/google/appinventor/components/annotations/DesignerComponent;
    category = .enum Lcom/google/appinventor/components/common/ComponentCategory;->EXPERIMENTAL:Lcom/google/appinventor/components/common/ComponentCategory;
    description = "Non-visible component that communicates with Firebase to store and retrieve information."
    designerHelpDescription = "Non-visible component that communicates with a Firebase to store and retrieve information."
    iconName = "images/firebaseDB.png"
    nonVisible = true
    version = 0x1
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/SimpleObject;
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/UsesLibraries;
    libraries = "firebase.jar"
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/UsesPermissions;
    permissionNames = "android.permission.INTERNET"
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "Firebase"


# instance fields
.field private final activity:Landroid/app/Activity;

.field private androidUIHandler:Landroid/os/Handler;

.field private authListener:Lcom/firebase/client/Firebase$AuthStateListener;

.field private childListener:Lcom/firebase/client/ChildEventListener;

.field private defaultURL:Ljava/lang/String;

.field private developerBucket:Ljava/lang/String;

.field private firebaseToken:Ljava/lang/String;

.field private firebaseURL:Ljava/lang/String;

.field private myFirebase:Lcom/firebase/client/Firebase;

.field private projectBucket:Ljava/lang/String;

.field private useDefault:Z


# direct methods
.method public constructor <init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
    .locals 2
    .param p1, "container"    # Lcom/google/appinventor/components/runtime/ComponentContainer;

    .prologue
    const/4 v1, 0x0

    .line 85
    invoke-interface {p1}, Lcom/google/appinventor/components/runtime/ComponentContainer;->$form()Lcom/google/appinventor/components/runtime/Form;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/appinventor/components/runtime/AndroidNonvisibleComponent;-><init>(Lcom/google/appinventor/components/runtime/Form;)V

    .line 67
    iput-object v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    .line 68
    iput-object v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->defaultURL:Ljava/lang/String;

    .line 69
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    .line 90
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->androidUIHandler:Landroid/os/Handler;

    .line 91
    invoke-interface {p1}, Lcom/google/appinventor/components/runtime/ComponentContainer;->$context()Landroid/app/Activity;

    move-result-object v0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->activity:Landroid/app/Activity;

    .line 92
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->activity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/firebase/client/Firebase;->setAndroidContext(Landroid/content/Context;)V

    .line 94
    const-string v0, ""

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->developerBucket:Ljava/lang/String;

    .line 95
    const-string v0, ""

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->projectBucket:Ljava/lang/String;

    .line 96
    const-string v0, ""

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseToken:Ljava/lang/String;

    .line 98
    new-instance v0, Lcom/google/appinventor/components/runtime/FirebaseDB$1;

    invoke-direct {v0, p0}, Lcom/google/appinventor/components/runtime/FirebaseDB$1;-><init>(Lcom/google/appinventor/components/runtime/FirebaseDB;)V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->childListener:Lcom/firebase/client/ChildEventListener;

    .line 149
    new-instance v0, Lcom/google/appinventor/components/runtime/FirebaseDB$2;

    invoke-direct {v0, p0}, Lcom/google/appinventor/components/runtime/FirebaseDB$2;-><init>(Lcom/google/appinventor/components/runtime/FirebaseDB;)V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->authListener:Lcom/firebase/client/Firebase$AuthStateListener;

    .line 168
    return-void
.end method

.method static synthetic access$000(Lcom/google/appinventor/components/runtime/FirebaseDB;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/FirebaseDB;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->androidUIHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/appinventor/components/runtime/FirebaseDB;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/FirebaseDB;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseToken:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/google/appinventor/components/runtime/FirebaseDB;)Lcom/firebase/client/Firebase;
    .locals 1
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/FirebaseDB;

    .prologue
    .line 64
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    return-object v0
.end method

.method private connectFirebase()V
    .locals 4

    .prologue
    .line 461
    invoke-static {}, Lcom/google/appinventor/components/runtime/util/SdkLevel;->getLevel()I

    move-result v0

    const/16 v1, 0xa

    if-ge v0, v1, :cond_0

    .line 462
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->activity:Landroid/app/Activity;

    const-string v1, "The version of Android on this device is too old to use Firebase."

    const-string v2, "Android Too Old"

    const-string v3, "OK"

    invoke-static {v0, v1, v2, v3}, Lcom/google/appinventor/components/runtime/Notifier;->oneButtonAlert(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 474
    :goto_0
    return-void

    .line 466
    :cond_0
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    if-eqz v0, :cond_1

    .line 467
    new-instance v0, Lcom/firebase/client/Firebase;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "developers/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->developerBucket:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->projectBucket:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/firebase/client/Firebase;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    .line 472
    :goto_1
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->childListener:Lcom/firebase/client/ChildEventListener;

    invoke-virtual {v0, v1}, Lcom/firebase/client/Firebase;->addChildEventListener(Lcom/firebase/client/ChildEventListener;)Lcom/firebase/client/ChildEventListener;

    .line 473
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->authListener:Lcom/firebase/client/Firebase$AuthStateListener;

    invoke-virtual {v0, v1}, Lcom/firebase/client/Firebase;->addAuthStateListener(Lcom/firebase/client/Firebase$AuthStateListener;)Lcom/firebase/client/Firebase$AuthStateListener;

    goto :goto_0

    .line 469
    :cond_1
    new-instance v0, Lcom/firebase/client/Firebase;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->projectBucket:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/firebase/client/Firebase;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    goto :goto_1
.end method

.method private resetListener()V
    .locals 2

    .prologue
    .line 297
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    if-eqz v0, :cond_0

    .line 298
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->childListener:Lcom/firebase/client/ChildEventListener;

    invoke-virtual {v0, v1}, Lcom/firebase/client/Firebase;->removeEventListener(Lcom/firebase/client/ChildEventListener;)V

    .line 299
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->authListener:Lcom/firebase/client/Firebase$AuthStateListener;

    invoke-virtual {v0, v1}, Lcom/firebase/client/Firebase;->removeAuthStateListener(Lcom/firebase/client/Firebase$AuthStateListener;)V

    .line 302
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    .line 303
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->connectFirebase()V

    .line 304
    return-void
.end method


# virtual methods
.method public DataChanged(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleEvent;
    .end annotation

    .prologue
    .line 435
    if-eqz p2, :cond_0

    :try_start_0
    instance-of v1, p2, Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 436
    check-cast p2, Ljava/lang/String;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-static {p2}, Lcom/google/appinventor/components/runtime/util/JsonUtil;->getObjectFromJson(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p2

    .line 443
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_0
    const-string v1, "DataChanged"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-static {p0, v1, v2}, Lcom/google/appinventor/components/runtime/EventDispatcher;->dispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 444
    return-void

    .line 438
    .end local p2    # "value":Ljava/lang/Object;
    :catch_0
    move-exception v0

    .line 439
    .local v0, "e":Lorg/json/JSONException;
    new-instance v1, Lcom/google/appinventor/components/runtime/errors/YailRuntimeError;

    const-string v2, "Value failed to convert from JSON."

    const-string v3, "JSON Retrieval Error."

    invoke-direct {v1, v2, v3}, Lcom/google/appinventor/components/runtime/errors/YailRuntimeError;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    throw v1
.end method

.method public DefaultURL(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/DesignerProperty;
        editorType = "string"
    .end annotation

    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->BEHAVIOR:Lcom/google/appinventor/components/annotations/PropertyCategory;
        userVisible = false
    .end annotation

    .prologue
    .line 519
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->defaultURL:Ljava/lang/String;

    .line 520
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    if-eqz v0, :cond_0

    .line 521
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->defaultURL:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    .line 522
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->resetListener()V

    .line 524
    :cond_0
    return-void
.end method

.method public DeveloperBucket()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->BEHAVIOR:Lcom/google/appinventor/components/annotations/PropertyCategory;
        userVisible = false
    .end annotation

    .prologue
    .line 229
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->developerBucket:Ljava/lang/String;

    return-object v0
.end method

.method public DeveloperBucket(Ljava/lang/String;)V
    .locals 0
    .param p1, "bucket"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/DesignerProperty;
        editorType = "string"
    .end annotation

    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
    .end annotation

    .prologue
    .line 242
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->developerBucket:Ljava/lang/String;

    .line 243
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->resetListener()V

    .line 244
    return-void
.end method

.method public FirebaseError(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleEvent;
    .end annotation

    .prologue
    .line 454
    const-string v0, "Firebase"

    invoke-static {v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 457
    const-string v0, "FirebaseError"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-static {p0, v0, v1}, Lcom/google/appinventor/components/runtime/EventDispatcher;->dispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 458
    return-void
.end method

.method public FirebaseToken()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->BEHAVIOR:Lcom/google/appinventor/components/annotations/PropertyCategory;
        userVisible = false
    .end annotation

    .prologue
    .line 279
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseToken:Ljava/lang/String;

    return-object v0
.end method

.method public FirebaseToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "JWT"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/DesignerProperty;
        editorType = "string"
    .end annotation

    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
    .end annotation

    .prologue
    .line 291
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseToken:Ljava/lang/String;

    .line 292
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->resetListener()V

    .line 293
    return-void
.end method

.method public FirebaseURL()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->BEHAVIOR:Lcom/google/appinventor/components/annotations/PropertyCategory;
        description = "Gets the URL for this FirebaseDB."
        userVisible = false
    .end annotation

    .prologue
    .line 179
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    if-eqz v0, :cond_0

    .line 180
    const-string v0, "DEFAULT"

    .line 182
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    goto :goto_0
.end method

.method public FirebaseURL(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/DesignerProperty;
        defaultValue = "DEFAULT"
        editorType = "FirbaseURL"
    .end annotation

    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        description = "Sets the URL for this FirebaseDB."
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 198
    const-string v0, "DEFAULT"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 199
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    if-nez v0, :cond_2

    .line 200
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    .line 201
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->defaultURL:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 202
    const-string v0, "Firebase"

    const-string v1, "FirebaseURL called before DefaultURL (should not happen!)"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 220
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->defaultURL:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    .line 205
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->resetListener()V

    goto :goto_0

    .line 208
    :cond_2
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->defaultURL:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    goto :goto_0

    .line 211
    :cond_3
    iput-boolean v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    .line 212
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 215
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->firebaseURL:Ljava/lang/String;

    .line 216
    iput-boolean v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->useDefault:Z

    .line 217
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->resetListener()V

    goto :goto_0
.end method

.method public GetValue(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "valueIfTagNotThere"    # Ljava/lang/Object;
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleFunction;
    .end annotation

    .prologue
    .line 364
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    invoke-virtual {v0, p1}, Lcom/firebase/client/Firebase;->child(Ljava/lang/String;)Lcom/firebase/client/Firebase;

    move-result-object v0

    new-instance v1, Lcom/google/appinventor/components/runtime/FirebaseDB$3;

    invoke-direct {v1, p0, p2, p1}, Lcom/google/appinventor/components/runtime/FirebaseDB$3;-><init>(Lcom/google/appinventor/components/runtime/FirebaseDB;Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/firebase/client/Firebase;->addListenerForSingleValueEvent(Lcom/firebase/client/ValueEventListener;)V

    .line 403
    return-void
.end method

.method public GotValue(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleEvent;
    .end annotation

    .prologue
    .line 414
    if-eqz p2, :cond_0

    :try_start_0
    instance-of v1, p2, Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 415
    check-cast p2, Ljava/lang/String;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-static {p2}, Lcom/google/appinventor/components/runtime/util/JsonUtil;->getObjectFromJson(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p2

    .line 422
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_0
    const-string v1, "GotValue"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-static {p0, v1, v2}, Lcom/google/appinventor/components/runtime/EventDispatcher;->dispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 423
    return-void

    .line 417
    .end local p2    # "value":Ljava/lang/Object;
    :catch_0
    move-exception v0

    .line 418
    .local v0, "e":Lorg/json/JSONException;
    new-instance v1, Lcom/google/appinventor/components/runtime/errors/YailRuntimeError;

    const-string v2, "Value failed to convert from JSON."

    const-string v3, "JSON Retrieval Error."

    invoke-direct {v1, v2, v3}, Lcom/google/appinventor/components/runtime/errors/YailRuntimeError;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    throw v1
.end method

.method public ProjectBucket()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->BEHAVIOR:Lcom/google/appinventor/components/annotations/PropertyCategory;
        description = "Gets the ProjectBucket for this FirebaseDB."
    .end annotation

    .prologue
    .line 254
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->projectBucket:Ljava/lang/String;

    return-object v0
.end method

.method public ProjectBucket(Ljava/lang/String;)V
    .locals 1
    .param p1, "bucket"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/DesignerProperty;
        defaultValue = ""
        editorType = "string"
    .end annotation

    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        description = "Sets the ProjectBucket for this FirebaseDB."
    .end annotation

    .prologue
    .line 266
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->projectBucket:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 267
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->projectBucket:Ljava/lang/String;

    .line 268
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->resetListener()V

    .line 270
    :cond_0
    return-void
.end method

.method public StoreValue(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "valueToStore"    # Ljava/lang/Object;
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleFunction;
    .end annotation

    .prologue
    .line 342
    if-eqz p2, :cond_0

    .line 343
    :try_start_0
    invoke-static {p2}, Lcom/google/appinventor/components/runtime/util/JsonUtil;->getJsonRepresentation(Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p2

    .line 350
    .end local p2    # "valueToStore":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    invoke-virtual {v1, p1}, Lcom/firebase/client/Firebase;->child(Ljava/lang/String;)Lcom/firebase/client/Firebase;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/firebase/client/Firebase;->setValue(Ljava/lang/Object;)V

    .line 351
    return-void

    .line 345
    .restart local p2    # "valueToStore":Ljava/lang/Object;
    :catch_0
    move-exception v0

    .line 346
    .local v0, "e":Lorg/json/JSONException;
    new-instance v1, Lcom/google/appinventor/components/runtime/errors/YailRuntimeError;

    const-string v2, "Value failed to convert to JSON."

    const-string v3, "JSON Creation Error."

    invoke-direct {v1, v2, v3}, Lcom/google/appinventor/components/runtime/errors/YailRuntimeError;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    throw v1
.end method

.method public Unauthenticate()V
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleFunction;
        description = "If you are having difficulty with the Companion and you are switching between different Firebase accounts, you may need to use this function to clear internal Firebase caches. You can just use the \"Do It\" function on this block in the blocks editor. Note: You should not normally need to use this block as part of an application."
    .end annotation

    .prologue
    .line 502
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    if-nez v0, :cond_0

    .line 503
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->connectFirebase()V

    .line 505
    :cond_0
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB;->myFirebase:Lcom/firebase/client/Firebase;

    invoke-virtual {v0}, Lcom/firebase/client/Firebase;->unauth()V

    .line 506
    return-void
.end method
