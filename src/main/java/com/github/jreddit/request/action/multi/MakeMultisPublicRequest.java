package com.github.jreddit.request.action.multi;
/**
 * @author Jacob Hong
 */
import com.github.jreddit.request.RedditPostRequest;

public class MakeMultisPublicRequest extends RedditPostRequest{
	private String ENDPOINT_FORMAT = "/api/multi";

    public MakeMultisPublicRequest(String _multiPath, String multi) {
		super();
		ENDPOINT_FORMAT += (_multiPath + ".json?");
		this.addBodyParameter("model", multi);
		this.addBodyParameter("expand_srs", "true");
	}
    
    @Override
    public String generateRedditURI() {
        return ENDPOINT_FORMAT;
    }


}
