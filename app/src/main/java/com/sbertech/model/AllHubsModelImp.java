package com.sbertech.model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sbertech.model.Xml.Rss;


import java.io.BufferedReader;
import java.io.InputStreamReader;
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
                    if (responseCode != 200)
                        throw new Exception("Что-то пошло не так");
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

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
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, Rss.class);
    }
}