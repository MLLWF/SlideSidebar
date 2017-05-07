package com.mllwf.slidesidebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.xutil.LogUtil.L;

/**
 * Created by ML on 2017/5/6.
 */

public class CustormButton extends Button {


    public CustormButton(Context context) {
        super(context);
    }

    public CustormButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 事件分发
     *
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        L.e("View  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev));
        boolean isDispatch = super.dispatchTouchEvent(ev);
        L.e("View  dispatchTouchEvent   " + MotionEventType.getEnventTypeMsg(ev) + "   " + isDispatch);
        return isDispatch;
    }

    /**
     * 事件消费
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        L.e("View  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event));
        boolean isTouch = super.onTouchEvent(event);
        L.e("View  onTouchEvent   " + MotionEventType.getEnventTypeMsg(event) + "   " + isTouch);
        return isTouch;
    }
}
