.class Lcom/google/appinventor/components/runtime/FirebaseDB$1;
.super Ljava/lang/Object;
.source "FirebaseDB.java"

# interfaces
.implements Lcom/firebase/client/ChildEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/FirebaseDB;-><init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/FirebaseDB;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/FirebaseDB;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/FirebaseDB$1;->this$0:Lcom/google/appinventor/components/runtime/FirebaseDB;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancelled(Lcom/firebase/client/FirebaseError;)V
    .locals 2
    .param p1, "error"    # Lcom/firebase/client/FirebaseError;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB$1;->this$0:Lcom/google/appinventor/components/runtime/FirebaseDB;

    # getter for: Lcom/google/appinventor/components/runtime/FirebaseDB;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->access$000(Lcom/google/appinventor/components/runtime/FirebaseDB;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/google/appinventor/components/runtime/FirebaseDB$1$2;

    invoke-direct {v1, p0, p1}, Lcom/google/appinventor/components/runtime/FirebaseDB$1$2;-><init>(Lcom/google/appinventor/components/runtime/FirebaseDB$1;Lcom/firebase/client/FirebaseError;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 120
    return-void
.end method

.method public onChildAdded(Lcom/firebase/client/DataSnapshot;Ljava/lang/String;)V
    .locals 2
    .param p1, "snapshot"    # Lcom/firebase/client/DataSnapshot;
    .param p2, "previousChildKey"    # Ljava/lang/String;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB$1;->this$0:Lcom/google/appinventor/components/runtime/FirebaseDB;

    # getter for: Lcom/google/appinventor/components/runtime/FirebaseDB;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->access$000(Lcom/google/appinventor/components/runtime/FirebaseDB;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/google/appinventor/components/runtime/FirebaseDB$1$1;

    invoke-direct {v1, p0, p1}, Lcom/google/appinventor/components/runtime/FirebaseDB$1$1;-><init>(Lcom/google/appinventor/components/runtime/FirebaseDB$1;Lcom/firebase/client/DataSnapshot;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 109
    return-void
.end method

.method public onChildChanged(Lcom/firebase/client/DataSnapshot;Ljava/lang/String;)V
    .locals 2
    .param p1, "snapshot"    # Lcom/firebase/client/DataSnapshot;
    .param p2, "previousChildKey"    # Ljava/lang/String;

    .prologue
    .line 124
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB$1;->this$0:Lcom/google/appinventor/components/runtime/FirebaseDB;

    # getter for: Lcom/google/appinventor/components/runtime/FirebaseDB;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->access$000(Lcom/google/appinventor/components/runtime/FirebaseDB;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/google/appinventor/components/runtime/FirebaseDB$1$3;

    invoke-direct {v1, p0, p1}, Lcom/google/appinventor/components/runtime/FirebaseDB$1$3;-><init>(Lcom/google/appinventor/components/runtime/FirebaseDB$1;Lcom/firebase/client/DataSnapshot;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 131
    return-void
.end method

.method public onChildMoved(Lcom/firebase/client/DataSnapshot;Ljava/lang/String;)V
    .locals 0
    .param p1, "snapshot"    # Lcom/firebase/client/DataSnapshot;
    .param p2, "previousChildKey"    # Ljava/lang/String;

    .prologue
    .line 135
    return-void
.end method

.method public onChildRemoved(Lcom/firebase/client/DataSnapshot;)V
    .locals 2
    .param p1, "snapshot"    # Lcom/firebase/client/DataSnapshot;

    .prologue
    .line 139
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/FirebaseDB$1;->this$0:Lcom/google/appinventor/components/runtime/FirebaseDB;

    # getter for: Lcom/google/appinventor/components/runtime/FirebaseDB;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/FirebaseDB;->access$000(Lcom/google/appinventor/components/runtime/FirebaseDB;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/google/appinventor/components/runtime/FirebaseDB$1$4;

    invoke-direct {v1, p0, p1}, Lcom/google/appinventor/components/runtime/FirebaseDB$1$4;-><init>(Lcom/google/appinventor/components/runtime/FirebaseDB$1;Lcom/firebase/client/DataSnapshot;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 146
    return-void
.end method
