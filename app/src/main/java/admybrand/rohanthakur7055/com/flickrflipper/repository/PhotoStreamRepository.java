package admybrand.rohanthakur7055.com.flickrflipper.repository;



import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;
import rx.Observable;

/**
 * Created by rohan on 5/4/2018.
 */


public interface PhotoStreamRepository {

    /**
     * Get observable emitting items in the public photo stream.
     * @return Items from the public photo stream.
     */
    Observable<PhotoInfoWrapper> getPublicPhotoStream();
}
