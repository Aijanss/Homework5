package com.example.homework5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<MainViewHolder> {
    private final List<Book> list;
    private OnClickListener listener;
    private Context context;


    public Adapter(List<Book> books, List<Book> list1, Context context, OnClickListener listener) {
        this.list = list1;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_item, parent, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {


        String date = "Mar 10, 2016 6:30:00 PM";
        SimpleDateFormat spf = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aaa");
        Date newDate = list.get(position).getData();
        try {
            newDate = spf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf = new SimpleDateFormat("dd MMM yyyy");
        date = spf.format(newDate);
        holder.imageView.setImageResource(list.get(position).getImage());
        if (list.get(holder.getAdapterPosition()).getDataStr() == null)
            holder.dataView.setText(date);
        else
            holder.dataView.setText(list.get(position).getDataStr());
        holder.menuPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.delete) {
                            Toast.makeText(context, "Item deleted", Toast.LENGTH_LONG).show();
                            deleteItem(position);
                        }
                        if (item.getItemId() == R.id.data) {
                            listener.openActivity(holder.getAdapterPosition());
                        }

                        return true;
                    }
                });

            }

        });


    }

    public void deleteItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, list.size());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDate(Book book, int position) {
        list.set(position, book);
        notifyDataSetChanged();
    }


}

class MainViewHolder extends ViewHolder {
    ImageView imageView, menuPopUp;
    TextView dataView;


    public MainViewHolder(@NonNull View view) {
        super(view);
        imageView = (ImageView) view.findViewById(R.id.image);
        dataView = (TextView) view.findViewById(R.id.data);
        menuPopUp = (ImageView) view.findViewById(R.id.menuPopup);

    }


}




