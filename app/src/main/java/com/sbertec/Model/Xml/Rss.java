package com.sbertec.Model.Xml;

import org.simpleframework.xml.Element;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public class Rss {
    @Element(name="channel")
    private Channel channel;

    private String version;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "ClassPojo [channel = " + channel + ", version = " + version + "]";
    }
}
