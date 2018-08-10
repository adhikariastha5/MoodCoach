package com.example.astha.moodcoach;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fetchedData extends AppCompatActivity implements View.OnClickListener {
    String t1 = "";
    String resp, two;
    TextView fetch, disp, disp2;
    Button btnYes,save,view,dispChart;
    Button work, rship, finance, education;
    DatabaseHelper myDb;

    String[] sad = {"6S9E0MVteEc", "DdHB7V6sGFo", "K8BGkoJv6gg", "TLoDa3d6rCk"};
    String[] happy = {"_R6R62qUgIs", "nb6B2lzUqMI", "R7iN71uJcG0", "EUoKyjBIoE8"};
    String[] fear = {"SUEK9Sab4Vs", "VQXyYumRXUk", "ztkmSCsrD80", "2cYoQQDOOgU"};
    String[] bored = {"ynvmecumJMg", "xzDPbrrTQys", "UGPxfizP1aI", "7dcc1LXx64s"};
    String[] angry = {"3J-cYxxHQGQ", "LNyJgNjCDuU", "VaoV1PrYft4", "fQNFMxYxFSQ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetched_data2);
        myDb = new DatabaseHelper(this);

        fetch = (TextView) findViewById(R.id.fetchOne);
        disp = (TextView) findViewById(R.id.disp);
        disp2 = (TextView) findViewById(R.id.disp2);
        view=(Button) findViewById(R.id.view);
        dispChart=(Button) findViewById(R.id.chart);
        //btnYes=(Button) findViewById(R.id.yes);
        //btnYes.setOnClickListener(this);
        work = (Button) findViewById(R.id.work);
        save=(Button) findViewById(R.id.save);
        rship = (Button) findViewById(R.id.relationship);
        finance = (Button) findViewById(R.id.finance);
        education = (Button) findViewById(R.id.education);
        save.setOnClickListener(this);
        view.setOnClickListener(this);
        work.setOnClickListener(this);
        rship.setOnClickListener(this);
        education.setOnClickListener(this);
        finance.setOnClickListener(this);


        fetchingData();
    }

    void fetchingData() {

        final String URL = "http://7780a6c7.ngrok.io/predict";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                resp = response.toString();
                two = resp.substring(2, resp.length() - 2);

                //Log.d("val", response.toString());

                //disp.setText("Seems like you are ");
                fetch.setText(two);
                //disp2.setText("is it because of any of the following reasons?");


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Volley Log", error);
            }
        }
        );
        com.example.astha.moodcoach.AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        //Toast.makeText(getApplicationContext(),"Data Loaded Succesfully!",Toast.LENGTH_SHORT).show();
    }

    public void onClick(View V) {
        if (V.getId() == R.id.save) {
            boolean isInserted = myDb.insertData(two);

        }else if(V.getId()==R.id.view){
            viewall();
        }else if(V.getId()==R.id.chart){
            goGraph();

            /*Intent i=new Intent(fetchedData.this,graphActivity.class);
            startActivity(i);*/
        }
        else {

            Intent i = new Intent(fetchedData.this, YTplayer.class);

            Log.d("id", two + " " + String.valueOf(V.getId()));
            if (V.getId() == R.id.work) {

            }
            if (V.getId() == R.id.work) {
                if (two.equalsIgnoreCase("happy"))
                    i.putExtra("vidid", happy[0]);
                else if (two.equalsIgnoreCase("sad"))
                    i.putExtra("vidid", sad[0]);
                else if (two.equalsIgnoreCase("angry"))
                    i.putExtra("vidid", angry[0]);
                else if (two.equalsIgnoreCase("bored"))
                    i.putExtra("vidid", bored[0]);
                else if (two.equalsIgnoreCase("fear"))
                    i.putExtra("vidid", fear[0]);


            } else if (V.getId() == R.id.relationship) {
                if (two.equalsIgnoreCase("happy"))
                    i.putExtra("vidid", happy[1]);
                    //happy[0].split(",")
                else if (two.equalsIgnoreCase("sad"))
                    i.putExtra("vidid", sad[1]);
                else if (two.equalsIgnoreCase("angry"))
                    i.putExtra("vidid", angry[1]);
                else if (two.equalsIgnoreCase("bored"))
                    i.putExtra("vidid", bored[1]);
                else if (two.equalsIgnoreCase("fear"))
                    i.putExtra("vidid", fear[1]);


            } else if (V.getId() == R.id.finance) {
                if (two.equalsIgnoreCase("happy"))
                    i.putExtra("vidid", happy[2]);
                else if (two.equalsIgnoreCase("sad"))
                    i.putExtra("vidid", sad[2]);
                else if (two.equalsIgnoreCase("angry"))
                    i.putExtra("vidid", angry[2]);
                else if (two.equalsIgnoreCase("bored"))
                    i.putExtra("vidid", bored[2]);
                else if (two.equalsIgnoreCase("fear"))
                    i.putExtra("vidid", fear[2]);

            } else if (V.getId() == R.id.education) {
                if (two.equalsIgnoreCase("happy"))
                    i.putExtra("vidid", happy[3]);
                else if (two.equalsIgnoreCase("sad"))
                    i.putExtra("vidid", sad[3]);
                else if (two.equalsIgnoreCase("angry"))
                    i.putExtra("vidid", angry[3]);
                else if (two.equalsIgnoreCase("bored"))
                    i.putExtra("vidid", bored[3]);
                else if (two.equalsIgnoreCase("fear"))
                    i.putExtra("vidid", fear[3]);


            }
            //i.putExtra("force_fullscreen",true);
            startActivity(i);
        }

    }
    public void goGraph(){
        Intent i=new Intent(fetchedData.this,graphActivity.class);
        startActivity(i);
    }
    public void viewall(){
        Cursor res=myDb.getAllData();
        if(res.getCount()==0){
            //show message
            showMessage("ERROR","Nothing found");
            return;
        }

        StringBuffer buffer=new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID :"+res.getString(0)+"\n");
            buffer.append("MOOD :"+res.getString(1)+"\n\n");
        }
        //show all data
        showMessage("Data",buffer.toString());
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
