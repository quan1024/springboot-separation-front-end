package com.quan.mapper;

import com.quan.entity.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PlayerMapper {
    void addPlayer(Player player);
    int deletePlayer(Player player);
    Player selectPlayerById(Player player);
    List<Player> selectAllPlayer();
    int updatePlayerById(Player player);

}
