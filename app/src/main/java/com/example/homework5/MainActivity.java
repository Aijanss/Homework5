package com.example.homework5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    public RecyclerView recyclerView;
    private Adapter adapter;
    private int position;
    List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      user();
    }
    public void user() {
        recyclerView = findViewById(R.id.recyclerview);
        books.add(new Book(new Date(System.currentTimeMillis()), R.drawable.image1));
        books.add(new Book(new Date(System.currentTimeMillis()), R.drawable.image2));
        books.add(new Book(new Date(System.currentTimeMillis()), R.drawable.image3));
        books.add(new Book(new Date(System.currentTimeMillis()), R.drawable.image4));
        adapter = new Adapter(books, books, this, this::openActivity);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void openActivity(int position) {
        this.position = position;
        Toast.makeText(this, "position: " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent, 22);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 22 & resultCode == RESULT_OK & data != null) {
            String text = data.getStringExtra("data");
            Book book = books.get(position);
            book.setDataStr(text);
            adapter.setDate(book, position);
        }
    }
}
