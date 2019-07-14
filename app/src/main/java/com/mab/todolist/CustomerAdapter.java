package com.mab.todolist;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder>{
    ArrayList<String> todoList;
    Activity activity;
    Context context;

    public CustomerAdapter(ArrayList<String> todoList, Activity activity, Context context) {
        this.todoList = todoList;
        this.activity = activity;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        Toast.makeText(context,todoList.size()+"", Toast.LENGTH_LONG);
        myViewHolder.todo.setText(todoList.get(i));
        myViewHolder.DeleteTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todoList.remove(i);
                refresh(todoList);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public void refresh(ArrayList<String> todoList) {
        this.todoList = todoList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView todo;
        ImageButton DeleteTodo;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            todo = itemView.findViewById(R.id.todo);
            DeleteTodo = itemView.findViewById(R.id.deleteTodo);
        }
    }
}
