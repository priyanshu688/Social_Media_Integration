package com.example.socialmediaintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FbUserActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_user);

        ImageView image = findViewById(R.id.myimage);
        TextView detail = findViewById(R.id.mydetail);
        TextView myemail = findViewById(R.id.myemail);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null) {

            Glide.with(this).load(user.getPhotoUrl()).into(image);

            detail.setText(user.getDisplayName());
            myemail.setText(user.getEmail());
        }
    }

    public void logout(View view ) {
         mAuth.signOut();
         startActivity(new Intent(this, MainActivity.class));
         finish();
    }
}