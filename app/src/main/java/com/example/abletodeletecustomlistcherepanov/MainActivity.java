package com.example.abletodeletecustomlistcherepanov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abletodeletecustomlistcherepanov.adapters.ContactAdapter;
import com.example.abletodeletecustomlistcherepanov.model.Contact;
import com.example.abletodeletecustomlistcherepanov.adapters.ContactAdapter;
import com.example.abletodeletecustomlistcherepanov.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;
    SwipeRefreshLayout refreshLayout;
    List<Contact> list = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void itemActions(final ContactAdapter adapter) {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position + " position", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(view == button) {
                    list.remove(position);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void init() {
        listView = findViewById(R.id.list_view);
        button = findViewById(R.id.delete_button);
        refreshLayout = findViewById(R.id.refresh_layout);

        prepareContent();
        ContactAdapter contactAdapter = new ContactAdapter(list, this);
        listView.setAdapter(contactAdapter);
        itemActions(contactAdapter);
        refreshList(contactAdapter);
    }

    private void refreshList(final ContactAdapter adapter) {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
                list.clear();
                prepareContent();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void prepareContent() {
        list.add(new Contact("Vasya"
                , "+7(324)321-31-12"
                , false));

        list.add(new Contact("Petya"
                , "+7(432)123-12-43"
                , false));

        list.add(new Contact("Grisha"
                , "+7(765)987-87-65"
                , false));
    }


}
