package ru.imkovach.coloreffect;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.widget.LinearLayout.VERTICAL;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorListFragment extends Fragment {

    private ColorListListener mainActivity;

    // Создадим интерфейс, через который мы будем передавать номер строки списка, нажатой пользователем
    interface ColorListListener {
        void onListItemClick(int id);
    }

    @Override
    public void onAttach(Context context) {

        mainActivity = (ColorListListener) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_color_list, container, false);

        RecyclerView colorsRecyclerView = view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(VERTICAL);
        colorsRecyclerView.setLayoutManager(layoutManager);

        colorsRecyclerView.setAdapter(new MyAdapter());

        // Inflate the layout for this fragment
        return view;

    }

    private class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView categoryNameTextView;

        MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.color_list_item, parent, false));
            itemView.setOnClickListener(this);
            categoryNameTextView = itemView.findViewById(R.id.category_name_text_view);
        }

        private void bind(int position) {
            String category = Color.colors[position].getColorName();
            categoryNameTextView.setText(category);
        }

        @Override
        public void onClick(View view) {
            showColorActivity(this.getLayoutPosition());
        }
    }

    // Адаптер для RecyclerView
    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new MyViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.bind(position);
        }

        @Override
        public int getItemCount() {
            return Color.colors.length;
        }
    }

    // Запускаем Activity для конкретной услуги
    private void showColorActivity(int categoryId) {
        mainActivity.onListItemClick(categoryId);
    }

}
