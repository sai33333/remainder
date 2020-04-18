package p021f;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p005v4.app.C0067e;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import app.Activity_Create;
import com.outlook.healthyapps.reminder.R;

/* renamed from: f.g */
public class C1403g extends C0067e implements OnTimeSetListener {

    /* renamed from: ag */
    Activity_Create f5080ag;

    /* renamed from: c */
    public Dialog mo168c(Bundle bundle) {
        this.f5080ag = (Activity_Create) mo252l();
        new TimePickerDialog(mo252l(), this, this.f5080ag.f666l.mo1024b(), this.f5080ag.f666l.mo1027c(), DateFormat.is24HourFormat(mo252l()));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f5080ag.getBaseContext());
        if (Integer.parseInt(defaultSharedPreferences.getString(this.f5080ag.getString(R.string.prefKey_dateTimeMode), "1")) != 1) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(mo252l(), R.style.timePickerSpinner, this, this.f5080ag.f666l.mo1024b(), this.f5080ag.f666l.mo1027c(), DateFormat.is24HourFormat(mo252l()));
            return timePickerDialog;
        } else if (Integer.parseInt(defaultSharedPreferences.getString(this.f5080ag.getString(R.string.prefKey_theme), "1")) == 2) {
            TimePickerDialog timePickerDialog2 = new TimePickerDialog(mo252l(), R.style.Dark_datePicker, this, this.f5080ag.f666l.mo1024b(), this.f5080ag.f666l.mo1027c(), DateFormat.is24HourFormat(mo252l()));
            return timePickerDialog2;
        } else {
            TimePickerDialog timePickerDialog3 = new TimePickerDialog(mo252l(), R.style.Light_datePicker, this, this.f5080ag.f666l.mo1024b(), this.f5080ag.f666l.mo1027c(), DateFormat.is24HourFormat(mo252l()));
            return timePickerDialog3;
        }
    }

    public void onTimeSet(TimePicker timePicker, int i, int i2) {
        this.f5080ag.f666l.mo1022a(i);
        this.f5080ag.f666l.mo1028c(i2);
        this.f5080ag.mo974i();
    }
}
