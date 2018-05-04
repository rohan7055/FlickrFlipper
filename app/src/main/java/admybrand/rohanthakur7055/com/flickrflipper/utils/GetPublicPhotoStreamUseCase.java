package admybrand.rohanthakur7055.com.flickrflipper.utils;



import javax.inject.Inject;

import admybrand.rohanthakur7055.com.flickrflipper.repository.PhotoStreamRepository;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseExecutor;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseScheduler;
import rx.Observable;

/**
 * Created by rohan on 5/4/2018.
 */


public class GetPublicPhotoStreamUseCase extends UseCase {

    private PhotoStreamRepository photoStreamRepository;

    @Inject
    public GetPublicPhotoStreamUseCase(PhotoStreamRepository photoStreamRepository,
                                       BaseExecutor baseExecutor, BaseScheduler baseScheduler) {
        super(baseExecutor, baseScheduler);

        this.photoStreamRepository = photoStreamRepository;
    }

    @Override
    Observable buildUseCase() {

        return photoStreamRepository.getPublicPhotoStream();

    }
}
