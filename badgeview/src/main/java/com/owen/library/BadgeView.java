package com.owen.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewTreeObserver;
import android.widget.TextView;


public class BadgeView extends TextView {

    private static final int DEFAULT_LR_PADDING_DP = 5;
    private static final int DEFAULT_BADGE_COLOR = Color.RED;
    private static final int DEFAULT_TEXT_COLOR = Color.WHITE;

    public BadgeView(Context context) {
        this(context, null, android.R.attr.textViewStyle);
    }

    public BadgeView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public BadgeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setDefaultTextColor();
        setDefaultPadding();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                setDefaultBackground();

                if (Build.VERSION.SDK_INT < 16) {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    private void setDefaultTextColor() {
        setTextColor(DEFAULT_TEXT_COLOR);
    }

    private void setDefaultBackground() {
        ShapeDrawable badgeBg = getDefaultBackground();
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(badgeBg);
        } else {
            setBackground(badgeBg);
        }
    }

    private void setDefaultPadding() {
        int paddingPixels = dpToPix(DEFAULT_LR_PADDING_DP);
        setPadding(paddingPixels, 0, paddingPixels, 0);
    }

    private ShapeDrawable getDefaultBackground() {
        int r = getHeight() / 2;
        float[] outerR = new float[]{r, r, r, r, r, r, r, r};

        RoundRectShape rr = new RoundRectShape(outerR, null, null);
        ShapeDrawable drawable = new ShapeDrawable(rr);
        drawable.getPaint().setColor(DEFAULT_BADGE_COLOR);

        return drawable;

    }

    private int dpToPix(int dp) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
        return (int) px;
    }
}
