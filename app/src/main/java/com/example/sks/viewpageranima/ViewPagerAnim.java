package com.example.sks.viewpageranima;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by sks on 2016/9/9.
 */
public class ViewPagerAnim implements ViewPager.PageTransformer {
    public static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;
    //public static final int MIN_SCALE = 0.94f;


    public void transformPage(View view, float position) {
        int width = view.getWidth();
        int pageWidth = width;
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            ViewHelper.setAlpha(view, 1);


        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                float result1=horzMargin-vertMargin/2;
                ViewHelper.setTranslationX(view,result1);
            } else {
                float result2=-horzMargin + vertMargin / 2;
                ViewHelper.setTranslationY(view,result2);
            }

            // Scale the page down (between MIN_SCALE and 1)

            ViewHelper.setScaleX(view,scaleFactor);
            ViewHelper.setScaleY(view,scaleFactor);

            ViewHelper.setAlpha(view,MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            ViewHelper.setAlpha(view,1);
        }
    }
}
