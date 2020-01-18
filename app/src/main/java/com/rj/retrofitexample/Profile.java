package com.rj.retrofitexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.rj.retrofitexample.model.RegisterList;
import com.rj.retrofitexample.util.RetrofitObj;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

    private ImageView image;
    private int PICK_REQUEST_CODE = 11;
    private Uri filePath;
    private Bitmap bitmap;
    private boolean status = false;
    private Button button;
    private EditText mobile,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //init user session
        //view of image and mobile and email
        image = findViewById(R.id.edit_profile_image);
        mobile = findViewById(R.id.edit_profile_mobile);
        email = findViewById(R.id.edit_profile_email);
        //get image from file manager
        image.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_REQUEST_CODE);
        });
        //update button
        button = findViewById(R.id.update);
        button.setOnClickListener(v -> {
            String uMobile = mobile.getText().toString().trim();
            String uEmail = email.getText().toString().trim();

            if("".equals(uMobile)||uMobile.length()!=10){
                mobile.setError("Enter valid mobile Number");
            }else if("".equals(uEmail)){
                email.setError("Enter Email");
            }
            else if(!status){
                Toast.makeText(Profile.this, "Select Image", Toast.LENGTH_SHORT).show();
            }
            else{
                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(() -> {
                    String img = getImageToString(bitmap);
                    updateData(img,uMobile,uEmail);
                });
            }
        });
    }

    private void updateData(String img, String newMobile, String uEmail) {
        Thread thread = new Thread(() -> {
            //pass the required fields
            Call<RegisterList> call = RetrofitObj.getRequestInterfaceApi().updateUser(uEmail,img,newMobile,"secCode");
            call.enqueue(new Callback<RegisterList>() {
                @Override
                public void onResponse(Call<RegisterList> call, Response<RegisterList> response) {
                    if(response.isSuccessful()){
                        RegisterList register = response.body();
                        //do something when data is submitted
                        // or update local user data with response
                        Intent intent = new Intent(Profile.this, MainActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<RegisterList> call, Throwable t) {
                    Toast.makeText(Profile.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
        thread.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_REQUEST_CODE && resultCode == RESULT_OK && data!=null && data.getData()!=null){
            filePath = data.getData();
            status = true;
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                image.setImageURI(filePath);
            }
            catch (IOException e){
            }
        }
    }

    public String getImageToString(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,40,stream);
        byte[] bytes =  stream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }
}
