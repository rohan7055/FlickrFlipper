package admybrand.rohanthakur7055.com.flickrflipper.data;



import javax.inject.Inject;

import admybrand.rohanthakur7055.com.flickrflipper.api.FlickrWebService;
import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;
import rx.Observable;


/**
 * Created by rohan on 5/4/2018.
 */

public class PhotoStreamCloudDataSource implements PhotoStreamDataSource {

    private FlickrWebService flickrWebService;

    @Inject
    public PhotoStreamCloudDataSource(FlickrWebService flickrWebService) {
        this.flickrWebService = flickrWebService;
    }

    @Override
    public Observable<PhotoInfoWrapper> getPublicPhotoStream() {

        return flickrWebService.getPublicPhotoStream();

    }
}
