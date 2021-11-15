package com.example.spottywebapp.api.spotifyApi;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;


@RestController //restful web services
@RequestMapping("/api")
public class SpotifyAuthController {
    private static final String CLIENT_ID = "aad0ceac29e9477bae151417a721ecf5";
    private static final String CLIENT_SECRET = "de9884d5bbab4ac78171276d75383936";
    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/api/get-user-code");
    public String code = "";

    //create spotifyapi object
    public static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRedirectUri(redirectUri)
            .build();


    @GetMapping("login")
    @ResponseBody
    public RedirectView spotifyLogin(RedirectAttributes attributes){
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
                .scope("playlist-modify-public, user-read-private, user-top-read")
                .show_dialog(true)
                .build();
        final URI uri = authorizationCodeUriRequest.execute();
        return new RedirectView(uri.toString());
    }

    //request param requests the usercode, which is the parameter we need to ask spotify for a user access token so
    //spotify knows that the user has authenticated. Httpservletresponse will allow us to redirect back to our
    //front end
    @GetMapping(value = "get-user-code")
    public String getSpotifyUserCode(@RequestParam("code") String userCode, HttpServletResponse response) throws IOException{
        code = userCode;
        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(code)
                .build();

        try{
            final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());
            System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
        }
        catch( IOException | SpotifyWebApiException | org.apache.hc.core5.http.ParseException e){
            System.out.println("Error: " + e.getMessage());
        }
        // System.out.println(spotifyApi.getAccessToken());
        response.sendRedirect("http://localhost:8080/home");
        return spotifyApi.getAccessToken();

    }

}