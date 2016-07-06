package me.crosswall.coverflow.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;

/**
 * Created by vincentpaing on 30/6/16.
 */
public class OverlapActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_normal);

    PagerContainer pagerContainer = (PagerContainer) findViewById(R.id.pager_container);
    pagerContainer.setOverlapEnabled(true);

    final ViewPager viewPager = pagerContainer.getViewPager();
    MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
    viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
    viewPager.setAdapter(pagerAdapter);

    new CoverFlow.Builder().with(viewPager)
        .scale(0.3f)
        .pagerMargin(getResources().getDimensionPixelSize(R.dimen.overlap_pager_margin))
        .spaceSize(0f)
        .build();

    //Manually setting the first View to be elevated
    viewPager.post(new Runnable() {
      @Override public void run() {
        Fragment fragment = (Fragment) viewPager.getAdapter().instantiateItem(viewPager, 0);
        ViewCompat.setElevation(fragment.getView(), 8.0f);
      }
    });
  }

  private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override public Fragment getItem(int position) {
      return OverlapFragment.newInstance(DemoData.covers[position]);
    }

    @Override public int getCount() {
      return DemoData.covers.length;
    }
  }
}
