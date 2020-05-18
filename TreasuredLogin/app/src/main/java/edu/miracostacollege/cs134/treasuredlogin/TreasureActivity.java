package edu.miracostacollege.cs134.treasuredlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TreasureActivity extends AppCompatActivity {

    //TODO (1): Add Firebase member variables (auth and user)
    private FirebaseAuth auth ;
    private FirebaseUser user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasure);

        Intent intent = getIntent() ;

        //TODO (2): Initialize Firebase authentication
        auth = FirebaseAuth.getInstance() ;
        //TODO (3): Initialize current user
        user = auth.getCurrentUser() ;

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);
        //TODO (4): Set the text view's text to "Welcome " + user's email address
        welcomeTextView.setText("Welcome " + user.getEmail());
    }


    // TODO (5): Create a public void handleSignOut(View v) that signs out of Firebase authentication,
    // TODO (5): finishes this activity and starts a new Intent back to the LoginActivity.

    public void handleSignOut(View v)
    {
        auth.signOut();
        finish() ;
        Intent intent = new Intent(this, LoginActivity.class) ;
        startActivity(intent) ;
    }
}
