package com.mab.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import android.widget.EditText;

import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclrView;
    ArrayList<String> todoList  = new ArrayList<>();
    CustomerAdapter mAdapter;
    private EditText TodoField;
    private ImageButton AddBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoList.add("Hello");
        todoList.add("World");
        mRecyclrView = findViewById(R.id.recyclerView);
        TodoField = findViewById(R.id.inputField);
        AddBtn = findViewById(R.id.addBtn);
        mRecyclrView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CustomerAdapter(todoList,this,MainActivity.this);
        mRecyclrView.setAdapter(mAdapter);
        //Toast.makeText(this, todoList.size()+"", Toast.LENGTH_SHORT).show();
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todo = TodoField.getText().toString();
                todoList.add(todo);
                mAdapter.refresh(todoList);
                mRecyclrView.setAdapter(mAdapter);
                TodoField.setText("");
            }
        });
    }
}
