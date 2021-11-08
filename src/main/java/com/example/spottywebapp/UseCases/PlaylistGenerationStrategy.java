package com.example.spottywebapp.UseCases;

import com.example.spottywebapp.Entities.Playlist;

import java.util.ArrayList;

public interface PlaylistGenerationStrategy {
    Playlist generatePlaylist(ArrayList<String> words, Playlist playlist);
}
