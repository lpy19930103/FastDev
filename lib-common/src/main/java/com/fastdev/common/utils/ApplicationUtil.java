package com.fastdev.common.utils;


import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lipy on 17/7/31.
 */
public class ApplicationUtil {
    public static final String APP_PACKAGE_NAME = "com.hiwifi";


    private static String getPackageName(Context paramContext) {
        return paramContext.getPackageName();
    }


    public static boolean isRunning(Context paramContext) {
        List<ActivityManager.RunningAppProcessInfo> activity = ((ActivityManager) paramContext.getSystemService(Context.ACTIVITY_SERVICE)).getRunningAppProcesses();
        int i = 0;
        while (i < activity.size()) {
            if ("com.hiwifi".equals(activity.get(i).processName)) {
                return true;
            }
            i += 1;
        }
        return false;
    }

    public static boolean isRunningBackground(Context paramContext) {
        boolean bool2 = false;
        Iterator localIterator = ((ActivityManager) paramContext.getSystemService(Context.ACTIVITY_SERVICE)).getRunningAppProcesses().iterator();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = null;
        do {
            //            bool1 = bool2;
            if (!localIterator.hasNext()) {
                break;
            }
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) localIterator.next();
        } while (!localRunningAppProcessInfo.processName.equals(paramContext.getPackageName()));
        boolean bool1 = bool2;
        if (localRunningAppProcessInfo.importance == 400) {
            bool1 = true;
        }
        return bool1;
    }

    public static String getVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
