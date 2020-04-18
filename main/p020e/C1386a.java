package p020e;

import android.content.Context;
import android.text.format.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import p022g.C1404a;

/* renamed from: e.a */
public class C1386a {

    /* renamed from: a */
    private int f5026a;

    /* renamed from: b */
    private String f5027b;

    /* renamed from: c */
    private String f5028c;

    /* renamed from: d */
    private String f5029d;

    /* renamed from: e */
    private long f5030e;

    /* renamed from: f */
    private long f5031f;

    /* renamed from: g */
    private String f5032g;

    /* renamed from: h */
    private int f5033h;

    /* renamed from: i */
    private String f5034i;

    /* renamed from: j */
    private String f5035j;

    /* renamed from: k */
    private C1404a f5036k = new C1404a();

    /* renamed from: a */
    public int mo3687a() {
        return this.f5026a;
    }

    /* renamed from: a */
    public void mo3688a(int i) {
        this.f5026a = i;
    }

    /* renamed from: a */
    public void mo3689a(long j) {
        this.f5030e = j;
    }

    /* renamed from: a */
    public void mo3690a(long j, Context context) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = Boolean.valueOf(DateFormat.is24HourFormat(context)).booleanValue() ? new SimpleDateFormat("HH:mm", Locale.getDefault()) : new SimpleDateFormat("h:mm a", Locale.getDefault());
        date.setTime(j);
        this.f5029d = simpleDateFormat.format(date);
    }

    /* renamed from: a */
    public void mo3691a(long j, String str, int i, Context context) {
        String str2;
        StringBuilder sb;
        Calendar instance = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("LLLL", Locale.getDefault());
        java.text.DateFormat dateFormat = DateFormat.getDateFormat(context);
        instance.setTimeInMillis(j);
        date.setTime(j);
        int i2 = instance.get(5);
        String format = simpleDateFormat.format(date);
        simpleDateFormat2.format(date);
        this.f5028c = dateFormat.format(date);
        C1404a aVar = this.f5036k;
        if (str.equals("NA")) {
            str2 = "One Time";
        } else {
            C1404a aVar2 = this.f5036k;
            if (!str.equals("H")) {
                C1404a aVar3 = this.f5036k;
                if (!str.equals("D")) {
                    C1404a aVar4 = this.f5036k;
                    if (!str.equals("W")) {
                        C1404a aVar5 = this.f5036k;
                        if (!str.equals("M")) {
                            C1404a aVar6 = this.f5036k;
                            if (!str.equals("Y")) {
                                return;
                            }
                            if (i > 1) {
                                sb = new StringBuilder();
                                sb.append("Every ");
                                sb.append(i);
                                format = " Years";
                            } else {
                                str2 = "Every Year";
                            }
                        } else if (i > 1) {
                            sb = new StringBuilder();
                            sb.append("Every ");
                            sb.append(i);
                            format = " Months";
                        } else {
                            str2 = "Every Month";
                        }
                    } else if (i > 1) {
                        sb = new StringBuilder();
                        sb.append("Every ");
                        sb.append(i);
                        format = " Weeks";
                    } else {
                        sb = new StringBuilder();
                        sb.append("Every ");
                    }
                } else if (i > 1) {
                    sb = new StringBuilder();
                    sb.append("Every ");
                    sb.append(i);
                    format = " Days";
                } else {
                    str2 = "Every Day";
                }
            } else if (i > 1) {
                sb = new StringBuilder();
                sb.append("Every ");
                sb.append(i);
                format = " Hours";
            } else {
                str2 = "Every Hour";
            }
            sb.append(format);
            str2 = sb.toString();
        }
        this.f5035j = str2;
    }

    /* renamed from: a */
    public void mo3692a(String str) {
        this.f5027b = str;
    }

    /* renamed from: b */
    public String mo3693b() {
        return this.f5027b;
    }

    /* renamed from: b */
    public void mo3694b(int i) {
        this.f5033h = i;
    }

    /* renamed from: b */
    public void mo3695b(long j) {
        this.f5031f = j;
    }

    /* renamed from: b */
    public void mo3696b(long j, Context context) {
        Date date = new Date();
        java.text.DateFormat dateFormat = DateFormat.getDateFormat(context);
        date.setTime(j);
        this.f5028c = dateFormat.format(date);
    }

    /* renamed from: b */
    public void mo3697b(String str) {
        this.f5032g = str;
    }

    /* renamed from: c */
    public String mo3698c() {
        return this.f5028c;
    }

    /* renamed from: c */
    public void mo3699c(String str) {
        this.f5034i = str;
    }

    /* renamed from: d */
    public String mo3700d() {
        return this.f5029d;
    }

    /* renamed from: d */
    public void mo3701d(String str) {
        this.f5035j = str;
    }

    /* renamed from: e */
    public long mo3702e() {
        return this.f5030e;
    }

    /* renamed from: f */
    public long mo3703f() {
        return this.f5031f;
    }

    /* renamed from: g */
    public String mo3704g() {
        return this.f5032g;
    }

    /* renamed from: h */
    public int mo3705h() {
        return this.f5033h;
    }

    /* renamed from: i */
    public String mo3706i() {
        return this.f5034i;
    }

    /* renamed from: j */
    public String mo3707j() {
        return this.f5035j;
    }
}
