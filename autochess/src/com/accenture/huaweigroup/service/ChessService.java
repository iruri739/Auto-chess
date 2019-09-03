package com.accenture.huaweigroup.service;

import com.accenture.huaweigroup.module.entity.Chess;
import com.accenture.huaweigroup.module.mapper.ChessMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChessService implements InitializingBean {

    @Autowired
    private ChessMapper chessMapper;

    private static final Logger LOG = LoggerFactory.getLogger(ChessService.class);

    private static ConcurrentHashMap<Integer, Chess> chessMap = new ConcurrentHashMap<>();

    public ChessService() {
        super();
    }



//    public Vector<Chess> getAllChess() {
//        return chessMapper.getAll();
//    }

    public Chess createChess(int chessId) {
        return new Chess(chessMap.get(chessId));
    }

    public ArrayList<Chess> getRandomCards() {
        Random random = new Random();
        ArrayList<Chess> cards = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            int cardId = 0;
            cardId = random.nextInt(chessMap.size()) + 1;
            cards.add(chessMap.get(cardId));
        }
        return cards;
    }

    public ArrayList<Chess> getRandomCards(int count) {
        Random random = new Random();
        ArrayList<Chess> cards = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            int cardId = 0;
            cardId = random.nextInt(chessMap.size()) + 1;
            cards.add(chessMap.get(cardId));
        }
        return cards;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<Chess> list = chessMapper.getAll();
        for (Chess c : list) {
            chessMap.put(c.getId(), c);
        }
        LOG.info("ChessMap initialize finished!!");
        LOG.info(list.toString());
    }
}
