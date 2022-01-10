package com.example.orion;

import static com.example.orion.MainActivity.myPeople;
import static com.example.orion.MainActivity.peoplePics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<String> filteredlist;
    String searchedText;
    ListView listView;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        filteredlist= new ArrayList<>();
        filteredlist.addAll(myPeople);

        listView= findViewById(R.id.listview);
        adapter = new DataAdapter(this, R.layout.single_listview, filteredlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent = new Intent(SearchActivity.this, userActivity.class);
                intent.putExtra("name", filteredlist.get(position));
                int imagePosition= myPeople.indexOf(filteredlist.get(position));
                intent.putExtra("pic", peoplePics.get(imagePosition));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                searching=true;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                adapter.filterList(myPeople);
//                searching=false;
                return false;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchedText=newText;
                filter(newText);
                return false;
            }
        });

        return true;
    }

    private void filter(String text) {
        filteredlist.clear();

        for (String item : myPeople) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            adapter.filterList(filteredlist);
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            adapter.filterList(filteredlist);
        }
    }


}