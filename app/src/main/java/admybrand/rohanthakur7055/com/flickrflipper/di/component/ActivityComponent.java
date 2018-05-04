package admybrand.rohanthakur7055.com.flickrflipper.di.component;


import admybrand.rohanthakur7055.com.flickrflipper.ui.activity.MainActivity;
import admybrand.rohanthakur7055.com.flickrflipper.di.module.ActivityModule;
import admybrand.rohanthakur7055.com.flickrflipper.di.scope.PerActivity;
import dagger.Component;


/**
 * Created by rohan on 5/4/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
