package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.cli.PlaylistRepository;
import com.example.spottywebapp.entities.Playlist;
//import com.example.spottywebapp.api.errors; Add this!!!!

import java.util.List;
import java.util.Optional;

public class PlaylistInteractor {
    private final PlaylistRepository repository;


    public PlaylistInteractor(PlaylistRepository repository) {
        this.repository = repository;
    }

    public List<Playlist> getAllPlaylists(){
        return repository.findAll();

    }

    public Playlist save(Playlist playlist){
        return repository.save(playlist);
    }

}
