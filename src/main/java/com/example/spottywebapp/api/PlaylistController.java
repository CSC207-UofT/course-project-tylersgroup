package com.example.spottywebapp.api;

import com.example.spottywebapp.Entities.Playlist;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaylistController {

    private final PlaylistInteractor interactor;


    public PlaylistController(PlaylistInteractor interactor){
        this.interactor = interactor;
    }



    @PostMapping("/playlist")
    Playlist makePlaylist(@RequestBody Playlist newPlaylist){
        return interactor.save(newPlaylist);

//        ArrayList<String> splitInput = UserInputController.splitUserInput(input);
//
//        Playlist newPlaylist = PlaylistGenerator.generatePlaylist(splitInput);
//
//        return newPlaylist.toString();


    }


}
