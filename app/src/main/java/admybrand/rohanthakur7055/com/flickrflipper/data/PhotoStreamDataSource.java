package admybrand.rohanthakur7055.com.flickrflipper.data;


import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;
import rx.Observable;

/**
 * Created by rohan on 5/4/2018.
 */


public interface PhotoStreamDataSource {

    /**
     * Get observable emitting items in the public photo stream.
     * @return Items from the public photo stream.
     */
    Observable<PhotoInfoWrapper> getPublicPhotoStream();
}
