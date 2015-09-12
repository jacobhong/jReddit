package examples;

import java.util.Scanner;

import org.apache.http.ParseException;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.github.jreddit.oauth.RedditOAuthAgent;
import com.github.jreddit.oauth.RedditToken;
import com.github.jreddit.oauth.app.RedditApp;
import com.github.jreddit.oauth.app.RedditInstalledApp;
import com.github.jreddit.oauth.client.RedditClient;
import com.github.jreddit.oauth.client.RedditHttpClient;
import com.github.jreddit.oauth.exception.RedditOAuthException;
import com.github.jreddit.oauth.param.RedditDuration;
import com.github.jreddit.oauth.param.RedditScope;
import com.github.jreddit.oauth.param.RedditScopeBuilder;
import com.github.jreddit.request.retrieval.Multireddits.MultiredditsRequest;
import com.github.jreddit.request.retrieval.username.UsernameRequest;

public class ExampleMultiSub {

    public static void main(String[] args) throws RedditOAuthException, ParseException, org.json.simple.parser.ParseException {

        // Information about the app
        String userAgent = "jReddit: Reddit API Wrapper for Java";
        String clientID = "qNGuNwlfKGc_nw";
        String secret = "7VTq9-BKCt4ZHhMJsvf_XNdbn0c";
        String redirectURI = "https://localhost:8080/jboss-javaee6-webapp/rest/redditProfilePorter/";
        
        // Reddit application
        RedditApp redditApp = new RedditInstalledApp(clientID, secret, redirectURI);
        
        // Create OAuth agent
        RedditOAuthAgent agent = new RedditOAuthAgent(userAgent, redditApp);    
        
        // Create request executor 
        RedditClient client = new RedditHttpClient(userAgent, HttpClientBuilder.create().build());
       
        RedditScopeBuilder scopeBuilder = new RedditScopeBuilder();
        scopeBuilder.addScope(RedditScope.IDENTITY);
        scopeBuilder.addScope(RedditScope.READ);
        
        System.out.println(agent.generateCodeFlowURI(scopeBuilder, RedditDuration.PERMANENT));
        Scanner scan = new Scanner(System.in);
        String code = scan.next().trim();
        // Input the code below:
        scan.close();
        // Ask for token
        RedditToken token = agent.token(code);
        // To try when not authenticated: RedditToken token = agent.tokenAppOnly(false);

        // Create the request
        UsernameRequest user = new UsernameRequest();
        String usernameJSON = client.get(token, user);
        System.out.println("json\n" + usernameJSON);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject((JSONObject)parser.parse(usernameJSON));
        System.out.println("prety print \n " + jsonObject.toString()); // Print it with specified indentation

        String username = (String) jsonObject.get("name");
        System.out.println("name : " + username);
        
        MultiredditsRequest request = new MultiredditsRequest(username);
        System.out.println("subreddits >> > > \n " + client.get(token, request));
        



    }
    
    public String getUserToken() throws ParseException, RedditOAuthException, org.json.simple.parser.ParseException{

        // Information about the app
        String userAgent = "jReddit: Reddit API Wrapper for Java";
        String clientID = "qNGuNwlfKGc_nw";
        String secret = "7VTq9-BKCt4ZHhMJsvf_XNdbn0c";

        String redirectURI = "https://localhost:8080/jboss-javaee6-webapp/rest/redditProfilePorter/";
        
        // Reddit application
        RedditApp redditApp = new RedditInstalledApp(clientID, secret, redirectURI);
        
        // Create OAuth agent
        RedditOAuthAgent agent = new RedditOAuthAgent(userAgent, redditApp);    
        
        // Create request executor 
        RedditClient client = new RedditHttpClient(userAgent, HttpClientBuilder.create().build());
       
        RedditScopeBuilder scopeBuilder = new RedditScopeBuilder();
        scopeBuilder.addScope(RedditScope.IDENTITY);
        scopeBuilder.addScope(RedditScope.READ);
        System.out.println(agent.generateCodeFlowURI(scopeBuilder, RedditDuration.PERMANENT));
        Scanner scan = new Scanner(System.in);
        String code = scan.next().trim();
        // Input the code below:
        scan.close();
        // Ask for token
        RedditToken token = agent.token(code);
        // To try when not authenticated: RedditToken token = agent.tokenAppOnly(false);

        // Create the request
        UsernameRequest user = new UsernameRequest();
        String usernameJSON = client.get(token, user);
        System.out.println("json\n" + usernameJSON);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject((JSONObject)parser.parse(usernameJSON));
        System.out.println("prety print \n " + jsonObject.toString()); // Print it with specified indentation

        String username = (String) jsonObject.get("name");
        System.out.println("name : " + username);
        
        MultiredditsRequest request = new MultiredditsRequest(username);
        System.out.println("subreddits >> > > \n " + client.get(token, request));
		return  client.get(token, request);
        
    }
    
}
