package admybrand.rohanthakur7055.com.flickrflipper.ui.view;


import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;

/**
 * Created by rohan on 5/4/2018.
 */
public interface PhotoStreamView {

    void showProgressBar();

    void hideProgressBar();

    void showPhotos(PhotoInfoWrapper photoInfoWrapper);

    void showError(String message);
}
