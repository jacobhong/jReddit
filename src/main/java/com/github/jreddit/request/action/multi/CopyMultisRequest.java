package com.github.jreddit.request.action.multi;
/**
 * 
 * @author Jacob Hong
 *
 */
import com.github.jreddit.request.RedditPostRequest;

public class CopyMultisRequest extends RedditPostRequest{

    public CopyMultisRequest() {
		super();
		this.addBodyParameter("display_name", "android");
		this.addBodyParameter("from", "/user/134pp/m/manygifs");
		this.addBodyParameter("to", "/user/134p/m/test");

	}



	/** Endpoint format. */
    private static final String ENDPOINT_FORMAT = "/api/multi/copy.json?";


    
    @Override
    public String generateRedditURI() {
        return ENDPOINT_FORMAT;
    }

    
}
