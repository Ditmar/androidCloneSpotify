package com.developer.ditmar.clonespotify;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.developer.ditmar.clonespotify.utils.EndPoints;
import com.developer.ditmar.clonespotify.utils.UserDataServer;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    Button loginButton, registerButton;
    static final int code_camera = 999;
    private MainActivity root = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
        getSupportActionBar().hide();
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

                //ENVIO A LA API
                AsyncHttpClient client = new AsyncHttpClient();

                EditText email = root.findViewById(R.id.email_txt);
                EditText password = root.findViewById(R.id.password_txt);


                RequestParams params = new RequestParams();
                params.add("nick", email.getText().toString());
                params.add("password", password.getText().toString());

                client.post(EndPoints.LOGIN_SERVICE, params, new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            if (response.has("msn")) {
                                UserDataServer.MSN = response.getString("msn");
                            }
                            if (response.has("token")) {
                                UserDataServer.TOKEN = response.getString("token");
                            }
                            if (UserDataServer.TOKEN.length() > 150) {
                                Intent intent = new Intent(root, MainDashBoardActivity.class);
                                root.startActivity(intent);
                            } else {
                                Toast.makeText(root, response.getString("msn"), Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


                /*Intent intent = new Intent(root, MainDashBoardActivity.class);
                root.startActivity(intent);*/
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
