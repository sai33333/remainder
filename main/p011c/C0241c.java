package p011c;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.outlook.healthyapps.reminder.R;

/* renamed from: c.c */
public class C0241c {
    /* renamed from: a */
    public static void m1190a(Context context, String str) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.alert_box);
        ((TextView) dialog.findViewById(R.id.text)).setText(str);
        ((Button) dialog.findViewById(R.id.dialogButtonOK)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
    }

    /* renamed from: a */
    public static void m1191a(Context context, String str, String str2) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.alert_box);
        TextView textView = (TextView) dialog.findViewById(R.id.text);
        ((TextView) dialog.findViewById(R.id.title)).setText(str2);
        textView.setText(str);
        ((Button) dialog.findViewById(R.id.dialogButtonOK)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.show();
    }
}
