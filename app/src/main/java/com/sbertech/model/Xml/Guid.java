package com.sbertech.model.Xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Created by Emelyanov.N4 on 29.01.2018.
 */

public class Guid {
    @JacksonXmlText
    private String content;

    @JacksonXmlProperty(isAttribute = true)
    private Boolean isPermaLink;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getIsPermaLink() {
        return isPermaLink;
    }

    public void setIsPermaLink(Boolean isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    @Override
    public String toString() {
        return "ClassPojo [content = " + content + ", isPermaLink = " + isPermaLink + "]";
    }
}
