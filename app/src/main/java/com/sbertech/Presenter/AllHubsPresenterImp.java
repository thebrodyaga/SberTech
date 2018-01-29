package com.sbertech.Presenter;

import com.sbertech.Model.AllHubsModel;
import com.sbertech.Model.Xml.Rss;
import com.sbertech.View.MainActivityView;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public class AllHubsPresenterImp implements AllHubsPresenter, AllHubsModel.OnFinishedListener {
    private MainActivityView view;
    private AllHubsModel model;

    public AllHubsPresenterImp(MainActivityView view, AllHubsModel model) {
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
    public void onSuccessful(Rss result) {
        if (view != null) {
            view.setData(result);
            view.hideProgress();
        }
    }

    @Override
    public void onError(String message) {
        if (view != null) {
            view.showMessage(message);
            view.hideProgress();
        }
    }
}
