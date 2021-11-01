package authorization.authorization_code;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class AuthorizationCodeUri {
    private static final String clientId = "aad0ceac29e9477bae151417a721ecf5";
    private static final String clientSecret = "de9884d5bbab4ac78171276d75383936";
    private static final URI redirectUri = SpotifyHttpManager.makeUri("https://example.com/spotify-redirect");

    private static final SpotifyApi spotifyApi = new SpotifyApi.builder()
            .setClientID(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();

    private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
    //.scope("enter the scopes that we want to have access to");
    //.show_dialogue(true)
            .build();

    public static void authorizationCode_Sync(){
        final URI uri = authorizationCodeUriRequest.execute();

        System.out.println("URI: " + uri.toString());
    }

    public static void main(String[] args) {
        authorizationCodeUri_Sync();
        authorizationCodeUri_Async();
    }
}