package com.example.asus.firebaseuploadexample.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.firebaseuploadexample.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Logout extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_logout );

        firebaseAuth = FirebaseAuth.getInstance ();

        if(firebaseAuth.getCurrentUser () == null){
            finish ();
            startActivity ( new Intent ( this,Login.class ) );
        }

        FirebaseUser user = firebaseAuth.getCurrentUser ();
        textViewUserEmail = (TextView) findViewById ( R.id.viewEmail );
        textViewUserEmail.setText ( "Welcome : "+ user.getEmail () );
        buttonLogout = (Button) findViewById ( R.id.buttonLogout );
        buttonLogout.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v) {

        if(v == buttonLogout){
            firebaseAuth.signOut ();
            finish ();
            startActivity ( new Intent(this, Login.class) );
        }

    }
}
