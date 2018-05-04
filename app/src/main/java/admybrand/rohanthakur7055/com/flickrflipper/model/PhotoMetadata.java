package admybrand.rohanthakur7055.com.flickrflipper.model;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

/**
 * Created by rohan on 5/4/2018.
 */

public class PhotoMetadata {

    private String width;
    private String height;


    public PhotoMetadata(String html){

        Elements elements = Jsoup.parse(html).select("img");

        width = elements.attr("width");

        height = elements.attr("height");

    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }
}
