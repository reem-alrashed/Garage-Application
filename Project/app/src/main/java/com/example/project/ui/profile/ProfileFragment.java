package com.example.project.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.project.Customer;
import com.example.project.DBHelper;
import com.example.project.R;
import com.google.android.material.snackbar.Snackbar;

public class ProfileFragment extends Fragment {
    LinearLayout coordinatorLayout;
    Button saveBtn;
    EditText name, username, password, phone, email;
    String CurrentUsername;
    DBHelper db;
    Customer customer;
    public int id;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        db = new DBHelper(getContext());
        customer = new Customer();
        coordinatorLayout = view.findViewById(R.id.profileLL);
        name = view.findViewById(R.id.namemyaccount);
        username = view.findViewById(R.id.usernamemyaccount);
        password = view.findViewById(R.id.passmyaccout);
        email = view.findViewById(R.id.emailmyaccount);
        phone = view.findViewById(R.id.myaccountphoneET);
        saveBtn = view.findViewById(R.id.saveBtn);

        fillData();//get user information from database

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        return view;
    }//end of onCreateView()

    private void fillData() {
        Bundle extras = getActivity().getIntent().getExtras();
        assert extras != null;
        CurrentUsername = extras.getString("username");

        customer = db.getCustomer(CurrentUsername);
        id=customer.getId();
        name.setText(customer.getName());
        username.setText(customer.getUsername());
        password.setText(customer.getPassword());
        email.setText(customer.getEmail());
        phone.setText(Integer.toString(customer.getPhoneNumber()));

    }//end fillData()

    private void updateData() {
        try {
            db.updateCustomer(name.getText().toString(), username.getText().toString(),
                    password.getText().toString(), Integer.parseInt(phone.getText().toString()),
                    email.getText().toString(),id);

            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "تم حفظ التغييرات بنجاح! ", Snackbar.LENGTH_LONG);
            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//end of updateData()


}//end of fragment