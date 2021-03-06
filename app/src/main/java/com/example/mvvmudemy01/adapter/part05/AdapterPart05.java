package com.example.mvvmudemy01.adapter.part05;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmudemy01.R;
import com.example.mvvmudemy01.model.infoMain;
import com.example.mvvmudemy01.view.Part01ViewModelActivity;
import com.example.mvvmudemy01.view.Part03DataBindingActivity;
import com.example.mvvmudemy01.view.Part04ProjectActivity;
import com.example.mvvmudemy01.view.part05.Part05CountryListActivity;
import com.example.mvvmudemy01.view.part05.Part05CountrySearchActivity;
import com.example.mvvmudemy01.view.part05.Part05MovieListActivity;
import com.example.mvvmudemy01.view.part05.Part05MovieListMvvmActivity;
import com.example.mvvmudemy01.view.part05.Part05UserActivity;
import com.example.mvvmudemy01.view.roomView.Part02RoomdbActivity;

import java.util.Collections;
import java.util.List;


public class AdapterPart05 extends RecyclerView.Adapter<AdapterPart05.ViewHolder> {
    private LayoutInflater inflater;
    List<infoMain> data = Collections.emptyList();//in tori tarif mikonim ke agar list khali bood Error NullPointExeption nadagad
    private Context context;


    public AdapterPart05(Context context, List<infoMain> data) {
        inflater = LayoutInflater.from(context);//infalter moshakhas mikne ke kodom Amal tarsim koja bayad anjam shavad
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;//ba return krdn be ViewHolder extends RecyclerView.ViewHolder ferstade mishavad
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//Bind yni etesal ya match kardan va har bar ba tekrar shodan dastorat dakhel method amal mikonad
        infoMain cur = data.get(position);
        holder.title.setText(cur.title);
        //Typeface font = Typeface.createFromAsset(context.getAssets(), "AGhasem.ttf");
        // holder.title.setTypeface(font);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {//Karesh tanha etesal ba Component ha mibashad yni msl findviewbyId kar mikne
        TextView title;
        LinearLayout linear_main_row;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.list_nav_title);
            linear_main_row = itemView.findViewById(R.id.linear_main_row);

            linear_main_row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getPosition() == 0) {
                        Intent intent = new Intent(context, Part05CountryListActivity.class);
                        context.startActivity(intent);
                    } if (getPosition() == 1) {
                        Intent intent = new Intent(context, Part05CountrySearchActivity.class);
                        context.startActivity(intent);
                    }if (getPosition() == 2) {
                        Intent intent = new Intent(context, Part05UserActivity.class);
                        context.startActivity(intent);
                    }if (getPosition() == 3) {
                        Intent intent = new Intent(context, Part05MovieListActivity.class);
                        context.startActivity(intent);
                    }if (getPosition() == 4) {
                        Intent intent = new Intent(context, Part05MovieListMvvmActivity.class);
                        context.startActivity(intent);
                    }

                }
            });


        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "This Position" + getPosition(), Toast.LENGTH_SHORT).show();
        }
    }


}
