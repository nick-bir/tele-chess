package com.polygon.chess

object Side {
    val WHITE: Byte
        get() = 0b0
    val BLACK: Byte
        get() = 0b1
}
object CastlingOptions {
    val W_KING: Byte
        get() = 0b0001
    val W_QUEEN: Byte
        get() = 0b0010
    val B_KING: Byte
        get() = 0b0100
    val B_QUEEN: Byte
        get() = 0b1000
    val ALL: Byte
        get() = 0b1111
    val NONE: Byte
        get() = 0b0000
}

object Pieces {
    val BLANK: Byte
        get() = 0
    val W_PAWN: Byte
        get() = 1
    val W_ROOK: Byte
        get() = 2
    val W_KNIGHT: Byte
        get() = 3
    val W_BISHOP: Byte
        get() = 4
    val W_QUEEN: Byte
        get() = 5
    val W_KING: Byte
        get() = 6
    val B_PAWN: Byte
        get() = 7
    val B_ROOK: Byte
        get() = 8
    val B_KNIGHT: Byte
        get() = 9
    val B_BISHOP: Byte
        get() = 10
    val B_QUEEN: Byte
        get() = 11
    val B_KING: Byte
        get() = 12
}