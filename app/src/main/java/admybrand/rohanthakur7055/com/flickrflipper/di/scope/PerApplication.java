package admybrand.rohanthakur7055.com.flickrflipper.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by rohan on 5/4/2018.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {
}
