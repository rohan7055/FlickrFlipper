package admybrand.rohanthakur7055.com.flickrflipper.di.component;



import admybrand.rohanthakur7055.com.flickrflipper.FlickrFlipper;
import admybrand.rohanthakur7055.com.flickrflipper.api.FlickrWebService;
import admybrand.rohanthakur7055.com.flickrflipper.di.module.ApplicationModule;
import admybrand.rohanthakur7055.com.flickrflipper.di.scope.PerApplication;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseExecutor;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseScheduler;
import dagger.Component;


/**
 * Created by rohan on 5/4/2018.
 */

@PerApplication
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    FlickrWebService flickerWebService();
    BaseScheduler baseScheduler();
    BaseExecutor baseExecutor();

    void inject(FlickrFlipper flickrFlipper);

}
