package com.quan.service.impl;

import com.quan.entity.Hero;
import com.quan.entity.Player;
import com.quan.mapper.PlayerMapper;
import com.quan.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PlayerMapper")
public class PlayerServiceimpl implements PlayerService {

    @Autowired(required = false)
    private PlayerMapper playerMapper;

    @Override
    public void addPlayer(Player player) {
        playerMapper.addPlayer(player);
    }

    @Override
    public Integer deletePlayer(Player player) {
        return playerMapper.deletePlayer(player);
    }

    @Override
    public Player selectPlayerById(Player player) {
        return playerMapper.selectPlayerById(player);
    }

    @Override
    public List<Player> selectAllPlayer() {
        return playerMapper.selectAllPlayer();
    }

    @Override
    public int updatePlayerById(Player player) {
        return playerMapper.updatePlayerById(player);
    }
}
