package com.sbertech.presenter;

import android.support.annotation.Nullable;

import com.sbertech.model.AllHubsModel;
import com.sbertech.model.Xml.Rss;
import com.sbertech.view.FragmentView;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public class AllHubsPresenterImp implements AllHubsPresenter, AllHubsModel.OnFinishedListener {
    private FragmentView view;
    private AllHubsModel model;

    public AllHubsPresenterImp(FragmentView view, AllHubsModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void loadDate() {
        if (view != null)
            view.showProgress();
        model.loadDate(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void refreshData() {
        model.loadDate(this);
    }

    @Override
    public void onSuccessful(Rss result) {
        if (view != null) {
            view.setData(result);
            view.hideProgress();
        }
    }

    @Override
    public void onError(@Nullable String message) {
        if (view != null) {
            view.hideProgress();
            view.showMessage(message != null ? message : "Что-то пошло не так :(");
        }
    }
}
