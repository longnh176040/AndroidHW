package com.example.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.linearlayoutpractice.R;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<ItemModel> itemModels;
    Context context;
    int count = 0;

    public CustomAdapter(List<ItemModel> items, Context context) {
        this.itemModels = items;
        this.context = context;
        count = 0;
    }

    @Override
    public int getCount() { return itemModels.size(); }

    @Override
    public Object getItem(int position) {
        return itemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         final ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.imageName = view.findViewById(R.id.text_avatar);
            viewHolder.name = view.findViewById(R.id.text_user);
            viewHolder.title = view.findViewById(R.id.text_title);
            viewHolder.content = view.findViewById(R.id.text_content);
            viewHolder.time = view.findViewById(R.id.text_time);
            viewHolder.starButton = view.findViewById(R.id.btn_fav);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final ItemModel item = itemModels.get(i);

        viewHolder.imageName.setText(item.getImageName());
        viewHolder.name.setText(item.getName());
        viewHolder.title.setText(item.getTitle());
        viewHolder.content.setText(item.getContent());
        viewHolder.time.setText(item.getTime());

        viewHolder.starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = item.clicked;
                item.clicked = !check;
                if (check) {
                    viewHolder.starButton.setBackgroundResource(R.drawable.star_foreground);
                } else viewHolder.starButton.setBackgroundResource(R.drawable.ic_launcher_foreground);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}

class ViewHolder {
    TextView imageName;
    TextView name;
    TextView title;
    TextView content;
    TextView time;
    ImageButton starButton;
}
