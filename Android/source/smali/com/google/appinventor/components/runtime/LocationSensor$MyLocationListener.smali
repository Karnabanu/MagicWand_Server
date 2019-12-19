.class Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;
.super Ljava/lang/Object;
.source "LocationSensor.java"

# interfaces
.implements Landroid/location/LocationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/appinventor/components/runtime/LocationSensor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyLocationListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/LocationSensor;


# direct methods
.method private constructor <init>(Lcom/google/appinventor/components/runtime/LocationSensor;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/appinventor/components/runtime/LocationSensor;Lcom/google/appinventor/components/runtime/LocationSensor$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/appinventor/components/runtime/LocationSensor;
    .param p2, "x1"    # Lcom/google/appinventor/components/runtime/LocationSensor$1;

    .prologue
    .line 72
    invoke-direct {p0, p1}, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;-><init>(Lcom/google/appinventor/components/runtime/LocationSensor;)V

    return-void
.end method


# virtual methods
.method public onLocationChanged(Landroid/location/Location;)V
    .locals 8
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    const/4 v6, 0x1

    const-wide/16 v4, 0x0

    .line 78
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # setter for: Lcom/google/appinventor/components/runtime/LocationSensor;->lastLocation:Landroid/location/Location;
    invoke-static {v0, p1}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$002(Lcom/google/appinventor/components/runtime/LocationSensor;Landroid/location/Location;)Landroid/location/Location;

    .line 79
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    # setter for: Lcom/google/appinventor/components/runtime/LocationSensor;->longitude:D
    invoke-static {v0, v2, v3}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$102(Lcom/google/appinventor/components/runtime/LocationSensor;D)D

    .line 80
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    # setter for: Lcom/google/appinventor/components/runtime/LocationSensor;->latitude:D
    invoke-static {v0, v2, v3}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$202(Lcom/google/appinventor/components/runtime/LocationSensor;D)D

    .line 83
    invoke-virtual {p1}, Landroid/location/Location;->hasAltitude()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # setter for: Lcom/google/appinventor/components/runtime/LocationSensor;->hasAltitude:Z
    invoke-static {v0, v6}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$302(Lcom/google/appinventor/components/runtime/LocationSensor;Z)Z

    .line 85
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-virtual {p1}, Landroid/location/Location;->getAltitude()D

    move-result-wide v2

    # setter for: Lcom/google/appinventor/components/runtime/LocationSensor;->altitude:D
    invoke-static {v0, v2, v3}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$402(Lcom/google/appinventor/components/runtime/LocationSensor;D)D

    .line 90
    :cond_0
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->longitude:D
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$100(Lcom/google/appinventor/components/runtime/LocationSensor;)D

    move-result-wide v0

    cmpl-double v0, v0, v4

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->latitude:D
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$200(Lcom/google/appinventor/components/runtime/LocationSensor;)D

    move-result-wide v0

    cmpl-double v0, v0, v4

    if-eqz v0, :cond_2

    .line 91
    :cond_1
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # setter for: Lcom/google/appinventor/components/runtime/LocationSensor;->hasLocationData:Z
    invoke-static {v0, v6}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$502(Lcom/google/appinventor/components/runtime/LocationSensor;Z)Z

    .line 92
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->latitude:D
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$200(Lcom/google/appinventor/components/runtime/LocationSensor;)D

    move-result-wide v2

    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->longitude:D
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$100(Lcom/google/appinventor/components/runtime/LocationSensor;)D

    move-result-wide v4

    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->altitude:D
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$400(Lcom/google/appinventor/components/runtime/LocationSensor;)D

    move-result-wide v6

    invoke-virtual/range {v1 .. v7}, Lcom/google/appinventor/components/runtime/LocationSensor;->LocationChanged(DDD)V

    .line 94
    :cond_2
    return-void
.end method

.method public onProviderDisabled(Ljava/lang/String;)V
    .locals 2
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 98
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    const-string v1, "Disabled"

    invoke-virtual {v0, p1, v1}, Lcom/google/appinventor/components/runtime/LocationSensor;->StatusChanged(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # invokes: Lcom/google/appinventor/components/runtime/LocationSensor;->stopListening()V
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$600(Lcom/google/appinventor/components/runtime/LocationSensor;)V

    .line 100
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->enabled:Z
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$700(Lcom/google/appinventor/components/runtime/LocationSensor;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->RefreshProvider()V

    .line 103
    :cond_0
    return-void
.end method

.method public onProviderEnabled(Ljava/lang/String;)V
    .locals 2
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 107
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    const-string v1, "Enabled"

    invoke-virtual {v0, p1, v1}, Lcom/google/appinventor/components/runtime/LocationSensor;->StatusChanged(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->RefreshProvider()V

    .line 109
    return-void
.end method

.method public onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 2
    .param p1, "provider"    # Ljava/lang/String;
    .param p2, "status"    # I
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 113
    packed-switch p2, :pswitch_data_0

    .line 138
    :cond_0
    :goto_0
    return-void

    .line 116
    :pswitch_0
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    const-string v1, "TEMPORARILY_UNAVAILABLE"

    invoke-virtual {v0, p1, v1}, Lcom/google/appinventor/components/runtime/LocationSensor;->StatusChanged(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 121
    :pswitch_1
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    const-string v1, "OUT_OF_SERVICE"

    invoke-virtual {v0, p1, v1}, Lcom/google/appinventor/components/runtime/LocationSensor;->StatusChanged(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->providerName:Ljava/lang/String;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$800(Lcom/google/appinventor/components/runtime/LocationSensor;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # invokes: Lcom/google/appinventor/components/runtime/LocationSensor;->stopListening()V
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$600(Lcom/google/appinventor/components/runtime/LocationSensor;)V

    .line 125
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->RefreshProvider()V

    goto :goto_0

    .line 131
    :pswitch_2
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    const-string v1, "AVAILABLE"

    invoke-virtual {v0, p1, v1}, Lcom/google/appinventor/components/runtime/LocationSensor;->StatusChanged(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->providerName:Ljava/lang/String;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$800(Lcom/google/appinventor/components/runtime/LocationSensor;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    # getter for: Lcom/google/appinventor/components/runtime/LocationSensor;->allProviders:Ljava/util/List;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->access$900(Lcom/google/appinventor/components/runtime/LocationSensor;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 134
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/LocationSensor$MyLocationListener;->this$0:Lcom/google/appinventor/components/runtime/LocationSensor;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/LocationSensor;->RefreshProvider()V

    goto :goto_0

    .line 113
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
