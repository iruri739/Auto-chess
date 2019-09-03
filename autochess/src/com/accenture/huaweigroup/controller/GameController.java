package com.accenture.huaweigroup.controller;

import com.accenture.huaweigroup.service.ChessService;
import com.accenture.huaweigroup.service.GameService;
import com.accenture.huaweigroup.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private UserService userService;
    @Autowired
    private ChessService chessService;

    private static final Logger LOG = LoggerFactory.getLogger(GameController.class);
//
//    @RequestMapping(value = "/joinGame", method = RequestMethod.GET)
//    public String joinGame(@RequestParam("userId") int userId) {
//        try {
//            int gameId = gameService.findOpponent(userId);
//            if (gameId != 0) {
//                return String.valueOf(gameId);
//            } else {
//                return "wait";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//    }
//
//    @RequestMapping(value = "/getInitData", method = RequestMethod.GET)
//    public InitGameDTO getInitData(@RequestParam("gameId") int gameId, @RequestParam("userId") int userId) {
//        LOG.info("玩家 " + userId + " 正在尝试获取初始数据 " + "游戏ID：" + gameId);
//        InitGameDTO gameData = new InitGameDTO();
//        try {
//            int findGameId = gameService.findGame(userId);
//            if (findGameId == gameId) {
//                gameData.setState("ok");
//                Game game = gameService.getGame(gameId);
//                int opponentId;
//                if (game.getUserId() == userId) {
//                    opponentId = game.getOtherUserId();
//                } else {
//                    opponentId = game.getUserId();
//                }
//                gameData.setOpponentId(opponentId);
//                gameData.setOpponentName(userService.getUserById(opponentId).getName());
//                gameData.setCardInventory(gameService.requireInventory(gameId, userId));
//            } else {
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            InitGameDTO errorData = new InitGameDTO();
//            errorData.setState("error");
//            LOG.error("玩家 "+ userId +" 获取数据失败！");
//            return errorData;
//        }
//        LOG.info("玩家 " + userId + " 获取的数据：");
//        LOG.info(gameData.toString());
//        return gameData;
//    }
//
//    @RequestMapping(value = "/getRefreashInventory", method = RequestMethod.GET)
//    public MsgGameDTO getNewCardInventory(@RequestParam("gameId") int gameId, @RequestParam("userId") int userId){
//        MsgGameDTO msgGameDTO = new MsgGameDTO();
//        msgGameDTO.setState("ok");
//        try {
//            gameService.refreshInventory(gameId, userId);
//            Game game = gameService.getGame(gameId);
//            msgGameDTO.setGameId(game.getId());
//            msgGameDTO.setUserId(game.getUserId());
//            msgGameDTO.setCardInventory(gameService.requireInventory(gameId, userId));
//        } catch (Exception e) {
//            e.printStackTrace();
//            MsgGameDTO errorMsg = new MsgGameDTO();
//            errorMsg.setState("error");
//            return errorMsg;
//        }
//        return msgGameDTO;
//    }
//
//    @RequestMapping(value = "/sendGameData", method = RequestMethod.POST)
//    public String receiveData(@RequestBody MsgGameDTO data) {
//        try {
//            gameService.changeInventory(data.getGameId(), data.getUserId(), data.getCardInventory());
//            gameService.changeBattleCards(data.getGameId(), data.getUserId(), data.getBattleCards());
//            gameService.changeHandCards(data.getGameId(), data.getUserId(), data.getHandCards());
//            return "ok";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }
//
//    @RequestMapping(value = "/getOpponentData", method = RequestMethod.GET)
//    public MsgGameDTO sendOpponentData(@RequestParam("gameId") int gameId, @RequestParam("opponentId") int opponentId) {
//        MsgGameDTO msgGameDTO = new MsgGameDTO();
//        try {
//            msgGameDTO.setState("ok");
//            msgGameDTO.setGameId(gameId);
//            msgGameDTO.setUserId(opponentId);
//            msgGameDTO.setCardInventory(gameService.requireInventory(gameId, opponentId));
//            msgGameDTO.setBattleCards(gameService.requireBattleCards(gameId, opponentId));
//            msgGameDTO.setHandCards(gameService.requireHandCards(gameId, opponentId));
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOG.error("游戏ID：" + gameId + " 获取对手 " + opponentId + " 的数据失败");
//            MsgGameDTO errorMsg = new MsgGameDTO();
//            errorMsg.setState("error");
//            return errorMsg;
//        }
//        return msgGameDTO;
//    }
//
//    @RequestMapping(value = "/sendGameResult", method = RequestMethod.GET)
//    public String receiveGameResult(@RequestParam("gameId") int gameId, @RequestParam("winnerId") int winnerId) {
//        try {
//            gameService.processGameResult(gameId, winnerId);
//            return "ok";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }
}
