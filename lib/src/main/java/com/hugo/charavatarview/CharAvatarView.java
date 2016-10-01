package com.hugo.charavatarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by HugoXie on 16/9/14.
 *
 * Email: Hugo3641@gmail.com
 * GitHub: https://github.com/xcc3641
 * Info: 根据用户名随机生成头像
 */
public class CharAvatarView extends ImageView {
    private static final String TAG = CharAvatarView.class.getSimpleName();
    // 颜色画板集
    private static final int[] colors = {
        0xff1abc9c, 0xff16a085, 0xfff1c40f, 0xfff39c12, 0xff2ecc71,
        0xff27ae60, 0xffe67e22, 0xffd35400, 0xff3498db, 0xff2980b9,
        0xffe74c3c, 0xffc0392b, 0xff9b59b6, 0xff8e44ad, 0xffbdc3c7,
        0xff34495e, 0xff2c3e50, 0xff95a5a6, 0xff7f8c8d, 0xffec87bf,
        0xffd870ad, 0xfff69785, 0xff9ba37e, 0xffb49255, 0xffb49255, 0xffa94136
    };


    private Paint mPaintBackground;
    private Paint mPaintText;
    private Rect mRect;

    private String text;

    private int charHash;

    public CharAvatarView(Context context) {
        this(context, null);
    }

    public CharAvatarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CharAvatarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaintBackground = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // 宽高相同
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null != text) {
            int color = colors[charHash % colors.length];
            // 画圆
            mPaintBackground.setColor(color);
            canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2, mPaintBackground);
            // 写字
            mPaintText.setColor(Color.WHITE);
            mPaintText.setTextSize(getWidth() / 2);
            mPaintText.setStrokeWidth(3);
            mPaintText.getTextBounds(text, 0, 1, mRect);
            // 垂直居中
            Paint.FontMetricsInt fontMetrics = mPaintText.getFontMetricsInt();
            int baseline = (getMeasuredHeight() - fontMetrics.bottom - fontMetrics.top) / 2;
            // 左右居中
            mPaintText.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(text, getWidth() / 2, baseline, mPaintText);
        }
    }

    /**
     * @param content 传入字符内容
     * 只会取内容的第一个字符,如果是字母转换成大写
     */
    public void setText(String content) {
        if (content == null) {
            content=" ";
        }
        this.text = String.valueOf(content.toCharArray()[0]);
        this.text = text.toUpperCase();
        charHash = this.text.hashCode();
        // 重绘
        invalidate();
    }

}
