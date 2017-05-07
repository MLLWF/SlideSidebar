package com.mllwf.slidesidebar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.xutil.BaseInit;
import com.example.xutil.LogUtil.L;
import com.example.xutil.ViewUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TEDrawerLayout drawerLayout;

    private RelativeLayout drawerRel;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseInit.getInstance().init(getApplication(), true);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initDrawerView();
        drawerLayout = (TEDrawerLayout) findViewById(R.id.drawer_layout);
        /**
         *  设置打开侧边栏之后，主界面不会变暗
         */
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
        drawerLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

            }
        });
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.i("Activity  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev));
        boolean isDispatch = super.dispatchTouchEvent(ev);
        L.i("Activity  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev) + "   " + isDispatch);
        return isDispatch;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.i("Activity  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event));
        boolean isTouch = super.onTouchEvent(event);
        L.i("Activity  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event) + "   " + isTouch);
        return isTouch;
    }

    private void initDrawerView() {
        drawerRel = (RelativeLayout) findViewById(R.id.nav_view);
        drawerRel.getBackground().setAlpha(30);
        oneBtn = (Button) findViewById(R.id.btn_one);
        twoBtn = (Button) findViewById(R.id.btn_two);
        threeBtn = (Button) findViewById(R.id.btn_three);
        ViewUtils.bindClickListenerOnViews(this, oneBtn, twoBtn, threeBtn, drawerRel);
    }


    public void toCanSlieDrawer(View view) {
    }

    @Override
    public void onClick(View v) {
        if (v == oneBtn) {
            L.toastShort("oneBtn");
        } else if (v == twoBtn) {
            L.toastShort("twoBtn");
        } else if (v == threeBtn) {
            L.toastShort("threeBtn");
        }

    }
}
