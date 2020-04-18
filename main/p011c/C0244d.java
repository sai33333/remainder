package p011c;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.outlook.healthyapps.reminder.R;

/* renamed from: c.d */
public class C0244d {
    /* renamed from: a */
    public static void m1192a(Context context, String str, final C0251e eVar) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.confirm_box);
        Button button = (Button) dialog.findViewById(R.id.dialogButtonNO);
        Button button2 = (Button) dialog.findViewById(R.id.dialogButtonYES);
        ((TextView) dialog.findViewById(R.id.text)).setText(str);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                eVar.mo965a();
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
    }

    /* renamed from: a */
    public static void m1193a(Context context, String str, String str2, final C0251e eVar) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.confirm_box);
        Button button = (Button) dialog.findViewById(R.id.dialogButtonNO);
        Button button2 = (Button) dialog.findViewById(R.id.dialogButtonYES);
        TextView textView = (TextView) dialog.findViewById(R.id.text);
        TextView textView2 = (TextView) dialog.findViewById(R.id.title);
        button.setText("Cancel");
        button2.setText("OK");
        textView2.setText(str2);
        textView.setText(str);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                eVar.mo965a();
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
    }

    /* renamed from: b */
    public static void m1194b(Context context, String str, String str2, final C0251e eVar) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.confirm_box);
        Button button = (Button) dialog.findViewById(R.id.dialogButtonNO);
        Button button2 = (Button) dialog.findViewById(R.id.dialogButtonYES);
        TextView textView = (TextView) dialog.findViewById(R.id.text);
        TextView textView2 = (TextView) dialog.findViewById(R.id.title);
        button.setText("Cancel");
        button2.setText("View in PLAYSTORE");
        textView2.setText(str2);
        textView.setText(str);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                eVar.mo965a();
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
    }
}
