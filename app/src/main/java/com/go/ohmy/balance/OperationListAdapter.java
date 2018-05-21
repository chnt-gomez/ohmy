package com.go.ohmy.balance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.go.ohmy.R;
import com.go.ohmy.entity.Operation;

import java.util.List;

public class OperationListAdapter extends RecyclerView.Adapter<OperationListAdapter.OperationViewHolder> {

    private final LayoutInflater inflater;
    private List<Operation> operations;

    OperationListAdapter(Context context){ inflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public OperationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.operation_row, parent, false);
        return new OperationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OperationViewHolder holder, int position) {
        if (operations != null){
            Operation current = operations.get(position);
            holder.operationConcept.setText(current.getConcept());
        }else{
            holder.operationConcept.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return (operations != null ? operations.size() : 0);
    }

    void setOperations(List<Operation> operations){
        this.operations = operations;
        notifyDataSetChanged();
    }

    class OperationViewHolder extends RecyclerView.ViewHolder{

        private final TextView operationConcept;

        public OperationViewHolder(View itemView) {
            super(itemView);
            operationConcept = itemView.findViewById(R.id.text_view);
        }
    }

}
