package com.polygon.chess

import java.lang.StringBuilder
import kotlin.experimental.and

fun gameToFen(game: ChessGame): String {
    val result = StringBuilder(90)
    result.append(boardToFen(game.board, result))
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

fun boardToFen(board: Board, builder: StringBuilder) {
    for (rank in 7 downTo 0) {
        var numberOfBlanks = 0
        for (file in 0..7) {
            val squareIdx = rankAndFileToIdx(rank, file)
            if (board[squareIdx] == Pieces.BLANK) {
                numberOfBlanks++
            } else {
                if (numberOfBlanks > 0) {
                    builder.append(numberOfBlanks)
                }
            }
        }
        if (numberOfBlanks > 0) {
            builder.append(numberOfBlanks)
        }
        builder.append('/')
    }
}

fun pieceToString(piece: Byte): Char {
    val isBlack = piece > 6
    val pieceIdx = if (isBlack) piece - 6 else piece
    val char = when (pieceIdx.toByte()) {
        Pieces.W_PAWN -> 'P'
        Pieces.W_ROOK -> 'R'
        Pieces.W_KNIGHT -> 'N'
        Pieces.W_BISHOP -> 'B'
        Pieces.W_QUEEN -> 'Q'
        Pieces.W_KING -> 'K'
        else -> throw IllegalStateException("Unable to parse piece with code $piece")
    }
    return if (isBlack) {
        char + 32
    } else {
        char
    }
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