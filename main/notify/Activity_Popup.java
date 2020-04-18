package notify;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import app.Activity_Create;
import com.outlook.healthyapps.reminder.R;
import p010b.C0238a;
import p011c.C0239a;
import p011c.C0240b;
import p019d.C1385a;
import p020e.C1386a;
import p022g.C1404a;

public class Activity_Popup extends Activity {

    /* renamed from: a */
    public Context f5082a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f5083b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0238a f5084c;

    /* renamed from: d */
    private C0240b f5085d;

    /* renamed from: e */
    private C1404a f5086e = new C1404a();

    /* renamed from: f */
    private C0239a f5087f;

    /* renamed from: g */
    private BroadcastReceiver f5088g = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("_ACTION_DONE") && Integer.parseInt(((TextView) Activity_Popup.this.findViewById(R.id.txtViewMsg)).getTag().toString()) == intent.getExtras().getInt("bID")) {
                Activity_Popup.this.finish();
            }
        }
    };

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        C0240b bVar = this.f5085d;
        C0240b.m1189b(this);
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_notif);
        getWindow().setFlags(1024, 1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setFinishOnTouchOutside(false);
        try {
            this.f5082a = getApplicationContext();
            this.f5087f = new C0239a(this.f5082a);
            this.f5083b = getIntent().getExtras().getInt("bID");
            this.f5084c = new C0238a(this.f5082a);
            final C1386a a = this.f5084c.mo1003a(this.f5083b);
            TextView textView = (TextView) findViewById(R.id.txtViewMsg);
            textView.setMovementMethod(new ScrollingMovementMethod());
            textView.setText(a.mo3693b());
            String g = a.mo3704g();
            C1404a aVar = this.f5086e;
            if (g.equals("NA")) {
                TextView textView2 = (TextView) findViewById(R.id.txtViewDate);
                StringBuilder sb = new StringBuilder();
                sb.append("Scheduled at ");
                sb.append(this.f5087f.mo1021a(a.mo3702e()));
                textView2.setText(sb.toString());
                ((TextView) findViewById(R.id.txtViewNextRun)).setVisibility(8);
            } else {
                TextView textView3 = (TextView) findViewById(R.id.txtViewDate);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Start Date  ::  ");
                sb2.append(this.f5087f.mo1021a(a.mo3702e()));
                textView3.setText(sb2.toString());
                TextView textView4 = (TextView) findViewById(R.id.txtViewNextRun);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Next Run  ::  ");
                sb3.append(this.f5087f.mo1021a(a.mo3703f()));
                textView4.setText(sb3.toString());
            }
            TextView textView5 = (TextView) findViewById(R.id.txtViewRptDesc);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Repeat  ::  ");
            sb4.append(a.mo3707j());
            textView5.setText(sb4.toString());
            textView.setTag(Integer.valueOf(this.f5083b));
            if (textView.getText().toString().contains("[No Title]")) {
                textView.setContentDescription(textView.getText().toString().replace("[", "").replace("]", ""));
            }
            ((Button) findViewById(R.id.btnDismiss)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ((NotificationManager) Activity_Popup.this.f5082a.getSystemService("notification")).cancel(Activity_Popup.this.f5083b);
                    Activity_Popup.this.finish();
                }
            });
            ((Button) findViewById(R.id.btnEdit)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Activity_Popup.this, Activity_Create.class);
                    intent.putExtra("bID", Activity_Popup.this.f5083b);
                    Activity_Popup.this.startActivity(intent);
                    Activity_Popup.this.finish();
                }
            });
            ((Button) findViewById(R.id.btnDelete)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Activity_Popup.this.f5084c.mo1010b(Activity_Popup.this.f5083b);
                    Activity_Popup.this.finish();
                    Toast.makeText(Activity_Popup.this.f5082a, "Reminder deleted", 0).show();
                }
            });
            ((Button) findViewById(R.id.btnSnooze)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ((NotificationManager) Activity_Popup.this.f5082a.getSystemService("notification")).cancel(Activity_Popup.this.f5083b);
                    int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(Activity_Popup.this.getBaseContext()).getString(Activity_Popup.this.getString(R.string.prefKey_snooze), Activity_Popup.this.getString(R.string.snoozeLength_default)));
                    Activity_Popup.this.f5084c.mo1007a(a, parseInt);
                    Activity_Popup.this.finish();
                    Context context = Activity_Popup.this.f5082a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Snoozed. Will remind you in ");
                    sb.append(parseInt);
                    sb.append(" minutes");
                    Toast.makeText(context, sb.toString(), 0).show();
                }
            });
        } catch (Exception unused) {
            finish();
            Toast.makeText(this.f5082a, "Sorry! This reminder is already deleted.", 0).show();
        }
    }

    public void onPause() {
        super.onPause();
        unregisterReceiver(this.f5088g);
    }

    public void onResume() {
        super.onResume();
        registerReceiver(this.f5088g, new IntentFilter("_ACTION_DONE"));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            try {
                if (!C1385a.m6397a(getApplicationContext()).mo3681d(Integer.parseInt(((TextView) findViewById(R.id.txtViewMsg)).getTag().toString()))) {
                    finish();
                }
            } catch (Exception unused) {
            }
        }
    }
}
