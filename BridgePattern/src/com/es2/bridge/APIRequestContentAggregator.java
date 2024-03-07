package com.es2.bridge;

public class APIRequestContentAggregator extends APIRequest {
    public APIRequestContentAggregator() {
        super();
    }

    public String getContent(String serviceId, String contentId)
            throws ServiceNotFoundException {
        if (!this.services.containsKey(serviceId)) {
            throw new ServiceNotFoundException("Service not found");
        }

        return this.services.get(serviceId).getContent(contentId);
    }
}
