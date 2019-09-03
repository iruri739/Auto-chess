package com.accenture.huaweigroup.module.entity;

import java.util.List;

public class PlayerData {
    private int id;
    private int hp;
    private int gold;
    private int winCount;
    private List<Chess> handCards;
    private List<Chess> battleCards;
    private List<Chess> cardInventory;

    public PlayerData() {
        super();
    }

    public PlayerData(int id, int hp, int gold, int winCount, List<Chess> handCards, List<Chess> battleCards, List<Chess> cardInventory) {
        super();
        this.id = id;
        this.hp = hp;
        this.gold = gold;
        this.winCount = winCount;
        this.handCards = handCards;
        this.battleCards = battleCards;
        this.cardInventory = cardInventory;
    }

    @Override
    public String toString() {
        return "PlayerData{" +
                "id=" + id +
                ", hp=" + hp +
                ", gold=" + gold +
                ", winCount=" + winCount +
                ", handCards=" + handCards +
                ", battleCards=" + battleCards +
                ", cardInventory=" + cardInventory +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
