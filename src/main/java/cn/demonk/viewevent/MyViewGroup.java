package cn.demonk.viewevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by ligs on 10/9/16.
 */
public class MyViewGroup extends FrameLayout {

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //键盘
    public boolean dispatchKeyEvent(KeyEvent event) {
        DLog.i(this, "==============================================");
        DLog.i(this, "dispatcherKeyEvent,event=" + event.getAction());
        return super.dispatchKeyEvent(event);
    }

    //屏幕
    public boolean dispatchTouchEvent(MotionEvent event) {
        DLog.i(this, "==============================================");
        DLog.i(this, "dispatchTouchEvent,event=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        DLog.i(this, "onTouchEvent,event=" + event.getAction());
        return super.onTouchEvent(event);
    }

    //viewgroup特有
    public boolean onInterceptTouchEvent(MotionEvent event) {
        DLog.i(this, "onInterceptTouchEvent,event=" + event.getAction());
        return super.onInterceptTouchEvent(event);
    }
}
