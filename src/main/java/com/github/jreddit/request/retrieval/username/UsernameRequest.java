package com.github.jreddit.request.retrieval.username;

import com.github.jreddit.request.RedditGetRequest;

public class UsernameRequest extends RedditGetRequest {
	/** Endpoint format. */
    private final String ENDPOINT_FORMAT = "/api/v1/me.json?";

    public UsernameRequest() {
        super();
    }
    
    @Override
    public String generateRedditURI() {
        return ENDPOINT_FORMAT;
    }
}
