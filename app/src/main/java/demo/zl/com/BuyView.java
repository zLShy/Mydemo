package demo.zl.com;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by zhangli on 2017/7/20.
 */

public class BuyView extends View implements ValueAnimator.AnimatorUpdateListener{

    public static final int VIEW_SIZE = 20;
    private Paint mPaint;

    protected int radius;
    private Context mContext;
    protected Point startPosition;
    protected Point endPosition;
    CallBacks callBacks;
    private Paint mCirclepaint;

    public BuyView(Context context) {
        this(context,null);

    }

    public BuyView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public BuyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.mCirclepaint = new Paint();
        this.mCirclepaint.setColor(Color.RED);
        this.mCirclepaint.setAntiAlias(true);

    }

    public void setStartPosition(Point startPosition) {
        startPosition.y -= 10;
        this.startPosition = startPosition;
    }

    public void setCallBacks(CallBacks callBacks) {
        this.callBacks = callBacks;
    }

    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int PX4SIZE = (int) convertDpToPixel(VIEW_SIZE, mContext);
        setMeasuredDimension(PX4SIZE, PX4SIZE);
        radius = PX4SIZE / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, radius, mCirclepaint);
        super.onDraw(canvas);

    }

    public void startanim() {
        if (startPosition == null || endPosition == null) {
            return;
        }

        int pointX = (startPosition.x + endPosition.x) / 2;
        int pointY = (int) (startPosition.y - convertDpToPixel(100, mContext));
        Point controllPoint = new Point(pointX, pointY);
        ValueAnim anim = new ValueAnim(controllPoint);
        ValueAnimator animator = ValueAnimator.ofObject(anim,startPosition,endPosition);
        animator.addUpdateListener(this);
        animator.setDuration(400);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

                BuyView.this.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {

                BuyView.this.setVisibility(GONE);
                callBacks.getResult("1");
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {

        Point point = (Point) valueAnimator.getAnimatedValue();
        setX(point.x);
        setY(point.y);
        invalidate();
    }

    public class ValueAnim implements TypeEvaluator<Point> {

        private Point mPoint;

        public ValueAnim(Point mPoint) {
            this.mPoint = mPoint;
        }

        @Override
        public Point evaluate(float t, Point startPoint, Point endPoint) {
            int x = (int) ((1-t)*(1-t)*startPoint.x + 2*t*(1-t)*mPoint.x+ t*t*endPoint.x);
            int y = (int) ((1-t)*(1-t)*startPoint.y +2*t*(1-t)*mPoint.y+t*t*endPoint.y);
            return new Point(x,y);
        }
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }
}
