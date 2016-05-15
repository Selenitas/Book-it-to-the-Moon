package com.selenitas.bookittothemoon;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.selenitas.bookittothemoon.gallery.GalleryActivity;
import com.selenitas.bookittothemoon.information.InformationActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLocalizeTheMoon;
    private Button btnInformation;
    private Button btnFavourites;
    private Button btnOptions;
    private Button btnGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Map buttons
        this.btnInformation = (Button) findViewById(R.id.information_buttom);
        this.btnGallery = (Button) findViewById(R.id.galery_button);
        this.btnLocalizeTheMoon = (Button) findViewById(R.id.galery_button);
        // Clicks
        clickButtonAceptar();
        clickButtonGallery();
        clickButtonLocalize();

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

    public void clickButtonLocalize() {
        this.btnLocalizeTheMoon.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(ComponentName.unflattenFromString("com.selenitas.vuforia"));
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(intent);
            }
        });
    }

}
