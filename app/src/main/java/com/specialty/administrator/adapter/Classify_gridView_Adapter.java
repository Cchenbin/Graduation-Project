package com.specialty.administrator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.specialty.administrator.specialty.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈彬 on 2018/1/3.
 */

public class Classify_gridView_Adapter extends BaseAdapter {
    private Context context;
    private List<Picture> pictures = new ArrayList<>();
    private LayoutInflater inflater;

    public Classify_gridView_Adapter(String[] titles, Integer[] images, Context context) {
        super();
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        for (int i = 0; i < images.length; i++) {
            Picture picture = new Picture(titles[i], images[i]);
            pictures.add(picture);
        }
    }

    @Override
    public int getCount() {
        if (null != pictures) {
            return pictures.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return pictures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = inflater.inflate(R.layout.classify_gridview_item, null);
            holder.image = view.findViewById(R.id.classify_image);
            holder.title = view.findViewById(R.id.classify_title);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        Picture picture = pictures.get(position);
        holder.image.setImageResource(picture.getImageId());
        holder.title.setText(picture.getTitle());

        return view;
    }

    private class Holder {
        public TextView title;
        public ImageView image;
    }

    private class Picture {

        private String title;
        private int imageId;

        public Picture(String title, Integer imageId) {
            this.imageId = imageId;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public int getImageId() {
            return imageId;
        }

    }
}
