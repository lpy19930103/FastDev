package com.fastdev.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fastdev.common.utils.ToastUtil;

public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(loadViewLayout(), null);
        ToastUtil.initialize(getActivity());
        initView(view);
        initListener();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initLocalData();
    }

    protected abstract int loadViewLayout();

    protected abstract void initView(View view);

    protected abstract void initListener();

    protected abstract void initLocalData();

    protected abstract void visibleHint(boolean isVisible);


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        visibleHint(!hidden);
    }

    public void showErrorTip(int paramInt) {
        ToastUtil.showNewErrorMsg(paramInt);
    }

    public void showErrorTip(String paramString) {
        ToastUtil.showNewMsg(paramString);
    }

    public void showSuccessTip(int paramInt) {
        ToastUtil.showNewSuccessMsg(paramInt);
    }

    public void showSuccessTip(String paramString) {
        ToastUtil.showNewMsg(paramString);
    }


}
