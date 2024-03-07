package com.es2.bridge;

import java.util.LinkedHashMap;

public class APIRequest extends Object {
    protected LinkedHashMap<String, APIServiceInterface> services;

    public APIRequest() {
        this.services = new LinkedHashMap<>();
    }

    public String addService(APIServiceInterface service) {
        String id = generateId();
        this.services.put(id, service);
        return id;
    }

    public String getContent(String serviceId, String contentId) throws ServiceNotFoundException {
        if (!serviceId.equals("0") && !this.services.containsKey(serviceId)) {
            throw new ServiceNotFoundException("Service not found");
        }

        return this.services.get(serviceId).getContent(contentId);
    }

    public String setContent(String serviceId, String content) throws ServiceNotFoundException {
        if (!serviceId.equals("0") && !this.services.containsKey(serviceId)) {
            throw new ServiceNotFoundException("Service not found");
        }

        return this.services.get(serviceId).setContent(content);
    }

    private String generateId() {
        return java.util.UUID.randomUUID().toString();
    }
}
