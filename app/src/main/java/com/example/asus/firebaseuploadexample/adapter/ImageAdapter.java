package com.example.asus.firebaseuploadexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.firebaseuploadexample.PemesananActivity;
import com.example.asus.firebaseuploadexample.R;
import com.example.asus.firebaseuploadexample.model.Upload;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{
    private Context mContext;
    private List <Upload> mUploads;


    public ImageAdapter(Context context , List <Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {
        View v = LayoutInflater.from ( mContext ).inflate ( R.layout.image_item , parent , false );
        final ImageViewHolder viewHolder = new ImageViewHolder ( v );
        viewHolder.view_container.setOnClickListener ( new View.OnClickListener ( ){
            @Override
            public void onClick(View v) {
                Intent i = new Intent ( mContext,PemesananActivity.class );
                i.putExtra("home_name",mUploads.get(viewHolder.getAdapterPosition()).getName ());
                i.putExtra("home_image",mUploads.get(viewHolder.getAdapterPosition()).getImageUrl ());
                i.putExtra("home_harga",mUploads.get(viewHolder.getAdapterPosition()).getmHarga ());
                i.putExtra("home_daerah",mUploads.get(viewHolder.getAdapterPosition()).getmDaerah ());
                i.putExtra("home_des",mUploads.get(viewHolder.getAdapterPosition()).getmDes ());
                mContext.startActivity ( i );
            }
        } );

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder , int position) {
        Upload uploadCurrent = mUploads.get ( position );
        holder.textViewName.setText ( "Jenis Hewan : " + uploadCurrent.getName ( ) );
        holder.textViewHarga.setText ( "Harga 1 Ekor : " + uploadCurrent.getmHarga ( ) );
        holder.textViewDaerah.setText ( "Daerah Peternak : " + uploadCurrent.getmDaerah ( ) );
        holder.textViewDes.setText ( "Spesifikasi : " + uploadCurrent.getmDes ( ) );
        Picasso.with ( mContext ).load ( uploadCurrent.getImageUrl ( ) ).placeholder ( R.mipmap.ic_launcher ).fit ( ).centerCrop ( ).into ( holder.imageView );
    }

    @Override
    public int getItemCount() {
        return mUploads.size ( );
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imageView;
        public TextView textViewHarga;
        public TextView textViewDaerah;
        public TextView textViewDes;
        public LinearLayout view_container;

        public ImageViewHolder(View itemView) {
            super ( itemView );
            view_container = itemView.findViewById(R.id.kontener);
            textViewDes = itemView.findViewById ( R.id.text_view_des );
            textViewName = itemView.findViewById ( R.id.text_view_name );
            imageView = itemView.findViewById ( R.id.image_view_upload );
            textViewHarga = itemView.findViewById ( R.id.text_view_harga );
            textViewDaerah = itemView.findViewById ( R.id.text_view_daerah );

        }
    }
}