package com.sbertec.Model.Xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public class Channel {
    @Element(name="pubDate")
    private String pubDate;

    @Element(name="title")
    private String title;

    @Element(name="managingEditor")
    private String managingEditor;

    @Element(name="description")
    private String description;

    @Element(name="link")
    private String link;

    /*@Element(name="lastBuildDate")*/
    private String lastBuildDate;

    @ElementList(inline = true, required = false)
    private List<Item> items;

    @Element(name="generator")
    private String generator;

    @Element(name="image")
    private Image image;

    @Element(name="language")
    private String language;

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManagingEditor() {
        return managingEditor;
    }

    public void setManagingEditor(String managingEditor) {
        this.managingEditor = managingEditor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}


