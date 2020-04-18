package app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.ads.C0285a;
import com.google.android.gms.ads.C0311c;
import com.google.android.gms.ads.C0311c.C0312a;
import com.google.android.gms.ads.C0326g;
import com.outlook.healthyapps.reminder.R;
import notify.C1410a;
import p010b.C0238a;
import p011c.C0240b;
import p011c.C0241c;
import p011c.C0244d;
import p011c.C0251e;

public class Activity_Preference extends PreferenceActivity {

    /* renamed from: a */
    private C0240b f688a;

    /* renamed from: b */
    private int f689b;

    /* renamed from: c */
    private C0326g f690c;

    /* renamed from: d */
    private boolean f691d = false;

    /* renamed from: app.Activity_Preference$a */
    public static class C0229a extends PreferenceFragment implements OnSharedPreferenceChangeListener {

        /* renamed from: a */
        private int f693a;

        /* renamed from: a */
        private void m1138a() {
            String sb;
            EditTextPreference editTextPreference = (EditTextPreference) findPreference(getString(R.string.prefKey_snooze));
            if (editTextPreference.getText().isEmpty() || editTextPreference.getText().equals("0")) {
                editTextPreference.setText("0");
                sb = "0 minutes";
            } else if (editTextPreference.getText().equals("1")) {
                sb = "1 minute";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(editTextPreference.getText());
                sb2.append(" minutes");
                sb = sb2.toString();
            }
            editTextPreference.setSummary(sb);
        }

        /* renamed from: a */
        private void m1139a(final String str) {
            Preference findPreference = findPreference(getString(R.string.prefKey_autoStart));
            if ("xiaomi".equalsIgnoreCase(str) || "oppo".equalsIgnoreCase(str) || "vivo".equalsIgnoreCase(str) || "Letv".equalsIgnoreCase(str) || "Honor".equalsIgnoreCase(str) || "huawei".equalsIgnoreCase(str) || "asus".equalsIgnoreCase(str) || "samsung".equalsIgnoreCase(str) || "oneplus".equalsIgnoreCase(str)) {
                findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cc A[Catch:{ Exception -> 0x00d2 }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean onPreferenceClick(android.preference.Preference r4) {
                        /*
                            r3 = this;
                            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x00d2 }
                            r4.<init>()     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r0 = "xiaomi"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x001d
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.miui.securitycenter"
                            java.lang.String r2 = "com.miui.permcenter.autostart.AutoStartManagementActivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                        L_0x0018:
                            r4.setComponent(r0)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x00b6
                        L_0x001d:
                            java.lang.String r0 = "oppo"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x0031
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.coloros.safecenter"
                            java.lang.String r2 = "com.coloros.safecenter.permission.startup.StartupAppListActivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x0018
                        L_0x0031:
                            java.lang.String r0 = "vivo"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x0045
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.vivo.permissionmanager"
                            java.lang.String r2 = "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x0018
                        L_0x0045:
                            java.lang.String r0 = "Letv"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x0059
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.letv.android.letvsafe"
                            java.lang.String r2 = "com.letv.android.letvsafe.AutobootManageActivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x0018
                        L_0x0059:
                            java.lang.String r0 = "Honor"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 != 0) goto L_0x00ab
                            java.lang.String r0 = "huawei"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x006e
                            goto L_0x00ab
                        L_0x006e:
                            java.lang.String r0 = "asus"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x0082
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.asus.mobilemanager"
                            java.lang.String r2 = "com.asus.mobilemanager.autostart.AutoStartActivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x0018
                        L_0x0082:
                            java.lang.String r0 = "samsung"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x0096
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.samsung.android.lool"
                            java.lang.String r2 = "com.samsung.android.sm.ui.battery.BatteryActivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x0018
                        L_0x0096:
                            java.lang.String r0 = "oneplus"
                            java.lang.String r1 = r3     // Catch:{ Exception -> 0x00d2 }
                            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x00d2 }
                            if (r0 == 0) goto L_0x00b6
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.oneplus.security"
                            java.lang.String r2 = "com.oneplus.security.chainlaunch.view.ChainLaunchAppListAct‌​ivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x0018
                        L_0x00ab:
                            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x00d2 }
                            java.lang.String r1 = "com.huawei.systemmanager"
                            java.lang.String r2 = "com.huawei.systemmanager.optimize.process.ProtectActivity"
                            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x0018
                        L_0x00b6:
                            app.Activity_Preference$a r0 = app.Activity_Preference.C0229a.this     // Catch:{ Exception -> 0x00d2 }
                            android.app.Activity r0 = r0.getActivity()     // Catch:{ Exception -> 0x00d2 }
                            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ Exception -> 0x00d2 }
                            r1 = 65536(0x10000, float:9.18355E-41)
                            java.util.List r0 = r0.queryIntentActivities(r4, r1)     // Catch:{ Exception -> 0x00d2 }
                            int r0 = r0.size()     // Catch:{ Exception -> 0x00d2 }
                            if (r0 <= 0) goto L_0x00dc
                            app.Activity_Preference$a r0 = app.Activity_Preference.C0229a.this     // Catch:{ Exception -> 0x00d2 }
                            r0.startActivity(r4)     // Catch:{ Exception -> 0x00d2 }
                            goto L_0x00dc
                        L_0x00d2:
                            r4 = move-exception
                            java.lang.String r0 = "exc"
                            java.lang.String r4 = java.lang.String.valueOf(r4)
                            android.util.Log.e(r0, r4)
                        L_0x00dc:
                            r4 = 0
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: app.Activity_Preference.C0229a.C02301.onPreferenceClick(android.preference.Preference):boolean");
                    }
                });
            } else {
                getPreferenceScreen().removePreference(findPreference);
            }
        }

        /* renamed from: b */
        private void m1140b() {
            ListPreference listPreference = (ListPreference) findPreference(getString(R.string.prefKey_dateTimeMode));
            listPreference.setSummary(listPreference.getEntries()[listPreference.findIndexOfValue(listPreference.getValue())]);
        }

        /* renamed from: c */
        private void m1141c() {
            ListPreference listPreference = (ListPreference) findPreference(getString(R.string.prefKey_theme));
            listPreference.setSummary(listPreference.getEntries()[listPreference.findIndexOfValue(listPreference.getValue())]);
            int i = this.f693a;
            if (i != 0 && i != Integer.parseInt(listPreference.getValue())) {
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.theme_change, 0);
                startActivityForResult(getActivity().getIntent(), 0);
            }
        }

        /* renamed from: d */
        private void m1142d() {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference(getString(R.string.prefKey_turnOnScreen));
            checkBoxPreference.setSummary(checkBoxPreference.isChecked() ? "Enabled" : "Disabled");
        }

        /* renamed from: e */
        private void m1143e() {
            ListPreference listPreference = (ListPreference) findPreference(getString(R.string.prefKey_notificationStyle));
            listPreference.setSummary(listPreference.getEntries()[listPreference.findIndexOfValue(listPreference.getValue())]);
        }

        /* renamed from: f */
        private void m1144f() {
            Preference findPreference = findPreference(getString(R.string.prefKey_ringtone));
            new C1410a(findPreference.getContext());
            findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", "com.outlook.healthyapps.reminder");
                    intent.putExtra("android.provider.extra.CHANNEL_ID", "CHANNEL_10");
                    C0229a.this.startActivity(intent);
                    return false;
                }
            });
        }

        /* renamed from: g */
        private void m1145g() {
            final Preference findPreference = findPreference(getString(R.string.prefKey_deleteAll));
            findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    C0244d.m1192a(findPreference.getContext(), "Are you sure you want to delete all expired reminders?", new C0251e() {
                        /* renamed from: a */
                        public void mo965a() {
                            String str;
                            Context context;
                            Toast makeText;
                            int f = new C0238a(findPreference.getContext()).mo1017f();
                            if (f > 1) {
                                Context context2 = findPreference.getContext();
                                StringBuilder sb = new StringBuilder();
                                sb.append(f);
                                sb.append(" reminders deleted");
                                makeText = Toast.makeText(context2, sb.toString(), 0);
                            } else {
                                if (f == 1) {
                                    context = findPreference.getContext();
                                    str = "1 reminder deleted";
                                } else {
                                    context = findPreference.getContext();
                                    str = "No expired reminders to delete";
                                }
                                makeText = Toast.makeText(context, str, 0);
                            }
                            makeText.show();
                        }
                    });
                    return false;
                }
            });
        }

        /* renamed from: h */
        private void m1146h() {
            final Preference findPreference = findPreference(getString(R.string.prefKey_widget));
            findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    C0241c.m1191a(findPreference.getContext(), "\nYou can access Keep faster by adding a widget to your home screen.\n\nTo add a widget, Please go to widget section in your mobile. And touch and hold the reminder icon.\n\nYou should have enough space in your home screen to add a widget.\n", "Widget");
                    return false;
                }
            });
        }

        /* renamed from: i */
        private void m1147i() {
            final Preference findPreference = findPreference(getString(R.string.prefKey_backup));
            findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    C0229a.this.startActivity(new Intent(findPreference.getContext(), Activity_Backup.class));
                    return false;
                }
            });
        }

        /* renamed from: j */
        private void m1148j() {
            final Preference findPreference = findPreference(getString(R.string.prefKey_sponsor));
            findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    C0244d.m1194b(findPreference.getContext(), "More advanced features are available in our sponsor app.\n\nYou can try downloading from playstore.", "More Options Available!", new C0251e() {
                        /* renamed from: a */
                        public void mo965a() {
                            C0229a.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=alarm.clock.calendar.reminder")));
                        }
                    });
                    return false;
                }
            });
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.preferences);
            onSharedPreferenceChanged(null, "");
            this.f693a = Integer.parseInt(((ListPreference) findPreference(getString(R.string.prefKey_theme))).getValue());
            m1139a(Build.MANUFACTURER);
            m1146h();
            m1145g();
            m1144f();
            m1147i();
            m1148j();
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            m1143e();
            m1138a();
            m1140b();
            m1142d();
            m1141c();
        }

        public void onStart() {
            super.onStart();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        public void onStop() {
            super.onStop();
            getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    /* renamed from: a */
    private void m1134a() {
        C0311c a = new C0312a().mo1215b("B3EEABB8EE11C2BE770B684D95219ECB").mo1215b("B384DF608B3108D845FD227A62E1BC6E").mo1215b("153E7B689C73764962211D887A2C151D").mo1215b("CEFCD180C8E97BBFD732B7409126C71C").mo1214a();
        this.f690c = new C0326g(this);
        this.f690c.mo1255a("ca-app-pub-7426194022511830/9919112423");
        this.f690c.mo1252a((C0285a) new C0285a() {
            /* renamed from: a */
            public void mo990a() {
                super.mo990a();
            }

            /* renamed from: a */
            public void mo991a(int i) {
                super.mo991a(i);
            }

            /* renamed from: b */
            public void mo992b() {
                super.mo992b();
            }
        });
        this.f690c.mo1253a(a);
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(this.f689b == 2 ? new Intent(this, Activity_Create.class) : new Intent(this, Activity_List.class));
        finish();
        if (!this.f691d) {
            return;
        }
        if (this.f690c.mo1257a()) {
            this.f690c.mo1258b();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f691d = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo() != null;
        if (this.f691d) {
            m1134a();
        }
        C0240b bVar = this.f688a;
        C0240b.m1188a(this);
        super.onCreate(bundle);
        getFragmentManager().beginTransaction().replace(16908290, new C0229a()).commit();
        this.f689b = getIntent().getExtras().getInt("bSCREEN");
    }
}
