package cn.demonk.viewevent;

import android.util.Log;
import android.view.View;

/**
 * Created by ligs on 10/9/16.
 */
public class DLog {

    private static final String TAG = "demonk";

    public static final void d(View v, String msg) {
        Log.d(TAG, getMsg(v, msg));
    }

    public static final void e(View v, String msg) {
        Log.e(TAG, getMsg(v, msg));
    }

    public static final void i(View v,String msg){
        Log.w(TAG,getMsg(v,msg));
    }

    private static final String getMsg(View v, String msg) {
        return "view tag=" + v.getTag() + ",msg=" + msg;
    }
}
