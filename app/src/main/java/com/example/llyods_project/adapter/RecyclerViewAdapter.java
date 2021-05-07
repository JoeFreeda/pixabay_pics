package com.example.llyods_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.llyods_project.R;
import com.example.llyods_project.model.HitsItem;
import com.example.llyods_project.model.Pixabay_Res;
import com.example.llyods_project.views.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final Context context;
    List<HitsItem> userArrayList;

    public RecyclerViewAdapter(MainActivity context, List<HitsItem> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_pinterest, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(userArrayList.get(position).getPageURL());
//        holder.image.getLayoutParams().height = userArrayList.get(position).getPreviewHeight();
//        holder.image.getLayoutParams().width = userArrayList.get(position).getPreviewWidth();
//        holder.image.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(context).load(userArrayList.get(position).getPreviewURL()).into(holder.image);
    }



    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
