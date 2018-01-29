package com.sbertec.View;

import com.sbertec.Model.Xml.Rss;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public interface MainActivityView {
    void getData();

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void setData(Rss result);
}
