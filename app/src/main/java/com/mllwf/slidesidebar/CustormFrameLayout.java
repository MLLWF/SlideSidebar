package com.mllwf.slidesidebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.example.xutil.LogUtil.L;

/**
 * Created by ML on 2017/5/6.
 */

public class CustormFrameLayout extends FrameLayout {
    public CustormFrameLayout(Context context) {
        super(context);
    }

    public CustormFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.w("ViewGroup  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev));
        boolean isDispatch = super.dispatchTouchEvent(ev);
        L.w("ViewGroup  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev) + "   " + isDispatch);
        return isDispatch;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        L.w("ViewGroup  onInterceptTouchEvent   " + MotionEventType.getEnventTypeMsg(ev));
        boolean isIntercept = super.onInterceptTouchEvent(ev);
        L.w("ViewGroup  onInterceptTouchEvent   " + MotionEventType.getEnventTypeMsg(ev) + "   " + isIntercept);
        return isIntercept;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.w("ViewGroup  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event));
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                L.w("ViewGroup  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event) + "   手动事件消费");
                return true;
            default:
                break;
        }
        boolean isTouch = super.onTouchEvent(event);
        L.w("ViewGroup  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event) + "   " + isTouch);
        return isTouch;
    }
}
