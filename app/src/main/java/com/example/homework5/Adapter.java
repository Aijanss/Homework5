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

import java.util.List;

public class Adapter extends RecyclerView.Adapter<MainViewHolder> {
      private final List<Book> list;
       private Context context;
     public Adapter(List<Book> books, List<Book> list1, Context context) {
         this.list = list1;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_item,parent,false);

        return  new MainViewHolder(view);
    }

    @Override
      public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
         holder.imageView.setImageResource(list.get(position).getImage());
         holder.nameView.setText(list.get(position) .getName());
         holder.menuPopUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 PopupMenu popupMenu=new PopupMenu(context,v);
                 popupMenu.getMenuInflater().inflate(R.menu.pop_menu,popupMenu.getMenu());
                 popupMenu.show();
                 popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                     @Override
                     public boolean onMenuItemClick(MenuItem item) {
                         if(item.getItemId()==R.id.delete){
                             Toast.makeText( context,"Item deleted",Toast.LENGTH_LONG).show();
                           deleteItem(position);
                         }

                         return true;
                     }
                 });

             }

         });
             }

    public  void deleteItem(int position ){
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,list.size());

    }
    @Override
        public int getItemCount()
    {
        return list.size();
    }


}

       class MainViewHolder extends ViewHolder{
           ImageView imageView,menuPopUp;
           TextView nameView;
           public MainViewHolder(@NonNull View view) {
               super(view);
              imageView = (ImageView)view.findViewById(R.id.image);
              nameView = (TextView) view.findViewById(R.id.name);
             menuPopUp= (ImageView)view.findViewById(R.id.menuPopup);

              }

          }


