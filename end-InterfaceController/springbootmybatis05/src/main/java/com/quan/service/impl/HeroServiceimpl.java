package com.quan.service.impl;

import com.quan.entity.Hero;
import com.quan.mapper.HeroMapper;
import com.quan.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HeroService")
public class HeroServiceimpl implements HeroService {

    @Autowired(required = false)
    private HeroMapper heroMapper;
    @Override
    public void addHero(Hero hero) {
        heroMapper.addHero(hero);
    }

    @Override
    public int deleteHero(Hero hero) {
        return heroMapper.deleteHero(hero);
    }

    @Override
    public Hero selectHeroByName(Hero hero) {
        return heroMapper.selectHeroByName(hero);
    }

    @Override
    public List<Hero> selectAllHero() {
        return heroMapper.selectAllHero();
    }

    @Override
    public int updateHeroByName(Hero hero) {
        return heroMapper.updateHeroByName(hero);
    }

    @Override
    public void updateHero(Hero hero) {

    }

    @Override
    public Hero selHero(Hero hero) {
        return null;
    }

}
