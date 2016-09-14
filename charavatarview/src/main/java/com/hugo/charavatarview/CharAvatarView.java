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
 * Info: 给没有图片的头像根据用户名随机生成头像
 */
public class CharAvatarView extends ImageView {
    private static final String TAG = CharAvatarView.class.getSimpleName();
    // 颜色画板集
    private static final String[] colors = {
        "#1abc9c", "#16a085", "#f1c40f", "#f39c12", "#2ecc71",
        "#27ae60", "#e67e22", "#d35400", "#3498db", "#2980b9",
        "#e74c3c", "#c0392b", "#9b59b6", "#8e44ad", "#bdc3c7",
        "#34495e", "#2c3e50", "#95a5a6", "#7f8c8d", "#ec87bf",
        "#d870ad", "#f69785", "#9ba37e", "#b49255", "#b49255", "#a94136"
    };

    private Paint mPaint;

    private Rect mRect;

    private String text;

    private int charHash;

    public CharAvatarView(Context context) {
        super(context);
    }

    public CharAvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
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
            int color = Color.parseColor(colors[charHash % colors.length]);
            // 画圆
            mPaint.setColor(color);
            canvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2, mPaint);
            // 写字
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(getWidth() / 2);
            mPaint.setStrokeWidth(3);
            mPaint.getTextBounds(text, 0, 1, mRect);
            // 垂直居中
            Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
            int baseline = (getMeasuredHeight() - fontMetrics.bottom - fontMetrics.top) / 2;
            // 左右居中
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(text, getWidth() / 2, baseline, mPaint);
        }
    }

    /**
     * @param content 传入字符内容
     * 只会取内容的第一个字符,如果是字母转换成大写
     */
    public void setText(String content) {
        this.text = String.valueOf(content.toCharArray()[0]);
        this.text = text.toUpperCase();
        charHash = this.text.hashCode();
    }

    public Paint getPaint() {
        return mPaint;
    }
}
