package edu.temple.cis3515_assignment3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class CatAdapter extends BaseAdapter implements SpinnerAdapter
{
    Context context;
    ArrayList<Cat> cats;

    public CatAdapter (Context context, ArrayList cats)
    {
        this.context = context;
        this.cats = cats;
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
        //Similar to the getView method, we'll create a layout, check if
        //converView needs to be created, and then call up the necessary data
        LinearLayout lLayout;
        TextView catView;
        ImageView catImg;

        if (convertView == null)
        {
            lLayout = new LinearLayout(context);
            catView = new TextView(context);
            catView.setTextSize(28);
            lLayout.addView(catView);
        }
        else
        {
            lLayout = (LinearLayout)convertView;
            catView = (TextView)lLayout.getChildAt(1);
        }

        catView.setText(cats.get(position).getName());

        return lLayout;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        //Similar to the getView method, we'll create a layout, check if
        //converView needs to be created, and then call up the necessary data
        ConstraintLayout cLayout;
        TextView catView;
        ImageView catImg;

        if (convertView == null)
        {
            cLayout = new ConstraintLayout(context);
            catImg = new ImageView(context);
            catView = new TextView(context);
            catView.setTextSize(28);
            cLayout.addView(catImg);
            cLayout.addView(catView);
        }
        else
        {
            cLayout = (ConstraintLayout)convertView;
            catImg = (ImageView)cLayout.getChildAt(0);
            catView = (TextView)cLayout.getChildAt(1);
        }

        catImg.setAdjustViewBounds(true);
        catImg.setMaxWidth(150);
        catImg.setImageResource(cats.get(position).getImgID());
        catView.setText(cats.get(position).getName());

        return cLayout;
    }

}
