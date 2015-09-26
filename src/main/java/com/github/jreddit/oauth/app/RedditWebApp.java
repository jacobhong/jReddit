package com.github.jreddit.oauth.app;

import org.apache.http.impl.client.HttpClientBuilder;

import com.github.jreddit.oauth.RedditOAuthAgent;
import com.github.jreddit.oauth.client.RedditClient;
import com.github.jreddit.oauth.client.RedditHttpClient;

public class RedditWebApp extends RedditApp {	

		private RedditInstalledApp redditApp;		
	    private RedditOAuthAgent agent;      
	    private RedditClient client;
     
    /**
     * Reddit Web Application.<br>
     * <br>
     * <i>All</i> information given in this constructor <i>must</i>
     * match the information stated on reddit.
     * 
     * @param clientID Client identifier (e.g. "p_jcolKysdMFud")
     * @param clientSecret Client secret (e.g. "gko_LXEJKF89djs98fhFJkj9s")
     * @param redirectURI Redirect URI (e.g. "http://www.example.com/auth")
     */
    public RedditWebApp(String clientID, String clientSecret, String redirectURI, String userAgent) {
        super(clientID, clientSecret, redirectURI);     
        redditApp = new RedditInstalledApp(clientID, clientSecret, redirectURI);
        agent = new RedditOAuthAgent(userAgent, redditApp);   
        client = new RedditHttpClient(userAgent, HttpClientBuilder.create().build());
    }

	public RedditInstalledApp getRedditApp() {
		return redditApp;
	}

	public void setRedditApp(RedditInstalledApp redditApp) {
		this.redditApp = redditApp;
	}

	public RedditOAuthAgent getAgent() {
		return agent;
	}

	public void setAgent(RedditOAuthAgent agent) {
		this.agent = agent;
	}

	public RedditClient getClient() {
		return client;
	}

	public void setClient(RedditClient client) {
		this.client = client;
	}
    
}
