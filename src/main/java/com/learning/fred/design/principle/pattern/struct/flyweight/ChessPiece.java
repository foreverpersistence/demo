package com.learning.fred.design.principle.pattern.struct.flyweight;

/**
 * @author fred
 * @date 2020/12/23 14:01
 * @description 棋子
 */
public class ChessPiece {

    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit chessPieceUnit, int positionX, int positionY) {
        this.chessPieceUnit = chessPieceUnit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //get set
}
