package com.example.sharedpreferencecolorchoose;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button redBtn, greenBtn, blueBtn;

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBtn = (Button) findViewById(R.id.redId);
        blueBtn = (Button) findViewById(R.id.blueId);
        greenBtn = (Button) findViewById(R.id.greenId);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutId);

        if(getBgColor() != getResources().getColor(R.color.colorPrimary)){

            linearLayout.setBackgroundColor(getBgColor());
        }

        redBtn.setOnClickListener(this);
        blueBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.redId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));


            saveColor(getResources().getColor(R.color.red));

        }else if(view.getId() == R.id.blueId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            saveColor(getResources().getColor(R.color.blue));

        }else if(view.getId() == R.id.greenId){

            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            saveColor(getResources().getColor(R.color.green));
        }
    }

    private void saveColor(int color) {

        SharedPreferences sharedPreferences = getSharedPreferences("myColor", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("bgcolor", color);

        editor.commit();

    }

    private int getBgColor(){

        SharedPreferences sharedPreferences = getSharedPreferences("myColor", MODE_PRIVATE);
        int lastBgColor = sharedPreferences.getInt("bgcolor", getResources().getColor(R.color.colorPrimary));

        return  lastBgColor;
    }
}
