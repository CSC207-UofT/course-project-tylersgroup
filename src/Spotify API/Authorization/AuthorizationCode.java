package authorization.authorization_code;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;


public class AuthorizationCode(object){
    private static final String clientID = "aad0ceac29e9477bae151417a721ecf5";
    private static final String token_url = "";
    private static final URI redirectURI = SpotifyHttpManager.makeUri("http:localhost:8080/api/get-user-code/");
    //TODO: I'm not sure if the above will work yet, need to test out.
    private String code = ""; //user access code, will eventually ask spotify for a user access token

    SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId("aad0ceac29e9477bae151417a721ecf5")
            .setClientSecret("de9884d5bbab4ac78171276d75383936")
            .setRedirectUri("<your_redirect_uri>")
            .build();

    //use "Authorization code flow" to retrieve an access token.

    private static final AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
            .build();

    // code to set up the access and refresh tokens in order to access data from the API.
    public static void authorizationCode_Sync(){
        try{
            final AuthorizationCodeCredentials = authorizationCodeRequest.execute();

            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

            //print when the token expires
        }
        catch(IOException | SpotifyWebApiException | ParseException e){
            System.out.println("Error: " + e.getMessage());
        }

        public static void authorizationCode_Async(){
            try{
                //TODO
            }
        }
    }
    public static void main(String[] args) {
        authorizationCode_Sync();
        authorizationCode_Async();
    }
}
