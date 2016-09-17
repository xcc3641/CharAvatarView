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
        0xFF1abc9c, 0xFF16a085, 0xFFf1c40f, 0xFFf39c12, 0xFF2ecc71,
        0xFF27ae60, 0xFFe67e22, 0xFFd35400, 0xFF3498db, 0xFF2980b9,
        0xFFe74c3c, 0xFFc0392b, 0xFF9b59b6, 0xFF8e44ad, 0xFFbdc3c7,
        0xFF34495e, 0xFF2c3e50, 0xFF95a5a6, 0xFF7f8c8d, 0xFFec87bf,
        0xFFd870ad, 0xFFf69785, 0xFF9ba37e, 0xFFb49255, 0xFFb49255, 0xFFa94136
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
            throw new NullPointerException("字符串内容不能为空");
        }
        this.text = String.valueOf(content.toCharArray()[0]);
        this.text = text.toUpperCase();
        charHash = this.text.hashCode();
        // 重绘
        invalidate();
    }

}
