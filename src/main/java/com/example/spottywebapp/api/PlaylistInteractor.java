package com.example.spottywebapp.api;

import com.example.spottywebapp.entities.Playlist;
import org.springframework.stereotype.Component;

@Component
public class PlaylistInteractor {

    private final PlaylistRepository repository;

    public PlaylistInteractor(PlaylistRepository repository) {
        this.repository = repository;
    }

    public Playlist save(Playlist newPlaylist) {
        return repository.save(newPlaylist);
    }
}
