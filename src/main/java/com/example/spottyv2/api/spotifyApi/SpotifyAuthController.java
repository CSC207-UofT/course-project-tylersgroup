package com.example.spottyv2.api.spotifyApi;

import com.example.spottyv2.Controllers.MakeUserController;
import com.example.spottyv2.api.Serializer.JsonSerializer;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.model_objects.specification.User;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.spottyv2.api.spotifyApi.SpotifyUserController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * Handles authorization for spotifyApi.
 */

@RestController //restful web services
@RequestMapping("/api")
public class SpotifyAuthController {
    private static final String CLIENT_ID = "aad0ceac29e9477bae151417a721ecf5";
    private static final String CLIENT_SECRET = "de9884d5bbab4ac78171276d75383936";
    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/api/get-user-code");
    public String code = "";

    /**
     * Creation of a spotifyApi object that can be used by other related spotify controllers.
     *
     */
    public static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRedirectUri(redirectUri)
            .build();

    /**
     * Login to spotify, requests scopes
     * @param attributes redirect view
     * @return uri which sends the user to login screen.
     */

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


    /**
     * Gets unique user code from currently logged in spotify user
     * @param userCode Usercode from quthorization code request
     * @param response response from server
     * @return accessToken string
     * @throws IOException
     */
    @GetMapping(value = "get-user-code")
    public String getSpotifyUserCode(@RequestParam("code") String userCode, HttpServletResponse response) throws IOException{
        code = userCode;
        String userId;
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
        User loggedUser = SpotifyUserController.getCurrentUser();
        String url = String.format("/home?id=%s", loggedUser.getId());
        response.sendRedirect(url);
        //Saving the new spotify user to the Json file
        JsonSerializer userSaver = new JsonSerializer();
        MakeUserController userMaker = new MakeUserController();
        userSaver.saveUser(userMaker.makeUser(loggedUser.getId(), true));

        return spotifyApi.getAccessToken();

    }

}