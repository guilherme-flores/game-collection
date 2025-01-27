package com.guilhermeflores.gamelist.services;

import com.guilhermeflores.gamelist.dto.GameListDTO;
import com.guilhermeflores.gamelist.entities.GameList;
import com.guilhermeflores.gamelist.projections.GameMinProjection;
import com.guilhermeflores.gamelist.repositories.GameListRepository;
import com.guilhermeflores.gamelist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}