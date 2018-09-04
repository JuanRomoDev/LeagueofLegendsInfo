package com.juanromodev.leagueoflegendsinfo.ui.items;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.juanromodev.leagueoflegendsinfo.R;
import com.juanromodev.leagueoflegendsinfo.data.model.item.Item;
import com.juanromodev.leagueoflegendsinfo.data.remote.DataDragonClient;

import java.util.List;

public class ItemsFragment extends Fragment implements ItemsContract.View {

    private ItemsContract.Presenter presenter;

    private RecyclerView itemsRecyclerView;
    private ProgressBar itemsProgressBar;
    private ItemsAdapter itemsAdapter;

    public static ItemsFragment newInstance() {
        return new ItemsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new ItemsPresenter(DataDragonClient.Factory.getDataDragonClient(), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_items, container, false);

        itemsRecyclerView = root.findViewById(R.id.items_recycler_view);

        itemsRecyclerView.setHasFixedSize(true);

        itemsRecyclerView.setLayoutManager(
                new LinearLayoutManager(getContext())
        );

        itemsProgressBar = root.findViewById(R.id.items_progress_bar);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(ItemsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            itemsProgressBar.setVisibility(View.VISIBLE);
        } else {
            itemsProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showItems(List<Item> items) {
        itemsAdapter = new ItemsAdapter(items);
        itemsRecyclerView.setAdapter(itemsAdapter);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    private class ItemsAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        private List<Item> itemList;

        public ItemsAdapter(List<Item> itemList) {
            this.itemList = itemList;
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

            return new ItemViewHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            Item item = itemList.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView itemNameTextView;

        private Item item;

        public ItemViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_item, parent, false));
            itemView.setOnClickListener(this);

            itemNameTextView = itemView.findViewById(R.id.item_name_text_view);
        }

        public void bind(Item item) {
            this.item = item;

            itemNameTextView.setText(item.getName());
        }

        @Override
        public void onClick(View view) {
            presenter.openItemDetails(item);
        }
    }
}
