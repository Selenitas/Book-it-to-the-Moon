package com.selenitas.bookittothemoon.information;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.selenitas.bookittothemoon.R;

public class MoonHistoryActivity extends AppCompatActivity {

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(R.id.back_info_button);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moon_history);
        // Map Button
        this.btnBack = (Button) findViewById(R.id.back_info_button);
        // Clicks
        clickBtnBack(this.btnBack);
    }

    public void clickBtnBack(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateUpToFromChild(MoonHistoryActivity.this, getParentActivityIntent());
            }
        });
    }
}
