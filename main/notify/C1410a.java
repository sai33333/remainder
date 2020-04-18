package notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.RingtoneManager;
import android.net.Uri;
import com.outlook.healthyapps.reminder.R;

/* renamed from: notify.a */
public class C1410a extends ContextWrapper {

    /* renamed from: a */
    private NotificationManager f5099a;

    public C1410a(Context context) {
        super(context);
        AudioAttributes build = new Builder().setContentType(4).setUsage(5).build();
        Uri defaultUri = RingtoneManager.getDefaultUri(4);
        NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_10", "Reminder", 4);
        notificationChannel.setLightColor(-1);
        notificationChannel.setLockscreenVisibility(1);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000});
        notificationChannel.setSound(defaultUri, build);
        m6454b().createNotificationChannel(notificationChannel);
    }

    /* renamed from: a */
    private int m6453a() {
        return R.drawable.ic_notif;
    }

    /* renamed from: b */
    private NotificationManager m6454b() {
        if (this.f5099a == null) {
            this.f5099a = (NotificationManager) getSystemService("notification");
        }
        return this.f5099a;
    }

    /* renamed from: a */
    public Notification.Builder mo3745a(String str, PendingIntent pendingIntent) {
        return new Notification.Builder(getApplicationContext(), "CHANNEL_10").setContentTitle("Reminder").setContentText(str).setSmallIcon(m6453a()).setColor(-16776961).setContentIntent(pendingIntent).setAutoCancel(false);
    }

    /* renamed from: a */
    public void mo3746a(int i, Notification.Builder builder) {
        m6454b().notify(i, builder.build());
    }
}
