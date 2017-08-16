package demo.zl.com;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by zhangli on 2017/8/4.
 */

public class MyListView  extends ListView{
    private int  dragSrcPotion;
    private int dragDesPotion;
    private int Deagpoint;
    private int dragoffsetY;
    private int UpSrcollBounce;
    private int downScrollBounce;

    public MyListView(Context context) {

        super(context);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) ev.getX();
            int y = (int) ev.getY();
            dragSrcPotion = dragDesPotion =  pointToPosition(x,y);
            ViewGroup itemView = (ViewGroup) getChildAt(dragSrcPotion-getFirstVisiblePosition());
            Deagpoint = y - itemView.getTop();
            //listview on phone y loction
            dragoffsetY = (int) (ev.getRawY() - y);
            //drage icon
            View dragger = itemView.findViewById(R.id.myview);
            //think point position
            if (dragger != null && x < dragger.getRight() +10) {
                // ding yi listview scrool line
                UpSrcollBounce = getHeight() /3;
                downScrollBounce = getHeight() * 2 / 3;
                itemView.setDrawingCacheEnabled(true);
                Bitmap bm = itemView.getDrawingCache();
                startDrag(bm,y);
            }
        }


        return super.onInterceptTouchEvent(ev);

    }

    private void startDrag(Bitmap bm, int y) {

    }
}
