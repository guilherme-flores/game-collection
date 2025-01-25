package com.guilhermeflores.gamelist.repositories;

import com.guilhermeflores.gamelist.entities.GameList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}