package com.mvgx.common.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.mvgx.common.R;


public class ProgressLoadDialog {
    private Dialog dialog;
    private Display display;
    private Activity activity;

    public ProgressLoadDialog(Activity context) {
        this.activity = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
       display =  windowManager.getDefaultDisplay();

       dialog = new Dialog(context, R.style.AlertDialogStyle);
    }

    public ProgressLoadDialog builder() {
        return this;
    }

    public ProgressLoadDialog addView(View view) {
        dialog.setContentView(view);
        view.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
        return this;
    }

    /**
     * 设置布局的比例
     * @param view
     * @param scale 0到1   0.3
     * @return
     */
    public ProgressLoadDialog addView(View view, float scale) {
        dialog.setContentView(view);
        view.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * scale), LinearLayout.LayoutParams.WRAP_CONTENT));
        return this;
    }

    public void show() {
        if (null != dialog && !activity.isFinishing()){
            dialog.show();
        }
    }


    public ProgressLoadDialog setCancelable(boolean flag) {
        dialog.setCancelable(flag);
        return this;
    }

    public void dismiss() {
        if (null != dialog && !activity.isFinishing()){
            dialog.dismiss();
        }
    }
    public boolean isShow(){
        if (null != dialog && !activity.isFinishing()){
            return dialog.isShowing();
        }
        return false;
    }
}
