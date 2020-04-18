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

/* renamed from: f.d */
public class C1397d extends DialogFragment {

    /* renamed from: a */
    Activity_Create f5057a;

    /* renamed from: b */
    NumberPicker f5058b;

    /* renamed from: c */
    NumberPicker f5059c;

    /* renamed from: d */
    String[] f5060d;

    /* renamed from: e */
    private OnClickListener f5061e = new OnClickListener() {
        public void onClick(View view) {
            String str = C1397d.this.f5060d[C1397d.this.f5059c.getValue()];
            C1397d.this.f5057a.f673s = String.valueOf(str.charAt(0));
            C1397d.this.f5057a.f672r = C1397d.this.f5058b.getValue();
            C1397d.this.f5057a.mo972g();
            C1397d.this.dismiss();
        }
    };

    public Dialog onCreateDialog(Bundle bundle) {
        this.f5057a = (Activity_Create) getActivity();
        Dialog dialog = new Dialog(this.f5057a);
        dialog.getWindow().requestFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.setContentView(R.layout.layout_repeat_freq_custom1);
        dialog.show();
        this.f5058b = (NumberPicker) dialog.findViewById(R.id.picker_Numbers);
        this.f5059c = (NumberPicker) dialog.findViewById(R.id.picker_Frequencies);
        this.f5058b.setMinValue(2);
        this.f5058b.setMaxValue(100);
        this.f5059c.setMinValue(0);
        this.f5059c.setMaxValue(4);
        this.f5060d = new String[]{"Hours", "Days", "Weeks", "Months", "Years"};
        this.f5059c.setDisplayedValues(this.f5060d);
        ((Button) dialog.findViewById(R.id.btnOK_C1)).setOnClickListener(this.f5061e);
        return dialog;
    }
}
