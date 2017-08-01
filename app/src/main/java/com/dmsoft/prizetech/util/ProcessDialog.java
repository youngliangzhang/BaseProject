package com.dmsoft.prizetech.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dmsoft.prizetech.R;

public class ProcessDialog {

    public static ProgressDialog show(Context context){

        View view = LayoutInflater.from(context).inflate(R.layout.layout_process_dialog, null);
        ProgressDialog dialog = ProgressDialog.show(context, null, null);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(/*context.getResources().getColor(R.color.dialog_background)*/ Color.TRANSPARENT));
        return dialog;
    }

    public static ProgressDialog show(Context context, String title){

        View view = LayoutInflater.from(context).inflate(R.layout.layout_process_dialog, null);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_progress_title);
        tvTitle.setText(title);

        ProgressDialog dialog = ProgressDialog.show(context, null, null);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(/*context.getResources().getColor(R.color.dialog_background)*/ Color.TRANSPARENT));
        return dialog;
    }
}
