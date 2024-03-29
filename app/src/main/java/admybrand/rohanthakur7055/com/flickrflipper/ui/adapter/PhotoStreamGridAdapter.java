package admybrand.rohanthakur7055.com.flickrflipper.ui.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import admybrand.rohanthakur7055.com.flickrflipper.R;
import admybrand.rohanthakur7055.com.flickrflipper.model.PhotoInfo;

/**
 * Created by rohan on 5/4/2018.
 */
public class PhotoStreamGridAdapter extends BaseAdapter {

    private List<PhotoInfo> photoInfoList = new ArrayList<>();

    private LayoutInflater layoutInflater;

    private Activity activity;

    @Inject
    public PhotoStreamGridAdapter(Activity activity, LayoutInflater layoutInflater) {

        this.activity = activity;

        this.layoutInflater = layoutInflater;

    }

    public void updateDataSet(List<PhotoInfo> photoInfoList){

        this.photoInfoList.addAll(photoInfoList);

        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return photoInfoList.size();
    }

    @Override
    public Object getItem(int i) {
        return photoInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final PhotoStreamViewHolder photoStreamViewHolder;

        if(view == null){

            view = layoutInflater.inflate(R.layout.cardview_photo, viewGroup, false);

            photoStreamViewHolder = new PhotoStreamViewHolder();

            photoStreamViewHolder.frontView = (ImageView) view.findViewById(R.id.cardview_photoFrontView);

            photoStreamViewHolder.backView = (RelativeLayout) view.findViewById(R.id.cardview_photoBackView);

            photoStreamViewHolder.backViewPhotoTitle = (TextView) view.findViewById(R.id.cardview_photoTitle);

            photoStreamViewHolder.backViewPhotoDimens = (TextView) view.findViewById(R.id.cardview_photoDimens);

            view.setTag(photoStreamViewHolder);

        }else{

            photoStreamViewHolder = (PhotoStreamViewHolder) view.getTag();

        }

        final PhotoInfo photoInfo = (PhotoInfo) getItem(i);

        if(photoInfo.getVisibleSide() == null || photoInfo.getVisibleSide() == PhotoInfo.Side.FRONT){

            setViewAlpha(0, photoStreamViewHolder.backView);
            setViewRotationY(-180, photoStreamViewHolder.backView);

            setViewAlpha(1.0f, photoStreamViewHolder.frontView);
            setViewRotationY(0, photoStreamViewHolder.frontView);

        }else{

            setViewAlpha(1.0f, photoStreamViewHolder.backView);
            setViewRotationY(0, photoStreamViewHolder.backView);

            setViewAlpha(0.0f, photoStreamViewHolder.frontView);
            setViewRotationY(180, photoStreamViewHolder.frontView);


        }

        //load the image with picasso.
        Picasso.with(activity).load(photoInfo.getMedia().getMediaUrl()).placeholder(android.R.color.darker_gray).fit().into(photoStreamViewHolder.frontView);

        photoStreamViewHolder.backViewPhotoTitle.setText(photoInfo.getTitle());

        photoStreamViewHolder.backViewPhotoDimens.setText(photoInfo.getPhotoMetaData().getWidth() + "X"
                + photoInfo.getPhotoMetaData().getHeight());

        return view;
    }

    private void setViewAlpha(float alpha, View view) {

        view.setAlpha(alpha);

    }

    private void setViewRotationY(int rotationAngle, View view){

        view.setRotationY(rotationAngle);

    }


    public static class PhotoStreamViewHolder{

        public ImageView frontView;
        public RelativeLayout backView;
        TextView backViewPhotoTitle;
        TextView backViewPhotoDimens;

    }
}
