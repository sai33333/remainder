package p019d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import p020e.C1386a;

/* renamed from: d.a */
public class C1385a extends SQLiteOpenHelper {

    /* renamed from: a */
    public static String[] f5024a = {"cID", "cTITLE", "cDATE", "cTIME", "cREPEAT_DESC", "cFIRST_RUN", "cNEXT_RUN", "cREPEAT_TYPE", "cREPEAT_FREQ", "cSTATUS"};

    /* renamed from: b */
    private static C1385a f5025b;

    private C1385a(Context context) {
        super(context, "DB_REMINDER", null, 1);
    }

    /* renamed from: a */
    public static C1385a m6397a(Context context) {
        if (f5025b == null) {
            f5025b = new C1385a(context.getApplicationContext());
        }
        return f5025b;
    }

    /* renamed from: a */
    public int mo3671a(C1386a aVar) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cTITLE", aVar.mo3693b());
        contentValues.put("cDATE", aVar.mo3698c());
        contentValues.put("cTIME", aVar.mo3700d());
        contentValues.put("cREPEAT_DESC", aVar.mo3707j());
        contentValues.put("cFIRST_RUN", Long.valueOf(aVar.mo3702e()));
        contentValues.put("cNEXT_RUN", Long.valueOf(aVar.mo3703f()));
        contentValues.put("cREPEAT_TYPE", aVar.mo3704g());
        contentValues.put("cREPEAT_FREQ", Integer.valueOf(aVar.mo3705h()));
        contentValues.put("cSTATUS", "A");
        return (int) writableDatabase.insert("tREMINDER", null, contentValues);
    }

    /* renamed from: a */
    public C1386a mo3672a(int i) {
        C1386a aVar = new C1386a();
        Cursor query = getReadableDatabase().query("tREMINDER", new String[]{"cTITLE", "cDATE", "cTIME", "cREPEAT_DESC", "cFIRST_RUN", "cNEXT_RUN", "cREPEAT_TYPE", "cREPEAT_FREQ"}, "cID=?", new String[]{String.valueOf(i)}, null, null, null, null);
        if (query != null) {
            query.moveToFirst();
            int columnIndex = query.getColumnIndex("cTITLE");
            int columnIndex2 = query.getColumnIndex("cREPEAT_DESC");
            int columnIndex3 = query.getColumnIndex("cFIRST_RUN");
            int columnIndex4 = query.getColumnIndex("cNEXT_RUN");
            int columnIndex5 = query.getColumnIndex("cREPEAT_TYPE");
            int columnIndex6 = query.getColumnIndex("cREPEAT_FREQ");
            aVar.mo3688a(i);
            aVar.mo3692a(query.getString(columnIndex));
            aVar.mo3701d(query.getString(columnIndex2));
            aVar.mo3689a(Long.parseLong(query.getString(columnIndex3)));
            aVar.mo3695b(Long.parseLong(query.getString(columnIndex4)));
            aVar.mo3697b(query.getString(columnIndex5));
            aVar.mo3694b(Integer.parseInt(query.getString(columnIndex6)));
            query.close();
        }
        return aVar;
    }

    /* renamed from: a */
    public ArrayList<C1386a> mo3673a() {
        String[] strArr = {"cID"};
        ArrayList<C1386a> arrayList = new ArrayList<>();
        Cursor query = getReadableDatabase().query("tREMINDER", strArr, "cSTATUS=?", new String[]{"A"}, null, null, null, null);
        int columnIndex = query.getColumnIndex("cID");
        if (query.moveToFirst()) {
            do {
                C1386a aVar = new C1386a();
                aVar.mo3688a(Integer.parseInt(query.getString(columnIndex)));
                arrayList.add(aVar);
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    /* renamed from: a */
    public void mo3674a(int i, long j) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cNEXT_RUN", Long.valueOf(j));
        readableDatabase.update("tREMINDER", contentValues, "cID=?", new String[]{String.valueOf(i)});
    }

    /* renamed from: a */
    public boolean mo3675a(ArrayList<C1386a> arrayList) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C1386a aVar = (C1386a) it.next();
                contentValues.put("cTITLE", aVar.mo3693b());
                contentValues.put("cDATE", aVar.mo3698c());
                contentValues.put("cTIME", aVar.mo3700d());
                contentValues.put("cREPEAT_DESC", aVar.mo3707j());
                contentValues.put("cFIRST_RUN", Long.valueOf(aVar.mo3702e()));
                contentValues.put("cNEXT_RUN", Long.valueOf(aVar.mo3703f()));
                contentValues.put("cREPEAT_TYPE", aVar.mo3704g());
                contentValues.put("cREPEAT_FREQ", Integer.valueOf(aVar.mo3705h()));
                contentValues.put("cSTATUS", aVar.mo3706i());
                writableDatabase.insert("tREMINDER", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
            return true;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    /* renamed from: b */
    public long mo3676b() {
        return DatabaseUtils.queryNumEntries(getReadableDatabase(), "tREMINDER");
    }

    /* renamed from: b */
    public void mo3677b(int i) {
        getReadableDatabase().delete("tREMINDER", "cID=?", new String[]{String.valueOf(i)});
    }

    /* renamed from: c */
    public ArrayList<C1386a> mo3678c() {
        ArrayList<C1386a> arrayList = new ArrayList<>();
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM tREMINDER ORDER BY cSTATUS ASC, cNEXT_RUN ASC", null);
        int columnIndex = rawQuery.getColumnIndex("cID");
        int columnIndex2 = rawQuery.getColumnIndex("cTITLE");
        int columnIndex3 = rawQuery.getColumnIndex("cREPEAT_DESC");
        int columnIndex4 = rawQuery.getColumnIndex("cFIRST_RUN");
        int columnIndex5 = rawQuery.getColumnIndex("cNEXT_RUN");
        int columnIndex6 = rawQuery.getColumnIndex("cREPEAT_TYPE");
        int columnIndex7 = rawQuery.getColumnIndex("cSTATUS");
        if (rawQuery.moveToFirst()) {
            do {
                C1386a aVar = new C1386a();
                aVar.mo3688a(Integer.parseInt(rawQuery.getString(columnIndex)));
                aVar.mo3692a(rawQuery.getString(columnIndex2));
                aVar.mo3701d(rawQuery.getString(columnIndex3));
                aVar.mo3689a(Long.parseLong(rawQuery.getString(columnIndex4)));
                aVar.mo3695b(Long.parseLong(rawQuery.getString(columnIndex5)));
                aVar.mo3697b(rawQuery.getString(columnIndex6));
                aVar.mo3699c(rawQuery.getString(columnIndex7));
                arrayList.add(aVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return arrayList;
    }

    /* renamed from: c */
    public void mo3679c(int i) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cSTATUS", "E");
        readableDatabase.update("tREMINDER", contentValues, "cID=?", new String[]{String.valueOf(i)});
    }

    /* renamed from: d */
    public ArrayList<C1386a> mo3680d() {
        ArrayList<C1386a> arrayList = new ArrayList<>();
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM tREMINDER WHERE cSTATUS ='A'", null);
        int columnIndex = rawQuery.getColumnIndex("cID");
        int columnIndex2 = rawQuery.getColumnIndex("cTITLE");
        int columnIndex3 = rawQuery.getColumnIndex("cNEXT_RUN");
        if (rawQuery.moveToFirst()) {
            do {
                C1386a aVar = new C1386a();
                aVar.mo3688a(Integer.parseInt(rawQuery.getString(columnIndex)));
                aVar.mo3692a(rawQuery.getString(columnIndex2));
                aVar.mo3695b(Long.parseLong(rawQuery.getString(columnIndex3)));
                arrayList.add(aVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return arrayList;
    }

    /* renamed from: d */
    public boolean mo3681d(int i) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT 1 FROM tREMINDER WHERE cID=");
        sb.append(i);
        Cursor rawQuery = readableDatabase.rawQuery(sb.toString(), null);
        boolean z = rawQuery.getCount() > 0;
        rawQuery.close();
        return z;
    }

    /* renamed from: e */
    public ArrayList<C1386a> mo3682e() {
        ArrayList<C1386a> arrayList = new ArrayList<>();
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT * FROM tREMINDER WHERE cSTATUS ='A' ORDER BY cNEXT_RUN ASC", null);
        int columnIndex = rawQuery.getColumnIndex("cID");
        int columnIndex2 = rawQuery.getColumnIndex("cTITLE");
        int columnIndex3 = rawQuery.getColumnIndex("cFIRST_RUN");
        int columnIndex4 = rawQuery.getColumnIndex("cNEXT_RUN");
        int columnIndex5 = rawQuery.getColumnIndex("cREPEAT_TYPE");
        int columnIndex6 = rawQuery.getColumnIndex("cREPEAT_DESC");
        if (rawQuery.moveToFirst()) {
            do {
                C1386a aVar = new C1386a();
                aVar.mo3688a(Integer.parseInt(rawQuery.getString(columnIndex)));
                aVar.mo3692a(rawQuery.getString(columnIndex2));
                aVar.mo3689a(Long.parseLong(rawQuery.getString(columnIndex3)));
                aVar.mo3695b(Long.parseLong(rawQuery.getString(columnIndex4)));
                aVar.mo3697b(rawQuery.getString(columnIndex5));
                aVar.mo3701d(rawQuery.getString(columnIndex6));
                arrayList.add(aVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return arrayList;
    }

    /* renamed from: f */
    public int mo3683f() {
        return getReadableDatabase().delete("tREMINDER", "cSTATUS=?", new String[]{"E"});
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE tREMINDER(cID INTEGER PRIMARY KEY,cTITLE TEXT,cDATE TEXT,cTIME TEXT,cREPEAT_DESC TEXT,cFIRST_RUN INTEGER,cNEXT_RUN INTEGER,cREPEAT_TYPE TEXT,cREPEAT_FREQ INTEGER,cSTATUS TEXT)");
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        sQLiteDatabase.disableWriteAheadLogging();
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < i2) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tREMINDER");
            onCreate(sQLiteDatabase);
        }
    }
}
