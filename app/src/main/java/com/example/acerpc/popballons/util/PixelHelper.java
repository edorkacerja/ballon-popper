package com.example.acerpc.popballons.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by AcerPC on 12/4/2016.
 */

public class PixelHelper {
    public static int pixelsToDp(int px, Context context) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, px,
                context.getResources().getDisplayMetrics());
    }
}
