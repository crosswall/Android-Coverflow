package me.crosswall.lib.coverflow.core;
import android.support.v4.view.LinkagePager;
import android.view.View;


/**
 * Created by yuweichen on 16/4/29.
 */
public class LinkageCoverTransformer implements LinkagePager.PageTransformer {

    public static final String TAG = "CoverTransformer";

    public static final float SCALE_MIN = 0.3f;
    public static final float SCALE_MAX = 1f;
    public static final float MARGIN_MIN = 0f;
    public static final float MARGIN_MAX = 50f;
    public float scale  = 0f;

    public float pagerMargin = 0f;
    public float spaceValue = 0f;

    private float rotationY    = 0f;

    public LinkageCoverTransformer(float scale, float pagerMargin,float spaceValue,float rotationY) {
        this.scale = scale;
        this.pagerMargin = pagerMargin;
        this.spaceValue  = spaceValue;
        this.rotationY   = rotationY;
    }


    @Override
    public void transformPage(View page, float position) {

       // Log.d(TAG,"position:"+position);

        if (scale != 0f) {
            float realScale = Utils.getFloat(1 - Math.abs(position * scale),SCALE_MIN,SCALE_MAX);
            page.setScaleX(realScale);
            page.setScaleY(realScale);
        }

        if (pagerMargin != 0) {

            float realPagerMargin = position * (pagerMargin);

            if (spaceValue != 0) {
                float realSpaceValue = Utils.getFloat(Math.abs(position * spaceValue),MARGIN_MIN,MARGIN_MAX);
                realPagerMargin += (position > 0) ? realSpaceValue : - realSpaceValue;
            }

            page.setTranslationX(realPagerMargin);
        }

        //TODO
        //rotate status
        if(rotationY!=0){
            float realRotationY = Math.abs(position * rotationY);
            page.setRotationY(position < 0f ? realRotationY : -realRotationY);
        }
    }
}
