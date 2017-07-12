package demo.zl.com;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.RelativeLayout;


public class AnimActivity extends BaseActivity implements View.OnClickListener{


    private Button sure,btn;
    private RelativeLayout rl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.anim_activity);

        init();
    }

    private void init() {

        this.sure = (Button) findViewById(R.id.sure);
        this.btn = (Button) findViewById(R.id.btn);
        this.rl = (RelativeLayout) findViewById(R.id.rl);
        this.sure.setOnClickListener(this);
    }




    private void showView() {
        int screenHigh = ScreenUtils.getScreenHeight(this);
        int rlHeiht = rl.getHeight();
        int btnHeight = btn.getHeight();
        Log.e("TGA","sc"+screenHigh+":x"+rlHeiht+"btn"+btnHeight);
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn,"translationY",0,screenHigh);
        AnimatorSet animSet = new AnimatorSet();
//        ObjectAnimator animator = new ValueAnimator();
//        animator.setDuration(10000);
//        animator.start();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btn,"alpha", 1.0F, 0.0F);
//        objectAnimator.setDuration(2000);
//        objectAnimator.start();
        animSet.play(animator).with(objectAnimator);

//        animator.ofFloat(screenHigh,screenHigh-rlHeiht-btnHeight);
        animSet.setDuration(3000);
        animSet.start();
        Log.e("Tga","move");
    }


    private void hideView() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sure:
                showView();
                break;
        }
    }
}
