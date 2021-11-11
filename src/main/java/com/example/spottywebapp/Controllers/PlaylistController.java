package com.example.spottywebapp.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.spottywebapp.entities.Playlist;
import com.example.spottywebapp.UseCases.PlaylistInteractor;

// import error stuff again
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaylistController {
    //@Autowired
    private final PlaylistInteractor interactor;

    public PlaylistController(PlaylistInteractor interactor){
        this.interactor = interactor;
    }

    @GetMapping("/playlists")
    List<Playlist> all() {
        return interactor.getAllPlaylists();
    }

    @PostMapping("/playlists")
    Playlist newPlaylist(@RequestBody Playlist playlist){
        return interactor.save(playlist);
        //// save a single Customer
        //repository.save(new Playlist(playlist.getPlaylist(), playlist.getPlaylistName());

    }
//    //TODO implement these through itneractor
//    @RequestMapping("/search/{id}")
//    public String search (@PathVariable long id){
//        String playlist = "";
//        playlist = repository.findByid(id).toString();
//        return playlist;*/

    //TODO implement these through interactor aswell
//    @RequestMapping("/searchbyplaylistname/{playlistname}")
//    public List<Playlist> //fetch?? (@PathVariable String playlistname){
//
//        List<Playlist> playlist = repository.findByFirstName(firstname);
//
//        for (Playlist playlist : playlist) {
//           //goes through interactor
//        }
    }
