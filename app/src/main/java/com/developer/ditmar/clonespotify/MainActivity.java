package com.developer.ditmar.clonespotify;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginButton, registerButton;
    static final int code_camera = 999;
    private MainActivity root = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        loadComponents();
    }

    private void loadComponents() {
        loginButton = this.findViewById(R.id.login);
        registerButton = this.findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerActivity = new Intent(root, RegisterUser.class);
                root.startActivity(registerActivity);
            }
        });
        loginButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(root, RegisterUser.class);
                intent.putExtra("backupAgentName", root.getApplicationInfo().backupAgentName);
                intent.putExtra("data", "soy la informacion de la actividad MainActivity");
                intent.putExtra("number", 26);
                root.startActivity(intent);*/
                /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                root.startActivity(intent);*/
                /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:75732654"));
                root.startActivity(intent);*/
                /*Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "Intents en android");
                root.startActivity(intent);*/
                //Intent intent = new Intent(Intent.ACTION_VIEW);
//                /intent.setData(Uri.parse("https://www.twitch.tv/"));
                //intent.putExtra(SearchManager.QUERY, "Intents en android");
                //root.startActivity(intent);
                /*Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (camera.resolveActivity(root.getPackageManager()) != null) {
                    root.startActivityForResult(camera, code_camera);
                }*/
            }
        }));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == code_camera && resultCode == RESULT_OK) {
            Bundle photo = data.getExtras();
            Bitmap imageBitmap = (Bitmap) photo.get("data");
            ImageView img = root.findViewById(R.id.imageView);
            img.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "OnResume", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(this, "OnPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }
}
