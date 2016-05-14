package com.selenitas.bookittothemoon.information;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.selenitas.bookittothemoon.MainActivity;
import com.selenitas.bookittothemoon.R;

public class InformationActivity extends AppCompatActivity {

    private Button btnHistory;
    private Button btnFunnyFacts;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        // Map buttons
        this.btnHistory = (Button) findViewById(R.id.history_buttom);
        this.btnFunnyFacts = (Button) findViewById(R.id.funny_facts_buttom);
        this.btnBack = (Button) findViewById(R.id.back_button);
        // Calls
        clickBtn(this.btnHistory, new MoonHistoryActivity());
        clickBtn(this.btnFunnyFacts, new FunnyFactsActivity());
        clickBtn(this.btnBack, new MainActivity());
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
}
