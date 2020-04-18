package app;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Environment;
import android.support.p005v4.app.C0055a;
import android.support.p005v4.p006a.C0048a;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.outlook.healthyapps.reminder.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import p010b.C0238a;
import p011c.C0240b;
import p011c.C0241c;
import p011c.C0244d;
import p011c.C0251e;
import p019d.C1385a;
import p020e.C1386a;

public class Activity_Backup extends Activity {

    /* renamed from: a */
    public final String f649a = "DB_REMINDER";

    /* renamed from: b */
    public final String f650b = "tREMINDER";

    /* renamed from: c */
    protected final File f651c = new File(Environment.getExternalStorageDirectory(), "BACKUP_REMINDER_HEALTHYAPPS");

    /* renamed from: d */
    protected final String f652d = "BACKUP_REMINDER_HEALTHYAPPS.db";

    /* renamed from: e */
    private C0240b f653e;

    /* renamed from: f */
    private Context f654f;

    /* renamed from: g */
    private C0238a f655g;

    /* renamed from: h */
    private final String f656h = "BACKUP_REMINDER_HEALTHYAPPS";

    /* renamed from: i */
    private final File f657i;

    public Activity_Backup() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getDataDirectory());
        sb.append("/data/");
        sb.append("com.outlook.healthyapps.reminder");
        sb.append("/databases/");
        sb.append("DB_REMINDER");
        this.f657i = new File(sb.toString());
    }

    /* renamed from: b */
    private void m1107b(File file, File file2) {
        FileChannel channel = new FileInputStream(file).getChannel();
        FileChannel channel2 = new FileOutputStream(file2).getChannel();
        try {
            channel.transferTo(0, channel.size(), channel2);
        } finally {
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        }
    }

    /* renamed from: e */
    private boolean m1108e() {
        return C0048a.m132a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    /* renamed from: f */
    private void m1109f() {
        if (C0055a.m169a(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            C0244d.m1193a(this, "Need your permission to save backup to your external storage!!!", "Permission is required!", new C0251e() {
                /* renamed from: a */
                public void mo965a() {
                    C0055a.m168a(Activity_Backup.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
                }
            });
        } else {
            C0055a.m168a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* renamed from: g */
    private boolean m1110g() {
        return C0048a.m132a(this, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* renamed from: h */
    private void m1111h() {
        if (C0055a.m169a(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            C0244d.m1193a(this, "Need your permission to restore backup from external storage!!!", "Permission is required!", new C0251e() {
                /* renamed from: a */
                public void mo965a() {
                    C0055a.m168a(Activity_Backup.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 2);
                }
            });
        } else {
            C0055a.m168a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 2);
        }
    }

    public void OnClick_Backup(View view) {
        if (m1108e()) {
            mo957a();
        } else {
            m1109f();
        }
    }

    public void OnClick_Restore(View view) {
        String str;
        C0251e eVar;
        if (m1110g()) {
            if (((CheckBox) findViewById(R.id.checkBoxRestoreType)).isChecked()) {
                str = "Are you sure you want to restore reminders from backup folder?\n\nYou have selected:\n \"Append to existing reminders in the app.\"";
                eVar = new C0251e() {
                    /* renamed from: a */
                    public void mo965a() {
                        Activity_Backup.this.mo961c();
                    }
                };
            } else {
                str = "Are you sure you want to restore reminders from backup folder?";
                eVar = new C0251e() {
                    /* renamed from: a */
                    public void mo965a() {
                        Activity_Backup.this.mo960b();
                    }
                };
            }
            C0244d.m1192a(this, str, eVar);
            return;
        }
        m1111h();
    }

    /* renamed from: a */
    public boolean mo957a() {
        if (this.f655g.mo1009b() == 0) {
            C0241c.m1191a(this, "\nThere are no reminders to take backup.\n", "No Reminders!");
            return false;
        } else if (!mo962d()) {
            C0241c.m1190a(this, "\nUnable to access external storage.\n");
            return false;
        } else {
            final File file = this.f657i;
            File file2 = this.f651c;
            final File file3 = new File(file2, "BACKUP_REMINDER_HEALTHYAPPS.db");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file3.exists()) {
                return mo959a(file, file3);
            }
            C0244d.m1192a(this, "Backup file already exists and will be overwritten.", new C0251e() {
                /* renamed from: a */
                public void mo965a() {
                    Activity_Backup.this.mo959a(file, file3);
                }
            });
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo958a(File file) {
        try {
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(file.getPath(), null, 1);
            Cursor query = openDatabase.query(true, "tREMINDER", null, null, null, null, null, null, null);
            for (String columnIndexOrThrow : C1385a.f5024a) {
                query.getColumnIndexOrThrow(columnIndexOrThrow);
            }
            openDatabase.close();
            query.close();
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            C0241c.m1191a(this, "\nBackup file was not compatible.\n", "Invalid backup file");
            return false;
        } catch (SQLiteException unused) {
            C0241c.m1191a(this, "\nBackup file was not compatible (or) not belongs to this app.\n", "Invalid backup file");
            return false;
        } catch (Exception unused2) {
            C0241c.m1190a(this, "\nCould not restore the reminders,\nbecause the backup file was not compatible (or) corrupted.\n");
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo959a(File file, File file2) {
        try {
            file2.createNewFile();
            m1107b(file, file2);
            C0241c.m1191a(this, "\nBackup file saved successfully to backup folder of your external storage. Please store this backup file into your email, computer etc..\n", "Success!");
            return true;
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append(e.getMessage());
            sb.append("\n");
            C0241c.m1190a(this, sb.toString());
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo960b() {
        if (!mo962d()) {
            C0241c.m1190a(this, "\nUnable to access external storage.\n");
            return false;
        }
        File file = new File(this.f651c, "BACKUP_REMINDER_HEALTHYAPPS.db");
        File file2 = this.f657i;
        if (!file.exists()) {
            C0241c.m1191a(this, "\nNo backup file can be found in your backup folder.\n\nTip:\nIf the backup file is stored in some other place, then please put it in backup folder.\n", "File does not exist.");
            return false;
        } else if (!mo958a(file)) {
            return false;
        } else {
            try {
                ArrayList a = this.f655g.mo1004a();
                file2.createNewFile();
                m1107b(file, file2);
                try {
                    this.f655g.mo1011b(a);
                    C0241c.m1191a(this, "\nReminders restored successfully.\n", "Success!");
                } catch (Exception unused) {
                    C0241c.m1190a(this, "\nReminders restored successfully.\nPlease restart your device to make reminders are active.\n");
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                C0241c.m1190a(this, "\nUnable to restore from backup.\n");
                return false;
            }
        }
    }

    /* renamed from: c */
    public boolean mo961c() {
        if (!mo962d()) {
            C0241c.m1190a(this, "\nUnable to access external storage.\n");
            return false;
        }
        File file = new File(this.f651c, "BACKUP_REMINDER_HEALTHYAPPS.db");
        if (!file.exists()) {
            C0241c.m1191a(this, "\nNo backup file can be found in your backup folder.\n\nTip:\nIf the backup file is stored in some other place, then please put it in backup folder.\n", "File does not exist.");
            return false;
        } else if (!mo958a(file)) {
            return false;
        } else {
            ArrayList a = this.f655g.mo1004a();
            ArrayList arrayList = new ArrayList();
            try {
                SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(file.getPath(), null, 1);
                Cursor query = openDatabase.query(true, "tREMINDER", null, null, null, null, null, null, null);
                int columnIndex = query.getColumnIndex("cTITLE");
                int columnIndex2 = query.getColumnIndex("cFIRST_RUN");
                int columnIndex3 = query.getColumnIndex("cNEXT_RUN");
                int columnIndex4 = query.getColumnIndex("cREPEAT_TYPE");
                int columnIndex5 = query.getColumnIndex("cREPEAT_DESC");
                int columnIndex6 = query.getColumnIndex("cREPEAT_FREQ");
                int columnIndex7 = query.getColumnIndex("cSTATUS");
                if (query.moveToFirst()) {
                    while (true) {
                        C1386a aVar = new C1386a();
                        aVar.mo3692a(query.getString(columnIndex));
                        int i = columnIndex;
                        aVar.mo3689a(Long.parseLong(query.getString(columnIndex2)));
                        aVar.mo3695b(Long.parseLong(query.getString(columnIndex3)));
                        aVar.mo3697b(query.getString(columnIndex4));
                        aVar.mo3701d(query.getString(columnIndex5));
                        aVar.mo3694b(Integer.parseInt(query.getString(columnIndex6)));
                        aVar.mo3699c(query.getString(columnIndex7));
                        arrayList.add(aVar);
                        if (!query.moveToNext()) {
                            break;
                        }
                        columnIndex = i;
                    }
                }
                openDatabase.close();
                query.close();
                this.f655g.mo1008a(arrayList);
                try {
                    this.f655g.mo1011b(a);
                    C0241c.m1191a(this, "\nReminders restored successfully.\n", "Success!");
                } catch (Exception unused) {
                    C0241c.m1190a(this, "\nReminders restored successfully.\nPlease restart your device to make reminders are active.\n");
                }
                return true;
            } catch (Exception unused2) {
                C0241c.m1191a(this, "\nThe data in the backup file was corrupted.\n", "Invalid backup file");
                return false;
            }
        }
    }

    /* renamed from: d */
    public boolean mo962d() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public void onCreate(Bundle bundle) {
        C0240b bVar = this.f653e;
        C0240b.m1188a(this);
        super.onCreate(bundle);
        setContentView(R.layout.layout_backup);
        this.f654f = getApplicationContext();
        this.f655g = new C0238a(this.f654f);
        ((TextView) findViewById(R.id.TextView_BackupFolder)).setText("1. Backup folder in External storage:\nBACKUP_REMINDER_HEALTHYAPPS");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z = false;
        if (iArr.length > 0 && iArr[0] == 0) {
            z = true;
        }
        if (z && i == 1) {
            mo957a();
        } else if (!z || i != 2) {
        } else {
            if (((CheckBox) findViewById(R.id.checkBoxRestoreType)).isChecked()) {
                mo961c();
            } else {
                mo960b();
            }
        }
    }
}
