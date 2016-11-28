package com.cjj.mousepaint.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cjj.mousepaint.R;
import com.cjj.mousepaint.model.CategoryModel;
import com.cjj.mousepaint.utils.ViewHolderUtils;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2015/11/3.
 */
public class CategoryDetialAdapter extends BaseAdapter {

    private Activity context;
    private List<CategoryModel.ReturnEntity.ListEntity> list;
    private ViewHolder mHolder;
    private int selectIndex = 0;

    public CategoryDetialAdapter(Activity context, List<CategoryModel.ReturnEntity.ListEntity> list) {
        this.context = context;
        this.list = list;
    }

    public void  updateData(List<CategoryModel.ReturnEntity.ListEntity> list)
    {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CategoryModel.ReturnEntity.ListEntity getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if( convertView == null )
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category_detial,null);
            mHolder = new ViewHolder();
            mHolder.tv_comic_title = (TextView) convertView.findViewById(R.id.tv_comic_title);
            mHolder.tv_comic_intro = (TextView) convertView.findViewById(R.id.tv_comic_intro);
            mHolder.tv_num_last = (TextView) convertView.findViewById(R.id.tv_num_last);
            mHolder.tv_comic_status = (TextView) convertView.findViewById(R.id.tv_comic_status);
            mHolder.iv_zone_item = (ImageView) convertView.findViewById(R.id.iv_zone_item);
            convertView.setTag(mHolder);
        }
        else
            mHolder = (ViewHolder) convertView.getTag();

//        mHolder = new ViewHolder();
//        convertView = ViewHolderUtils.loadingConvertView(parent.getContext(), convertView, R.layout.item_category_detial, ViewHolder.class);
//        mHolder = (ViewHolder) convertView.getTag();
        mHolder.tv_comic_title.setText(list.get(position).Title);
        mHolder.tv_comic_intro.setText(list.get(position).Explain);
        mHolder.tv_num_last.setText(list.get(position).Author);
        if(null != list.get(position).LastChapter&& !"null".equals(list.get(position).LastChapter.ChapterNo))
        mHolder.tv_comic_status.setText(list.get(position).LastChapter.ChapterNo+" 话");
        Glide.with(context).load(list.get(position).FrontCover).centerCrop().into(mHolder.iv_zone_item);
        return convertView;
    }



    public static class ViewHolder {
        public ImageView iv_zone_item;
        public TextView tv_comic_title,tv_comic_intro,tv_num_last,tv_comic_status;
    }
}
