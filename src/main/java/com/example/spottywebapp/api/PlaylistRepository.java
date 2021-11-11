package com.example.spottywebapp.api;

import com.example.spottywebapp.Entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {


}
