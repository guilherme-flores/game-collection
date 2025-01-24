package com.guilhermeflores.gamelist.services;

import java.util.List;

import com.guilhermeflores.gamelist.dto.GameMinDTO;
import com.guilhermeflores.gamelist.entities.Game;
import com.guilhermeflores.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
