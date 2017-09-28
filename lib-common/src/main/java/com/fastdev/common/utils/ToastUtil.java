package com.fastdev.common.utils;


import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fastdev.common.R;

/**
 * Created by lipy on 17/7/31.
 */


public class ToastUtil {
    private static int COLOR_ERROR = 0;
    private static int COLOR_SUCCESS = 0;
    private static final int DEFAULT_TIME_DELAY = 50;
    private static final int TYPE_CODE_ERROR = 2;
    private static final int TYPE_CODE_SUCCESS = 1;
    private static Context context;
    private static Handler handler;
    private static TextView msgView;
    private static View myToastView;
    private static Toast toast;

    private static void cancelToast() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    public static void initialize(Context paramContext) {
        context = paramContext;
        myToastView = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        msgView = (TextView) myToastView.findViewById(R.id.tv_msg_text);
        COLOR_SUCCESS = context.getResources().getColor(R.color.msg_status_success);
        COLOR_ERROR = context.getResources().getColor(R.color.msg_status_error);
    }

    public static void showErrorMsg(int paramInt) {
        try {
            showErrorMsg(context.getString(paramInt));
        } catch (Resources.NotFoundException localNotFoundException) {
            localNotFoundException.printStackTrace();
        }
    }

    public static void showErrorMsg(String paramString) {
        showMsg(2, paramString);
    }

    private static void showMsg(int paramInt, final String paramString) {
        if ((context == null) || (ApplicationUtil.isRunningBackground(context)) || (TextUtils.isEmpty(paramString))) {
            return;
        }
        if (toast == null) {
            toast = new Toast(context);
        }
        if (handler == null) {
            handler = new Handler();
        }
        handler.postDelayed(new Runnable() {
            public void run() {
                ToastUtil.msgView.setText(paramString);
                ToastUtil.toast.setView(ToastUtil.myToastView);
                ToastUtil.toast.setGravity(55, 0, 300);
                ToastUtil.toast.setDuration(Toast.LENGTH_SHORT);
                ToastUtil.toast.show();
            }
        }, 50L);
    }

    public static void showNewErrorMsg(int paramInt) {
        try {
            showNewMsg(context.getString(paramInt));
        } catch (Resources.NotFoundException localNotFoundException) {
            localNotFoundException.printStackTrace();
        }
    }

    public static void showNewErrorMsg(String paramString) {
        showNewMsg(paramString);
    }

    public static void showNewMsg(String paramString) {
        if (!TextUtils.isEmpty(paramString)) {
            Toast.makeText(context, paramString, Toast.LENGTH_SHORT).show();
        }
    }

    public static void showNewSuccessMsg(int paramInt) {
        try {
            showNewMsg(context.getString(paramInt));
        } catch (Resources.NotFoundException localNotFoundException) {
            localNotFoundException.printStackTrace();
        }
    }

    public static void showNewSuccessMsg(String paramString) {
        showNewMsg(paramString);
    }

    public static void showSuccessMsg(int paramInt) {
        try {
            showSuccessMsg(context.getString(paramInt));
        } catch (Resources.NotFoundException localNotFoundException) {
            localNotFoundException.printStackTrace();
        }
    }

    public static void showSuccessMsg(String paramString) {
        showMsg(1, paramString);
    }
}
