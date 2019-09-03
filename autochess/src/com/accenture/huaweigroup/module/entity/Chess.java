package com.accenture.huaweigroup.module.entity;

import org.springframework.stereotype.Component;

@Component
public class Chess {
    private int id;
    private String name;
    private int price;
    private int level;
    private int hp;
    private int attack;
    private ChessType type;
    private String img;
    private boolean isAlive = true;

    public Chess() {
        super();
    }

    public Chess(Chess chess) {
        this.id = chess.id;
        this.name = chess.name;
        this.price = chess.price;
        this.level = chess.level;
        this.hp = chess.hp;
        this.attack = chess.attack;
        this.type = chess.type;
        this.img = chess.img;
        this.isAlive = chess.isAlive;
    }

    @Override
    public String toString() {
        return "Chess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", level=" + level +
                ", hp=" + hp +
                ", attack=" + attack +
                ", type=" + type +
                ", img='" + img + '\'' +
                ", isAlive=" + isAlive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public ChessType getType() {
        return type;
    }

    public void setType(ChessType type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}


