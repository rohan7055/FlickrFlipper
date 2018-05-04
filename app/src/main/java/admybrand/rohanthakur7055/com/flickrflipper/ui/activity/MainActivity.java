package admybrand.rohanthakur7055.com.flickrflipper.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import javax.inject.Inject;

import admybrand.rohanthakur7055.com.flickrflipper.R;
import admybrand.rohanthakur7055.com.flickrflipper.animationflip.AnimationManager;
import admybrand.rohanthakur7055.com.flickrflipper.di.component.ActivityComponent;
import admybrand.rohanthakur7055.com.flickrflipper.di.component.DaggerActivityComponent;
import admybrand.rohanthakur7055.com.flickrflipper.di.module.ActivityModule;
import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfo;
import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfoWrapper;
import admybrand.rohanthakur7055.com.flickrflipper.ui.adapter.PhotoStreamGridAdapter;
import admybrand.rohanthakur7055.com.flickrflipper.ui.presenter.PhotoStreamPresenter;
import admybrand.rohanthakur7055.com.flickrflipper.ui.view.PhotoStreamView;

/**
 * Created by rohan on 5/4/2018.
 */


public class MainActivity  extends BaseActivity implements PhotoStreamView, AdapterView.OnItemClickListener {

    private GridView photoStreamGridView;
    private ProgressBar progressBar;

    @Inject
    PhotoStreamPresenter photoStreamPresenter;

    @Inject
    PhotoStreamGridAdapter photoStreamGridAdapter;

    @Inject
    public AnimationManager animationManager;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        injectDependencies();

        setupPresenter();

        setupAdapter();

        initAnimationManager();

        fetchPublicPhotoStream();

        setGridViewClickListener();
    }

    private void setupViews() {

        photoStreamGridView = (GridView) findViewById(R.id.photoStreamGridView);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    private void injectDependencies() {

        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();

        activityComponent.inject(this);

    }


    private void setupPresenter() {

        photoStreamPresenter.onViewAttached(this);

    }

    private void setupAdapter() {

        photoStreamGridView.setAdapter(photoStreamGridAdapter);

    }


    private void initAnimationManager() {

        animationManager.init();

    }


    private void fetchPublicPhotoStream() {

        photoStreamPresenter.getPublicPhotoStream();

    }


    private void setGridViewClickListener() {

        photoStreamGridView.setOnItemClickListener(this);

    }




    @Override
    public void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {

        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showPhotos(PhotoInfoWrapper photoInfoWrapper) {

        photoStreamGridAdapter.updateDataSet(photoInfoWrapper.getItems());

    }

    @Override
    public void showError(String message) {

        Snackbar.make(photoStreamGridView, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        photoStreamPresenter.retryLoadingPhotoStream();

                    }
                })
                .show();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        PhotoInfo photoInfo = (PhotoInfo) photoStreamGridAdapter.getItem(i);

        PhotoStreamGridAdapter.PhotoStreamViewHolder holder = (PhotoStreamGridAdapter.PhotoStreamViewHolder) view.getTag();

        animateViews(photoInfo, holder.frontView, holder.backView);
    }


    private void animateViews(PhotoInfo photoInfo, ImageView frontView, View backView) {

        if(photoInfo.getVisibleSide() == PhotoInfo.Side.FRONT || photoInfo.getVisibleSide() == null){

            animationManager.setFlipOutAnimationTarget(frontView);
            animationManager.setFlipInAnimationTarget(backView);

            photoInfo.setVisibleSide(PhotoInfo.Side.BACK);

        }else{

            animationManager.setFlipOutAnimationTarget(backView);
            animationManager.setFlipInAnimationTarget(frontView);

            photoInfo.setVisibleSide(PhotoInfo.Side.FRONT);

        }

        animationManager.startAnimations();
    }
}
