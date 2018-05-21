package com.go.ohmy.dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.go.ohmy.R;
import com.go.ohmy.entity.Operation;

public class Dialogs {

    static Dialog instance;

    public static Dialog newOperationDialog(final Context context, final DialogInteractionListener.BalanceViewListener view){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        @SuppressLint("InflateParams")
        final View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_new_operation, null);
        /*
        Init widgets
         */
        final EditText etConcept = dialogView.findViewById(R.id.editText);
        final Button btnOk = dialogView.findViewById(R.id.button);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String concept = etConcept.getText().toString();
                Operation operation = new Operation(concept, 1.0f);
                instance.dismiss();
                view.onNewOperation(operation);
            }
        });
        builder.setView(dialogView);
        instance = builder.create();
        return instance;
    }

    public static class DialogInteractionListener{
        public interface BalanceViewListener{
            void onNewOperation(Operation operation);
        }
    }

}
