package com.example.project.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.project.R;
import com.example.project.SplashActivity;


public class SettingFragment extends Fragment {
    Button logoutBtn;
    AlertDialog.Builder builder;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        builder = new AlertDialog.Builder(getContext());

        logoutBtn = (Button) view.findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutDialogMessage();
            }
        });
        return view;
    }

    public void showLogoutDialogMessage() {
        builder.setMessage("هل أنت متأكد تريد تسجيل الخروج؟").setTitle("تسجيل الخروج")
                .setIcon(R.drawable.logout)
                .setCancelable(false)
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getContext(), SplashActivity.class));
                    }
                }).setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        //Creating dialog box
        AlertDialog alert = builder.create();
        alert.show();


    }

}//end of fragment