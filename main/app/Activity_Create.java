package app;

import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.p005v4.app.C0075g;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.outlook.healthyapps.reminder.R;
import java.util.Calendar;
import java.util.Locale;
import p010b.C0238a;
import p011c.C0239a;
import p011c.C0240b;
import p011c.C0241c;
import p020e.C1386a;
import p021f.C1387a;
import p021f.C1392c;
import p021f.C1403g;
import p022g.C1404a;

public class Activity_Create extends C0075g {

    /* renamed from: k */
    public C0239a f665k;

    /* renamed from: l */
    public C0239a f666l;

    /* renamed from: m */
    public Context f667m;

    /* renamed from: n */
    public C1404a f668n = new C1404a();

    /* renamed from: o */
    public TextView f669o;

    /* renamed from: p */
    public TextView f670p;

    /* renamed from: q */
    public TextView f671q;

    /* renamed from: r */
    public int f672r = 1;

    /* renamed from: s */
    public String f673s = "NA";

    /* renamed from: t */
    private C0240b f674t;

    /* renamed from: u */
    private EditText f675u;

    /* renamed from: v */
    private C0238a f676v;

    /* renamed from: w */
    private int f677w = 0;

    /* renamed from: j */
    private C1386a m1123j() {
        C1386a aVar = new C1386a();
        aVar.mo3692a(this.f675u.getText().toString().isEmpty() ? "[No Title]" : this.f675u.getText().toString());
        aVar.mo3691a(this.f666l.mo1018a(), this.f673s, this.f672r, this.f667m);
        aVar.mo3690a(this.f666l.mo1018a(), this.f667m);
        aVar.mo3689a(this.f666l.mo1018a());
        String str = this.f673s;
        C1404a aVar2 = this.f668n;
        if (str.contains("WD")) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(this.f666l.mo1018a());
            int i = instance.get(11);
            int i2 = instance.get(1);
            int i3 = instance.get(2);
            int i4 = instance.get(5) - 1;
            aVar.mo3695b(this.f665k.mo1020a(this.f673s, this.f672r, i2, i3, i4, i, instance.get(12), i4));
        } else {
            String str2 = this.f673s;
            C1404a aVar3 = this.f668n;
            if (str2.contains("Nth")) {
                Calendar instance2 = Calendar.getInstance();
                instance2.setTimeInMillis(this.f666l.mo1018a());
                int i5 = instance2.get(11);
                int i6 = instance2.get(1);
                int i7 = instance2.get(2);
                int i8 = instance2.get(12);
                long a = this.f665k.mo1020a(this.f673s, this.f672r, i6, i7 - 1, 1, i5, i8, 1);
                if (a < this.f666l.mo1018a()) {
                    a = this.f665k.mo1020a(this.f673s, this.f672r, i6, i7, 1, i5, i8, 1);
                }
                aVar.mo3695b(a);
            } else {
                aVar.mo3695b(this.f666l.mo1018a());
                aVar.mo3697b(this.f673s);
                aVar.mo3694b(this.f672r);
                return aVar;
            }
        }
        aVar.mo3701d(this.f671q.getText().toString());
        aVar.mo3697b(this.f673s);
        aVar.mo3694b(this.f672r);
        return aVar;
    }

    /* renamed from: k */
    private void m1124k() {
        startActivity(new Intent(this, Activity_List.class));
        finish();
    }

    public void OnClick_Date(View view) {
        new C1387a().mo164a(mo287f(), "datePicker");
    }

    public void OnClick_RepeatFreq(View view) {
        C1392c cVar = new C1392c();
        cVar.setCancelable(true);
        cVar.show(getFragmentManager(), "");
    }

    public void OnClick_SpeakTitle(View view) {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
        intent.putExtra("android.speech.extra.PROMPT", "Say something!");
        try {
            startActivityForResult(intent, 8000);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getApplicationContext(), "Sorry your device not supported", 0).show();
        }
    }

    public void OnClick_Time(View view) {
        new C1403g().mo164a(mo287f(), "timePicker");
    }

    public void OnClick_btnSave(View view) {
        Context context;
        String str;
        this.f666l.mo1035g();
        this.f665k.mo1036h();
        if (this.f666l.mo1018a() > this.f665k.mo1018a()) {
            int i = this.f677w;
            if (i == 0) {
                this.f676v.mo1006a(m1123j());
                context = this.f667m;
                str = "Reminder scheduled";
            } else {
                this.f676v.mo1010b(i);
                this.f676v.mo1006a(m1123j());
                context = this.f667m;
                str = "Reminder updated";
            }
            Toast.makeText(context, str, 0).show();
            m1124k();
            return;
        }
        C0241c.m1190a(this, "\nPlease set reminder for upcoming date (or) time.\n");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: g */
    public void mo972g() {
        this.f671q.setText(this.f668n.mo3726a(this.f672r, this.f673s));
        TextView textView = this.f671q;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.talkBack_RepeatType));
        sb.append(". Currently selected ");
        sb.append(this.f671q.getText());
        sb.append(". Button");
        textView.setContentDescription(sb.toString());
    }

    /* renamed from: h */
    public void mo973h() {
        this.f670p.setText(this.f666l.mo1038j());
        TextView textView = this.f670p;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.talkBack_Select_Date));
        sb.append(". Current selected date is ");
        sb.append(this.f670p.getText());
        sb.append(". Button");
        textView.setContentDescription(sb.toString());
    }

    /* renamed from: i */
    public void mo974i() {
        this.f669o.setText(this.f666l.mo1037i());
        TextView textView = this.f669o;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.talkBack_Select_Time));
        sb.append(". Current selected time is ");
        sb.append(this.f669o.getText());
        sb.append(". Button");
        textView.setContentDescription(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8000 && i2 == -1) {
            this.f675u.setText((CharSequence) intent.getStringArrayListExtra("android.speech.extra.RESULTS").get(0));
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Activity_List.class));
        finish();
    }

    public void onCreate(Bundle bundle) {
        C0240b bVar = this.f674t;
        C0240b.m1188a(this);
        super.onCreate(bundle);
        setContentView(R.layout.layout_create);
        this.f667m = getApplicationContext();
        this.f665k = new C0239a(this.f667m);
        this.f665k.mo1036h();
        this.f666l = new C0239a(this.f667m);
        this.f666l.mo1036h();
        this.f675u = (EditText) findViewById(R.id.editTextTitle);
        this.f670p = (TextView) findViewById(R.id.txtViewDate);
        this.f669o = (TextView) findViewById(R.id.txtViewTime);
        this.f671q = (TextView) findViewById(R.id.txtViewRepeatFreq);
        this.f668n.mo3727a();
        this.f676v = new C0238a(this.f667m);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            mo973h();
            mo974i();
            this.f672r = 1;
            C1404a aVar = this.f668n;
            this.f673s = "NA";
            mo972g();
        } else {
            this.f677w = extras.getInt("bID");
            ((NotificationManager) this.f667m.getSystemService("notification")).cancel(this.f677w);
            try {
                C1386a a = this.f676v.mo1003a(this.f677w);
                this.f675u.setText(a.mo3693b());
                this.f672r = a.mo3705h();
                this.f673s = a.mo3704g();
                mo972g();
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(a.mo3703f());
                this.f666l.mo1022a(instance.get(11));
                this.f666l.mo1028c(instance.get(12));
                this.f666l.mo1034f(instance.get(1));
                this.f666l.mo1030d(instance.get(2));
                this.f666l.mo1032e(instance.get(5));
                mo973h();
                mo974i();
                setTitle("Update Reminder");
            } catch (Exception unused) {
                m1124k();
                finish();
                Toast.makeText(this.f667m, "Sorry! This reminder is already deleted.", 0).show();
            }
        }
        this.f669o.setFocusableInTouchMode(false);
        this.f670p.setFocusableInTouchMode(false);
        this.f669o.setLongClickable(false);
        this.f669o.setTextIsSelectable(false);
        this.f670p.setLongClickable(false);
        this.f670p.setTextIsSelectable(false);
        this.f671q.setLongClickable(false);
        this.f671q.setTextIsSelectable(false);
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
                    intent.putExtra("bSCREEN", 2);
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
            getPackageName();
            try {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.outlook.healthyapps.reminderdonate")));
            } catch (ActivityNotFoundException unused) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.outlook.healthyapps.reminderdonate")));
            }
            return true;
        }
    }
}
