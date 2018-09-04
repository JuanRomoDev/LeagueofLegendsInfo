package com.juanromodev.leagueoflegendsinfo.ui.items;

import android.util.Log;

import com.juanromodev.leagueoflegendsinfo.data.model.item.Item;
import com.juanromodev.leagueoflegendsinfo.data.remote.DataDragonClient;
import com.juanromodev.leagueoflegendsinfo.data.remote.response.ItemResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ItemsPresenter implements ItemsContract.Presenter {

    private static final String TAG = ItemsPresenter.class.getSimpleName();

    private final DataDragonClient itemsRepository; // TODO Implement items repository

    private final ItemsContract.View itemsView;

    public ItemsPresenter(DataDragonClient itemsRepository, ItemsContract.View itemsView) {
        this.itemsRepository = itemsRepository;
        this.itemsView = itemsView;

        itemsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadItems();
    }

    @Override
    public void loadItems() {
        itemsView.setLoadingIndicator(true);

        itemsRepository.getRealm("na") // TODO Implement realm code as a preference
                .flatMap(realm -> itemsRepository.getItems(realm.getDataDragonVersion(), realm.getLocale()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ItemResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ItemResponse itemResponse) {
                        if (!itemsView.isActive()) {
                            return;
                        }
                        itemsView.setLoadingIndicator(false);

                        List<Item> itemList = new ArrayList<>(itemResponse.getData().values());

                        itemsView.showItems(itemList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO Show error message
                    }
                });
    }

    @Override
    public void openItemDetails(Item requestedItem) {
        Log.i(TAG, requestedItem.getName() + " clicked");
        // TODO Navigate to item details screen
    }
}
