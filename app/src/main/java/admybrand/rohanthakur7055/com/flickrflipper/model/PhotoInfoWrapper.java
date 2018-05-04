package admybrand.rohanthakur7055.com.flickrflipper.model;

import java.util.List;

/**
 * Created by rohan on 5/4/2018.
 */

public class PhotoInfoWrapper {

    private List<PhotoInfo> items;

    public List<PhotoInfo> getItems() {
        return items;
    }

    public PhotoInfoWrapper(List<PhotoInfo> items) {
        this.items = items;
    }
}
