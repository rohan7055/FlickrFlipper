package admybrand.rohanthakur7055.com.flickrflipper.di.module;

import android.app.Application;


import admybrand.rohanthakur7055.com.flickrflipper.api.FlickrWebService;
import admybrand.rohanthakur7055.com.flickrflipper.di.scope.PerApplication;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseExecutor;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.BaseScheduler;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.IoExecutor;
import admybrand.rohanthakur7055.com.flickrflipper.schedulers.MainThreadScheduler;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rohan on 5/4/2018.
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application){

        this.application = application;

    }

    /**
     * Provides the current application.
     * @return Current application instance.
     */
    @Provides @PerApplication
    Application provideApplication(){

        return application;

    }

    /**
     * Provides a single instance of OkHttpClient throughout the application.
     * @return Instance of OkHttpClient.
     */
    @Provides @PerApplication
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }

    /**
     * Provides a single instance of GSON converter factory required by retrofit to map JSON string to JAVA objects.
     * @return Instance of GSONConverterFactory.
     */
    @Provides @PerApplication
    Converter.Factory provideGSONConverterFactory(){
        return GsonConverterFactory.create();
    }

    /**
     * Provides a single instance of RxJavaCallAdapterFactory needed by retrofit to return Observables.
     * @return RxJavaCallAdapterFactory instance.
     */
    @Provides @PerApplication
    CallAdapter.Factory provideRxCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    /**
     * Provides a single instance of Retrofit to be used throughout the application.
     * @param okHttpClient OkHttpClient instance.
     * @param converterFactory ConverterFactory instance.
     * @param callAdapterFactory CallAdapterFactory instance.
     * @return Retrofit instance.
     */
    @Provides @PerApplication
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Converter.Factory converterFactory, CallAdapter.Factory callAdapterFactory){
        return new Retrofit.Builder()
                .baseUrl(FlickrWebService.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

    /**
     * Provide flickr web service instance for interacting with the flickr api.
     * @param retrofit Retrofit instance.
     * @return Flickr Webservice instance.
     */
    @Provides @PerApplication
    FlickrWebService provideFlickrWebService(Retrofit retrofit){

        return retrofit.create(FlickrWebService.class);

    }

    /**
     * Provides a schedulers for performing tasks on the io thread.
     * @param ioExecutor IoScheduler instance.
     * @return IoScheduler instance.
     */
    @Provides @PerApplication
    BaseExecutor provideExecutionScheduler(IoExecutor ioExecutor){

        return ioExecutor;

    }

    /**
     * Provides a scheduler for performing tasks on the main thread.
     * @param mainThreadScheduler MainThreadScheduler instance.
     * @return MainThreadScheduler instance.
     */
    @Provides @PerApplication
    BaseScheduler provideMainThreadScheduler(MainThreadScheduler mainThreadScheduler){

        return mainThreadScheduler;

    }

}
