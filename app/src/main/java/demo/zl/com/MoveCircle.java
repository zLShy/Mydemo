package demo.zl.com;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by zhangli on 2017/7/10.
 */

public class MoveCircle extends View {

    private Paint mPaint;
    private Paint mBigPaint;
    public MoveCircle(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        mBigPaint = new Paint();
        mBigPaint.setStyle(Paint.Style.STROKE);
        mBigPaint.setColor(Color.RED);
        mBigPaint.setStrokeWidth(3);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
