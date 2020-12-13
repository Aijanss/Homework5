package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    private Adapter adapter;
    private TextView textView;
    public Button dateButton;
    List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        dateButton = findViewById(R.id.dateButton);

        user();
        String data = getIntent().getStringExtra("data");
        if (data != null) {
            textView.setText(data);
        }
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });



            }


    public void user() {
        recyclerView = findViewById(R.id.recyclerview);
        books.add(new Book("Java", R.drawable.image1));
        books.add(new Book("Android", R.drawable.image2));
        books.add(new Book("Kotlin", R.drawable.image3));
        books.add(new Book("SQL", R.drawable.image4));
        adapter = new Adapter(books, books, this);
        recyclerView.setAdapter(adapter);
    }



}


