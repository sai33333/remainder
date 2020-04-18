package p021f;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import app.Activity_Create;
import com.outlook.healthyapps.reminder.R;
import p022g.C1404a;

/* renamed from: f.f */
public class C1401f extends DialogFragment {

    /* renamed from: a */
    Activity_Create f5070a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CheckBox f5071b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CheckBox f5072c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CheckBox f5073d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CheckBox f5074e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CheckBox f5075f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CheckBox f5076g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CheckBox f5077h;

    /* renamed from: i */
    private OnClickListener f5078i = new OnClickListener() {
        public void onClick(View view) {
            Activity_Create activity_Create;
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            if (C1401f.this.f5071b.isChecked()) {
                stringBuffer.append("1");
            }
            if (C1401f.this.f5072c.isChecked()) {
                stringBuffer.append("2");
            }
            if (C1401f.this.f5073d.isChecked()) {
                stringBuffer.append("3");
            }
            if (C1401f.this.f5074e.isChecked()) {
                stringBuffer.append("4");
            }
            if (C1401f.this.f5075f.isChecked()) {
                stringBuffer.append("5");
            }
            if (C1401f.this.f5076g.isChecked()) {
                stringBuffer.append("6");
            }
            if (C1401f.this.f5077h.isChecked()) {
                stringBuffer.append("7");
            }
            if (stringBuffer.toString().isEmpty()) {
                activity_Create = C1401f.this.f5070a;
                C1404a aVar = C1401f.this.f5070a.f668n;
                str = "NA";
            } else if (stringBuffer.toString().equals("1234567")) {
                activity_Create = C1401f.this.f5070a;
                C1404a aVar2 = C1401f.this.f5070a.f668n;
                str = "D";
            } else {
                Activity_Create activity_Create2 = C1401f.this.f5070a;
                StringBuilder sb = new StringBuilder();
                C1404a aVar3 = C1401f.this.f5070a.f668n;
                sb.append("WD");
                sb.append("-");
                sb.append(stringBuffer.toString());
                activity_Create2.f673s = sb.toString();
                C1401f.this.f5070a.f672r = 1;
                C1401f.this.f5070a.mo972g();
                C1401f.this.dismiss();
            }
            activity_Create.f673s = str;
            C1401f.this.f5070a.f672r = 1;
            C1401f.this.f5070a.mo972g();
            C1401f.this.dismiss();
        }
    };

    public Dialog onCreateDialog(Bundle bundle) {
        this.f5070a = (Activity_Create) getActivity();
        Dialog dialog = new Dialog(this.f5070a);
        dialog.getWindow().requestFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.setContentView(R.layout.layout_repeat_freq_weekdays);
        dialog.show();
        this.f5071b = (CheckBox) dialog.findViewById(R.id.chk_sun);
        this.f5072c = (CheckBox) dialog.findViewById(R.id.chk_mon);
        this.f5073d = (CheckBox) dialog.findViewById(R.id.chk_tue);
        this.f5074e = (CheckBox) dialog.findViewById(R.id.chk_wed);
        this.f5075f = (CheckBox) dialog.findViewById(R.id.chk_thu);
        this.f5076g = (CheckBox) dialog.findViewById(R.id.chk_fri);
        this.f5077h = (CheckBox) dialog.findViewById(R.id.chk_sat);
        ((Button) dialog.findViewById(R.id.btnOK_WD)).setOnClickListener(this.f5078i);
        return dialog;
    }
}
