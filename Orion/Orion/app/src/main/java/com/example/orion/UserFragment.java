package com.example.orion;

import static com.example.orion.MainActivity.myPeople;
import static com.example.orion.MainActivity.peoplePics;

import android.content.Intent;
import android.icu.text.DateFormatSymbols;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class UserFragment extends Fragment {
    ListView listView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user, container, false);
        listView=view.findViewById(R.id.listview);



            DataAdapter adapter = new DataAdapter(getContext(), R.layout.single_listview, myPeople);
            listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent = new Intent(getContext(), userActivity.class);
                intent.putExtra("name", myPeople.get(position));
                intent.putExtra("pic", peoplePics.get(position));
                startActivity(intent);
            }
        });
    return view;
    }
}
