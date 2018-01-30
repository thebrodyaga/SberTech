package com.sbertech.view;

import com.sbertech.model.Xml.Rss;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public interface FragmentView {
    void getData();

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void setData(Rss result);
}
