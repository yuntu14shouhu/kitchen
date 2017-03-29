package com.jiajiaqian.kitchen.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 自定义scrollview
 * @Date 2017-03-28 23:28
 * @email qianjiajia_2013@126.com
 */
public class CustomScrollView extends ScrollView {

    /**
     * 使用说明：
     * XML中：
     *      MyCustomScrollView和MyCustomScrollBar高度要一致，MyCustomScrollBar要在MyCustomScrollView右边
     *      可以在外层用水平线性布局包裹，或相对布局设置
     * 代码中：
     *      要在view层 将滚动条控件设置到此控件来，
     *      使用方式为调用setScrollBar()方法：eg. mCustomScroll.setScrollBar(mScrollBar);
     */
    private static CustomScrollBar mScrollBar;
    private float noticeScrollViewTotleHeight;
    private float noticeScrollViewVisibleHeight;
    private CustomScrollListener mCustomScrollListener;
    private ScrollYListener mScrollYListener;
    private int lastY = 0;
    private static int WHAT_SCROLL = 110;
    private static int TIME_SCROLL = 10;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 10:
                    int scrollY = getScrollY();//获取当前滚动的Y轴距离
                    if (lastY != scrollY){
                        lastY = scrollY;
                        mScrollYListener.onScrollListener(scrollY);
                        //每隔TIME_SCROLL时间就发送消息----就是监听还有没有滚动
                        mHandler.sendEmptyMessageDelayed(WHAT_SCROLL,TIME_SCROLL);
                    }
            }
        }
    };

    public CustomScrollView(Context context) {
        super(context,null);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        noticeScrollViewTotleHeight = this.getChildAt(0).getMeasuredHeight();
        noticeScrollViewVisibleHeight = getMeasuredHeight();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (mScrollYListener!=null){
            mScrollYListener.onScrollListener(t);
        }
        if (mCustomScrollListener!=null){
            mCustomScrollListener.onCustomScrollListener(l, t, oldl, oldt);
        }

        float currentScrollY = this.getScrollY();
        float proportionTotalHeight = currentScrollY
                / (noticeScrollViewTotleHeight - noticeScrollViewVisibleHeight);
        float cursorMoveY = proportionTotalHeight
                * ( noticeScrollViewVisibleHeight-mScrollBar.userNoticeCursorHeight);

        mScrollBar.SetOffSet(cursorMoveY);

    }
    public void setScrollBar(CustomScrollBar scrollBar) {
        mScrollBar = scrollBar;
    }

    /**
     * 监听惯性滑动
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
            //当ACTION_UP这个动作发生时就发送一个标志为WHAT_SCROLL的消息，由上面的mHander处理
            case MotionEvent.ACTION_UP:
                if (mCustomScrollListener!=null){
                    mHandler.sendEmptyMessage(WHAT_SCROLL);
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 自定义滑动监听的接口
     */
    public interface CustomScrollListener{
        //这个就是提供的滑动监听了
        void onCustomScrollListener(int l, int t, int oldl, int oldt);
    }
    public void setCustomScrollListener(CustomScrollListener mCustomScrollListener){
        this.mCustomScrollListener = mCustomScrollListener;
    }

    /**
     * 自定义惯性滑动监听的接口
     */
    public interface ScrollYListener{
        //这个就是提供的滑动监听了
        void onScrollListener(int scrollY);
    }
    public void setScrollYListener(ScrollYListener mScrollYListener){
        this.mScrollYListener = mScrollYListener;
    }

}
