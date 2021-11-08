package com.example.spottywebapp.api;

import com.example.spottywebapp.Controllers.UserInputController;
import com.example.spottywebapp.UseCases.PlaylistGenerator;
import com.example.spottywebapp.entities.Playlist;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
