package com.jiajiaqian.kitchen.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.jiajiaqian.kitchen.R;

/**
 * @author qianjiajia
 * @version 1.0
 * @Description 自定义Scrollview的滚动条样式和长度
 * @Date 2017-03-28 23:26
 * @email qianjiajia_2013@126.com
 */
public class CustomScrollBar extends View {

    Paint mPaint;
    private float cursorMoveY;

    public float userNoticeCursorWidth,userNoticeCursorHeight;
    private int mRoundRadius;
    private int mColor;
    private RectF mRectF;

    public CustomScrollBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomScrollBar(Context context) {
        super(context,null);
    }

    public CustomScrollBar(Context context, AttributeSet attrs) {
        super(context, attrs,0);
        initRes(context,attrs);
    }
    private void initRes(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomScrollBar);
        userNoticeCursorHeight = typedArray.getInteger(R.styleable.CustomScrollBar_length_csb,30);//默认长度位为30
        mRoundRadius = typedArray.getInteger(R.styleable.CustomScrollBar_round_radius_csb,10);//默认圆角角度为10
        mColor = typedArray.getColor(R.styleable.CustomScrollBar_color_csb,0xff000000);//默认黑色

        mPaint = new Paint();
        mPaint.setColor(mColor);//滚动条的颜色
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        userNoticeCursorWidth = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRectF = new RectF(0, cursorMoveY,
                userNoticeCursorWidth,  cursorMoveY+userNoticeCursorHeight );
        //我这里直接将滚动条画成圆角矩形---可换成你想要的样式
        canvas.drawRoundRect(mRectF,mRoundRadius , mRoundRadius, mPaint);
    }

    public void SetOffSet(float cursorMoveY) {
        this.cursorMoveY = cursorMoveY;
        invalidate();
    }

}
