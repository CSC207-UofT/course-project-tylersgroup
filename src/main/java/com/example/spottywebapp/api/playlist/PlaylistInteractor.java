package com.example.spottywebapp.api.playlist;

import com.example.spottywebapp.Entities.Playlist;
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
