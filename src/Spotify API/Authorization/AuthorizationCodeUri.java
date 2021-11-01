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
}