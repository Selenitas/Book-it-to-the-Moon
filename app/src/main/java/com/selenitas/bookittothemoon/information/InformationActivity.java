package com.selenitas.bookittothemoon.information;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.selenitas.bookittothemoon.MainActivity;
import com.selenitas.bookittothemoon.R;

public class InformationActivity extends AppCompatActivity {

    private Button btnHistory;
    private Button btnFunnyFacts;
    private Button btnBack;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        // Map buttons
        this.btnHistory = (Button) findViewById(R.id.history_buttom);
        this.btnFunnyFacts = (Button) findViewById(R.id.funny_facts_buttom);
        this.btnBack = (Button) findViewById(R.id.back_button);
        this.textView = (TextView) findViewById(R.id.textView);
        this.textView.setTextColor(Color.WHITE);
        // Calls
        clickBtn(this.btnHistory, new MoonHistoryActivity());
        clickBtn(this.btnFunnyFacts, new FunnyFactsActivity());
        clickBtnBack(this.btnBack);
    }

    public void clickBtn(Button btn, final Object object){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this, object.getClass());
                startActivity(intent);
            }
        });
    }

    public void clickBtnBack(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateUpToFromChild(InformationActivity.this, getParentActivityIntent());
            }
        });
    }
}
