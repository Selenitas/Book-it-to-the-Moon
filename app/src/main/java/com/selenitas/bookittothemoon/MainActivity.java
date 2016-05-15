package com.selenitas.bookittothemoon;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.selenitas.bookittothemoon.gallery.GalleryActivity;
import com.selenitas.bookittothemoon.information.InformationActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLocalizeTheMoon;
    private Button btnInformation;
    private Button btnFavourites;
    private Button btnOptions;
    private Button btnGallery;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Map buttons
        this.btnInformation = (Button) findViewById(R.id.information_buttom);
        this.btnGallery = (Button) findViewById(R.id.galery_button);
        this.txtView = (TextView) findViewById(R.id.textView);
        this.txtView.setTextColor(Color.WHITE);
        // Clicks
        clickButtonAceptar();
        clickButtonGallery();

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

    public void clickButtonGallery() {
        this.btnGallery.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });
    }

}
