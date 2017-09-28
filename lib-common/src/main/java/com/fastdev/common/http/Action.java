package com.fastdev.common.http;

import android.content.Context;

import com.bean.DataObject;
import com.bean.LoginReq;
import com.bean.LoginRes;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;


import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by lipy on 2017/9/26.
 */

public class Action<T extends DataObject> extends ActionService {
    /**
     * 登录
     *
     * @param loginName
     * @param password
     * @param rememberMe
     * @return
     */
    public Observable<LoginRes> login(String loginName, String password, boolean rememberMe, Type type, Context context) {
        return postRequest(context, Urls.LOGIN, type)
                .upJson(encrypt(new LoginReq(loginName, password, rememberMe)))
                .adapt(new ObservableResponse<ServerModel>())
                .map(new Function<Response<ServerModel>, LoginRes>() {
                    @Override
                    public LoginRes apply(@NonNull Response<ServerModel> serverModelResponse) throws Exception {
                        ServerModel body = serverModelResponse.body();
                        return (LoginRes) body.getData();
                    }
                });
    }

    private static <REQ> String encrypt(REQ req) {
        String str = "";
        try {
            Gson gson = new Gson();
            str = gson.toJson(req);
            LogUtils.d("Param =  " + str);
            // str = URLEncoder.encode(str.substring(0, str.length()), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;

    }

    public static void cancle() {
        OkGo.getInstance().cancelAll();
    }

    public static void cancle(Object tag) {
        OkGo.getInstance().cancelTag(tag);
    }

}
