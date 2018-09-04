package com.juanromodev.leagueoflegendsinfo.ui.items;

import com.juanromodev.leagueoflegendsinfo.data.model.item.Item;
import com.juanromodev.leagueoflegendsinfo.ui.base.BasePresenter;
import com.juanromodev.leagueoflegendsinfo.ui.base.BaseView;

import java.util.List;

public interface ItemsContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showItems(List<Item> items);

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

        void loadItems();

        void openItemDetails(Item requestedItem);
    }
}
