package admybrand.rohanthakur7055.com.flickrflipper.schedulers;

import javax.inject.Inject;

import rx.Scheduler;
import rx.schedulers.Schedulers;


/**
 * Created by rohan on 5/4/2018.
 */

public class IoExecutor implements BaseExecutor {

    @Inject
    public IoExecutor() {
    }

    @Override
    public Scheduler scheduler() {
        return Schedulers.io();
    }
}
