package p000a;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.outlook.healthyapps.reminder.R;
import java.util.ArrayList;
import p011c.C0239a;
import p020e.C1386a;

/* renamed from: a.a */
public class C0000a extends ArrayAdapter<C1386a> {

    /* renamed from: a */
    private C0239a f0a;

    /* renamed from: b */
    private int f1b;

    /* renamed from: c */
    private int f2c;

    /* renamed from: d */
    private int f3d;

    /* renamed from: a.a$a */
    private static class C0002a {

        /* renamed from: a */
        TextView f4a;

        /* renamed from: b */
        TextView f5b;

        /* renamed from: c */
        TextView f6c;

        private C0002a() {
        }
    }

    public C0000a(Context context, ArrayList<C1386a> arrayList) {
        super(context, R.layout.layout_item_listview, arrayList);
        this.f0a = new C0239a(context);
        TypedValue typedValue = new TypedValue();
        Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr._expireColor, typedValue, true);
        this.f1b = typedValue.data;
        theme.resolveAttribute(R.attr._color1stLevel, typedValue, true);
        this.f2c = typedValue.data;
        theme.resolveAttribute(R.attr._color2ndLevel, typedValue, true);
        this.f3d = typedValue.data;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0002a aVar;
        int i2;
        TextView textView;
        String str;
        StringBuilder sb;
        TextView textView2;
        C1386a aVar2 = (C1386a) getItem(i);
        if (view == null) {
            aVar = new C0002a();
            view2 = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_listview, viewGroup, false);
            aVar.f4a = (TextView) view2.findViewById(R.id.textViewDescription);
            aVar.f5b = (TextView) view2.findViewById(R.id.textViewDateAndTime);
            aVar.f6c = (TextView) view2.findViewById(R.id.textViewRptDesc);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (C0002a) view.getTag();
        }
        aVar.f4a.setText(aVar2.mo3693b());
        aVar.f5b.setText(this.f0a.mo1021a(aVar2.mo3703f()));
        aVar.f6c.setText(aVar2.mo3707j());
        if (aVar2.mo3706i().equals("E")) {
            ((TextView) view2.findViewById(R.id.textViewDescription)).setTextColor(this.f1b);
            ((TextView) view2.findViewById(R.id.textViewDateAndTime)).setTextColor(this.f1b);
            textView = (TextView) view2.findViewById(R.id.textViewRptDesc);
            i2 = this.f1b;
        } else {
            ((TextView) view2.findViewById(R.id.textViewDescription)).setTextColor(this.f2c);
            ((TextView) view2.findViewById(R.id.textViewDateAndTime)).setTextColor(this.f2c);
            textView = (TextView) view2.findViewById(R.id.textViewRptDesc);
            i2 = this.f3d;
        }
        textView.setTextColor(i2);
        if (aVar2.mo3693b().contains("[No Title]")) {
            textView2 = aVar.f4a;
            sb = new StringBuilder();
            sb.append("Select this reminder. ");
            str = aVar2.mo3693b().replace("[", "").replace("]", "");
        } else {
            textView2 = aVar.f4a;
            sb = new StringBuilder();
            sb.append("Select this reminder. ");
            str = aVar2.mo3693b();
        }
        sb.append(str);
        textView2.setContentDescription(sb.toString());
        TextView textView3 = aVar.f5b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(". Scheduled at ");
        sb2.append(aVar.f5b.getText());
        textView3.setContentDescription(sb2.toString());
        TextView textView4 = aVar.f6c;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(". Repeat ");
        sb3.append(aVar2.mo3707j());
        textView4.setContentDescription(sb3.toString());
        return view2;
    }
}
