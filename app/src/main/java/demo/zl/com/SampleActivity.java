package demo.zl.com;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import utils.SizeUtils;


public class SampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

//        ListView lv = (ListView) findViewById(R.id.list);
        ListView lv1 = (ListView) findViewById(R.id.list1);

        List<String> items1 = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            items1.add("" + i);
        }

        String[] itemArray1 = new String[items1.size()];

        lv1.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, items1.toArray(itemArray1)));
        Log.e("TGA",getAppMetaData(this,"UMENG_CHANNEL"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                getNum();
            }
        }).start();

//        List<String> items = new ArrayList<>();
//        for(int i = 0; i < 100; i++) {
//            items.add("" + i);
//        }
//
//        String[] itemArray = new String[items.size()];
//
//        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, items.toArray(itemArray)));
    }


    /**
     * 获取application中指定的meta-data
     * @return 如果没有获取成功(没有对应值，或者异常)，则返回值为空
     */
    public static String getAppMetaData(Context ctx, String key) {
        if (ctx == null || TextUtils.isEmpty(key)) {
            return null;
        }
        String resultData = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(key);
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return resultData;
    }

    private void getNum() {
//        BigInteger m =new BigInteger("1380000000");
//        BigInteger start=new BigInteger("1370000000");
//        BigInteger one=new BigInteger("1");
//        int msgid=0;
//        for(BigInteger n=start;n.compareTo(m)<0;n=n.add(one)){
//            msgid++;
//            Log.e("TGA","所有数为"+msgid);
//        }
//        long n = (long) Math.pow(2,39);
//        Log.e("TGA",n+"==result");

//        long n = 1 << 12;
//        ArrayList<Double> mList = new ArrayList<>();
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(2.0);
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(3.0);
//        mList.add(1.0);
//        mList.add(1.0);
//        Double m= SizeUtils.getTwo(mList,7);
//        mList.add(1.0);
//        mList.add(1.0);
//
//        List<List<Integer>> mCombine = SizeUtils.FullComb(mList);

        List<String> mList = new ArrayList<String>();
        for (int i=1;i<=14;i++) {
            mList.add(String.valueOf(i));
        }
        List<List<Integer>> mResult = SizeUtils.FullComb(mList,9);
//        Log.e("TGA",mCombine.get(8).size()+"==size");
        Log.e("TGA",mResult.size()+"===size");
//        String[] str = new String[39] ;
//        for (int i=1;i<=39;i++) {
//            if (i >9) {
//                str[i-1] = String.valueOf(i);
//            }else {
//                str[i-1] = "0"+String.valueOf(i);
//            }
//
//        }
//        SizeUtils balls = new SizeUtils();
//        String b = new String();
//        int num = 9;
//        balls.Combine(str,num,b,0,38);
//        Log.e("TGA",balls.returnSize()+"===size");
    }
}
