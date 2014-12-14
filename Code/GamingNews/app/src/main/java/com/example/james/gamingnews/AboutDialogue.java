package com.example.james.gamingnews;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Created by James on 13/12/2014.
 */
public class AboutDialogue extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder mcAboutDialog = new AlertDialog.Builder(getActivity());
        mcAboutDialog.setMessage("Gaming Reviews")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }

                }
                );

        mcAboutDialog.setTitle("About");
        mcAboutDialog.setIcon(R.drawable.ic_action_about);
        return mcAboutDialog.create();



    }

}


