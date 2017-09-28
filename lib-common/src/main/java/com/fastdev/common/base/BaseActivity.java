package com.fastdev.common.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;


import com.gyf.barlibrary.ImmersionBar;
import com.fastdev.common.R;
import com.fastdev.common.utils.ToastUtil;

public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = "RUIX";

    protected boolean canShowDailog = false;
    private CommonTitleBar titleBar;

    private static int getStatusBarHeight(Context paramContext) {
        int i = 0;
        Resources resources = paramContext.getResources();
        int j = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (j > 0) {
            i = resources.getDimensionPixelSize(j);
        }
        return i;
    }

    private void init() {
        initContentView();
        initTitleBar();
        initView();
        initListener();
        initPresenter();
        initLocalData();
        ToastUtil.initialize(this);
    }

    private void initContentView() {
        if (isUseBaseTitleBar()) {
            setContentView(R.layout.activity_base);
            RelativeLayout localRelativeLayout = (RelativeLayout) findViewById(R.id.rl_gee_content_container);
            if (loadViewLayout() != 0) {
                LayoutInflater.from(this).inflate(loadViewLayout(), localRelativeLayout);
            }
            return;
        }
        setContentView(loadViewLayout());

    }


    protected void showLoading() {
//        if (loadingView() != null) {
////            loadingView().setVisibility(View.VISIBLE);
//            LogUtils.d("showLoading");
//            loadingView().show();
//        }
    }

    protected void hideLoading() {
//        if (loadingView() != null) {
//            LogUtils.d("hideLoading");
//            loadingView().hide();
////            loadingView().setVisibility(View.GONE);
//        }
    }

    private void redirectLogin() {
        try {
            startActivity(new Intent(this, Class.forName("com.ruix.account.LoginActivity")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finish();
    }


    protected void beforeOnCreate() {
    }

    public CommonTitleBar getTitleBar() {
        return this.titleBar;
    }

    protected abstract int loadViewLayout();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initLocalData();

    protected void initPresenter() {
    }

    protected void initTitleBar() {

        if (isUseBaseTitleBar()) {
            this.titleBar = ((CommonTitleBar) findViewById(R.id.nav));
        }

        if (isUseBaseStatusBar()) {
            ImmersionBar.with(this).keyboardEnable(true).statusBarDarkFont(true, 0.2f).init();
        }
    }


    protected boolean isFitsSystemWindows() {
        return true;
    }


    protected boolean isUseBaseTitleBar() {
        return true;
    }

    protected boolean isUseBaseStatusBar() {
        return true;
    }


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.canShowDailog = true;
    }

    protected void onCreate(Bundle paramBundle) {
        beforeOnCreate();
        super.onCreate(paramBundle);
        init();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (isUseBaseStatusBar()) {
            ImmersionBar.with(this).destroy(); //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        }
    }

    protected void onPause() {
        super.onPause();
        this.canShowDailog = false;
        //// TODO: 17/7/31
        //        MobclickAgent.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        this.canShowDailog = true;
        //// TODO: 17/7/31
        //        MobclickAgent.onResume(this);
    }

    protected void onSaveInstanceState(Bundle paramBundle) {
        super.onSaveInstanceState(paramBundle);
        this.canShowDailog = false;
    }

    //    public void resolveException(Throwable paramThrowable) {
    //        if ((paramThrowable instanceof SocketTimeoutException)) {
    //            showErrorTip("���������������������������������������");
    //        }
    //        do {
    //            return;
    //            if ((paramThrowable instanceof UnknownHostException)) {
    //                showErrorTip("���������������������������������������");
    //                return;
    //            }
    //            if ((paramThrowable instanceof NetworkUnusableException)) {
    //                showErrorTip("���������������������������������������");
    //                return;
    //            }
    //            if ((paramThrowable instanceof IOException)) {
    //                showErrorTip("���������������������������������������");
    //                paramThrowable.printStackTrace();
    //                return;
    //            }
    //            if ((paramThrowable instanceof TokenExpiredException)) {
    //                paramThrowable = new Intent();
    //                paramThrowable.setAction(RuiXConstant.NOTICE_LOGOUT);
    //                RuiApplication.getAppContext().sendOrderedBroadcast(paramThrowable, null);
    //                return;
    //            }
    //            if ((paramThrowable instanceof PermissionException)) {
    //                paramThrowable = new Intent();
    //                paramThrowable.setAction(RuiXConstant.NOTICE_PERMISSION_EXCEPTION);
    //                RuiApplication.getAppContext().sendOrderedBroadcast(paramThrowable, null);
    //                return;
    //            }
    //        } while (!(paramThrowable instanceof RequestApiException));
    //        showErrorTip(paramThrowable.getMessage());
    //    }

    public void setTitle(int paramInt) {
        if ((this.titleBar != null) && (paramInt != 0)) {
            this.titleBar.setTitle(paramInt);
        }
    }

    public void setTitle(String paramString) {
        if ((this.titleBar != null) && (paramString != null)) {
            this.titleBar.setTitle(paramString);
        }
    }

    public void showErrorTip(int paramInt) {
        if (this.canShowDailog) {
            ToastUtil.showNewErrorMsg(paramInt);
        }
    }

    public void showErrorTip(String paramString) {
        if (this.canShowDailog) {
            ToastUtil.showNewMsg(paramString);
        }
    }

    public void showSuccessTip(int paramInt) {
        if (this.canShowDailog) {
            ToastUtil.showNewSuccessMsg(paramInt);
        }
    }

    public void showSuccessTip(String paramString) {
        if (this.canShowDailog) {
            ToastUtil.showNewMsg(paramString);
        }
    }

//    protected int statusBarTintColor() {
//        return R.color.white;
//    }

//    protected LoadingView loadingView() {
//        return null;
//    }
}
