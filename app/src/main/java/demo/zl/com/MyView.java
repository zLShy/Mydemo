package demo.zl.com;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangli on 2017/8/21.
 */

public class MyView extends View {
    private Paint mPaint;
    private Paint mArcPaint;
    private Paint mPaintCilcle;
    private float Myact;
    private int mWl;
    private int offset;

    //    double ω = 2*Math.PI / getWidth();
    public MyView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.CYAN);
        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(Color.RED);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mPaintCilcle = new Paint();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF mRectF = new RectF(100,100,800,400);
        canvas.drawRoundRect(mRectF,30,30,mPaint);

        canvas.drawArc(mRectF,0,90,true,mArcPaint);

        char[] chars = "abcdef".toCharArray();
        canvas.drawPosText("abcd",new float[] {
                100,100,
                200,200,
                300,300,
                400,400
        },mArcPaint);

        Path mPath = new Path();
        mPath.cubicTo(400,500,300,700,800,900);
        canvas.drawPath(mPath,mArcPaint);
        canvas.drawTextOnPath("helloworld",mPath,100,20,mArcPaint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.star);
        canvas.drawBitmap(bitmap,new Matrix(),new Paint());

        ValueAnimator animator = ValueAnimator.ofInt(0,mWl);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
               offset =  (int)valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });

        animator.start();
    }


}
