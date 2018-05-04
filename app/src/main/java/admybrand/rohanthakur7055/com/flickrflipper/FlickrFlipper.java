package admybrand.rohanthakur7055.com.flickrflipper;

import android.app.Application;

import admybrand.rohanthakur7055.com.flickrflipper.di.component.ApplicationComponent;
import admybrand.rohanthakur7055.com.flickrflipper.di.component.DaggerApplicationComponent;
import admybrand.rohanthakur7055.com.flickrflipper.di.module.ApplicationModule;

/**
 * Created by rohan on 5/4/2018.
 */

public class FlickrFlipper extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        injectApplicationComponent();
    }

    private void injectApplicationComponent() {

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent(){

        return applicationComponent;

    }
}
