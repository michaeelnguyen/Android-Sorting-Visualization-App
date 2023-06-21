package com.example.bubblesortapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class BubbleSortDisplayActivity extends AppCompatActivity {
    BubbleSort sort;
    TextView textView;
    Handler timerHandler = new Handler(Looper.getMainLooper());
    ArrayList<BubbleInfo> txtViews = new ArrayList<BubbleInfo>();

    Runnable startRunnable = new Runnable() {
        @Override
        public void run() {
            for (BubbleInfo b: txtViews) {
                b.xOrig = b.view.getX();
            }
            timerHandler.postDelayed(timerRunnable, 10);
        }
    };

    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            int SPEED = 500;

            // Access TextView stepsView and set attributes
            TextView stepsView = findViewById(R.id.scrollView).findViewById(R.id.linearLayout1).findViewById(R.id.stepsView);
            String prevStep = (String) stepsView.getText();
            //stepsView.setVisibility(View.INVISIBLE);
            stepsView.setGravity(Gravity.CENTER_HORIZONTAL);

            //Check if input array is already sorted
            if(sort.IsSorted()){
                for(int i = 0; i < sort.Length(); i++){
                    txtViews.get(i).view.setTextColor(Color.BLUE);
                }
                stepsView.setVisibility(View.VISIBLE);
                stepsView.setText(prevStep + "\n" + sort.ArrString() + "\n\n FINISHED!");
                return;
            }

            // Once position hits the end of array, output step with additional newline
            // to distinguish iterations
            if(sort.AtEndOfArr() && !sort.IsSorted()) {
                txtViews.get(sort.Position()).view.setTextColor(Color.BLUE);
                stepsView.setText(prevStep + "\n" + sort.ArrString() + "\n");
            }
            else if(!sort.AtEndOfArr() && !sort.IsSorted()) {
                stepsView.setText(prevStep + "\n" + sort.ArrString());
            } else {
                // DONE sort.AtEndOfArr() && sort.IsSorted()
                txtViews.get(sort.Position()).view.setTextColor(Color.BLUE);
                txtViews.get(sort.Position() - 1).view.setTextColor(Color.BLUE);
                stepsView.setVisibility(View.VISIBLE);
                stepsView.setText(prevStep + "\n" + sort.ArrString());
                return;
            }

            sort.NextStep();

            if (sort.Swapped()) {
                SwapAnimation.SwapBubbles(
                        txtViews.get(sort.Position() - 1),
                        txtViews.get(sort.Position()),
                        SPEED,
                        timerHandler,
                        this
                );
            }
            else {
                timerHandler.postDelayed(this, SPEED);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(UserInputActivity.EXTRA_MESSAGE);


        String[] strArr = message.split("[\\s,]");
        // Convert to int Array
        int[] intArr = StrArrayToIntArray.convertToIntArray(strArr);


        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView0)));
        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView1)));
        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView2)));
        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView3)));
        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView4)));
        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView5)));
        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView6)));
        txtViews.add(new BubbleInfo((TextView)findViewById(R.id.textView7)));


        // Set user input numbers into each TextView ELSE Set TextView visibility to GONE.
        for(int i = 0; i < txtViews.size(); i++){
            if(i < strArr.length) {
                txtViews.get(i).view.setText(strArr[i]);
            }else {
                txtViews.get(i).view.setVisibility(View.GONE);
            }
        }

        sort = new BubbleSort(intArr);
        timerHandler.postDelayed(startRunnable, 1000);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);

    }

    public void goToMainMenu(View v){
        Intent intent = new Intent(BubbleSortDisplayActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void goToInput(View v){
        Intent intent = new Intent(BubbleSortDisplayActivity.this, UserInputActivity.class);
        startActivity(intent);
    }
}