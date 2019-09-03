package com.accenture.huaweigroup.module.entity;

import org.springframework.stereotype.Component;

@Component
public class GameRecord {
    private int recordId;
    private int gameId;
    private int playerOneId;
    private int playerTwoId;
    private int winnerId;
    private int gameState;

    public GameRecord() {
        super();
    }

    @Override
    public String toString() {
        return "GameRecord{" +
                "recordId=" + recordId +
                ", gameId=" + gameId +
                ", playerOneId=" + playerOneId +
                ", playerTwoId=" + playerTwoId +
                ", winnerId=" + winnerId +
                ", gameState=" + gameState +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerOneId() {
        return playerOneId;
    }

    public void setPlayerOneId(int playerOneId) {
        this.playerOneId = playerOneId;
    }

    public int getPlayerTwoId() {
        return playerTwoId;
    }

    public void setPlayerTwoId(int playerTwoId) {
        this.playerTwoId = playerTwoId;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
}
