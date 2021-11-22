package com.example.spottyv2.UseCases;

import com.example.spottyv2.Entities.Playlist;

import java.util.ArrayList;

public interface PlaylistGenerationStrategy {
    Playlist generatePlaylist(ArrayList<String> words, Playlist playlist);

    Playlist generatePlaylistWeb(ArrayList<String> words, Playlist playlist);
}
