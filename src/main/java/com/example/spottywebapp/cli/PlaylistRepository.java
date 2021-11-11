package com.example.spottywebapp.cli;

import com.example.spottywebapp.entities.Playlist; //imports need to go through the api
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface is implemented as a gateway class for the interface, implementation is handles by spring boot directly
 */
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
//might need to implement this if working with the spotify API
}
