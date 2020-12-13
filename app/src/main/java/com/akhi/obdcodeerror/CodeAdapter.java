package com.akhi.obdcodeerror;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CodeAdapter extends RecyclerView.Adapter<CodeAdapter.ViewHolder> {
Context context;
    List<Model> models;

    public CodeAdapter(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public CodeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.simple_code_layout,parent,false);
       // CodeAdapter.ViewHolder viewHolder = new CodeAdapter.ViewHolder(view);
        return view;    }

    @Override
    public void onBindViewHolder(@NonNull CodeAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
