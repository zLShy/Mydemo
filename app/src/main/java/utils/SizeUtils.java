package utils;

import android.content.Context;
import android.util.Log;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanjunhui
 * on 2016/9/29.
 * email:303767416@qq.com
 */
public class SizeUtils {
    List<String> mList = new ArrayList<String>();

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public void Combine(String[] a, int num, String b, int low, int high) {

        if (num == 0) {
            System.out.print(b + " ");
            mList.add(b);
        } else {
            for (int i = low; i < a.length; i++) {
                b += a[i];
                Combine(a, num - 1, b, i + 1, a.length);
                b = b.substring(0, b.length() - 2);

            }


        }

    }

    public int returnSize() {
        return mList.size();
    }


    public static double recursion(ArrayList<Double> Dint, int gameNum) {
        int n = 9;
        double sum =0.0;
        //————————————————————————————————————————————9串1————————————————————————————————————
        //外层
        for (int a = 0; a < gameNum - (n - 1); a++) {
            //内层
            for (int b = a + 1; b < gameNum; b++) {
                for (int c = b + 1; c < gameNum; c++) {
                    for (int d = c + 1; d < gameNum; d++) {
                        for (int e = d + 1; e < gameNum; e++) {
                            for (int f = e + 1; f < gameNum; f++) {
                                for (int g = f + 1; g < gameNum; g++) {
                                    for (int h = g + 1; h < gameNum; h++) {
                                        for (int i = h + 1; i < gameNum; i++) {
                                            sum = Dint.get(a) * Dint.get(b) * Dint.get(c) * Dint.get(d) * Dint.get(e) * Dint.get(f) * Dint.get(g) * Dint.get(h)* Dint.get(i) + sum;
                                        }
//                                            Log.e("tag", Dint.get(a) + "*" + Dint.get(b) + "*" + Dint.get(c) + "*" + Dint.get(d) + "*" + Dint.get(e) + "*" + Dint.get(f) + "*" + Dint.get(g) + "*" + Dint.get(h));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static double getEight(ArrayList<Double> Dint, int gameNum) {
        int n = 8;
        double sum =0.0;
        for (int a = 0; a < gameNum - (n - 1); a++) {
            //内层
            for (int b = a + 1; b < gameNum; b++) {
                for (int c = b + 1; c < gameNum; c++) {
                    for (int d = c + 1; d < gameNum; d++) {
                        for (int e = d + 1; e < gameNum; e++) {
                            for (int f = e + 1; f < gameNum; f++) {
                                for (int g = f + 1; g < gameNum; g++) {
                                    for (int h = g + 1; h < gameNum; h++) {
                                        sum = Dint.get(a) * Dint.get(b) * Dint.get(c) * Dint.get(d) * Dint.get(e) * Dint.get(f) * Dint.get(g) * Dint.get(h) + sum;
//                                            Log.e("tag", Dint.get(a) + "*" + Dint.get(b) + "*" + Dint.get(c) + "*" + Dint.get(d) + "*" + Dint.get(e) + "*" + Dint.get(f) + "*" + Dint.get(g) + "*" + Dint.get(h));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return sum;
    }


    public static double getsenve (ArrayList<Double> Dint, int gameNum) {
        int n = 7;
        double sum =0.0;
        for (int a = 0; a < gameNum - (n - 1); a++) {
            //内层
            for (int b = a + 1; b < gameNum; b++) {
                for (int c = b + 1; c < gameNum; c++) {
                    for (int d = c + 1; d < gameNum; d++) {
                        for (int e = d + 1; e < gameNum; e++) {
                            for (int f = e + 1; f < gameNum; f++) {
                                for (int g = f + 1; g < gameNum; g++) {
                                    sum = Dint.get(a) * Dint.get(b) * Dint.get(c) * Dint.get(d) * Dint.get(e) * Dint.get(f) * Dint.get(g) + sum;
//                                        Log.e("tag", Dint.get(a) + "*" + Dint.get(b) + "*" + Dint.get(c) + "*" + Dint.get(d) + "*" + Dint.get(e) + "*" + Dint.get(f) + "*" + Dint.get(g));
                                }
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static double getsix(ArrayList<Double> Dint, int gameNum) {
        int n = 6;
        double sum =0.0;
        for (int a = 0; a < gameNum - (n - 1); a++) {
            //内层
            for (int b = a + 1; b < gameNum; b++) {
                for (int c = b + 1; c < gameNum; c++) {
                    for (int d = c + 1; d < gameNum; d++) {
                        for (int e = d + 1; e < gameNum; e++) {
                            for (int f = e + 1; f < gameNum; f++) {
                                sum = Dint.get(a) * Dint.get(b) * Dint.get(c) * Dint.get(d) * Dint.get(e) * Dint.get(f) + sum;
//                                    Log.e("tag", Dint.get(a) + "*" + Dint.get(b) + "*" + Dint.get(c) + "*" + Dint.get(d) + "*" + Dint.get(e) + "*" + Dint.get(f));
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static double getTwo(ArrayList<Double> Dint, int gameNum) {
        int n = 2;
        double sum =0.0;
        for (int a = 0; a < gameNum - (n - 1); a++) {
            //内层
            for (int b = a + 1; b < gameNum; b++) {
                sum = Dint.get(a) * Dint.get(b) + sum;
            }
        }
        return sum;
    }

    public static List<List<Integer>> FullComb(List<String> data,int no) {
        if (data == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList();
        int m = data.size();
        int n = (1 << m) - 1;
        for (int i = 1; i <= n; i++) {
            List<Integer> list=new ArrayList();
            for(int j=0;j<m;j++){
                int add=i&(1<<j);
                if(add>0){
                    list.add(j);
                }
            }
            if(list.size() == no){
                result.add(list);
            }
        }
        return result;
    }


}
