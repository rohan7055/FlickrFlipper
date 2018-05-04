package admybrand.rohanthakur7055.com.flickrflipper.ui.presenter;


import javax.inject.Inject;
import javax.inject.Named;

import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;
import admybrand.rohanthakur7055.com.flickrflipper.ui.view.PhotoStreamView;
import admybrand.rohanthakur7055.com.flickrflipper.utils.UseCase;
import rx.Subscriber;

/**
 * Created by rohan on 5/4/2018.
 */

public class PhotoStreamPresenter {

    private PhotoStreamView photoStreamView;

    private UseCase useCase;

    @Inject
    public PhotoStreamPresenter(@Named("publicPhotoStream")UseCase useCase) {

        this.useCase = useCase;

    }

    public void onViewAttached(PhotoStreamView photoStreamView){

        this.photoStreamView = photoStreamView;

    }

    public void onViewDetached(){

        useCase.unSubscribe();

    }

    public void getPublicPhotoStream(){

        photoStreamView.showProgressBar();

        useCase.execute(new PhotoStreamSubscriber());

    }

    public void retryLoadingPhotoStream(){

        photoStreamView.showProgressBar();

        useCase.execute(new PhotoStreamSubscriber());

    }

    private final class PhotoStreamSubscriber extends Subscriber<PhotoInfoWrapper> {

        @Override
        public void onCompleted() {

            photoStreamView.hideProgressBar();

        }

        @Override
        public void onError(Throwable e) {

            photoStreamView.hideProgressBar();

            photoStreamView.showError("An error occurred");
        }

        @Override
        public void onNext(PhotoInfoWrapper photoInfoWrapper) {

            photoStreamView.showPhotos(photoInfoWrapper);

        }
    }
}
