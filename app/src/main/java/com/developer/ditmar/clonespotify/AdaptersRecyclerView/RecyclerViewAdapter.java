package com.developer.ditmar.clonespotify.AdaptersRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.developer.ditmar.clonespotify.R;
import com.developer.ditmar.clonespotify.adapters.StructListMp3;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyItemComponent> {
    private LayoutInflater layoutInflater;
    private ArrayList<StructListMp3> data;
    private Context context;
    public RecyclerViewAdapter(Context context, ArrayList<StructListMp3> data) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public MyItemComponent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = layoutInflater.inflate(R.layout.item_listmp3, null);
        return new MyItemComponent(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyItemComponent holder, int position) {
        ImageView img = holder.getImageview();
        if (data.get(position).getImage().equals("No IMAGE")) {
            Glide.with(context)
                    .load("https://topesdegama.com/app/uploads-topesdegama.com/2018/10/Logo-Spotify-blanco.jpg")
                    .centerCrop()
                    .into(img);
        } else {
            Glide.with(context)
                    .load(data.get(position).getImage())
                    .centerCrop()
                    .into(img);
        }
        TextView txt = holder.getTitleview();
        txt.setText(data.get(position).getTitle());
        TextView album = holder.getAlbumview();
        album.setText(data.get(position).getAlbum());
        ImageButton button = holder.getButtonview();
        button.setTag(data.get(position).getRelativepath());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageButton btn = (ImageButton) view;
                String urlpath = (String) btn.getTag();
                urlpath = "http://192.168.0.107:8000" + urlpath;
                Intent videoplayer = new Intent(Intent.ACTION_VIEW, Uri.parse(urlpath));
                videoplayer.setDataAndType(Uri.parse(urlpath), "video/mp4");
                context.startActivity(videoplayer);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    class  MyItemComponent extends RecyclerView.ViewHolder
    {

        private ImageView imageview;
        private TextView titleview;
        private TextView albumview;
        private ImageButton buttonview;
        public MyItemComponent(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageView3);
            titleview = itemView.findViewById(R.id.title);
            albumview = itemView.findViewById(R.id.album);
            buttonview = itemView.findViewById(R.id.imageButton);

        }

        public ImageView getImageview() {
            return imageview;
        }

        public void setImageview(ImageView imageview) {
            this.imageview = imageview;
        }

        public TextView getTitleview() {
            return titleview;
        }

        public void setTitleview(TextView titleview) {
            this.titleview = titleview;
        }

        public TextView getAlbumview() {
            return albumview;
        }

        public void setAlbumview(TextView albumview) {
            this.albumview = albumview;
        }

        public ImageButton getButtonview() {
            return buttonview;
        }

        public void setButtonview(ImageButton buttonview) {
            this.buttonview = buttonview;
        }
    }
}
