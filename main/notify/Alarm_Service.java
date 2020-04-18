package notify;

import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p005v4.app.C0123t;
import android.support.p005v4.app.C0135v.C0137b;
import android.support.p005v4.app.C0135v.C0138c;
import android.support.p005v4.app.C0135v.C0139d;
import app.Activity_Create;
import app.Activity_List;
import com.outlook.healthyapps.reminder.R;

public class Alarm_Service extends C0123t {

    /* renamed from: j */
    private C1410a f5098j;

    /* renamed from: a */
    public static void m6451a(Context context, Intent intent) {
        m617a(context, Alarm_Service.class, 1, intent);
    }

    /* renamed from: a */
    public void mo524a(Intent intent) {
        Bundle extras = intent.getExtras();
        int i = extras.getInt("bID");
        String string = extras.getString("bTITLE");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        int parseInt = Integer.parseInt(defaultSharedPreferences.getString(getString(R.string.prefKey_notificationStyle), "3"));
        int parseInt2 = Integer.parseInt(defaultSharedPreferences.getString(getString(R.string.prefKey_snooze), getString(R.string.snoozeLength_default)));
        C0138c cVar = new C0138c(this);
        Intent intent2 = new Intent(this, Activity_List.class);
        intent2.addFlags(268468224);
        Intent intent3 = new Intent();
        intent3.setAction("_DELETE");
        intent3.putExtra("bID", i);
        Intent intent4 = new Intent();
        intent4.setAction("_SNOOZE");
        intent4.putExtra("bID", i);
        intent4.putExtra("bSNOOZE_LEN", parseInt2);
        Intent intent5 = new Intent(this, Activity_Create.class);
        intent5.setFlags(67108864);
        intent5.putExtra("bID", i);
        PendingIntent activity = PendingIntent.getActivity(this, i, intent2, 134217728);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, i, intent3, 134217728);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this, i, intent4, 134217728);
        PendingIntent activity2 = PendingIntent.getActivity(this, i, intent5, 134217728);
        cVar.mo559a((CharSequence) "Reminder");
        cVar.mo554a((int) R.drawable.ic_notif);
        cVar.mo557a(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        cVar.mo558a((C0139d) new C0137b().mo553a(string));
        cVar.mo562c(string);
        cVar.mo561b((CharSequence) string);
        cVar.mo556a(activity);
        cVar.mo560b(1);
        cVar.mo555a(R.drawable.ic_delete, "Delete", broadcast);
        cVar.mo555a(R.drawable.ic_snooz, "Snooze", broadcast2);
        cVar.mo555a(R.drawable.ic_edit, "Edit", activity2);
        this.f5098j = new C1410a(this);
        Builder a = this.f5098j.mo3745a(string, activity);
        if (a != null) {
            this.f5098j.mo3746a(i, a);
        }
        if (parseInt != 1) {
            Intent intent6 = new Intent(this, Activity_Popup.class);
            intent6.putExtra("bID", i);
            intent6.setFlags(402653184);
            startActivity(intent6);
        }
    }
}
