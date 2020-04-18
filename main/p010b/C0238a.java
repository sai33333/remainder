package p010b;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Calendar;
import notify.Alarm_Receiver;
import p011c.C0239a;
import p019d.C1385a;
import p020e.C1386a;
import p022g.C1404a;
import widget.WidgetProvider;

/* renamed from: b.a */
public class C0238a {

    /* renamed from: a */
    private Context f707a;

    /* renamed from: b */
    private C1385a f708b;

    /* renamed from: c */
    private C0239a f709c;

    /* renamed from: d */
    private C1404a f710d = new C1404a();

    public C0238a(Context context) {
        this.f707a = context;
        this.f708b = C1385a.m6397a(context);
        this.f709c = new C0239a(context);
    }

    /* renamed from: g */
    private void m1151g() {
        try {
            Intent intent = new Intent();
            intent.setAction("_REFRESH");
            intent.putExtra("Random", Math.random() * 1000.0d);
            intent.setClass(this.f707a, WidgetProvider.class);
            this.f707a.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public C1386a mo1003a(int i) {
        return this.f708b.mo3672a(i);
    }

    /* renamed from: a */
    public ArrayList<C1386a> mo1004a() {
        return this.f708b.mo3673a();
    }

    /* renamed from: a */
    public void mo1005a(int i, int i2) {
        mo1007a(mo1003a(i), i2);
    }

    /* renamed from: a */
    public void mo1006a(C1386a aVar) {
        int a = this.f708b.mo3671a(aVar);
        aVar.mo3688a(a);
        new Alarm_Receiver().mo3740a(this.f707a, aVar, a);
        m1151g();
    }

    /* renamed from: a */
    public void mo1007a(C1386a aVar, int i) {
        new C1404a();
        C0239a aVar2 = new C0239a(this.f707a);
        aVar2.mo1036h();
        String str = "One Time [Snooze]";
        String b = aVar.mo3693b();
        if (aVar.mo3707j().equals(str)) {
            mo1010b(aVar.mo3687a());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[Snooze] ");
            sb.append(b);
            b = sb.toString();
        }
        long b2 = aVar2.mo1025b(i);
        C1386a aVar3 = new C1386a();
        aVar3.mo3692a(b);
        aVar3.mo3696b(b2, this.f707a);
        aVar3.mo3690a(b2, this.f707a);
        aVar3.mo3689a(b2);
        aVar3.mo3695b(b2);
        aVar3.mo3697b("NA");
        aVar3.mo3694b(1);
        aVar3.mo3701d(str);
        mo1006a(aVar3);
    }

    /* renamed from: a */
    public boolean mo1008a(ArrayList<C1386a> arrayList) {
        return this.f708b.mo3675a(arrayList);
    }

    /* renamed from: b */
    public long mo1009b() {
        return this.f708b.mo3676b();
    }

    /* renamed from: b */
    public void mo1010b(int i) {
        new Alarm_Receiver().mo3739a(this.f707a, i);
        this.f708b.mo3677b(i);
        m1151g();
    }

    /* renamed from: b */
    public boolean mo1011b(ArrayList<C1386a> arrayList) {
        Alarm_Receiver alarm_Receiver = new Alarm_Receiver();
        alarm_Receiver.mo3742b(this.f707a, arrayList);
        alarm_Receiver.mo3741a(this.f707a, this.f708b.mo3680d());
        m1151g();
        return true;
    }

    /* renamed from: c */
    public ArrayList<C1386a> mo1012c() {
        return this.f708b.mo3678c();
    }

    /* renamed from: c */
    public void mo1013c(int i) {
        int i2 = i;
        C1386a a = this.f708b.mo3672a(i2);
        String g = a.mo3704g();
        C1404a aVar = this.f710d;
        if (g.equals("NA")) {
            this.f708b.mo3679c(i2);
        } else {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(a.mo3702e());
            int i3 = instance.get(12);
            int i4 = instance.get(5);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(a.mo3703f());
            int i5 = instance2.get(11);
            long a2 = this.f709c.mo1020a(a.mo3704g(), a.mo3705h(), instance2.get(1), instance2.get(2), instance2.get(5), i5, i3, i4);
            if (a2 < Calendar.getInstance().getTimeInMillis()) {
                while (a2 < Calendar.getInstance().getTimeInMillis()) {
                    Calendar instance3 = Calendar.getInstance();
                    instance3.setTimeInMillis(a2);
                    a2 = this.f709c.mo1020a(a.mo3704g(), a.mo3705h(), instance3.get(1), instance3.get(2), instance3.get(5), instance3.get(11), i3, i4);
                }
            }
            this.f708b.mo3674a(i2, a2);
            a.mo3695b(a2);
            new Alarm_Receiver().mo3740a(this.f707a, a, i2);
        }
        m1151g();
    }

    /* renamed from: d */
    public ArrayList<C1386a> mo1014d() {
        return this.f708b.mo3680d();
    }

    /* renamed from: d */
    public void mo1015d(int i) {
        try {
            Intent intent = new Intent();
            intent.setAction("_ACTION_DONE");
            intent.putExtra("bID", i);
            this.f707a.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public ArrayList<C1386a> mo1016e() {
        return this.f708b.mo3682e();
    }

    /* renamed from: f */
    public int mo1017f() {
        return this.f708b.mo3683f();
    }
}
