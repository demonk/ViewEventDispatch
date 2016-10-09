package cn.demonk.viewevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by ligs on 10/9/16.
 */
public class MyButton extends Button {

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        DLog.d(this, "dispatchKeyEvent,event=" + event.getAction());
        return super.dispatchKeyEvent(event);
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        DLog.d(this, "dispatchTouchEvent,event=" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        DLog.d(this, "onTouchEvent,event=" + event.getAction());
        return super.onTouchEvent(event);
    }
}
