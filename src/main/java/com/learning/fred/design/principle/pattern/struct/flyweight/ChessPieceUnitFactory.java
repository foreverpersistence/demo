package com.learning.fred.design.principle.pattern.struct.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * @date 2020/12/23 13:59
 * @description todo
 */
public class ChessPieceUnitFactory {

    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1, new ChessPieceUnit(1, "", ChessPieceUnit.Color.BLACK));
        pieces.put(2, new ChessPieceUnit(2, "", ChessPieceUnit.Color.BLACK));
        //
    }

    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }

}
