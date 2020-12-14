package com.akhi.obdcodeerror;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CodeAdapter extends RecyclerView.Adapter<CodeAdapter.ViewHolder> {
Context context;
    List<Model>models;

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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CodeAdapter.ViewHolder holder, int position) {
        final Model model = models.get(position);
        holder.textViewName.setText(model.getCode());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Search.class);
                intent.putExtra("Code",model.getCode());
                intent.putExtra("Description",model.getDescription());
               intent.putExtra("Possible_Cause",model.getPossible_Cause());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewName = itemView.findViewById(R.id.codesearch);

        }
    }


}
