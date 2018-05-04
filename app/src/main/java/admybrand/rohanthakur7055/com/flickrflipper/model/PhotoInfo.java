package admybrand.rohanthakur7055.com.flickrflipper.model;

/**
 * Created by rohan on 5/4/2018.
 */
public class PhotoInfo {

    public enum Side{

        FRONT, BACK

    }

    private String title;
    private String link;
    private PhotoInfoMedia media;
    private String description;
    private PhotoMetadata photoMetadata;
    private Side visibleSide = Side.FRONT;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public PhotoInfoMedia getMedia() {
        return media;
    }

    public String getDescription() {
        return description;
    }

    public Side getVisibleSide() {
        return visibleSide;
    }

    public void setVisibleSide(Side visibleSide) {
        this.visibleSide = visibleSide;
    }

    public PhotoMetadata getPhotoMetaData(){

        if(photoMetadata == null){

            photoMetadata = new PhotoMetadata(description);

        }

        return photoMetadata;

    }

    public PhotoInfo(String title, String link, PhotoInfoMedia media, String description) {
        this.title = title;
        this.link = link;
        this.media = media;
        this.description = description;
    }
}
