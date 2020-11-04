package com.quan.service;

import com.quan.entity.Hero;
import com.quan.entity.Player;

import java.util.List;

public interface PlayerService {
    void addPlayer(Player player);
    Integer deletePlayer(Player player);
    Player selectPlayerById(Player player);
    List<Player> selectAllPlayer();
    int updatePlayerById(Player player);
}
