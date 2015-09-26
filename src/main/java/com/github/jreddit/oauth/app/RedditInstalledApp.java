package com.github.jreddit.oauth.app;

public class RedditInstalledApp extends RedditApp {

    /**
     * Reddit Installed Application.<br>
     * <br>
     * <i>All</i> information given in this constructor <i>must</i>
     * match the information stated on reddit. The secret is defaulted
     * to an empty string.
     * 
     * @param clientID Client identifier (e.g. "p_jcolKysdMFud")
     * @param redirectURI Redirect URI (e.g. "http://www.example.com/auth")
     */
<<<<<<< HEAD
    public RedditInstalledApp(String clientID, String secretKey, String redirectURI) {
        super(clientID, secretKey, redirectURI); // Empty string is the secret for an installed app
=======
    public RedditInstalledApp(String clientID, String secret, String redirectURI) {
        super(clientID, secret, redirectURI); // Empty string is the secret for an installed app
>>>>>>> be1320e6ade623b15cde426ef1f47c5d9e75d837
    }
    
}
