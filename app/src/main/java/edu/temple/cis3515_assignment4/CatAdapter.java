package edu.temple.cis3515_assignment4;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CatAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Cat> cats;
    LayoutInflater inflater;

    public CatAdapter (Context context, ArrayList cats)
    {
        this.context = context;
        this.cats = cats;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return cats.size();
    }

    @Override
    public Object getItem(int position)
    {
        return cats.get(position);
    }

    //Must be implemented, though we don't use it
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //Inflate the convertView from the gridview_layout file
        convertView = inflater.inflate(R.layout.gridview_layout, null);

        //Prep the Image
        ImageView catImg = convertView.findViewById(R.id.catimg);
        catImg.setImageResource(cats.get(position).getImgID());

        //Prep the text
        TextView catText = convertView.findViewById(R.id.cattext);
        catText.setText(cats.get(position).getName());

        return convertView;
    }

}
