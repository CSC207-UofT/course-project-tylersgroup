package com.example.spottywebapp.api.playlist;

import com.example.spottywebapp.Entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {


}
