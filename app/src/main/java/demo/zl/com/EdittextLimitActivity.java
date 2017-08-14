package demo.zl.com;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import app.season.backgroundview.BackgroundView;


/**
 * Created by Administrator on 2016/12/16.
 * email:303767416@qq.com
 */

public class EdittextLimitActivity extends BaseActivity implements CallBacks{


    private RegionEdittext edittext;
    private Button btn,btn1;
    private BuyView buyView;
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
        this.btn = (Button) findViewById(R.id.btn);
        this.btn1 = (Button) findViewById(R.id.btn1);
        this.buyView = (BuyView) findViewById(R.id.myview);
        this.edittext = (RegionEdittext) findViewById(R.id.limitet);
        this.edittext.setRegion(100,1);
        this.edittext.setTextWatcher();

        this.edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });

        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] position = new int[2];
                view.getLocationInWindow(position);
                buyView.setStartPosition(new Point(position[0],position[1]));
                buyView.setCallBacks(EdittextLimitActivity.this);
                int endPosition[] = new int[2];
                btn1.getLocationInWindow(endPosition);
                buyView.setEndPosition(new Point(endPosition[0],endPosition[1]));
                buyView.startanim();
            }
        });
    }


    @Override
    public void getResult(String sting) {
        btn1.setText(sting);
    }
}
