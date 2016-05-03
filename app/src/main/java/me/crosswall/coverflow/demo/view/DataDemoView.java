package me.crosswall.coverflow.demo.view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import me.crosswall.coverflow.demo.R;

/**
 * Created by yuweichen on 16/5/3.
 */
public class DataDemoView extends LinearLayout{
    private ListView listview;

    public DataDemoView(Context context) {
        super(context);
        initView(context);
    }

    public DataDemoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DataDemoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = inflate(context, R.layout.view_demo_list,this);
        listview = (ListView) view.findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_expandable_list_item_1,
                getData());
        listview.setAdapter(adapter);

        ViewCompat.setNestedScrollingEnabled(listview, true);
    }

    private ArrayList<String> getData()
    {

        ArrayList<String> list = new ArrayList<>();
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");
        list.add("hello world");
        list.add("hello android");

        return list;
    }


}
