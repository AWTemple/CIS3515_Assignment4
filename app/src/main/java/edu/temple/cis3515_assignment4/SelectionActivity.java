package edu.temple.cis3515_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity
{
    //Classwide Declarations
    GridView gridview;
    ImageView imageView;
    TextView textView;
    int[] catImgArray;
    ArrayList<Cat> catArray;
    public static final String NAME = "@string/intent_cat_name";
    public static final String DESC = "@string/intent_cat_desc";
    public static final String IMG = "@string/intent_cat_img";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("@string/app_name");

        //Get our Views by ID
        gridview = findViewById(R.id.gridView);
        textView = findViewById(R.id.prompt);

        //Make an ArrayList of Cat Objects
        catArray = new ArrayList<Cat>();
        catArray.add(new Cat("@string/kitten", "@string/kitten_desc"));
        catArray.add(new Cat("@string/old_cat", "@string/old_cat_desc"));
        catArray.add(new Cat("@string/super_cat", "@string/super_cat_desc"));
        catArray.add(new Cat("@string/fancy_cat", "@string/fancy_cat_desc"));
        catArray.add(new Cat("@string/buff_cat", "@string/buff_cat_desc"));
        catArray.add(new Cat("@string/covid_cat", "@string/covid_cat_desc"));


        //Instantiate array of images to go with
        catImgArray = new int[]{R.drawable.kitten, R.drawable.oldcat, R.drawable.supercat,
                                R.drawable.fancycat, R.drawable.buffcat, R.drawable.covidcat};

        //Set Each Cat Object's Image ID
        for(int i = 0; i < catArray.size(); i++)
        {
            catArray.get(i).setImgID(catImgArray[i]);
        }

        //Create one of our custom catAdapters and pass it to our Spinner
        CatAdapter catAdapter = new CatAdapter(this, catArray);
        gridview.setAdapter(catAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    newActivity(position);
                }

            });
    }

    //Added this for Assignment four:
    //We'll need to launch the new activity when an item is selected

    private void newActivity(int position)
    {
        Cat currCat = catArray.get(position);
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(NAME, currCat.getName());
        intent.putExtra(DESC, currCat.getDesc());
        intent.putExtra(IMG, currCat.getImgID());
        startActivity(intent);

    }

}
