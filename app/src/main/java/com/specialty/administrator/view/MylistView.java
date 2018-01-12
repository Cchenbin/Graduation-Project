package com.specialty.administrator.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 陈彬 on 2018/1/12.
 */

public class MylistView extends ListView {
    public MylistView(Context context) {
        super(context);
    }

    public MylistView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MylistView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,//右移运算符，相当于除于4
                MeasureSpec.AT_MOST);//测量模式取最大值
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);//重新测量高度
    }
}
