package com.sbertec.Model;

import com.sbertec.Model.Xml.Rss;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public interface AllHubsModel {
    void loadDate(OnFinishedListener listener);

    interface OnFinishedListener {
        void onSuccessful(Rss result);
        void onError(String message);
    }
}
