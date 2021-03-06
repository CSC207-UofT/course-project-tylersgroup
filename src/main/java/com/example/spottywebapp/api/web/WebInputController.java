package com.example.spottywebapp.api.web;

import com.example.spottywebapp.Controllers.MakePlaylistController;
import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.api.Serializer.Serializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@ControllerAdvice
public class WebInputController {


    @RequestMapping(value="/PlayGen", method = RequestMethod.POST)
    public @ResponseBody
    RedirectView submitPost(HttpServletRequest request,
                            @ModelAttribute("WebInput") WebInput input,
                            RedirectAttributes attributes) {
        String out;
        Playlist playlist;

        if (input.isValid()) {
            System.out.println(input); //Logging to console for testing purposes
            MakePlaylistController MakePlaylist = new MakePlaylistController();
            //String username = "testUser";
            if (input.getNum() == 1){
                playlist = MakePlaylist.makePlaylistWeb(input.getInput(), "longest");
            } else {
                playlist = MakePlaylist.makePlaylistWeb(input.getInput(), "shortest");
            }
            Serializer write = new Serializer();
            write.serialize(playlist);

            //Logging to console
            out = playlist.toString();
            attributes.addFlashAttribute("playlist", playlist);


        } else{
            out = "failed";
        }
        System.out.println(out);
        return new RedirectView("/result", true);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public String result(HttpServletRequest request){
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            Playlist playlist = (Playlist) inputFlashMap.get("playlist");
            System.out.println("Result: " + playlist);
            return "<html><head>\n" +
                    "<style>\n" +
                    "body {background-color: #bc7089;}\n" +
                    "h1   {color: white;" +
                    "      font-family: Arial, Helvetica, sans-serif;}\n" +
                    "p    {color: white;" +
                    "      font-family: Arial, Helvetica, sans-serif;}\n" +
                    "" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Generated Playlist</h1>\n" +
                    "<h2>" + playlist.toString() + "</h2></body></html>";

        }else{
            return "failed";
        }

    }

    @GetMapping(value = "/manage")
    @ResponseBody
    public String manage(){
        Serializer getter = new Serializer();
        StringBuilder out = new StringBuilder();
        for (String playlist: getter.getPlaylists()){
            out.append("<li>");
            out.append(playlist).append("\n");
            out.append("</li>");
        }
        return "<html><head>\n" +
                "<style>\n" +
                "body {background-color: #bc7089;}\n" +
                "h1   {color: white;" +
                "      font-family: Arial, Helvetica, sans-serif;}\n" +
                "p    {color: white;" +
                "      font-family: Arial, Helvetica, sans-serif;}\n" +
                "" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Generated Playlists</h1>\n" +
                "<h2>" + out + "</h2></body></html>";

    }


}
