package com.example.orion;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class userActivity extends AppCompatActivity {

    TextView nameTV;
    ImageView userImage;
    int picId;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        name= getIntent().getStringExtra("name");
        picId= getIntent().getIntExtra("pic",R.drawable.alison);

        nameTV= findViewById(R.id.userTV);
        userImage= findViewById(R.id.userImage);

        nameTV.setText(name);
        userImage.setImageDrawable(getDrawable(picId));
    }
}