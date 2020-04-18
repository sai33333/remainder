package p022g;

import com.google.android.gms.internal.C1217ty;
import java.util.HashMap;
import java.util.Map;

/* renamed from: g.a */
public class C1404a {

    /* renamed from: a */
    Map f5081a = new HashMap();

    /* renamed from: a */
    private String m6441a(int i) {
        String str = "";
        switch (i) {
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case C1217ty.f4597d /*4*/:
                return "Wednesday";
            case C1217ty.f4598e /*5*/:
                return "Thursday";
            case C1217ty.f4599f /*6*/:
                return "Friday";
            case C1217ty.f4600g /*7*/:
                return "Saturday";
            default:
                return str;
        }
    }

    /* renamed from: b */
    private String m6442b(int i) {
        String str = "";
        switch (i) {
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tue";
            case C1217ty.f4597d /*4*/:
                return "Wed";
            case C1217ty.f4598e /*5*/:
                return "Thu";
            case C1217ty.f4599f /*6*/:
                return "Fri";
            case C1217ty.f4600g /*7*/:
                return "Sat";
            default:
                return str;
        }
    }

    /* renamed from: a */
    public String mo3726a(int i, String str) {
        String sb;
        if (str.equals("NA")) {
            return "No Repeating";
        }
        int i2 = 1;
        if (str.contains("WD")) {
            String str2 = str.split("-")[1];
            StringBuffer stringBuffer = new StringBuffer();
            if (str2.length() == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Every ");
                sb2.append(m6441a(Integer.parseInt(str2)));
                sb = sb2.toString();
            } else {
                if (str2.length() == 6) {
                    while (true) {
                        if (i2 >= 8) {
                            break;
                        } else if (!str.contains(String.valueOf(i2))) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Everyday except ");
                            sb3.append(m6441a(i2));
                            sb = sb3.toString();
                            break;
                        } else {
                            i2++;
                        }
                    }
                } else {
                    stringBuffer.append("Every");
                    String str3 = " ";
                    while (i2 < 8) {
                        if (str.contains(String.valueOf(i2))) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str3);
                            sb4.append(m6442b(i2));
                            stringBuffer.append(sb4.toString());
                            str3 = ", ";
                        }
                        i2++;
                    }
                }
                return stringBuffer.toString();
            }
            stringBuffer.append(sb);
            return stringBuffer.toString();
        } else if (str.contains("Nth")) {
            String str4 = "";
            switch (i) {
                case 1:
                    str4 = "1st";
                    break;
                case 2:
                    str4 = "2nd";
                    break;
                case 3:
                    str4 = "3rd";
                    break;
                case C1217ty.f4597d /*4*/:
                    str4 = "4th";
                    break;
                case C1217ty.f4598e /*5*/:
                    str4 = "Last";
                    break;
            }
            int parseInt = Integer.parseInt(str.split("-")[1]);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Every ");
            sb5.append(str4);
            sb5.append(" ");
            sb5.append(m6441a(parseInt));
            return sb5.toString();
        } else if (i > 1) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Every ");
            sb6.append(i);
            sb6.append(" ");
            sb6.append(this.f5081a.get(str).toString());
            sb6.append("s");
            return sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Every ");
            sb7.append(this.f5081a.get(str).toString());
            return sb7.toString();
        }
    }

    /* renamed from: a */
    public void mo3727a() {
        this.f5081a.put("H", "Hour");
        this.f5081a.put("D", "Day");
        this.f5081a.put("W", "Week");
        this.f5081a.put("M", "Month");
        this.f5081a.put("Y", "Year");
    }
}
