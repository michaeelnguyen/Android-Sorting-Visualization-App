package com.example.bubblesortapp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import android.os.Handler;


public class SwapAnimation {
    public static void SwapBubbles(BubbleInfo b1, BubbleInfo b2, int speed, Handler h, Runnable onComplete){
        // Get Both TextView x position and and switch positions
        ObjectAnimator anim = ObjectAnimator.ofFloat(b1.view,"x",b2.xOrig);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(b2.view,"x",b1.xOrig);

        anim.setDuration(speed);
        anim2.setDuration(speed);
        anim.start();
        anim2.start();

        anim2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) { }

            @Override
            public void onAnimationEnd(Animator animator) {
                // return textviews to original position
                b1.view.setX(b1.xOrig);
                b2.view.setX(b2.xOrig);

                // swap texts
                CharSequence t1 = b1.view.getText();
                CharSequence t2 = b2.view.getText();
                b1.view.setText(t2);
                b2.view.setText(t1);
                h.postDelayed(onComplete, 1);
            }

            @Override
            public void onAnimationCancel(Animator animator) { }

            @Override
            public void onAnimationRepeat(Animator animator) { }
        });
    }
}
