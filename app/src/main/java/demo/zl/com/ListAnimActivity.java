package demo.zl.com;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cn.schope.gys.listviewitemdeleteanimationlib.FlingDismissListener;
import cn.schope.gys.listviewitemdeleteanimationlib.MyListViewWrapper;
import cn.schope.gys.listviewitemdeleteanimationlib.OnDismissCallback;


public class ListAnimActivity extends BaseActivity implements View.OnClickListener,OnDismissCallback {

    private Button btn;
    private ListView listView;
    private FlingDismissListener flingDismissListener;
    private ArrayList<String> strs = new ArrayList<String>();
    private MyAdapter adapter;

    {
        for (int i = 0;i<10;i++){
            strs.add("我是第:"+i+"个Item");
        }
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list_anim_activity);

        init();
    }

    private void init() {
        this.btn = (Button) findViewById(R.id.deleteall);
        this.listView = (ListView) findViewById(R.id.list);
        this.btn.setOnClickListener(this);
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
        listView.setDivider(null);
        flingDismissListener = new FlingDismissListener(new MyListViewWrapper(listView),this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                flingDismissListener.dismissOne(position, strs.get(position));
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.deleteall:
                ArrayList<FlingDismissListener.DeleteItemWrapper> deleteItems = new ArrayList<FlingDismissListener.DeleteItemWrapper>();
                for(int i = 0;i<5;i++){
                    deleteItems.add(new FlingDismissListener.DeleteItemWrapper(i,strs.get(i)));
                }
                flingDismissListener.dismiss(deleteItems);
                break;
        }
    }

    @Override
    public void onDismiss(@NonNull ViewGroup listView, @NonNull FlingDismissListener.DeleteItemWrapper[] reverseSortedPositions) {
        for (FlingDismissListener.DeleteItemWrapper deleteItem : reverseSortedPositions){
            //由于每次删除一些item所在的position都会改变,所以必须使用对象来删除.
            strs.remove(deleteItem.item);
        }
        adapter.notifyDataSetChanged();
    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return strs.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            FrameLayout frameLayout = new FrameLayout(ListAnimActivity.this);
            TextView textView = new TextView(ListAnimActivity.this);
            textView.setText(strs.get(position));
            frameLayout.addView(textView);
            textView.getLayoutParams().height = (int) dp2px(30);
            return frameLayout;
        }
    }

    public float dp2px(float dp){
        return dp * getResources().getDisplayMetrics().density;
    }
}
