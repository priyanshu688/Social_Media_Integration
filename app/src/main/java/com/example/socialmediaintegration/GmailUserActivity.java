package com.example.socialmediaintegration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GmailUserActivity extends AppCompatActivity {
    // Initialize variable
    ImageView ivImage;
    TextView tvName , email;
    Button btLogout;
    FirebaseAuth firebaseAuth;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_user);

        // Assign variable
        ivImage = findViewById(R.id.iv_image);
        tvName = findViewById(R.id.tv_name);
        email = findViewById(R.id.email);
        btLogout = findViewById(R.id.bt_logout);

        // Initialise firebase auth
        firebaseAuth = FirebaseAuth.getInstance();

        // Initialize firebase user
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        // Check condition
        if(firebaseUser != null) {
            // When firebase user is not equal to null
            // Set image on image view
            Glide.with(GmailUserActivity.this)
                    .load(firebaseUser.getPhotoUrl())
                    .into(ivImage);

            // Set name on text view
            tvName.setText(firebaseUser.getDisplayName());
            email.setText(firebaseUser.getEmail());
        }

        // Initialize sign in client
        googleSignInClient = GoogleSignIn.getClient(GmailUserActivity.this
                        , GoogleSignInOptions.DEFAULT_SIGN_IN);

        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign out from google
                googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                            // Check condition
                          if (task.isSuccessful()) {
                              // When task is successful
                              // Sign out from firebase
                              firebaseAuth.signOut();
                              // Display toast
                              Toast.makeText(getApplicationContext()
                                      ,"Sign out successfully",Toast.LENGTH_SHORT).show();
                              // Finish Activity
                               finish();
                          }
                    }
                });
            }
        });
    }
}