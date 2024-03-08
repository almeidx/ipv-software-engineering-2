package com.es2.composite;

public class Link extends Menu {
    private String url;

    public Link() {
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    /**
     * Print the label and URL of the link
     */
    public void showOptions() {
        System.out.println(getLabel());
        System.out.println(getURL());
    }
}
