package p011c;

import android.content.Context;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: c.a */
public class C0239a {

    /* renamed from: a */
    Date f711a;

    /* renamed from: b */
    DateFormat f712b;

    /* renamed from: c */
    DateFormat f713c;

    /* renamed from: d */
    private int f714d = -1;

    /* renamed from: e */
    private int f715e = -1;

    /* renamed from: f */
    private int f716f = -1;

    /* renamed from: g */
    private int f717g = -1;

    /* renamed from: h */
    private int f718h = -1;

    /* renamed from: i */
    private long f719i = -1;

    /* renamed from: j */
    private boolean f720j;

    /* renamed from: k */
    private Calendar f721k = Calendar.getInstance();

    public C0239a(Context context) {
        this.f720j = android.text.format.DateFormat.is24HourFormat(context);
        this.f712b = android.text.format.DateFormat.getDateFormat(context);
        this.f713c = android.text.format.DateFormat.getTimeFormat(context);
    }

    /* renamed from: a */
    public long mo1018a() {
        return this.f719i;
    }

    /* renamed from: a */
    public long mo1019a(int i, int i2, int i3, int i4, int i5) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2, i3, i4, i5, 0);
        return instance.getTimeInMillis();
    }

    /* renamed from: a */
    public long mo1020a(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        String str2 = str;
        int i9 = i;
        int i10 = i7;
        Calendar instance = Calendar.getInstance();
        instance.set(i2, i3, i4, i5, i6, 0);
        if (str.equals("H")) {
            instance.add(12, i9 * 60);
        } else {
            if (str.equals("D")) {
                i8 = i9 * 24;
            } else if (str.equals("W")) {
                i8 = i9 * 168;
            } else if (str.equals("M")) {
                instance.add(2, i9 * 1);
                int i11 = instance.get(5);
                if (i10 > 28) {
                    while (i11 < i10 && i11 < instance.getActualMaximum(5)) {
                        instance.add(5, 1);
                        i11++;
                    }
                }
            } else if (str.equals("Y")) {
                instance.add(2, i9 * 12);
                int i12 = instance.get(5);
                if (i3 == 1 && i10 == 29) {
                    while (i12 < i10 && i12 < instance.getActualMaximum(5)) {
                        instance.add(5, 1);
                        i12++;
                    }
                }
            } else if (str.contains("WD")) {
                int i13 = i9 * 24;
                do {
                    instance.add(11, i13);
                } while (!str.contains(String.valueOf(instance.get(7))));
            } else if (str.contains("Nth")) {
                instance.set(5, 1);
                instance.add(2, 1);
                if (i9 < 5) {
                    instance.set(7, Integer.parseInt(str.split("-")[1]));
                    instance.set(8, i);
                } else {
                    int parseInt = Integer.parseInt(str.split("-")[1]);
                    instance.set(5, instance.getActualMaximum(5));
                    while (instance.get(7) != parseInt) {
                        instance.add(5, -1);
                    }
                }
            }
            instance.add(11, i8);
        }
        return instance.getTimeInMillis();
    }

    /* renamed from: a */
    public String mo1021a(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f712b.format(Long.valueOf(j)));
        sb.append("  ");
        sb.append(this.f713c.format(Long.valueOf(j)));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo1022a(int i) {
        this.f714d = i;
    }

    /* renamed from: a */
    public void mo1023a(int i, int i2, int i3) {
        this.f719i = mo1026b(i, i2, i3);
    }

    /* renamed from: b */
    public int mo1024b() {
        return this.f714d;
    }

    /* renamed from: b */
    public long mo1025b(int i) {
        this.f721k = Calendar.getInstance();
        this.f721k.add(12, i);
        return this.f721k.getTimeInMillis();
    }

    /* renamed from: b */
    public long mo1026b(int i, int i2, int i3) {
        Calendar instance = Calendar.getInstance();
        instance.set(i, i2, i3);
        return instance.getTimeInMillis();
    }

    /* renamed from: c */
    public int mo1027c() {
        return this.f715e;
    }

    /* renamed from: c */
    public void mo1028c(int i) {
        this.f715e = i;
    }

    /* renamed from: d */
    public int mo1029d() {
        return this.f716f;
    }

    /* renamed from: d */
    public void mo1030d(int i) {
        this.f716f = i;
    }

    /* renamed from: e */
    public int mo1031e() {
        return this.f717g;
    }

    /* renamed from: e */
    public void mo1032e(int i) {
        this.f717g = i;
    }

    /* renamed from: f */
    public int mo1033f() {
        return this.f718h;
    }

    /* renamed from: f */
    public void mo1034f(int i) {
        this.f718h = i;
    }

    /* renamed from: g */
    public void mo1035g() {
        this.f719i = mo1019a(this.f718h, this.f716f, this.f717g, this.f714d, this.f715e);
    }

    /* renamed from: h */
    public void mo1036h() {
        this.f721k = Calendar.getInstance();
        this.f714d = this.f721k.get(11);
        this.f715e = this.f721k.get(12);
        this.f716f = this.f721k.get(2);
        this.f717g = this.f721k.get(5);
        this.f718h = this.f721k.get(1);
        this.f719i = this.f721k.getTimeInMillis();
    }

    /* renamed from: i */
    public String mo1037i() {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.f719i);
        SimpleDateFormat simpleDateFormat = this.f720j ? new SimpleDateFormat("HH:mm", Locale.getDefault()) : new SimpleDateFormat("h:mm a", Locale.getDefault());
        instance.set(11, this.f714d);
        instance.set(12, this.f715e);
        date.setTime(instance.getTimeInMillis());
        return simpleDateFormat.format(date);
    }

    /* renamed from: j */
    public String mo1038j() {
        mo1023a(this.f718h, this.f716f, this.f717g);
        this.f711a = new Date(this.f719i);
        return this.f712b.format(this.f711a);
    }
}
