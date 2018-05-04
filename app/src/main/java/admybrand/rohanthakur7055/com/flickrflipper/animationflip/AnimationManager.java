package admybrand.rohanthakur7055.com.flickrflipper.animationflip;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.view.View;


import javax.inject.Inject;

import admybrand.rohanthakur7055.com.flickrflipper.R;

/**
 * Created by rohan on 5/4/2018.
 */
public class AnimationManager {

    private Activity activity;
    AnimatorSet flipOutAnimation;
    AnimatorSet flipInAnimation;

    @Inject
    public AnimationManager(Activity activity) {

        this.activity = activity;
    }

    public void init(){

        flipOutAnimation = (AnimatorSet) AnimatorInflater.loadAnimator(activity, R.animator.flip_out_animator);
        flipInAnimation = (AnimatorSet) AnimatorInflater.loadAnimator(activity, R.animator.flip_in_animator);


    }

    public void setFlipOutAnimationTarget(View view){

        if(flipOutAnimation.isRunning()){

            flipOutAnimation.end();
        }

        flipOutAnimation.setTarget(view);


    }

    public void setFlipInAnimationTarget(View view){

        if(flipInAnimation.isRunning()){

            flipInAnimation.end();
        }

        flipInAnimation.setTarget(view);

    }

    public void startAnimations(){

        flipOutAnimation.start();
        flipInAnimation.start();

    }

}
