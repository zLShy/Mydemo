package demo.zl.com;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import app.season.backgroundview.BackgroundView;


/**
 * Created by Administrator on 2016/12/16.
 * email:303767416@qq.com
 */

public class EdittextLimitActivity extends BaseActivity{


    private RegionEdittext edittext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.limit_activity);
        init();

        Log.e("TGA",android.os.Build.VERSION.SDK_INT+"===banbenhao=="+android.os.Build.MODEL+"=="+android.os.Build.VERSION.RELEASE);
        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        Log.e("TGA",tm.getDeviceId()+"");
    }

    private void init() {
        this.edittext = (RegionEdittext) findViewById(R.id.limitet);
        this.edittext.setRegion(100,1);
        this.edittext.setTextWatcher();

        this.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });
    }


}
