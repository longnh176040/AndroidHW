package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.linearlayoutpractice.R;
import java.util.ArrayList;
import java.util.List;
import io.bloco.faker.Faker;

public class GmailActivity1711 extends AppCompatActivity {

    List<ItemModel> itemModels;
    ListView listView;
    Faker faker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_activity1711);

         faker = new Faker();

        itemModels = new ArrayList<>();

        for (int i = 0; i < 100; i++)
            itemModels.add(new ItemModel(faker.name.firstName(), faker.book.title(), faker.book.genre(), "11:11",false));

        listView = findViewById(R.id.list_view);
        CustomAdapter adapter = new CustomAdapter(itemModels, this);
        listView.setAdapter(adapter);
    }
}

