package admybrand.rohanthakur7055.com.flickrflipper.schedulers;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;


/**
 * Created by rohan on 5/4/2018.
 */


public class MainThreadScheduler implements BaseScheduler {

    @Inject
    public MainThreadScheduler() {
    }

    @Override
    public Scheduler scheduler() {
        return AndroidSchedulers.mainThread();
    }
}
