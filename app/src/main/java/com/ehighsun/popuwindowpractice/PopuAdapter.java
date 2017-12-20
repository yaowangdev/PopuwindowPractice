package com.ehighsun.popuwindowpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19 0019.
 */

public class PopuAdapter extends BaseAdapter {
    private List<Species> mList;
    private Context mContext;
    private LayoutInflater inflater;

    public PopuAdapter(List<Species> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView= inflater.inflate(R.layout.popu_item,parent,false);
            holder.ivImage = convertView.findViewById(R.id.iv_popumenu_img);
            holder.tvText = convertView.findViewById(R.id.tv_popumenu_text);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ivImage.setImageBitmap(mList.get(position).getBm());
        holder.tvText.setText(mList.get(position).getName());
        return convertView;
    }

    class ViewHolder{
        ImageView ivImage;
        TextView tvText;
    }
}
