package com.selenitas.bookittothemoon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.selenitas.bookittothemoon.information.InformationActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLocalizeTheMoon;
    private Button btnInformation;
    private Button btnGallery;
    private Button btnFavourites;
    private Button btnOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Map buttons
        this.btnInformation = (Button) findViewById(R.id.information_buttom);
        // Clicks
        clickButtonAceptar();
    }

    // Controllers
    public void clickButtonAceptar(){
        this.btnInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intent);
            }
        });
    }
}
