package com.fastdev.common.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fastdev.common.R;


/**
 * Created by lipy on 17/7/31.
 */

public class CommonTitleBar extends RelativeLayout
        implements View.OnClickListener {
    private OnTitleBarClickLeftListener leftListener;
    public Context mContext;
    private ImageView mRlLeftBackBtn;
    private RelativeLayout mRlRootLayout;
    private TextView mTvRightBtn;
    private TextView mTvTitle;
    private OnTitleBarClickRightListener rightListener;

    public CommonTitleBar(Context paramContext) {
        super(paramContext);
        init(paramContext);
    }

    public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext);
    }

    private void init(Context paramContext) {
        this.mContext = paramContext;
        LayoutInflater.from(this.mContext).inflate(loadViewLayout(), this, true);
        initView();
        initListener();
    }

    private void initListener() {
        this.mRlLeftBackBtn.setOnClickListener(this);
        this.mTvRightBtn.setOnClickListener(this);
    }

    private void initView() {
        this.mRlRootLayout = ((RelativeLayout) findViewById(R.id.title_bar_root_layout));
        this.mRlLeftBackBtn = ((ImageView) findViewById(R.id.btn_titile_bar_back));
        this.mTvTitle = ((TextView) findViewById(R.id.tv_title_bar_title));
        this.mTvRightBtn = ((TextView) findViewById(R.id.tv_titile_bar_right));
    }

    private int loadViewLayout() {
        return R.layout.view_common_title_bar;
    }

    public ImageView getLeftBackBtn() {
        return this.mRlLeftBackBtn;
    }

    public TextView getRightBtn() {
        return this.mTvRightBtn;
    }

    public void onClick(View paramView) {
        if (paramView.getId() == R.id.btn_titile_bar_back) {
            if (this.leftListener != null) {
                leftListener.onClickLeftBackBtn();
            }
        } else if (paramView.getId() == R.id.tv_titile_bar_right) {
            if (this.rightListener != null) {
                rightListener.onClickRightBtn();
            }
        } else {
            ((Activity) getContext()).finish();

        }


    }

    public void setLeftBackBtnGone() {
        this.mRlLeftBackBtn.setVisibility(GONE);
    }

    public void setLeftBackBtnVisible() {
        this.mRlLeftBackBtn.setVisibility(VISIBLE);
    }

    public void setOnClickLeftListener(OnTitleBarClickLeftListener paramOnTitleBarClickLeftListener) {
        this.leftListener = paramOnTitleBarClickLeftListener;
    }

    public void setOnClickRightListener(OnTitleBarClickRightListener paramOnTitleBarClickRightListener) {
        this.rightListener = paramOnTitleBarClickRightListener;
    }

    public void setRootLayoutBgColor(int paramInt) {
        this.mRlRootLayout.setBackgroundResource(paramInt);
    }

    public void setTitle(int paramInt) {
        this.mTvTitle.setText(paramInt);
    }

    public void setTitle(String paramString) {
        this.mTvTitle.setText(paramString);
    }

    public interface OnTitleBarClickLeftListener {
        void onClickLeftBackBtn();
    }

    public interface OnTitleBarClickRightListener {
        void onClickRightBtn();
    }
}
