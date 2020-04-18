package p021f;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import app.Activity_Create;
import com.outlook.healthyapps.reminder.R;
import p022g.C1404a;

/* renamed from: f.c */
public class C1392c extends DialogFragment {

    /* renamed from: a */
    Activity_Create f5048a;

    /* renamed from: b */
    private OnClickListener f5049b = new OnClickListener() {
        public void onClick(View view) {
            C1392c.this.f5048a.f673s = ((TextView) view).getTag().toString();
            C1392c.this.f5048a.f672r = 1;
            C1392c.this.f5048a.mo972g();
            C1392c.this.dismiss();
        }
    };

    /* renamed from: c */
    private OnClickListener f5050c = new OnClickListener() {
        public void onClick(View view) {
            C1401f fVar = new C1401f();
            fVar.setCancelable(true);
            fVar.show(C1392c.this.getFragmentManager(), "");
            C1392c.this.dismiss();
        }
    };

    /* renamed from: d */
    private OnClickListener f5051d = new OnClickListener() {
        public void onClick(View view) {
            C1397d dVar = new C1397d();
            dVar.setCancelable(true);
            dVar.show(C1392c.this.getFragmentManager(), "");
            C1392c.this.dismiss();
        }
    };

    /* renamed from: e */
    private OnClickListener f5052e = new OnClickListener() {
        public void onClick(View view) {
            C1399e eVar = new C1399e();
            eVar.setCancelable(true);
            eVar.show(C1392c.this.getFragmentManager(), "");
            C1392c.this.dismiss();
        }
    };

    public Dialog onCreateDialog(Bundle bundle) {
        this.f5048a = (Activity_Create) getActivity();
        Dialog dialog = new Dialog(this.f5048a);
        dialog.getWindow().requestFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.setContentView(R.layout.layout_repeat_freq);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(R.id.txtView_NA);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txtView_H);
        TextView textView3 = (TextView) dialog.findViewById(R.id.txtView_D);
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtView_W);
        TextView textView5 = (TextView) dialog.findViewById(R.id.txtView_M);
        TextView textView6 = (TextView) dialog.findViewById(R.id.txtView_Y);
        TextView textView7 = (TextView) dialog.findViewById(R.id.txtView_WD);
        TextView textView8 = (TextView) dialog.findViewById(R.id.txtView_C1);
        TextView textView9 = (TextView) dialog.findViewById(R.id.txtView_C2);
        C1404a aVar = this.f5048a.f668n;
        C1404a aVar2 = this.f5048a.f668n;
        textView.setText(aVar.mo3726a(1, "NA"));
        C1404a aVar3 = this.f5048a.f668n;
        C1404a aVar4 = this.f5048a.f668n;
        textView2.setText(aVar3.mo3726a(1, "H"));
        C1404a aVar5 = this.f5048a.f668n;
        C1404a aVar6 = this.f5048a.f668n;
        textView3.setText(aVar5.mo3726a(1, "D"));
        C1404a aVar7 = this.f5048a.f668n;
        C1404a aVar8 = this.f5048a.f668n;
        textView4.setText(aVar7.mo3726a(1, "W"));
        C1404a aVar9 = this.f5048a.f668n;
        C1404a aVar10 = this.f5048a.f668n;
        textView5.setText(aVar9.mo3726a(1, "M"));
        C1404a aVar11 = this.f5048a.f668n;
        C1404a aVar12 = this.f5048a.f668n;
        textView6.setText(aVar11.mo3726a(1, "Y"));
        C1404a aVar13 = this.f5048a.f668n;
        textView.setTag("NA");
        C1404a aVar14 = this.f5048a.f668n;
        textView2.setTag("H");
        C1404a aVar15 = this.f5048a.f668n;
        textView3.setTag("D");
        C1404a aVar16 = this.f5048a.f668n;
        textView4.setTag("W");
        C1404a aVar17 = this.f5048a.f668n;
        textView5.setTag("M");
        C1404a aVar18 = this.f5048a.f668n;
        textView6.setTag("Y");
        textView.setOnClickListener(this.f5049b);
        textView2.setOnClickListener(this.f5049b);
        textView3.setOnClickListener(this.f5049b);
        textView4.setOnClickListener(this.f5049b);
        textView5.setOnClickListener(this.f5049b);
        textView6.setOnClickListener(this.f5049b);
        textView7.setOnClickListener(this.f5050c);
        textView8.setOnClickListener(this.f5051d);
        textView9.setOnClickListener(this.f5052e);
        return dialog;
    }
}
