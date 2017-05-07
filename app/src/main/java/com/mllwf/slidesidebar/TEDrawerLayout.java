package com.mllwf.slidesidebar;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.xutil.LogUtil.L;

/**
 * Created by ML on 2017/5/5.
 * <p>
 * 实现主界面可以相应触摸事件
 */

public class TEDrawerLayout extends DrawerLayout {

    public TEDrawerLayout(Context context) {
        super(context);
    }

    public TEDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.e("TEDrawerLayout  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev));
        boolean isDispatch = super.dispatchTouchEvent(ev);
        L.e("TEDrawerLayout  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev) + "   " + isDispatch);
        return isDispatch;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.e("TEDrawerLayout  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event));
        boolean isTouch = super.onTouchEvent(event);
        L.e("TEDrawerLayout  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event) + "   " + isTouch);
        return isTouch;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        L.e("TEDrawerLayout  onInterceptTouchEvent   " + MotionEventType.getEnventTypeMsg(ev));
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = ev.getX();
                float y = ev.getY();
                View touchesView = findTopChildUnder((int) x, (int) y);
                if (touchesView != null && isContentView(touchesView) && this.isDrawerOpen(GravityCompat.START)) {
                    L.e("TEDrawerLayout  onInterceptTouchEvent   " + MotionEventType.getEnventTypeMsg(ev) + "     手动判定不拦截");
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                return false;
            default:
                break;
        }
        boolean isIntercept = super.onInterceptTouchEvent(ev);
        L.e("TEDrawerLayout  onInterceptTouchEvent   " + MotionEventType.getEnventTypeMsg(ev) + "   " + isIntercept);
        return isIntercept;
    }

    /**
     * @param x 触摸点X坐标
     * @param y 触摸点Y坐标
     * @return 返回触摸点所在的子View区域
     */
    public ViewGroup findTopChildUnder(int x, int y) {
        final int childCount = this.getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            ViewGroup child = (ViewGroup) this.getChildAt(i);
            if (x >= child.getLeft() && x < child.getRight() && y >= child.getTop() && y < child.getBottom()) {
                return child;
            }
        }
        return null;
    }


    /**
     * @param childView 子View
     * @return 该子View是否是主界面
     */
    public boolean isContentView(View childView) {
        return ((LayoutParams) childView.getLayoutParams()).gravity == Gravity.NO_GRAVITY;
    }
}
