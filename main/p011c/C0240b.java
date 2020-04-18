package p011c;

import android.app.Activity;
import android.preference.PreferenceManager;
import com.outlook.healthyapps.reminder.R;

/* renamed from: c.b */
public class C0240b {
    /* renamed from: a */
    public static void m1188a(Activity activity) {
        int i;
        switch (Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(activity.getBaseContext()).getString(activity.getString(R.string.prefKey_theme), "1"))) {
            case 1:
                i = R.style.Theme_Light;
                break;
            case 2:
                i = R.style.Theme_Dark;
                break;
            default:
                return;
        }
        activity.setTheme(i);
    }

    /* renamed from: b */
    public static void m1189b(Activity activity) {
        int i;
        switch (Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(activity.getBaseContext()).getString(activity.getString(R.string.prefKey_theme), "1"))) {
            case 1:
                i = R.style.Theme_Light_Pop;
                break;
            case 2:
                i = R.style.Theme_Dark_Pop;
                break;
            default:
                return;
        }
        activity.setTheme(i);
    }
}
