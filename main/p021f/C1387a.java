package p021f;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p005v4.app.C0067e;
import android.widget.DatePicker;
import app.Activity_Create;
import com.outlook.healthyapps.reminder.R;

/* renamed from: f.a */
public class C1387a extends C0067e implements OnDateSetListener {

    /* renamed from: ag */
    Activity_Create f5037ag;

    /* renamed from: c */
    public Dialog mo168c(Bundle bundle) {
        this.f5037ag = (Activity_Create) mo252l();
        new DatePickerDialog(mo252l(), this, this.f5037ag.f666l.mo1033f(), this.f5037ag.f666l.mo1029d(), this.f5037ag.f666l.mo1031e());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f5037ag.getBaseContext());
        if (Integer.parseInt(defaultSharedPreferences.getString(this.f5037ag.getString(R.string.prefKey_dateTimeMode), "1")) != 1) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(mo252l(), R.style.dtPickerSpinner, this, this.f5037ag.f666l.mo1033f(), this.f5037ag.f666l.mo1029d(), this.f5037ag.f666l.mo1031e());
            return datePickerDialog;
        } else if (Integer.parseInt(defaultSharedPreferences.getString(this.f5037ag.getString(R.string.prefKey_theme), "1")) == 2) {
            DatePickerDialog datePickerDialog2 = new DatePickerDialog(mo252l(), R.style.Dark_datePicker, this, this.f5037ag.f666l.mo1033f(), this.f5037ag.f666l.mo1029d(), this.f5037ag.f666l.mo1031e());
            return datePickerDialog2;
        } else {
            DatePickerDialog datePickerDialog3 = new DatePickerDialog(mo252l(), R.style.Light_datePicker, this, this.f5037ag.f666l.mo1033f(), this.f5037ag.f666l.mo1029d(), this.f5037ag.f666l.mo1031e());
            return datePickerDialog3;
        }
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        this.f5037ag.f666l.mo1034f(i);
        this.f5037ag.f666l.mo1030d(i2);
        this.f5037ag.f666l.mo1032e(i3);
        this.f5037ag.mo973h();
    }
}
