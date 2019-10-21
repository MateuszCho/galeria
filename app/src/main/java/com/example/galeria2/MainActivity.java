package com.example.galeria2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button pickImage;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            setupCloudMessaging();
        }

            imageView = findViewById(R.id.imageView);
            pickImage = findViewById(R.id.wybierzObraz);


            pickImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openGallery();
                }
            });
        }

    private void setupCloudMessaging() {
    }

    private void openGallery() {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(gallery, PICK_IMAGE);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
                imageUri = data.getData();
                imageView.setImageURI(imageUri);
            }
        }

        }




