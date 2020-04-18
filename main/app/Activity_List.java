package app;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PowerManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.C0311c.C0312a;
import com.outlook.healthyapps.reminder.R;
import java.util.ArrayList;
import p000a.C0000a;
import p010b.C0238a;
import p011c.C0239a;
import p011c.C0240b;
import p020e.C1386a;
import p021f.C1388b;

public class Activity_List extends Activity {

    /* renamed from: a */
    public Context f678a;

    /* renamed from: b */
    private C0238a f679b;

    /* renamed from: c */
    private ListView f680c;

    /* renamed from: d */
    private C0240b f681d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0239a f682e;

    /* renamed from: f */
    private Parcelable f683f;

    /* renamed from: g */
    private BroadcastReceiver f684g = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("_ACTION_DONE")) {
                Activity_List.this.mo978a();
            }
        }
    };

    /* renamed from: b */
    private void m1129b() {
        String str = "com.outlook.healthyapps.reminder";
        if (!((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations(str)) {
            Intent intent = new Intent();
            intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            sb.append(str);
            intent.setData(Uri.parse(sb.toString()));
            startActivity(intent);
        }
    }

    /* renamed from: c */
    private void m1130c() {
        AdView adView = (AdView) findViewById(R.id.adView);
        if (((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo() != null) {
            adView.setVisibility(0);
            adView.mo1122a(new C0312a().mo1215b("B3EEABB8EE11C2BE770B684D95219ECB").mo1215b("B384DF608B3108D845FD227A62E1BC6E").mo1215b("153E7B689C73764962211D887A2C151D").mo1215b("CEFCD180C8E97BBFD732B7409126C71C").mo1215b("C26F26C4EC4755BF24F61BA4ADBCF947").mo1214a());
            return;
        }
        adView.setVisibility(8);
    }

    public void OnClick_btnCreateNew(View view) {
        startActivity(new Intent(this, Activity_Create.class));
        finish();
    }

    /* renamed from: a */
    public void mo978a() {
        this.f683f = this.f680c.onSaveInstanceState();
        final ArrayList c = this.f679b.mo1012c();
        this.f680c.setAdapter(new C0000a(this, c));
        this.f680c.onRestoreInstanceState(this.f683f);
        this.f680c.setEmptyView(findViewById(16908292));
        this.f680c.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Bundle bundle = new Bundle();
                bundle.putInt("bID", ((C1386a) c.get(i)).mo3687a());
                bundle.putString("bSTART_DATE", Activity_List.this.f682e.mo1021a(((C1386a) c.get(i)).mo3702e()));
                bundle.putString("bNEXT_RUN", Activity_List.this.f682e.mo1021a(((C1386a) c.get(i)).mo3703f()));
                bundle.putString("bTITLE", ((C1386a) c.get(i)).mo3693b());
                bundle.putString("bRPT_DESC", ((C1386a) c.get(i)).mo3707j());
                bundle.putString("bRPT_TYPE", ((C1386a) c.get(i)).mo3704g());
                bundle.putString("bSTATUS", ((C1386a) c.get(i)).mo3706i());
                C1388b bVar = new C1388b();
                bVar.setCancelable(true);
                bVar.setArguments(bundle);
                bVar.show(Activity_List.this.getFragmentManager(), "");
            }
        });
    }

    /* renamed from: a */
    public void mo979a(int i) {
        Intent intent = new Intent(this, Activity_Create.class);
        intent.putExtra("bID", i);
        startActivity(intent);
        finish();
    }

    /* renamed from: b */
    public void mo980b(int i) {
        this.f679b.mo1010b(i);
        mo978a();
        Toast.makeText(this.f678a, "Reminder deleted", 0).show();
    }

    public void onCreate(Bundle bundle) {
        C0240b bVar = this.f681d;
        C0240b.m1188a(this);
        super.onCreate(bundle);
        setContentView(R.layout.layout_list);
        this.f678a = getApplicationContext();
        this.f679b = new C0238a(this.f678a);
        this.f682e = new C0239a(this.f678a);
        this.f680c = (ListView) findViewById(R.id.listViewReminderList);
        mo978a();
        m1130c();
        m1129b();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menu.findItem(R.id.buy).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.buy) {
            switch (itemId) {
                case R.id.settings /*2131165263*/:
                    Intent intent = new Intent(this, Activity_Preference.class);
                    intent.putExtra("bSCREEN", 1);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.share /*2131165264*/:
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.SEND");
                    intent2.putExtra("android.intent.extra.SUBJECT", "Reminder App");
                    StringBuilder sb = new StringBuilder();
                    sb.append("\nLet me recommend you this application\n\n");
                    sb.append("https://play.google.com/store/apps/details?id=com.outlook.healthyapps.reminder \n\n");
                    intent2.putExtra("android.intent.extra.TEXT", sb.toString());
                    intent2.setType("text/plain");
                    startActivity(Intent.createChooser(intent2, "Share via"));
                    return true;
                default:
                    return super.onOptionsItemSelected(menuItem);
            }
        } else {
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.outlook.healthyapps.reminderdonate")));
            } catch (ActivityNotFoundException unused) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.outlook.healthyapps.reminderdonate")));
            }
            return true;
        }
    }

    public void onPause() {
        super.onPause();
        unregisterReceiver(this.f684g);
    }

    public void onResume() {
        super.onResume();
        mo978a();
        registerReceiver(this.f684g, new IntentFilter("_ACTION_DONE"));
    }
}
