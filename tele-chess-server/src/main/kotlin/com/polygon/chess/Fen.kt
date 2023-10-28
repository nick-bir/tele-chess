package com.polygon.chess

import java.lang.StringBuilder
import kotlin.experimental.and

fun gameToFen(game: ChessGame): String {
    val result = StringBuilder()
    result.append(boardToFen(game, result))
    result.append(' ')
    result.append(if (game.activeSide == Side.WHITE) 'w' else 'b')
    result.append(' ')
    result.append(castlingOptionsToFen(game, result))
    result.append(' ')
    result.append(squareIdxToStr(game.enPassantTargetSquare))
    result.append(' ')
    result.append(game.halfMoveClock)
    result.append(' ')
    result.append(game.moveNumber)
    return result.toString()
}

fun boardToFen(game: ChessGame, builder: StringBuilder) {

}

fun castlingOptionsToFen(game: ChessGame, builder: StringBuilder) {
    if (game.castlingOptions == CastlingOptions.NONE) {
        builder.append('-')
    }
    if (game.castlingOptions and CastlingOptions.W_KING > 0) {
        builder.append('K')
    }
    if (game.castlingOptions and CastlingOptions.W_QUEEN > 0) {
        builder.append('Q')
    }
    if (game.castlingOptions and CastlingOptions.B_KING > 0) {
        builder.append('k')
    }
    if (game.castlingOptions and CastlingOptions.B_QUEEN > 0) {
        builder.append('K')
    }
}