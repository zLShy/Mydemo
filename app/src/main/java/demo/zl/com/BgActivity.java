package demo.zl.com;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

import MyView.TranslucentActionBar;
import MyView.TranslucentScrollView;
import app.season.backgroundview.BackgroundView;
import impl.ActionBarClickListener;


/**
 * Created by Administrator on 2016/12/16.
 * email:303767416@qq.com
 */

public class BgActivity extends BaseActivity{

    private BackgroundView backgroundView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);
        init();
    }

    private void init() {

        this.backgroundView = (BackgroundView) findViewById(R.id.background);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backgroundView.stopAnimation();
    }

    
}
