package com.lco.news.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.lco.news.Model.Post;
import com.lco.news.R;
import com.lco.news.WebActivity;

import java.util.List;
import java.util.regex.PatternSyntaxException;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
   List<Post> PostList;
    Context context;
//    ImageView profilepic;
 TextView title,description;

    public Adapter(List<Post> PostList, Context context) {
        this.PostList = PostList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        ViewHolder myholder = new ViewHolder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Post geterl = PostList.get(position);
        String T1,d2,image;
        T1 = geterl.getTitle();
        d2 = geterl.getDescription();
//        image = geterl.getSlug();
        title.setText(T1);
        description.setText(d2);
//        Picasso.get().load(image).into(profilepic);

    }

    @Override
    public int getItemCount() {
        return PostList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
//            profilepic = itemView.findViewById(R.id.imgview);
            title = itemView.findViewById(R.id.t);
            description = itemView.findViewById(R.id.d);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Post post = PostList.get(getAdapterPosition());
                    Intent i = new Intent(context, WebActivity.class);
                    i.putExtra("description",post.getDescription());
                    context.startActivity(i);
                }
            });


            }
    }
}