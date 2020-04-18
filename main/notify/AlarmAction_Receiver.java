package notify;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import p010b.C0238a;

public class AlarmAction_Receiver extends BroadcastReceiver {

    /* renamed from: a */
    private C0238a f5095a;

    public void onReceive(Context context, Intent intent) {
        String str;
        Bundle extras = intent.getExtras();
        int i = extras.getInt("bID");
        this.f5095a = new C0238a(context);
        if (intent.getAction().equals("_SNOOZE")) {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
            int i2 = extras.getInt("bSNOOZE_LEN");
            this.f5095a.mo1005a(i, i2);
            this.f5095a.mo1015d(i);
            StringBuilder sb = new StringBuilder();
            sb.append("Snoozed. Will remind you in ");
            sb.append(i2);
            sb.append(" minutes");
            str = sb.toString();
        } else if (intent.getAction().equals("_DELETE")) {
            this.f5095a.mo1010b(i);
            this.f5095a.mo1015d(i);
            str = "Reminder deleted";
        } else {
            return;
        }
        Toast.makeText(context, str, 0).show();
    }
}
