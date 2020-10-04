package com.example.project.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.project.AddToCart;
import com.example.project.BooksCategory;
import com.example.project.ElectronicCategory;
import com.example.project.HomeAccessoriesCategory;
import com.example.project.HomeApplianceCategory;
import com.example.project.MainActivity;
import com.example.project.R;


public class DashboardFragment extends Fragment {
    private ImageView booksCategory, homeAccessoriceCategory, electronicCategory, homeApplianceCategory;
    private Button cart_page;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        booksCategory = (ImageView) view.findViewById(R.id.categoryBooks);
        homeAccessoriceCategory = (ImageView) view.findViewById(R.id.categoryHome);
        electronicCategory = (ImageView) view.findViewById(R.id.categoryElectronic);
        homeApplianceCategory = (ImageView) view.findViewById(R.id.categoryFurnitures);

        booksCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BooksCategory.class));
            }
        });
        homeAccessoriceCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HomeAccessoriesCategory.class));
            }
        });
        electronicCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ElectronicCategory.class));
            }
        });
        homeApplianceCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HomeApplianceCategory.class));
            }
        });

        cart_page = view.findViewById(R.id.cart_page);
        cart_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddToCart.class));
            }
        });

        return view;
    }//end of onCreate()
}//end of fragment