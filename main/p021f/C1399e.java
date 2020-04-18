package p021f;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;
import app.Activity_Create;
import com.outlook.healthyapps.reminder.R;

/* renamed from: f.e */
public class C1399e extends DialogFragment {

    /* renamed from: a */
    Activity_Create f5063a;

    /* renamed from: b */
    NumberPicker f5064b;

    /* renamed from: c */
    NumberPicker f5065c;

    /* renamed from: d */
    String[] f5066d;

    /* renamed from: e */
    String[] f5067e;

    /* renamed from: f */
    private OnClickListener f5068f = new OnClickListener() {
        public void onClick(View view) {
            Activity_Create activity_Create = C1399e.this.f5063a;
            StringBuilder sb = new StringBuilder();
            sb.append("Nth-");
            sb.append(C1399e.this.f5065c.getValue());
            activity_Create.f673s = sb.toString();
            C1399e.this.f5063a.f672r = C1399e.this.f5064b.getValue();
            C1399e.this.f5063a.mo972g();
            C1399e.this.dismiss();
        }
    };

    public Dialog onCreateDialog(Bundle bundle) {
        this.f5063a = (Activity_Create) getActivity();
        Dialog dialog = new Dialog(this.f5063a);
        dialog.getWindow().requestFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.setContentView(R.layout.layout_repeat_freq_custom2);
        dialog.show();
        this.f5064b = (NumberPicker) dialog.findViewById(R.id.picker_Nth);
        this.f5065c = (NumberPicker) dialog.findViewById(R.id.picker_Days);
        this.f5064b.setMinValue(1);
        this.f5064b.setMaxValue(5);
        this.f5065c.setMinValue(1);
        this.f5065c.setMaxValue(7);
        this.f5067e = new String[]{"1st", "2nd", "3rd", "4th", "Last"};
        this.f5066d = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        this.f5064b.setDisplayedValues(this.f5067e);
        this.f5065c.setDisplayedValues(this.f5066d);
        ((Button) dialog.findViewById(R.id.btnOK_C2)).setOnClickListener(this.f5068f);
        return dialog;
    }
}
