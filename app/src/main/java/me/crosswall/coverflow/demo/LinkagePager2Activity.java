package me.crosswall.coverflow.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.LinkagePager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.crosswall.coverflow.demo.view.DataDemoView;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.LinkagePagerContainer;

/**
 * Created by yuweichen on 16/5/3.
 */
public class LinkagePager2Activity extends AppCompatActivity{
    private LinkagePagerContainer customPagerContainer;
    private LinkagePager pager;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_collapsing);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        customPagerContainer = (LinkagePagerContainer) findViewById(R.id.pager_container);

        final LinkagePager cover = customPagerContainer.getViewPager();

        PagerAdapter coverAdapter = new MyPagerAdapter();
        cover.setAdapter(coverAdapter);
        cover.setOffscreenPageLimit(5);

        new CoverFlow.Builder()
                .withLinkage(cover)
                .pagerMargin(0f)
                .scale(0.3f)
                .spaceSize(0f)
                .build();


        pager = (LinkagePager) findViewById(R.id.pager);

        MyListPagerAdapter adapter = new MyListPagerAdapter();

        pager.setOffscreenPageLimit(5);
        pager.setAdapter(adapter);


        cover.setLinkagePager(pager);
        pager.setLinkagePager(cover);



    }

    class MyListPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            DataDemoView view = new DataDemoView(LinkagePager2Activity.this);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView view = new TextView(LinkagePager2Activity.this);
            view.setText("Item "+position);
            view.setGravity(Gravity.CENTER);
            view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }


}
