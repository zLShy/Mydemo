package demo.zl.com;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MyDrawViewActivity extends BaseActivity{

    private MyWeaveView myWeaveView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mydrawview_activity);

        init();
    }

    private void init() {
        this.myWeaveView = (MyWeaveView) findViewById(R.id.myweave);

        myWeaveView.setOnWaveAnimationListener(new MyWeaveView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
//                lp.setMargins(0,0,0,(int)y+2);
//                imageView.setLayoutParams(lp);
            }
        });

    }




}
