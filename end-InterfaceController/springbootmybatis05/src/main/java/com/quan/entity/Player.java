package com.quan.entity;

public class Player {
    private Integer id;
    private String name;
    private Integer degree;
    private String playhero;

    public Player(Integer id, String name, Integer degree, String playhero) {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.playhero = playhero;
    }

    public Player() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public String getPlayhero() {
        return playhero;
    }

    public void setPlayhero(String playhero) {
        this.playhero = playhero;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                ", playhero='" + playhero + '\'' +
                '}';
    }
}
