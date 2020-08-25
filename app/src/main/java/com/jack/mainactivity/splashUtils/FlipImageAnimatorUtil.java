package com.jack.mainactivity.splashUtils;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

import com.jack.mainactivity.R;
import com.jack.mainactivity.model.CompositionData;

import java.util.List;

public class FlipImageAnimatorUtil {
    public static void start(Activity activity, List<CompositionData> compositionDataList, ImageView imageView) {
        ObjectAnimator animStage1 = (ObjectAnimator) AnimatorInflater.loadAnimator(activity, R.animator.flip_stage_1);
        final ObjectAnimator animStage2 = (ObjectAnimator) AnimatorInflater.loadAnimator(activity, R.animator.flip_stage_2);

        imageView.setImageDrawable(ResourcesCompat.getDrawable(activity.getResources(), compositionDataList.get(0).getCompositionDrawableResIdLight(),null));

        animStage1.setTarget(imageView);
        animStage2.setTarget(imageView);

        animStage1.setDuration(1000);
        animStage2.setDuration(1000);
        animStage1.start();

        animStage1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animStage2.start();
                imageView.setImageDrawable(ResourcesCompat.getDrawable(activity.getResources(), compositionDataList.get(1).getCompositionDrawableResIdLight(),null));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        animStage2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animStage1.start();
                imageView.setImageDrawable(ResourcesCompat.getDrawable(activity.getResources(), compositionDataList.get(0).getCompositionDrawableResIdLight(),null));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private static class AnimatorListener implements Animator.AnimatorListener {

        private ObjectAnimator objectAnimator;
        private ImageView imageView;
        private CompositionData compositionData;
        private Activity activity;

        public AnimatorListener(ObjectAnimator objectAnimator, ImageView imageView, CompositionData compositionData, Activity activity) {
            this.objectAnimator = objectAnimator;
            this.imageView = imageView;
            this.compositionData = compositionData;
            this.activity = activity;
        }

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {
            objectAnimator.start();
            imageView.setImageDrawable(ResourcesCompat.getDrawable(activity.getResources(), compositionData.getCompositionDrawableResIdLight(),null));
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }
}
