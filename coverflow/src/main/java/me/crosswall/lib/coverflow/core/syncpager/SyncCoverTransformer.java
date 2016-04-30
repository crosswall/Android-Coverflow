package me.crosswall.lib.coverflow.core.syncpager;
import android.view.View;

import me.crosswall.lib.coverflow.ScrollUtils;

/**
 * Created by yuweichen on 16/4/29.
 */
public class SyncCoverTransformer implements SyncViewPgaer.PageTransformer {

    public static final String TAG = "CoverTransformer";

    public static final float SCALE_MIN = 0.3f;
    public static final float SCALE_MAX = 1f;
    public static final float MARGIN_MIN = 0f;
    public static final float MARGIN_MAX = 50f;
    public float scale  = 0f;

    public float pagerMargin = 0f;
    public float spaceValue = 0f;

    public SyncCoverTransformer(float scale, float pagerMargin, float spaceValue) {
        this.scale = scale;
        this.pagerMargin = pagerMargin;
        this.spaceValue  = spaceValue;
    }


    @Override
    public void transformPage(View page, float position) {

       // Log.d(TAG,"position:"+position);

        if (scale != 0f) {
            float realScale = ScrollUtils.getFloat(1 - Math.abs(position * scale),SCALE_MIN,SCALE_MAX);
            page.setScaleX(realScale);
            page.setScaleY(realScale);
        }

        if (pagerMargin != 0) {

            float realPagerMargin = position * (pagerMargin);

            if (spaceValue != 0) {
                float realSpaceValue = ScrollUtils.getFloat(Math.abs(position * spaceValue),MARGIN_MIN,MARGIN_MAX);
                realPagerMargin += (position > 0) ? realSpaceValue : - realSpaceValue;
            }

            page.setTranslationX(realPagerMargin);
        }

        //TODO
        //rotate status
    }
}
