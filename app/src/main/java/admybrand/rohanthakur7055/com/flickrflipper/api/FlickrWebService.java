package admybrand.rohanthakur7055.com.flickrflipper.api;


import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by rohan on 5/4/2018.
 */

public interface FlickrWebService {

    String BASE_URL = "https://api.flickr.com/";

    @GET("services/feeds/photos_public.gne?format=json&nojsoncallback=1")
    Observable<PhotoInfoWrapper> getPublicPhotoStream();
}
