package com.example.pr_19;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;
public class CustomDialogFragment extends DialogFragment{
    Activity activity;
    public CustomDialogFragment(Activity act)
    {
        activity=act;
    }
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Передача данных")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Передать данные в окно")
                .setPositiveButton("Передать данные", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TextView txt;
                        txt=activity.findViewById(R.id.time_pick);
                        txt.setText("Передано");
                    }
                })
                .setNegativeButton("Не передавать", null)
                .create();
    }

}
