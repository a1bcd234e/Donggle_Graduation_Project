package com.example.graduate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuButtonActivity extends AppCompatActivity {
    Button tabB, oFood, oTime, oNotice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabB = (Button) findViewById(R.id.tabB);
        oFood = (Button) findViewById(R.id.oFood);
        oTime = (Button) findViewById(R.id.oTime);
        oNotice = (Button) findViewById(R.id.oNotice);

        tabB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleButtonVisibility();
            }
        });

        oFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), O_TimeTable.class);
                startActivity(intent);
            }
        });
        oTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), O_FoodTable.class);
                startActivity(intent);
            }
        });
        oNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), O_NoticeBoard.class);
                startActivity(intent);
            }
        });
    }

    private void toggleButtonVisibility() {
        toggleVisibility(oFood);
        toggleVisibility(oTime);
        toggleVisibility(oNotice);
    }
    private void toggleVisibility(Button button){
        if (button.getVisibility() == View.VISIBLE) {
            button.setVisibility(View.GONE);
        } else {
            button.setVisibility(View.VISIBLE);
        }
    }
}
