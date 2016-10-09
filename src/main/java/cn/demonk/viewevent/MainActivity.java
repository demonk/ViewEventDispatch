package cn.demonk.viewevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt1).setOnTouchListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt2).setOnTouchListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt3).setOnTouchListener(this);

        findViewById(R.id.viewgroup).setOnTouchListener(this);
        findViewById(R.id.viewgroup).setOnClickListener(this);

        findViewById(R.id.bt3).setOnTouchListener(this);
        findViewById(R.id.bt4).setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        DLog.d(view, "click");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        DLog.d(view, "touch,event=" + motionEvent.getAction());
        return false;
    }
}
