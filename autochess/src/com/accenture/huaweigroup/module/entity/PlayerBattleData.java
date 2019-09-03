package com.accenture.huaweigroup.module.entity;

import org.springframework.stereotype.Component;


@Component
public class PlayerBattleData {
    private String state;
    private int gameId;
    private int rounds;
    private PlayerData playerData;

    public PlayerBattleData() {
        super();
    }

    public PlayerBattleData(String state, int gameId, int rounds, PlayerData playerData) {
        super();
        this.state = state;
        this.gameId = gameId;
        this.rounds = rounds;
        this.playerData = playerData;
    }

    @Override
    public String toString() {
        return "PlayerBattleData{" +
                "state='" + state + '\'' +
                ", gameId=" + gameId +
                ", rounds=" + rounds +
                ", playerData=" + playerData +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public PlayerData getPlayerData() {
        return playerData;
    }

    public void setPlayerData(PlayerData playerData) {
        this.playerData = playerData;
    }
}
