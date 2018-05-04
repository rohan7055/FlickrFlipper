package admybrand.rohanthakur7055.com.flickrflipper.utils;



import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseExecutor;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseScheduler;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by rohan on 5/4/2018.
 */



public abstract class UseCase {

    abstract Observable buildUseCase();

    private final BaseExecutor baseExecutor;

    private final BaseScheduler baseScheduler;

    private Subscription subscription;

    public UseCase(BaseExecutor baseExecutor, BaseScheduler baseScheduler) {
        this.baseExecutor = baseExecutor;
        this.baseScheduler = baseScheduler;
    }

    public void execute(Subscriber subscriber){

        subscription = buildUseCase().subscribeOn(baseExecutor.scheduler())
                .observeOn(baseScheduler.scheduler())
                .subscribe(subscriber);

    }

    public void unSubscribe(){

        if(subscription != null && !subscription.isUnsubscribed()){

            subscription.unsubscribe();

        }

    }
}
