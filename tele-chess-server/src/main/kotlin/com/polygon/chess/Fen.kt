package com.polygon.chess

import java.lang.StringBuilder
import kotlin.experimental.and

fun gameToFen(game: ChessGame): String {
    val result = StringBuilder(90)
    result.appendBoard(game.board)
    result.append(' ')
    result.append(if (game.activeSide == Side.WHITE) 'w' else 'b')
    result.append(' ')
    result.appendCastlingOptions(game)
    result.append(' ')
    result.append(squareIdxToStr(game.enPassantTargetSquare))
    result.append(' ')
    result.append(game.halfMoveClock)
    result.append(' ')
    result.append(game.moveNumber)
    return result.toString()
}

private fun StringBuilder.appendBoard(board: Board) {
    for (rank in 7 downTo 0) {
        var numberOfBlanks = 0
        for (file in 0..7) {
            val squareIdx = rankAndFileToIdx(rank, file)
            if (board[squareIdx] == Pieces.BLANK) {
                numberOfBlanks++
            } else {
                if (numberOfBlanks > 0) {
                    this.append(numberOfBlanks)
                    numberOfBlanks = 0
                }
                this.append(pieceToString(board[squareIdx]))
            }
        }
        if (numberOfBlanks > 0) {
            this.append(numberOfBlanks)
        }
        if (rank > 0) {
            this.append('/')
        }
    }
}

private fun StringBuilder.appendCastlingOptions(game: ChessGame) {
    if (game.castlingOptions == CastlingOptions.NONE) {
        this.append('-')
    }
    if (game.castlingOptions and CastlingOptions.W_KING > 0) {
        this.append('K')
    }
    if (game.castlingOptions and CastlingOptions.W_QUEEN > 0) {
        this.append('Q')
    }
    if (game.castlingOptions and CastlingOptions.B_KING > 0) {
        this.append('k')
    }
    if (game.castlingOptions and CastlingOptions.B_QUEEN > 0) {
        this.append('q')
    }
}