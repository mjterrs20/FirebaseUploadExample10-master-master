package com.example.asus.firebaseuploadexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.firebaseuploadexample.model.Pemesan;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Keranjang extends AppCompatActivity {
    ListView lv;
    FirebaseListAdapter adapter;
    public double a,b,c;
    private String plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_keranjang );

        lv = findViewById ( R.id.listVIew );
        Query query = FirebaseDatabase.getInstance ().getReference ().child ( "Pemesan" );
        FirebaseListOptions<Pemesan> options = new FirebaseListOptions.Builder<Pemesan> ()
                .setLayout ( R.layout.view_keranjang )
                .setQuery ( query,Pemesan.class )
                .build();
        adapter = new FirebaseListAdapter (options ) {
            @Override
            protected void populateView(View v, Object model, int position) {
                TextView Jenis = v.findViewById ( R.id.viewJenis );
                TextView Harga = v.findViewById ( R.id.viewHarga );
                TextView name = v.findViewById ( R.id.viewName );
                TextView jumlah = v.findViewById ( R.id.viewJumlah );
                TextView nohp = v.findViewById ( R.id.viewNohp );
                TextView alamat = v.findViewById ( R.id.viewAlamat );
                TextView norek = v.findViewById ( R.id.viewNorek );
                TextView all = v.findViewById ( R.id.viewTot);



                Pemesan pemesan = (Pemesan) model;
                a = Double.parseDouble(pemesan.getHarga ().toString ());
                b = Double.parseDouble ( pemesan.getJumlah ().toString () );
                c = a * b ;
                plus = String.valueOf ( c );

                Jenis.setText ( "Name: "+pemesan.getJenis ().toString ());
                Harga.setText ( "Harga : "+pemesan.getHarga ().toString () );
                name.setText ( "Nama : "+pemesan.getName ().toString () );
                jumlah.setText ( "Jumlah Pesan : "+pemesan.getJumlah ().toString () );
                nohp.setText ( "No Hp : "+pemesan.getNohp ().toString () );
                alamat.setText ( "Alamat : "+pemesan.getDaerah ().toString () );
                all.setText ( "Jumlah harga : "+ plus );
                norek.setText ( "Silahkan Melakukan Pembayaran ke Rekening : 101.00.98300.997 (Mandiri) Pesanan akan Dikirm Dalam Waktu 3 hari " +
                       "Setelah Pembayaran " );
            }
        };
        lv.setAdapter(adapter);
    }
    protected void onStart() {
        super.onStart ( );
        adapter.startListening ();
    }

    @Override
    protected void onStop() {
        super.onStop ( );
        adapter.stopListening ();
    }

}
