package com.guilhermeflores.gamelist.repositories;

import com.guilhermeflores.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
}
