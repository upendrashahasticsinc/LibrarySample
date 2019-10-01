package com.astics.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class UsScrollView extends ScrollView {
    private int maxHeight;

    public UsScrollView(Context context) {
        this(context, null);
    }

    public UsScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UsScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.UsMaxHeight);
        try {
            maxHeight = styledAttrs.getDimensionPixelSize(R.styleable.UsMaxHeight_custom_maxHeight, 0);
        } finally {
            styledAttrs.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (maxHeight > 0) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}