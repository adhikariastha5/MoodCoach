package com.example.astha.moodcoach;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class imagebth extends AppCompatActivity implements View.OnClickListener {
    ImageButton happybtn,sadbtn,angbtn,fearbtn,boredbtn,neutralbtn;
    Button proceedbtn;

    String[] sad = {"6S9E0MVteEc", "DdHB7V6sGFo", "K8BGkoJv6gg", "TLoDa3d6rCk"};
    String[] happy = {"_R6R62qUgIs", "nb6B2lzUqMI", "R7iN71uJcG0", "EUoKyjBIoE8"};
    String[] fear = {"SUEK9Sab4Vs", "VQXyYumRXUk", "ztkmSCsrD80", "2cYoQQDOOgU"};
    String[] bored = {"zjFvdA4eDrw", "xzDPbrrTQys", "UGPxfizP1aI", "7dcc1LXx64s"};
    String[] angry = {"3J-cYxxHQGQ", "LNyJgNjCDuU", "VaoV1PrYft4", "fQNFMxYxFSQ"};
    String[] neutral={"R7iN71uJcG0","7dcc1LXx64s","2cYoQQDOOgU"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebth);

        proceedbtn=(Button) findViewById(R.id.proceed);
        happybtn=(ImageButton) findViewById(R.id.happiness);
        sadbtn=(ImageButton) findViewById(R.id.sadness);
        angbtn=(ImageButton) findViewById(R.id.anger);
        fearbtn=(ImageButton) findViewById(R.id.fear);
        boredbtn=(ImageButton) findViewById(R.id.boredom);
        neutralbtn=(ImageButton) findViewById(R.id.neutral);

        proceedbtn.setOnClickListener(this);
        happybtn.setOnClickListener(this);
        sadbtn.setOnClickListener(this);
        fearbtn.setOnClickListener(this);
        boredbtn.setOnClickListener(this);
        angbtn.setOnClickListener(this);
        neutralbtn.setOnClickListener(this);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


    }

    public void onClick(View V){
        if(V.getId()==R.id.proceed){
            Intent i = new Intent(imagebth.this, MainActivity.class);
            startActivity(i);
        }else if (V.getId() == R.id.happiness) {
            startActivity(new Intent(imagebth.this,happy.class));
        } else if (V.getId() == R.id.sadness) {
                startActivity(new Intent(imagebth.this,activity_sadwork.class));
        } else if (V.getId() == R.id.boredom) {
                startActivity(new Intent(imagebth.this,happy.class));
        } else if (V.getId() == R.id.anger) {
                startActivity(new Intent(imagebth.this,anger.class));
        } else if (V.getId() == R.id.fear) {
                startActivity(new Intent(imagebth.this,fear.class));
        } else if (V.getId() == R.id.neutral) {
                startActivity(new Intent(imagebth.this,neutral.class));
        }

    }

}
