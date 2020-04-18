package p021f;

import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import app.Activity_List;
import com.outlook.healthyapps.reminder.R;
import p022g.C1404a;

/* renamed from: f.b */
public class C1388b extends DialogFragment {

    /* renamed from: a */
    Activity_List f5038a;

    /* renamed from: b */
    public C1404a f5039b = new C1404a();

    /* renamed from: c */
    int f5040c;

    /* renamed from: d */
    private TextView f5041d;

    /* renamed from: e */
    private OnClickListener f5042e = new OnClickListener() {
        public void onClick(View view) {
            C1388b.this.dismiss();
        }
    };

    /* renamed from: f */
    private OnClickListener f5043f = new OnClickListener() {
        public void onClick(View view) {
            C1388b.this.dismiss();
            C1388b.this.f5038a.mo979a(C1388b.this.f5040c);
        }
    };

    /* renamed from: g */
    private OnClickListener f5044g = new OnClickListener() {
        public void onClick(View view) {
            C1388b.this.dismiss();
            C1388b.this.f5038a.mo980b(C1388b.this.f5040c);
        }
    };

    public Dialog onCreateDialog(Bundle bundle) {
        this.f5038a = (Activity_List) getActivity();
        Dialog dialog = new Dialog(this.f5038a);
        dialog.getWindow().requestFeature(1);
        dialog.getWindow().setFlags(1024, 1024);
        dialog.setContentView(R.layout.layout_dialog_listview);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
        Bundle arguments = getArguments();
        this.f5040c = arguments.getInt("bID");
        this.f5041d = (TextView) dialog.findViewById(R.id.txtViewMsg);
        this.f5041d.setMovementMethod(new ScrollingMovementMethod());
        String string = arguments.getString("bRPT_TYPE");
        C1404a aVar = this.f5039b;
        if (string.equals("NA")) {
            TextView textView = (TextView) dialog.findViewById(R.id.txtViewDate);
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduled at ");
            sb.append(arguments.getString("bSTART_DATE"));
            textView.setText(sb.toString());
            ((TextView) dialog.findViewById(R.id.txtViewNextRun)).setVisibility(8);
        } else {
            TextView textView2 = (TextView) dialog.findViewById(R.id.txtViewDate);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Start Date  ::  ");
            sb2.append(arguments.getString("bSTART_DATE"));
            textView2.setText(sb2.toString());
            TextView textView3 = (TextView) dialog.findViewById(R.id.txtViewNextRun);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Next Run  ::  ");
            sb3.append(arguments.getString("bNEXT_RUN"));
            textView3.setText(sb3.toString());
        }
        if (arguments.getString("bSTATUS").equals("E")) {
            ((TextView) dialog.findViewById(R.id.txtViewStatus)).setVisibility(0);
            ((TextView) dialog.findViewById(R.id.txtViewStatus)).setText("Expired");
        }
        this.f5041d.setText(arguments.getString("bTITLE"));
        TextView textView4 = (TextView) dialog.findViewById(R.id.txtViewRptDesc);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Repeat  ::  ");
        sb4.append(arguments.getString("bRPT_DESC"));
        textView4.setText(sb4.toString());
        ((Button) dialog.findViewById(R.id.btnCancel)).setOnClickListener(this.f5042e);
        ((Button) dialog.findViewById(R.id.btnEdit)).setOnClickListener(this.f5043f);
        ((Button) dialog.findViewById(R.id.btnDelete)).setOnClickListener(this.f5044g);
        if (this.f5041d.getText().toString().contains("[No Title]")) {
            TextView textView5 = this.f5041d;
            textView5.setContentDescription(textView5.getText().toString().replace("[", "").replace("]", ""));
        }
        return dialog;
    }

    public void onPause() {
        super.onPause();
        dismiss();
    }
}
