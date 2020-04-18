package notify;

import android.app.AlarmManager;
import android.app.AlarmManager.AlarmClockInfo;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import com.outlook.healthyapps.reminder.R;
import java.util.ArrayList;
import java.util.Iterator;
import p010b.C0238a;
import p020e.C1386a;

public class Alarm_Receiver extends BroadcastReceiver {

    /* renamed from: a */
    private static Context f5096a;

    /* renamed from: b */
    private C0238a f5097b;

    /* renamed from: a */
    public void mo3739a(Context context, int i) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, i, new Intent(context, Alarm_Receiver.class), 134217728));
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    /* renamed from: a */
    public void mo3740a(Context context, C1386a aVar, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent(context, Alarm_Receiver.class);
        intent.putExtra("bID", i);
        intent.putExtra("bTITLE", aVar.mo3693b());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i, intent, 268435456);
        alarmManager.setAlarmClock(new AlarmClockInfo(aVar.mo3703f(), broadcast), broadcast);
    }

    /* renamed from: a */
    public void mo3741a(Context context, ArrayList<C1386a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1386a aVar = (C1386a) it.next();
            try {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                Intent intent = new Intent(context, Alarm_Receiver.class);
                intent.putExtra("bID", aVar.mo3687a());
                intent.putExtra("bTITLE", aVar.mo3693b());
                PendingIntent broadcast = PendingIntent.getBroadcast(context, aVar.mo3687a(), intent, 268435456);
                alarmManager.setAlarmClock(new AlarmClockInfo(aVar.mo3703f(), broadcast), broadcast);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public void mo3742b(Context context, ArrayList<C1386a> arrayList) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent(context, Alarm_Receiver.class);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1386a aVar = (C1386a) it.next();
            alarmManager.cancel(PendingIntent.getBroadcast(context, aVar.mo3687a(), intent, 134217728));
            notificationManager.cancel(aVar.mo3687a());
        }
    }

    public void onReceive(Context context, Intent intent) {
        f5096a = context;
        this.f5097b = new C0238a(context);
        Bundle extras = intent.getExtras();
        int i = extras.getInt("bID");
        String string = extras.getString("bTITLE");
        this.f5097b.mo1013c(i);
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        powerManager.newWakeLock(1, "::Wakes CPU").acquire(6000);
        if (PreferenceManager.getDefaultSharedPreferences(f5096a).getBoolean(f5096a.getString(R.string.prefKey_turnOnScreen), true)) {
            powerManager.newWakeLock(805306394, "Reminder: Wakes Screen").acquire(6000);
        }
        Intent intent2 = new Intent(f5096a, Alarm_Service.class);
        intent2.putExtra("bID", i);
        intent2.putExtra("bTITLE", string);
        Alarm_Service.m6451a(context, intent2);
    }
}
