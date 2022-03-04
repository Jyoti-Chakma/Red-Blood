package com.piedroid.redblood;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<User> list;
    private MyViewHolder holder;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.fullName.setText(user.getFullName());
        holder.location.setText(user.getLocation());
        holder.session.setText(user.getSession());
        holder.age.setText(user.getAge());
        holder.blood.setText(user.getBlood());

        //Button
//        holder.aPositive.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Query query = FirebaseDatabase.getInstance().getReference("Users").orderByChild("blood").equalTo("A+");
//
//            }
//        });


        //Call Feature
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String call = user.getPhone();
                String s = "tel:" + call;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullName, location, session, age, blood;
        ImageButton call;
        Button aPositive, aNegative, bPositive, bNegative, oPositive, oNegative, abPositive, abNegative;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName = itemView.findViewById(R.id.tvFullName);
            location = itemView.findViewById(R.id.location);
            session = itemView.findViewById(R.id.tvsession);
            age = itemView.findViewById(R.id.tvage);
            blood = itemView.findViewById(R.id.bloodgroup);
            call = itemView.findViewById(R.id.phone);

            //Button
//            aPositive = itemView.findViewById(R.id.aPositive);
//            aNegative = itemView.findViewById(R.id.aNegative);
//            bPositive = itemView.findViewById(R.id.bPositive);
//            bNegative = itemView.findViewById(R.id.bNegative);
//            oPositive = itemView.findViewById(R.id.oPositive);
//            oNegative = itemView.findViewById(R.id.oNegative);
//            abPositive = itemView.findViewById(R.id.abPositive);
//            abNegative = itemView.findViewById(R.id.abNegative);

        }
    }

}