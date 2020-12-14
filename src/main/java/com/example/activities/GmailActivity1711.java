package com.example.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.view.ContextMenu;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.linearlayoutpractice.R;
import java.util.ArrayList;
import java.util.List;
import io.bloco.faker.Faker;

public class GmailActivity1711 extends AppCompatActivity implements Filterable {

    List<ItemModel> itemModels;
    List<ItemModel> itemModel;
    ListView listView;
    Faker faker;
    CustomAdapter adapter;
    ActionBar actionBar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_activity1711);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Inbox");
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.colorRed));
        actionBar.setIcon(R.drawable.reorder_foreground);

        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        faker = new Faker();

        itemModels = new ArrayList<>();
        itemModel = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            itemModels.add(new ItemModel(faker.name.firstName(), faker.book.title(), faker.book.genre(), "11:11", false));
            itemModel.add(new ItemModel(faker.name.firstName(), faker.book.title(), faker.book.genre(), "11:11", false));
        }
        listView = findViewById(R.id.list_view);
        adapter = new CustomAdapter(itemModel, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                registerForContextMenu(view);
                //view.setLongClickable(true);
                Log.v("TAG", "click click action");
            }
        });

        context = this;
        //registerForContextMenu(listView);
        //listView.setLongClickable(true);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
//        if (v.getId() == R.id.list_view) {
//            ListView lv = (ListView) v;
//            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
//            View view = (View) lv.getItemAtPosition(info.position);
//            menu.setHeaderTitle("Select action");
//            menu.add(0, 1, 0, "Reply");
//            menu.add(0, 2, 0, "Delete");
//        }

        menu.setHeaderTitle("Select action");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnu_rep) {
            Log.v("TAG", "REPLY action");
        } else if (item.getItemId() == R.id.mnu_del) {
            Log.v("TAG", "DELETE action");
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public Filter getFilter() {
        return resultFilter;
    }
    public Filter favouriteFilter() {
        return favFilter;
    }

    private  Filter resultFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ItemModel> filteredModels = new ArrayList<>();

            if(constraint == null || constraint.length() == 0) {
                filteredModels.addAll(itemModels);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ItemModel i : itemModels) {
                    if((i.getName().toLowerCase().contains((filterPattern))) ||
                            i.getTitle().toLowerCase().contains((filterPattern))) {
                        filteredModels.add(i);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredModels;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            itemModel.clear();
            itemModel.addAll((List) results.values);
            adapter.notifyDataSetChanged();
        }
    };

    private  Filter favFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ItemModel> filteredModels = new ArrayList<>();

            for (ItemModel i : itemModels)
            {
                if (i.clicked == true) filteredModels.add(i);
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredModels;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            itemModel.clear();
            itemModel.addAll((List) results.values);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gmail, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        //MenuItem favBtn = menu.findItem(R.id.action_fav);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.v("TAG", "onQueryTextSubmit: " + s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.v("TAG", "onQueryTextChange: " + s);
                getFilter().filter(s);
                return false;
            }
        });

//        favBtn.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                List<ItemModel> fav_items = new ArrayList<>();
//
//                for (ItemModel i : itemModels) {
//                    if (i.clicked == true)
//                        fav_items.add(i);
//                }
//
//                CustomAdapter fav_adapter = new CustomAdapter(fav_items, context);
//                listView.setAdapter(fav_adapter);
//                fav_adapter.notifyDataSetChanged();
//                return false;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Log.v("TAG", "SEARCH action");
        } else if (id == R.id.action_fav) {
            Log.v("TAG", "SHARE action");
            favouriteFilter().filter("0");
        }

        return super.onOptionsItemSelected(item);
    }
}

