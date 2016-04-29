package me.crosswall.lib.coverflow;

/**
 * Created by yuweichen on 16/4/29.
 */
public class ScrollUtils {

    public static float getFloat(float value,float minValue,float maxValue){
        return Math.min(maxValue, Math.max(minValue, value));
    }
}
