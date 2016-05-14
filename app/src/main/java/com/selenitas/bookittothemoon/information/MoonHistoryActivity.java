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
        clickBtn(this.btnBack, new InformationActivity());
    }

    public void clickBtn(Button btn, final Object object){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoonHistoryActivity.this, object.getClass());
                startActivity(intent);
            }
        });
    }
}
