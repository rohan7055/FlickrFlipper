package admybrand.rohanthakur7055.com.flickrflipper.repository;


import javax.inject.Inject;

import admybrand.rohanthakur7055.com.flickrflipper.data.PhotoStreamDataSource;
import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;
import rx.Observable;

/**
 * Created by rohan on 5/4/2018.
 */

public class PhotoStreamRepositoryImpl implements PhotoStreamRepository {

    private PhotoStreamDataSource photoStreamDataSource;

    @Inject
    public PhotoStreamRepositoryImpl(PhotoStreamDataSource photoStreamDataSource) {
        this.photoStreamDataSource = photoStreamDataSource;
    }

    @Override
    public Observable<PhotoInfoWrapper> getPublicPhotoStream() {

        return photoStreamDataSource.getPublicPhotoStream();

    }
}
