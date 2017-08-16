package demo.zl.com;

import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangli on 2017/8/16.
 */

public class MyZdy extends View{
    public MyZdy(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    class TypeValue implements TypeEvaluator<Point> {

        @Override
        public Point evaluate(float v, Point point, Point t1) {
            return null;
        }
    }
}
