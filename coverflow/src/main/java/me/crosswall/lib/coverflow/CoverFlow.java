package me.crosswall.lib.coverflow;

import android.support.v4.view.ViewPager;

import me.crosswall.lib.coverflow.core.CoverTransformer;

/**
 * Created by yuweichen on 16/4/29.
 */
public class CoverFlow {

  //  public static final float DEFAULT_SCALE_VALUE  = 0.3f;

  //  public static final float DEFAULT_PAGER_MARGIN = 0f;

 //   public static final float DEFAULT_SPACE_SIZE   = 0f;

    private final ViewPager syncViewPager;
    private final float scaleValue;
    private final float pagerMargin;
    private final float spaceSize;

    public CoverFlow(CoverFlow.Builder builder){

        if(null==builder){
            throw new IllegalArgumentException("A non-null CoverFlow.Builde must be provided");
        }

        this.syncViewPager = builder.syncViewPager;
        this.scaleValue  = builder.scaleValue;
        this.pagerMargin = builder.pagerMargin;
        this.spaceSize   = builder.spaceSize;

        if(null == this.syncViewPager){
            throw new IllegalArgumentException("A non-null ViewPager must be provided");
        }

        this.syncViewPager.setPageTransformer(false,
                new CoverTransformer(this.scaleValue,this.pagerMargin,this.spaceSize));

    }

    public static class Builder {
        private ViewPager syncViewPager;
        private float scaleValue;
        private float pagerMargin;
        private float spaceSize;

        public CoverFlow.Builder with(ViewPager syncViewPager) {
            this.syncViewPager = syncViewPager;
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
