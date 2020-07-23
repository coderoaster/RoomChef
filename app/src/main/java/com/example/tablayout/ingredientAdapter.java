package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ingredientAdapter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<ingredient> data = null;
    private LayoutInflater inflater = null;

    public ingredientAdapter(Context mContext, int layout, ArrayList<ingredient> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getSeq();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        TextView tv_name = convertView.findViewById(R.id.tv_ingredient);
        TextView tv_date = convertView.findViewById(R.id.tv_expire);

        tv_name.setText(data.get(position).getName());
        tv_date.setText(data.get(position).getDate());

        return convertView;
    }
}
