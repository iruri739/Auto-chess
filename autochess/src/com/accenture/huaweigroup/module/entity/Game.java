package com.accenture.huaweigroup.module.entity;

import com.accenture.huaweigroup.service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Game {
    private static final int PLAYER_DEFAULT_PREPARETIME = 30;

    @Autowired
    private ChessService chessService;

    private int id;
    private int totalTime = 0;
    private int rounds = 1;
    private int prepareTime = PLAYER_DEFAULT_PREPARETIME;
    private GameState state = GameState.CREATED;
    private ConcurrentHashMap<Integer, Player> playerList = new ConcurrentHashMap<>();

    public Game() {
        super();
    }

    public Game(int id, int playerOneId, int playerTwoId) {
        this.id = id;
        this.playerList.put(playerOneId, new Player(playerOneId));
        this.playerList.put(playerTwoId, new Player(playerTwoId));
        initPlayerCards();
    }

    private void initPlayerCards() {
        for (Player player : playerList.values()) {
            player.setCardInventory(chessService.getRandomCards());
        }
    }

    //双方玩家战场上卡牌的战斗处理
    public int fight() {
        return 0;
    }

    //花费金币更换玩家待选区卡牌，会返回是否成功
    public boolean randInventory(int userId) {
        return false;
    }

    //获取玩家手牌
    public ArrayList<Chess> getPlayerHandCards(int playerId) {
        return playerList.get(playerId).getHandCards();
    }

    //获取玩家战场卡牌
    public ArrayList<Chess> getPlayerBattleCards(int playerId) {
        return playerList.get(playerId).getBattleCards();
    }

    //获取玩家待选区卡牌
    public ArrayList<Chess> getPlayerCardInventory(int playerId) {
        return playerList.get(playerId).getCardInventory();
    }

    //更新玩家手牌
    public ArrayList<Chess> setPlayerHandCards(int playerId, ArrayList<Chess> newHandCards) {
        Player player = playerList.get(playerId);
        player.setHandCards(newHandCards);
        return player.getHandCards();
    }

    //更新玩家战场卡牌
    public ArrayList<Chess> setPlayerBattleCards(int playerId, ArrayList<Chess> newBattleCards) {
        Player player = playerList.get(playerId);
        player.setBattleCards(newBattleCards);
        return player.getBattleCards();
    }

    //更新玩家待选区卡牌
    public ArrayList<Chess> setPlayerCardInventory(int playerId, ArrayList<Chess> newInventory) {
        Player player = playerList.get(playerId);
        player.setCardInventory(newInventory);
        return player.getCardInventory();
    }

}
