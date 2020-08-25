package com.jack.mainactivity.demo;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.jack.mainactivity.MainActivity;
import com.jack.mainactivity.R;
import com.jack.mainactivity.databinding.ActivityMainBinding;

public class Demo {
    public void show(ActivityMainBinding activityMainBinding, Activity activity) {
        new ShowcaseView.Builder(activity)
                .setTarget(new ViewTarget(R.id.swipe_left, activity))
                .setContentTitle("Composition Pattern")
                .setContentText("Swipe left to show previous Composition Pattern")
                .hideOnTouchOutside()
                .setShowcaseEventListener(new OnShowcaseEventListener() {
                    @Override
                    public void onShowcaseViewHide(ShowcaseView showcaseView) {
                        new ShowcaseView.Builder(activity)
                                .setTarget(new ViewTarget(R.id.swipe_right, activity))
                                .setContentTitle("Composition Pattern")
                                .setContentText("Swipe right to show previous Composition Pattern")
                                .hideOnTouchOutside()
                                .setShowcaseEventListener(new OnShowcaseEventListener() {
                                    @Override
                                    public void onShowcaseViewHide(ShowcaseView showcaseView) {
                                        new ShowcaseView.Builder(activity)
                                                .setTarget(new ViewTarget(R.id.swipe_up, activity))
                                                .setContentTitle("Composition Pattern")
                                                .setContentText("Swipe up to change color of composition frame")
                                                .hideOnTouchOutside()
                                                .setShowcaseEventListener(new OnShowcaseEventListener() {
                                                    @Override
                                                    public void onShowcaseViewHide(ShowcaseView showcaseView) {
                                                        new ShowcaseView.Builder(activity)
                                                                .setTarget(new ViewTarget(R.id.swipe_down, activity))
                                                                .setContentTitle("Composition Pattern")
                                                                .setContentText("Swipe down to change color of composition frame")
                                                                .hideOnTouchOutside()
                                                                .setShowcaseEventListener(new OnShowcaseEventListener() {
                                                                    @Override
                                                                    public void onShowcaseViewHide(ShowcaseView showcaseView) {
                                                                        activity.finish();
                                                                    }

                                                                    @Override
                                                                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                                                                    }

                                                                    @Override
                                                                    public void onShowcaseViewShow(ShowcaseView showcaseView) {

                                                                    }

                                                                    @Override
                                                                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

                                                                    }
                                                                })
                                                                .build();
                                                    }

                                                    @Override
                                                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                                                    }

                                                    @Override
                                                    public void onShowcaseViewShow(ShowcaseView showcaseView) {

                                                    }

                                                    @Override
                                                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

                                                    }
                                                })
                                                .build();
                                    }

                                    @Override
                                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                                    }

                                    @Override
                                    public void onShowcaseViewShow(ShowcaseView showcaseView) {

                                    }

                                    @Override
                                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

                                    }
                                })
                                .build();
                    }

                    @Override
                    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewShow(ShowcaseView showcaseView) {

                    }

                    @Override
                    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

                    }
                })
                .build();
    }
}
