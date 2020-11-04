package com.quan.service;

import com.quan.entity.Hero;

import java.util.List;

public interface HeroService {
    void addHero(Hero hero);
    int deleteHero(Hero hero);
    Hero selectHeroByName(Hero hero);
    List<Hero> selectAllHero();
    int updateHeroByName(Hero hero);
    void updateHero(Hero hero);
    Hero selHero(Hero hero);

}
