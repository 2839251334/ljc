package com.example.administrator.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ListView mListView;
    private String[] names={ "圣甲盖亚", "鲁迪加诺", "布莱克","英卡洛斯","哈迪斯","谱尼",
                             "圣战瑞尔斯", "奈尼芬多", "雷神雷伊","米斯蒂克","厄尔塞拉"};
    private int[]  icons= { R.drawable.aa,R.drawable.bb,R.drawable.cc,R.drawable.dd, R.drawable.ee,
                            R.drawable.ff,R.drawable.gg,R.drawable.hh,R.drawable.ii, R.drawable.jj, R.drawable.kk};
    private String[] introduces = {
            "圣甲狂战的进化体",
            "大地震颤",
            "夜魔之神",
            "无脑之光",
            "不死冥王",
            "圣灵主宰",
            "斗天武神",
            "超能幻音",
            "雷神",
            "神出鬼没",
            "光耀万世"

    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        mListView = (ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
    }
    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return  names.length;
        }
        @Override
        public Object getItem(int position){
            return names[position];
        }
        @Override
        public long getItemId (int position){
            return position;
        }
        @Override
        public View getView(int position, View converView, ViewGroup parent){
            ViewHolder holder = null;
            if(converView == null){
                converView = View.inflate(MainActivity.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.name = (TextView)converView.findViewById(R.id.name);
                holder.introduce = (TextView)converView.findViewById(R.id.introduce);
                holder.iv = (ImageView) converView.findViewById(R.id.iv);
                converView.setTag(holder);
            }else{
                holder = (ViewHolder) converView.getTag();
            }
            holder.name.setText(names[position]);
            holder.introduce.setText(introduces[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return converView;
        }
    }

}
