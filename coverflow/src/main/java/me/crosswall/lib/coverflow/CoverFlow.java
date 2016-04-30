package me.crosswall.lib.coverflow;

import android.support.v4.view.ViewPager;

import me.crosswall.lib.coverflow.core.CoverTransformer;
import me.crosswall.lib.coverflow.core.syncpager.SyncCoverTransformer;
import me.crosswall.lib.coverflow.core.syncpager.SyncViewPgaer;

/**
 * Created by yuweichen on 16/4/29.
 */
public class CoverFlow {

  //  public static final float DEFAULT_SCALE_VALUE  = 0.3f;

  //  public static final float DEFAULT_PAGER_MARGIN = 0f;

 //   public static final float DEFAULT_SPACE_SIZE   = 0f;

    private final ViewPager viewPager;
    private final SyncViewPgaer syncViewPgaer;
    private final float scaleValue;
    private final float pagerMargin;
    private final float spaceSize;

    public CoverFlow(CoverFlow.Builder builder){

        if(null==builder){
            throw new IllegalArgumentException("A non-null CoverFlow.Builde must be provided");
        }

        this.viewPager = builder.viewPager;
        this.syncViewPgaer = builder.syncViewPgaer;
        this.scaleValue  = builder.scaleValue;
        this.pagerMargin = builder.pagerMargin;
        this.spaceSize   = builder.spaceSize;

        if(this.viewPager != null){
            this.viewPager.setPageTransformer(false,
                    new CoverTransformer(this.scaleValue,this.pagerMargin,this.spaceSize));
        }else if(this.syncViewPgaer !=null){
            this.syncViewPgaer.setPageTransformer(false,new SyncCoverTransformer(this.scaleValue,this.pagerMargin,this.spaceSize));
        }


    }

    public static class Builder {
        private ViewPager viewPager;
        private SyncViewPgaer syncViewPgaer;
        private float scaleValue;
        private float pagerMargin;
        private float spaceSize;

        public CoverFlow.Builder with(ViewPager viewPager) {
            this.viewPager = viewPager;
            return this;
        }

        public CoverFlow.Builder withSync(SyncViewPgaer syncViewPgaer){
            this.syncViewPgaer = syncViewPgaer;
            return this;
        }


        public CoverFlow.Builder scale(float scaleValue) {
            this.scaleValue = scaleValue;
            return this;
        }

        public CoverFlow.Builder pagerMargin(float pagerMargin) {
            this.pagerMargin = pagerMargin;
            return this;
        }

        public CoverFlow.Builder spaceSize(float spaceSize) {
            this.spaceSize = spaceSize;
            return this;
        }

        public CoverFlow build() {
            return new CoverFlow(this);

        }
    }
}
