package edu.temple.cis3515_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity
{
    //Classwide Declarations
    Spinner spinner;
    ImageView imageView;
    TextView textView;
    int[] catImgArray;
    ArrayList<Cat> catArray;
    public static final String NAME = "edu.temple.cis3515_assignment4.NAME";
    public static final String DESC = "edu.temple.cis3515_assignment4.DESC";
    public static final String IMG = "edu.temple.cis3515_assignment4.IMG";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Selection Activity");

        //Get our Views by ID
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        //Make an ArrayList of Cat Objects
        catArray = new ArrayList<Cat>();
        catArray.add(new Cat("Please Select a Cat:", ""));
        catArray.add(new Cat("Kitten", "I'd give it a Kit-10/10"));
        catArray.add(new Cat("Old Cat", "Aged like a fine feline."));
        catArray.add(new Cat("Fancy Cat", "He landed on his feet."));
        catArray.add(new Cat("Buff Cat", "Meowscular."));
        catArray.add(new Cat("COVID Cat", "Sick as a Dog."));

        //Instantiate array of images to go with
        catImgArray = new int[]{R.drawable.blank, R.drawable.kitten, R.drawable.oldcat,
                                R.drawable.fancycat, R.drawable.buffcat, R.drawable.covidcat};

        //Set Each Cat Object's Image ID
        for(int i = 0; i < catArray.size(); i++)
        {
            catArray.get(i).setImgID(catImgArray[i]);
        }

        //Create one of our custom catAdapters and pass it to our Spinner
        CatAdapter catAdapter = new CatAdapter(this, catArray);
        spinner.setAdapter(catAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    newActivity(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {
                    updateScreen(0);
                }
            });
    }

    private void updateScreen(int position)
    {
        Cat currCat = catArray.get(position);
        imageView.setImageResource(currCat.getImgID());
        textView.setText(currCat.getDesc());
    }

    //Added this for Assignment four:
    //We'll need to launch the new activity when an item is selected

    private void newActivity(int position)
    {
        if(position == 0)
            return; //Deal with Automatically running the blank image

        Cat currCat = catArray.get(position);
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra(NAME, currCat.getName());
        intent.putExtra(DESC, currCat.getDesc());
        intent.putExtra(IMG, currCat.getImgID());
        System.out.println(currCat.getName());
        startActivity(intent);

    }

}
