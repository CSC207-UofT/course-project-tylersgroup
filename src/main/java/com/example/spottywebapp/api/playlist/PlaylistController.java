package com.example.spottywebapp.api.playlist;

import com.example.spottywebapp.Entities.Playlist;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PlaylistController {

    private final PlaylistInteractor interactor;


    public PlaylistController(PlaylistInteractor interactor){
        this.interactor = interactor;
    }



    @GetMapping("/playlist")
    public ModelAndView makePlaylist(ModelMap model, @ModelAttribute("flashAttribute") Playlist playlist){

        interactor.save(playlist);
        model.addAttribute("playlistString", playlist.toString());
        return new ModelAndView("result", model);

//        ArrayList<String> splitInput = UserInputController.splitUserInput(input);
//
//        Playlist newPlaylist = PlaylistGenerator.generatePlaylist(splitInput);
//
//        return newPlaylist.toString();


    }


}
