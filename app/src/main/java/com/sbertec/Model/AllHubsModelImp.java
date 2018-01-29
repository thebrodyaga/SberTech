package com.sbertec.Model;

import com.sbertec.Model.Xml.Rss;

import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public class AllHubsModelImp implements AllHubsModel {

    @Override
    public void loadDate(final OnFinishedListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String url = "https://habrahabr.ru/rss/hubs/all/";

                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                    con.setRequestMethod("GET");
                    int responseCode = con.getResponseCode();
                    System.out.println("\nSending 'GET' request to URL : " + url);
                    System.out.println("Response Code : " + responseCode);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    listener.onSuccessful(parseXml(response.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.onError(e.getMessage());
                }
            }
        }).start();
    }

    private Rss parseXml(String xml) throws Exception {
        return new Persister().read(Rss.class, new StringReader(xml), false);
    }
}