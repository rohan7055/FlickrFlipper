package admybrand.rohanthakur7055.com.flickrflipper.ui.activity;

import android.support.v7.app.AppCompatActivity;

import admybrand.rohanthakur7055.com.flickrflipper.FlickrFlipper;
import admybrand.rohanthakur7055.com.flickrflipper.di.component.ApplicationComponent;

/**
 * Created by rohan on 5/4/2018.
 */

public class BaseActivity extends AppCompatActivity {
    public ApplicationComponent getApplicationComponent(){

        return getFlickrFlipper().getApplicationComponent();

    }

    private FlickrFlipper getFlickrFlipper(){

        return (FlickrFlipper) getApplication();

    }
}
