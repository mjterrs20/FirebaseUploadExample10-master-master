package com.example.asus.firebaseuploadexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asus.firebaseuploadexample.login.Login;
import com.example.asus.firebaseuploadexample.model.Pemesan;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Daganganku extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private MaterialEditText textViewUserEmail;
    private Button buttonCoba;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private ProgressDialog mProgresDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_daganganku );

        firebaseAuth = FirebaseAuth.getInstance ();

        if(firebaseAuth.getCurrentUser () == null){
            finish ();
            startActivity ( new Intent ( this,Login.class ) );
        }

        database = FirebaseDatabase.getInstance ();
        ref = database.getReference ("Coba");

        FirebaseUser user = firebaseAuth.getCurrentUser ();
        textViewUserEmail = (MaterialEditText) findViewById ( R.id.dgCoba );
        String nama = user.getEmail ().toString ();
        textViewUserEmail.setText (nama);
        buttonCoba = (Button) findViewById ( R.id.buttonCoba );

        buttonCoba.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                uploadData();
                Intent i = new Intent(Daganganku.this, Depan.class);
                startActivity(i);
            }
        } );
    }

    private void uploadData(){
        mProgresDialog = new ProgressDialog ( Daganganku.this );
        mProgresDialog.setMessage ( "Memesan Pilihan ...." );
        mProgresDialog.show();

        ref.addValueEventListener ( new ValueEventListener ( ) {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child ( textViewUserEmail.getText ().toString ()).exists ()){
                    mProgresDialog.dismiss ();
                    Toast.makeText ( Daganganku.this,"Anda Telah Memesan", Toast.LENGTH_LONG ).show ();
                }
                else{
                    mProgresDialog.dismiss ();
                    Pemesan pemesan = new Pemesan(textViewUserEmail.getText ().toString () );
                    ref.child ( textViewUserEmail.getText ().toString () ).setValue ( pemesan );
                    Toast.makeText ( Daganganku.this,"Berbasil pesan",Toast.LENGTH_SHORT ).show ();
                    Intent i = new Intent (Daganganku.this,Depan.class);
                    startActivity ( i );
                    finish ();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } );
    }


}
