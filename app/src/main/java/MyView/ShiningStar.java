package MyView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.List;

import demo.zl.com.R;

public class ShiningStar extends View {

    /**
     * 星星的坐标及大小
     */
    private static final int[][] starPosition = new int[][] {
            {80, 80, 66},{160, 80, 80},{240,160, 100},{120, 240, 120},{360, 480, 66}, {600, 600, 120}, {720, 500, 120},
            {360, 100, 66}, {600, 160, 120}, {720, 240, 120},{860, 80, 80}
    };

    /**
     * 星星存储器
     */
    private List<Star> stars = new ArrayList<Star>();

    /**
     * 星星资源
     */
    private Bitmap bitmap = null;

    /**
     * 画笔
     */
    private Paint paint = null;

    protected  float starScale = 1f;

    protected float starAlpha = 255f;

    public ShiningStar(Context context) {
        super(context);
        init();
    }

    public ShiningStar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShiningStar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            boolean flag = false;
            for (int i = 0; i < stars.size(); i++) {
                canvas.save();//这样使每一个星星的状态独立
                Rect dst = new Rect(stars.get(i).x, stars.get(i).y, stars.get(i).x + stars.get(i).size, stars.get(i).y + stars.get(i).size);
                android.util.Log.i("TestShining", "scale: " + starScale);
                if (flag) {
                    canvas.scale(starScale,  starScale, stars.get(i).x + stars.get(i).size/2, stars.get(i).y + stars.get(i).size/2);
                    paint.setAlpha((int)starAlpha);
                } else {
                    canvas.scale(1 - starScale,  1 - starScale, stars.get(i).x + stars.get(i).size/2, stars.get(i).y + stars.get(i).size/2);
                    paint.setAlpha((int)(255 - starAlpha));
                }
                flag = !flag;
                canvas.drawBitmap(bitmap, null, dst, paint);
                canvas.restore();
            }
        }
    }

    /**
     * 初始化
     */
    private void init() {
        initStars();
        initAnimation();
    }

    /**
     * 初始化星星对象
     */
    private void initStars() {
        for (int i = 0; i < starPosition.length; i++) {
            final Star star = new Star();
            star.x = starPosition[i][0];
            star.y = starPosition[i][1];
            star.size = starPosition[i][2];
            stars.add(star);
        }
    }

    public float getStarScale() {
        return starScale;
    }

    public void setStarScale(float starScale) {
        this.starScale = starScale;
        postInvalidate();
    }

    public float getStarAlpha() {
        return starAlpha;
    }

    public void setStarAlpha(float starAlpha) {
        this.starAlpha = starAlpha;
        postInvalidate();
    }

    /**
     * 初始化动画及绘制元素的对象
     */
    private void initAnimation() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
        paint = new Paint();
        paint.setAlpha(255);

        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(this, "starScale", 0, 1, 0);
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(-1);

        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(this, "starAlpha", 0, 255, 0);
        alphaAnim.setInterpolator(new LinearInterpolator());
        alphaAnim.setDuration(1000);
        alphaAnim.setRepeatCount(-1);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleAnim, alphaAnim);
        animatorSet.playTogether(scaleAnim);
        animatorSet.start();
    }

    /**
     * 星星属性
     */
    class Star {
        int x;
        int y;
        int size;
    }
}