package com.example.acerpc.popballons;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.acerpc.popballons.util.PixelHelper;

/**
 * Created by AcerPC on 12/4/2016.
 */

public class Ballon extends ImageView implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    private ValueAnimator mAnimator;

    public Ballon(Context context) {
        super(context);
    }

    public Ballon(Context context, int color, int rawHeight) {
        super(context);

        this.setImageResource(R.drawable.balloon);
        this.setColorFilter(color);
        int rawWidth = rawHeight/2;
        int dpHeight = PixelHelper.pixelsToDp(rawHeight, context);
        int dpWidth = PixelHelper.pixelsToDp(rawWidth, context);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dpWidth, dpHeight);
        setLayoutParams(layoutParams);

    }

    public void releaseBalloon(int screenHeight, int duration) {
        mAnimator = new ValueAnimator();
        mAnimator.setDuration(duration);
        mAnimator.setFloatValues(screenHeight, 0f);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setTarget(this);
        mAnimator.addListener(this);
        mAnimator.addUpdateListener(this);
        mAnimator.start();
    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {

    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }

    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        setY((float) valueAnimator.getAnimatedValue());
    }
}
