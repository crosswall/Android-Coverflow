package me.crosswall.coverflow.demo;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.crosswall.lib.coverflow.core.CoverTransformer;
import me.crosswall.lib.coverflow.core.PagerContainer;
import me.crosswall.lib.coverflow.core.SyncViewPager;

public class MainActivity extends AppCompatActivity {

    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerContainer mContainer = (PagerContainer) findViewById(R.id.pager_container);

        final ViewPager pager = mContainer.getViewPager();

        PagerAdapter adapter = new MyPagerAdapter();
        pager.setAdapter(adapter);

        pager.setOffscreenPageLimit(adapter.getCount());
        //A little space between pages
       // pager.setPageMargin(15);

        //If hardware acceleration is enabled, you should also remove
        // clipping on the pager for its children.
        pager.setClipChildren(false);

        pager.setPageTransformer(false,new CoverTransformer(0.3f,0f,0f));


        final SyncViewPager bindingPager = (SyncViewPager) findViewById(R.id.pager);
        bindingPager.setAdapter(adapter);
        bindingPager.setOffscreenPageLimit(adapter.getCount());

        bindingPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("@@@","positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bindingPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               Point touch = new Point();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        touch.x = (int) event.getX();
                        touch.y = (int) event.getY();
                        break;

                }
                pager.onTouchEvent(event);
                return false;
            }
        });

        pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Point touch = new Point();

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        touch.x = (int) event.getX();
                        touch.y = (int) event.getY();
                        break;

                }
                bindingPager.onTouchEvent(event);
                return false;
            }
        });
    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView view = new TextView(MainActivity.this);
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
