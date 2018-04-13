package me.crosswall.lib.coverflow.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by yuweichen on 16/4/29.
 */
public class Utils {
    
    public static int isInNonTappableRegion(int containerWidth,int pagerWidth,float oldX, float newX) {
        int tappableWidth = pagerWidth;
        int totalWidth = containerWidth;
        int nonTappableWidth = (totalWidth - tappableWidth) / 2;
        if (oldX < nonTappableWidth && newX < nonTappableWidth) {
            return -(int) Math.ceil((nonTappableWidth - newX) / (float) tappableWidth);
        }
        nonTappableWidth = (totalWidth + tappableWidth) / 2;
        if (oldX > nonTappableWidth && newX > nonTappableWidth) {
            return (int) Math.ceil((newX - nonTappableWidth) / (float) tappableWidth);
        }
        return 0;
    }

    public static float getFloat(float value,float minValue,float maxValue){
        return Math.min(maxValue, Math.max(minValue, value));
    }

    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

}
