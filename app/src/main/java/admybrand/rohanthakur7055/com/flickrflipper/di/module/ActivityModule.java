package admybrand.rohanthakur7055.com.flickrflipper.di.module;

import android.app.Activity;
import android.view.LayoutInflater;



import javax.inject.Named;

import admybrand.rohanthakur7055.com.flickrflipper.data.PhotoStreamCloudDataSource;
import admybrand.rohanthakur7055.com.flickrflipper.data.PhotoStreamDataSource;
import admybrand.rohanthakur7055.com.flickrflipper.di.scope.PerActivity;
import admybrand.rohanthakur7055.com.flickrflipper.repository.PhotoStreamRepository;
import admybrand.rohanthakur7055.com.flickrflipper.repository.PhotoStreamRepositoryImpl;
import admybrand.rohanthakur7055.com.flickrflipper.utils.GetPublicPhotoStreamUseCase;
import admybrand.rohanthakur7055.com.flickrflipper.utils.UseCase;
import dagger.Module;
import dagger.Provides;

/**
 * Created by rohan on 5/4/2018.
 */


@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Provide the current activity.
     * @return current activity.
     */
    @Provides @PerActivity
    Activity provideActivity(){

        return activity;

    }

    /**
     * Provides the cloud data source for fetching the public photo stream.
     * @param photoStreamCloudDataSource PhotoStreamCloudDataSource instance.
     * @return PhotoStreamCloudDataSource instance.
     */
    @Provides @PerActivity
    PhotoStreamDataSource provideCloudDataSource(PhotoStreamCloudDataSource photoStreamCloudDataSource){

        return photoStreamCloudDataSource;

    }

    /**
     * Provides the repository implementation for accessing the public photo stream.
     * @param photoStreamRepositoryImpl PhotoStreamRepositoryImpl instance.
     * @return PhotoStreamRepositoryImpl instance.
     */
    @Provides @PerActivity
    PhotoStreamRepository providePhotoStreamRepository(PhotoStreamRepositoryImpl photoStreamRepositoryImpl){

        return photoStreamRepositoryImpl;

    }

    /**
     * Provides use case for fetching public photo stream.
     * @param getPublicPhotoStreamUseCase GetPublicPhotoStreamUseCase instance.
     * @return GetPublicPhotoStreamUseCase instance.
     */
    @Provides @PerActivity @Named("publicPhotoStream")
    UseCase providePublicPhotoStreamUseCase(GetPublicPhotoStreamUseCase getPublicPhotoStreamUseCase){

        return getPublicPhotoStreamUseCase;

    }

    @Provides @PerActivity
    LayoutInflater provideLayoutInflater(){

        return activity.getLayoutInflater();

    }
}
