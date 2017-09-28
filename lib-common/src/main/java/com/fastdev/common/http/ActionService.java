package com.fastdev.common.http;


import android.content.Context;

import com.blankj.utilcode.util.StringUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.store.CookieStore;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.request.DeleteRequest;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;
import com.lzy.okgo.request.PutRequest;
import com.fastdev.common.base.Constants;
import com.fastdev.common.utils.ACache;

import java.lang.reflect.Type;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * Created by lipy on 2017/9/26.
 */

public class ActionService {
    /**
     * post请求添加请求头
     *
     * @return
     */
    protected static PostRequest<ServerModel> postRequest(Context context, String url, Type type) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.HEAD_KEY_USER_AGENT, "YGXT-ANDROID-APP");
        if (!StringUtils.isEmpty(ACache.get(context).getAsString(Constants.ACACHE_AUTHORIZATION))) {
            httpHeaders.put(Constants.ACACHE_AUTHORIZATION, ACache.get(context).getAsString(Constants.ACACHE_AUTHORIZATION));
        }
        return OkGo.<ServerModel>post(url)
                .headers(httpHeaders)
                .converter(new JsonConvert<ServerModel>(type));
    }

    /**
     * put请求添加请求头
     *
     * @return
     */
    protected static PutRequest putRequest(String url) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.HEAD_KEY_USER_AGENT, "android");
        HttpUrl httpUrl = HttpUrl.parse(url);
        Cookie.Builder builder = new Cookie.Builder();
        Cookie cookie = builder.name("id").value("id").domain(httpUrl.host()).build();
        CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
        if (cookieStore != null && cookieStore.getAllCookie() != null) {
            cookieStore.saveCookie(httpUrl, cookie);
        }
        return OkGo.put(url).
                headers(httpHeaders);
    }

    /**
     * get请求
     *
     * @return
     */
    protected static GetRequest getRequest(String url) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.HEAD_KEY_USER_AGENT, "android");
        HttpUrl httpUrl = HttpUrl.parse(url);
        Cookie.Builder builder = new Cookie.Builder();
        Cookie cookie = builder.name("id").value("id").domain(httpUrl.host()).build();
        CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();

        if (cookieStore != null && cookieStore.getAllCookie() != null) {
            cookieStore.saveCookie(httpUrl, cookie);
        }
        return OkGo.get(url).
                headers(httpHeaders);
    }

    /**
     * delete请求
     *
     * @return
     */
    protected static DeleteRequest deleteRequest(String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put(HttpHeaders.HEAD_KEY_USER_AGENT, "android");
        HttpUrl httpUrl = HttpUrl.parse(url);
        Cookie.Builder builder = new Cookie.Builder();
        Cookie cookie = builder.name("id").value("id").domain(httpUrl.host()).build();
        CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
        if (cookieStore != null && cookieStore.getAllCookie() != null) {
            cookieStore.saveCookie(httpUrl, cookie);
        }
        return OkGo.delete(url).
                headers(httpHeaders);
    }
}

