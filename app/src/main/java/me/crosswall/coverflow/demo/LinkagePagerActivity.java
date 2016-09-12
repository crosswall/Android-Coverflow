package me.crosswall.coverflow.demo;

import android.graphics.Color;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.LinkageCoverTransformer;
import me.crosswall.lib.coverflow.core.LinkagePagerContainer;
import me.crosswall.lib.coverflow.core.PageItemClickListener;

import android.support.v4.view.LinkagePager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LinkagePagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);

        LinkagePagerContainer mContainer = (LinkagePagerContainer) findViewById(R.id.pager_container);

        final LinkagePager pager = mContainer.getViewPager();

        PagerAdapter adapter = new MyPagerAdapter();
        pager.setAdapter(adapter);

        pager.setOffscreenPageLimit(adapter.getCount());

        final LinkagePager bindingPager = (LinkagePager) findViewById(R.id.pager);
        bindingPager.setAdapter(adapter);
        bindingPager.setOffscreenPageLimit(adapter.getCount());
        bindingPager.setLinkagePager(pager);

        pager.setClipChildren(false);
        pager.setPageTransformer(false,new LinkageCoverTransformer(0.3f,0f,0f,0f));

        mContainer.setPageItemClickListener(new PageItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                bindingPager.setCurrentItem(position);
            }
        });

    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView view = new TextView(LinkagePagerActivity.this);
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
            return 15;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }


}
