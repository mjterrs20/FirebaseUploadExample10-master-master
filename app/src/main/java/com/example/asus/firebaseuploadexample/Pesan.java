package com.example.asus.firebaseuploadexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.firebaseuploadexample.model.Pemesan;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pesan extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private ProgressDialog mProgresDialog;
    //private DatabaseReference databaseReference;
    private EditText pesanJenis,pesanHarga,pesanNama,pesanJumlah,pesanNohp,pesanDaerah;
    private Button buttonsPesan;
    Pemesan pemesan;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_pesan );

        database = FirebaseDatabase.getInstance ();
        ref = database.getReference ("Pemesan");
        pesanJenis = (EditText) findViewById ( R.id.pesanJenis );
        pesanHarga = (EditText) findViewById ( R.id.pesanHarga );
        pesanNama = (EditText) findViewById ( R.id.pesanNama );
        pesanJumlah = (EditText) findViewById ( R.id.pesanJumlah );
        pesanNohp = (EditText) findViewById ( R.id.pesanNohp );
        pesanDaerah = (EditText) findViewById ( R.id.pesanDaerah );
        buttonsPesan = (Button) findViewById ( R.id.buttonPesan );

        Bundle dataExtra = getIntent().getExtras();
        String name = dataExtra.getString("name");
        String harga = dataExtra.getString("harga");
        pesanJenis.setText ( name );
        pesanHarga.setText ( harga );


        buttonsPesan.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                uploadData();
                Intent i = new Intent(Pesan.this, Depan.class);
                startActivity(i);
            }
        } );

    }


    private void uploadData(){
        mProgresDialog = new ProgressDialog ( Pesan.this );
        mProgresDialog.setMessage ( "Memesan Pilihan ...." );
        mProgresDialog.show();

        ref.addValueEventListener ( new ValueEventListener ( ) {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child ( pesanNama.getText ().toString ()).exists ()){
                    mProgresDialog.dismiss ();
                    Toast.makeText ( Pesan.this,"Anda Telah Memesan", Toast.LENGTH_LONG ).show ();
                }
                else{
                    mProgresDialog.dismiss ();
                    Pemesan pemesan = new Pemesan(pesanJenis.getText ().toString (),pesanHarga.getText ().toString (),
                            pesanNama.getText ().toString (), pesanJumlah.getText ().toString (),pesanNohp.getText ().toString (),
                            pesanDaerah.getText ().toString ());
                    ref.child ( pesanNama.getText ().toString () ).setValue ( pemesan );
                    Toast.makeText ( Pesan.this,"Berbasil pesan",Toast.LENGTH_SHORT ).show ();
                    Intent i = new Intent (Pesan.this,Depan.class);
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
