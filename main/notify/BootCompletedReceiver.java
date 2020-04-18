package notify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p010b.C0238a;

public class BootCompletedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new Alarm_Receiver().mo3741a(context, new C0238a(context).mo1014d());
    }
}
