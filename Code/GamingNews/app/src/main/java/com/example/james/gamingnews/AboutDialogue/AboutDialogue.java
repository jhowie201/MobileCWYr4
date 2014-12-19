package com.example.james.gamingnews.AboutDialogue;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.example.james.gamingnews.R;

//User Import Statements!
/**
 * Created by James on 13/12/2014.
 */

//JAMES HOWIE S1310206 MUC GamingNews Application!
public class AboutDialogue extends DialogFragment { //About Dialog Class
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder mcAboutDialog = new AlertDialog.Builder(getActivity());
        mcAboutDialog.setMessage("Gaming News Application - Parsing Data from GameSpot.com") //Message In AlertBox
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() { //Button in AlertBox
                    public void onClick(DialogInterface dialog, int id) {

                    }

                }
                );

        mcAboutDialog.setTitle("About"); //AlertBox Title
        mcAboutDialog.setIcon(R.drawable.ic_action_about); //
        return mcAboutDialog.create(); //Returns Create AlertBox



    }

}


