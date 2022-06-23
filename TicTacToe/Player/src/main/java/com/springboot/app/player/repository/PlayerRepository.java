package com.springboot.app.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.app.player.entities.PlayerEntity;
// @TODO: te falta la anotacion muy importante...
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
	
}
