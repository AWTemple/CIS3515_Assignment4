package edu.temple.cis3515_assignment4;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

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
        lLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        return lLayout;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        //Similar to the getView method, we'll create a layout, check if
        //converView needs to be created, and then call up the necessary data
        LinearLayout cLayout;
        TextView catView;
        ImageView catImg;

        if (convertView == null)
        {
            cLayout = new LinearLayout(context);
            catImg = new ImageView(context);
            catView = new TextView(context);
            catView.setTextSize(28);
            cLayout.addView(catImg);
            cLayout.addView(catView);
        }
        else
        {
            cLayout = (LinearLayout)convertView;
            catImg = (ImageView)cLayout.getChildAt(0);
            catView = (TextView)cLayout.getChildAt(1);
        }

        catImg.setAdjustViewBounds(true);
        catImg.setMaxHeight(300);

        //Set weight for space distribution
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0,300);
        lp.weight = 1;
        catView.setLayoutParams(lp);
        lp.weight = 1;
        catImg.setLayoutParams(lp);

        catImg.setImageResource(cats.get(position).getImgID());
        catView.setText(cats.get(position).getName());
        catView.setGravity(Gravity.CENTER_VERTICAL);
        catView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        return cLayout;
    }

}
