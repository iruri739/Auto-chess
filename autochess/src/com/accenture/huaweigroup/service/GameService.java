package com.accenture.huaweigroup.service;

import com.accenture.huaweigroup.module.entity.Game;
import com.accenture.huaweigroup.module.entity.GameInitData;
import com.accenture.huaweigroup.module.entity.PlayerBattleData;
import com.accenture.huaweigroup.module.mapper.GameRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {

    private static final Logger LOG = LoggerFactory.getLogger(GameService.class);

    @Autowired
    private GameRecordMapper gameRecordMapper;
    @Autowired
    private ChessService chessService;

    private ConcurrentHashMap<Integer, Boolean> waitPlayerList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Game> gameList = new ConcurrentHashMap<>();

    //匹配玩家
    public boolean findOpponent(int playerId) {

        return false;
    }

    //检查匹配流程是否成功
    public boolean gameReadyCheck(int gameId, int playerId) {

        return false;
    }

    //创建游戏
    public int createGame() {

        return 0;
    }

    //获取游戏初始数据
    public GameInitData getInitGameData(int gameId, int playerId) {

        return null;
    }

    public boolean updateGameRecord(int gameId, int playerId) {

        return false;
    }

    //获取玩家数据
    public PlayerBattleData getPlayerBattleData(int gameId, int playerId) {
        return null;
    }

    //计时轮训gamelist清除异常游戏并做异常处理
    private void cycleCheckGame() {

    }

    /**
     * 根据前端发送的用户id随机从等待用户列表查找对手并匹配游戏
     *
     * @param userId 用户id
     * @return 找到对手则返回该局游戏id，否则返回0
     * @throws Exception
     */
//    public int findOpponent(int userId) throws Exception {
//        int gameId = 0;
//        if (!waitUserList.contains(userId)) {
//            //用户不在列表，检查是否已经开始游戏，开始则返回玩家所处游戏的id
//            gameId = findGame(userId);
//            if (gameId != 0) {
//                LOG.info("玩家 " + userId + " 已经加入游戏 游戏ID：" + gameId + " 无操作");
//                return gameId;
//                //否则检查列表是否有其他玩家，直接匹配
//            } else if (waitUserList.size() != 0){
//                gameId = prepareOpponent(userId);
//                //否则加入列表
//            } else {
//                waitUserList.addElement(userId);
//                LOG.info("当前列表无此玩家 " + "加入玩家 " + userId);
//            }
//        } else {
//            //用户存在列表，检查是否匹配到对手，没有对手则寻找列表内是否有同样没有对手的玩家
//            //存在则将为该双方玩家创建游戏，并从列表中移除
//            if (waitUserList.size() != 1) {
//                gameId = prepareOpponent(userId);
//            } else {
//                LOG.info("当前除玩家 " + userId + " 外无其他玩家 继续等待");
//            }
//        }
//        LOG.info("当前等待玩家列表： " + waitUserList);
//        return gameId;
//    }
//
//    private int prepareOpponent(int userId) throws Exception {
//        Random random = new Random();
//        int gameId = 0;
//        int randUserId = 0;
//        randUserId = waitUserList.get(random.nextInt(waitUserList.size()));
//        while (randUserId == userId) {
//            randUserId = waitUserList.get(random.nextInt(waitUserList.size()));
//        }
//        gameId = createGame(userId, randUserId);
//        waitUserList.removeElement(userId);
//        waitUserList.removeElement(randUserId);
//        LOG.info("玩家 " + userId + " 与玩家 " + randUserId + " 准备开始游戏");
//        return gameId;
//    }

    /**
     * 获得当前游戏指定玩家的卡牌区域信息
     * @param gameId 当局游戏的id
     * @param userId 用户id
     */
//    private void showGameState(int gameId, int userId) throws Exception {
//        Game game = gameList.get(gameId);
//        int gameUserId = 0;
//        if (game.getUserId() == userId) {
//            gameUserId = game.getUserId();
//        } else {
//            gameUserId = game.getOtherUserId();
//        }
//        LOG.info("玩家 " + gameUserId + " 当前游戏状态：");
//        LOG.info("玩家手牌：" + requireHandCards(gameId, gameUserId));
//        LOG.info("玩家战场卡牌：" + requireBattleCards(gameId, gameUserId));
//        LOG.info("玩家待选区卡牌：" + requireInventory(gameId, gameUserId));
//    }
//
//    public int findGame(int userId) throws Exception {
//        for (Game game : gameList.values()) {
//            if (userId == game.getUserId() || userId == game.getOtherUserId()) {
//                return game.getId();
//            }
//        }
//        return 0;
//    }
//
//    public Game getGame(int gameId) throws Exception {
//        return gameList.get(gameId);
//    }
//
//    private int createGame(Integer userId, Integer otherUserId) throws Exception {
//        gameMapper.insert(new GameEntity(userId, otherUserId, 0, 0));
//        GameEntity gameEntity = gameMapper.getStartGameByUserId(userId);
//        Game newGame = new Game(gameEntity.getGameId(), userId, otherUserId);
//        newGame.setCardInventory(userId, chessService.getRandomChess(5));
//        newGame.setCardInventory(otherUserId, chessService.getRandomChess(5));
//        gameList.put(newGame.getId(), newGame);
//        LOG.info("玩家 " + userId + " 与玩家 " + otherUserId + " 创建游戏");
//        LOG.info("游戏ID：" + gameEntity.getGameId());
//        LOG.info("当前游戏进行数：" + gameList.size());
//        showGameState(newGame.getId(), userId);
//        showGameState(newGame.getId(), otherUserId);
//        return gameEntity.getGameId();
//    }
//
//    public void processGameResult(int gameId, int winnerId) throws Exception {
//        GameEntity gameEntity = gameMapper.findByGameId(gameId);
//        gameEntity.setGameStatus(1);
//        gameEntity.setWinnerId(winnerId);
//        gameMapper.update(gameEntity);
//        gameList.remove(gameId);
//    }
//
//    public void refreshInventory(int gameId, int userId) throws Exception {
//        Game game = getGame(gameId);
//        Vector<Chess> newInventory = chessService.getRandomChess(5);
//        game.getCardInventoryTable().replace(userId, newInventory);
//        showGameState(gameId, userId);
//    }
//
//    public Vector<Integer> requireInventory(int gameId, int userId) throws Exception {
//        Game game = getGame(gameId);
//        Vector<Integer> inventoryCardIdList = getIdListFromChessList(game.getCardInventory(userId));
//        return inventoryCardIdList;
//
//    }
//
//    public Vector<Integer> requireBattleCards(int gameId, int userId) throws Exception {
//        Game game = getGame(gameId);
//        Vector<Integer> battleCardsIdList = getIdListFromChessList(game.getBattleCards(userId));
//        return battleCardsIdList;
//    }
//
//    public Vector<Integer> requireHandCards(int gameId, int userId) throws Exception {
//        Game game = getGame(gameId);
//        Vector<Integer> handCardsIdList = getIdListFromChessList(game.getHandCards(userId));
//        return handCardsIdList;
//    }
//
//    public void changeInventory(int gameId, int userId, Vector<Integer> newCardIdList) throws Exception {
//        Game game = getGame(gameId);
//        if (newCardIdList != null) {
//            Vector<Chess> newInventory = getChessListFromIdList(newCardIdList);
//            game.setCardInventory(userId, newInventory);
//            LOG.info("游戏ID：" + gameId + " 玩家 " + userId + " 候选区更新");
//            LOG.info("新候选区信息： " + newCardIdList);
//        } else {
//            LOG.info("游戏ID：" + gameId + " 玩家 " + userId + " 候选区无更新");
//        }
//        showGameState(gameId, userId);
//    }

    /**
     * 将棋子对象列表转化为对应棋子的ID列表
     * @param cardList 棋子对象列表
     * @return 返回对应棋子对象的ID列表
     */
//    public Vector<Integer> getIdListFromChessList(Vector<Chess> cardList) {
//        Vector<Integer> list = new Vector<>();
//        for (Chess c : cardList) {
//            if (c == null) {
//                list.addElement(0);
//                continue;
//            }
//            list.addElement(c.getChessId());
//        }
//        return list;
//    }

    /**
     * 将棋子ID列表转化为对应的棋子对象列表
     * @param cardIdList 棋子ID列表
     * @return 棋子对象列表
     */
//    public Vector<Chess> getChessListFromIdList(Vector<Integer> cardIdList) {
//        Vector<Chess> newCards = new Vector<>();
//        for (int cardId : cardIdList) {
//            if (cardId == 0) {
//                newCards.add(null);
//                continue;
//            }
//            newCards.add(chessService.createChess(cardId));
//        }
//        return newCards;
//    }
//
//    public void changeBattleCards(int gameId, int userId, Vector<Integer> newBattleCardsIdList) throws Exception {
//        Game game = getGame(gameId);
//        if (newBattleCardsIdList != null) {
//            Vector<Chess> newBattleCards = getChessListFromIdList(newBattleCardsIdList);
//            game.setBattleCards(userId, newBattleCards);
//            LOG.info("游戏ID：" + gameId + " 玩家 " + userId + " 战场区更新");
//            LOG.info("新战场区信息： " + newBattleCardsIdList);
//        } else {
//            LOG.info("游戏ID：" + gameId + " 玩家 " + userId + " 战场区无更新");
//        }
//        showGameState(gameId, userId);
//    }
//
//    public void changeHandCards(int gameId, int userId, Vector<Integer> newHandCardsIdList) throws Exception {
//        Game game = getGame(gameId);
//        if (newHandCardsIdList != null) {
//            Vector<Chess> newHandCards = getChessListFromIdList(newHandCardsIdList);
//            game.setHandCards(userId, newHandCards);
//            LOG.info("游戏ID：" + gameId + " 玩家 " + userId + " 手牌区更新");
//            LOG.info("新手牌区信息： " + newHandCardsIdList);
//        } else {
//            LOG.info("游戏ID：" + gameId + " 玩家 " + userId + " 手牌区无更新");
//        }
//        showGameState(gameId, userId);
//    }

}
