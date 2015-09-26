package com.github.jreddit.request.retrieval.multireddits;

import com.github.jreddit.request.RedditGetRequest;

public class MultiredditsRequest extends RedditGetRequest {
	/** Endpoint format. */
    private String ENDPOINT_FORMAT = "/api/multi/user/";

    public MultiredditsRequest(String user) {
        super();
        ENDPOINT_FORMAT = ENDPOINT_FORMAT + user + ".json?";
    }
    
    @Override
    public String generateRedditURI() {
        return ENDPOINT_FORMAT;
    }
    
}
