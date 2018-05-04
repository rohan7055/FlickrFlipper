package admybrand.rohanthakur7055.com.flickrflipper.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rohan on 5/4/2018.
 */

public class PhotoInfoMedia {

    @SerializedName("m")
    private String mediaUrl;

    public PhotoInfoMedia(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }
}
