package com.quan.mapper;

import com.quan.entity.Hero;
import com.quan.entity.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeroMapper {
    void addHero(Hero hero);
    int deleteHero(Hero hero);
    Hero selectHeroByName(Hero hero);
    List<Hero> selectAllHero();
    int updateHeroByName(Hero hero);
    void updateHero(Hero hero);
    Hero selHero(Hero hero);
    List<Hero> selAllHero(List<Hero> list);
}
