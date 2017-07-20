package demo.zl.com;

import android.app.VoiceInteractor;
import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by zhangli on 2017/7/17.
 */

public class RegionEdittext extends EditText {
    private Context context;
    private int max;
    private int min;

    public RegionEdittext(Context context) {
        super(context);
        this.context = context;
    }


    public RegionEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public RegionEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void setRegion(int maxNum, int minNum) {
        setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
        this.max = maxNum;
        this.min = minNum;
    }

    public void setTextWatcher() {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (start >= 0) {//从一输入就开始判断，
                    if (min != -1 && max != -1) {
                        try {
                            int num = Integer.parseInt(s.toString());
                            //判断当前edittext中的数字(可能一开始Edittext中有数字)是否大于max
                            if (num > max) {
                                s = String.valueOf(max);//如果大于max，则内容为max
                                setText(s);
//                                VoiceInteractor.ProΩmpt.showTips(context, "金额不能超过" + max + "元");

                            } else if (num < min) {
                                s = String.valueOf(min);//如果小于min,则内容为min
                            }
                        } catch (NumberFormatException e) {
//                            LFLog.e("ontextchanged", "==" + e.toString());
                        }
                        //edittext中的数字在max和min之间，则不做处理，正常显示即可。
                        return;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                int len = s.toString().length();
                String text = "";
                if (len >= 1) {
                     text = s.toString().substring(0,1);
                }

               if (!text.equals("") && text.equals("0")) {
                   setText(s.toString().substring(1,len));
               }
            }
        });
    }

}
