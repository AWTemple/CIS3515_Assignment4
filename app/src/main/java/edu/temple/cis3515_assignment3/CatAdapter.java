package edu.temple.cis3515_assignment3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        LinearLayout linearLayout;

        TextView catView;

        //Just like in the sample code from class, we check if convertview is null
        //If it is, we create a new CatView and set its attributes
        if (convertView == null)
        {
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            catView = new TextView(context);
            catView.setTextSize(28);
            linearLayout.addView(catView);
        }
        //Otherwise we convert the... convertView
        else
        {
            linearLayout = (LinearLayout) convertView;
            catView = (TextView) linearLayout.getChildAt(0);
        }

        catView.setText(cats.get(position).getName());

        return linearLayout;
    }

}
