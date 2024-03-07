package com.es2.bridge;

import java.util.LinkedHashMap;

public class APIMoodle extends Object implements APIServiceInterface {
    protected LinkedHashMap<String, String> content;

    public APIMoodle() {
        this.content = new LinkedHashMap<>();
    }

    public String getContent(String contentId) {
        if (contentId.equals("0")) {
            return String.join("", this.content.values());
        }

        if (!this.content.containsKey(contentId)) {
            return null;
        }

        return this.content.get(contentId);
    }

    public String setContent(String content) {
        String id = generateId();
        this.content.put(id, content);
        return id;
    }

    private String generateId() {
        return java.util.UUID.randomUUID().toString();
    }
}
