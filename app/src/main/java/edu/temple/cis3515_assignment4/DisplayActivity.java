package edu.temple.cis3515_assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    //we'll pretty much integrate the code from our first activity:

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        // Get the Intent that started this activity and extract the strings
        Intent intent = getIntent();
        String name = intent.getStringExtra(SelectionActivity.NAME);
        String desc = intent.getStringExtra(SelectionActivity.DESC);
        int imgID = intent.getIntExtra(SelectionActivity.IMG, 0);

        //Update the layout's views
        TextView nameView = findViewById(R.id.nameView);
        nameView.setText(name);
        TextView descView = findViewById(R.id.descView);
        descView.setText(desc);
        ImageView imgView = findViewById(R.id.catImg);
        imgView.setImageResource(imgID);

    }
}
