package com.learning.fred.design.principle.struct.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * @date 2020/12/23 14:02
 * @description todo
 */
public class ChessBoard {

    private Map<Integer, ChessPiece> chessPieceMap = new HashMap<>();

    public ChessBoard() {
        init();
    }

    private void init() {

        chessPieceMap.put(1, new ChessPiece(ChessPieceUnitFactory.getChessPiece(1), 0, 0));
        chessPieceMap.put(2, new ChessPiece(ChessPieceUnitFactory.getChessPiece(2), 1, 0));
        //

    }

    public void move(int chessPieceId, int toPositinX, int toPositinoT){

    }
}
