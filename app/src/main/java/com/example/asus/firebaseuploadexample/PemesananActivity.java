package com.example.asus.firebaseuploadexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PemesananActivity extends AppCompatActivity{

    private TextView pmsNama,pmsHarga,pmsDaerah,pmsDes;
    private ImageView pmsImage;
    private Button btn_pms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_pemesanan );

        btn_pms = findViewById ( R.id.det_btnPesan );

        Intent i = getIntent ();
        final String name =i.getStringExtra ( "home_name" );
        final String image =i.getStringExtra ( "home_image" );
        final String harga =i.getStringExtra ( "home_harga" );
        final String daerah =i.getStringExtra ( "home_daerah" );
        final String des =i.getStringExtra ( "home_des" );


        pmsNama = findViewById ( R.id.pmsNama );
        pmsHarga = findViewById ( R.id.pmsHarga );
        pmsDaerah = findViewById ( R.id.pmsDaerah );
        pmsDes = findViewById ( R.id.pmsDes );
        pmsImage = findViewById ( R.id.det_image );

        pmsNama.setText ( name );
        pmsHarga.setText ( harga );
        pmsDaerah.setText ( daerah );
        pmsDes.setText ( des );

        Picasso.with(this).load(image).fit()
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(pmsImage);
        btn_pms.setOnClickListener ( new View.OnClickListener ( ){
            @Override
            public void onClick(View v) {
                Intent i = new Intent ( PemesananActivity.this,Pesan.class );
                i.putExtra ( "name",name );
                i.putExtra ( "harga",harga );
                startActivity ( i );
            }
        } );
    }
}
