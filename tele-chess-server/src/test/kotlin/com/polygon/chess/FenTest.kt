package com.polygon.chess

import kotlin.experimental.or
import kotlin.test.*

class FenTest {

    @Test
    fun startingBoardTest() {
        expect("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1") { gameToFen(ChessGame())}
    }

    @Test
    fun customOptionsTest() {
        expect("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR b Kq a3 10 15") {
            val game = ChessGame()
            game.halfMoveClock = 10
            game.moveNumber = 15
            game.enPassantTargetSquare = rankAndFileToIdx(2, 0)
            game.castlingOptions = CastlingOptions.W_KING or CastlingOptions.B_QUEEN
            game.activeSide = Side.BLACK
            gameToFen(game)
        }
    }

    @Test
    fun blankBoardTest() {
        expect("8/8/8/8/8/8/8/8 w KQkq - 0 1") {
            val game = ChessGame()
            for (i in 0..63) {
                game.board[i] = 0
            }
            gameToFen(game)
        }
    }

    @Test
    fun customBoardTest() {
        expect("8/5N2/R3p3/1p2k3/5pK1/1P1P2b1/P6r/8 w KQkq - 0 1") {
            val game = ChessGame()
            for (i in 0..63) {
                game.board[i] = 0
            }
            game.board[rankAndFileToIdx(1, 0)] = Pieces.W_PAWN
            game.board[rankAndFileToIdx(1, 7)] = Pieces.B_ROOK
            game.board[rankAndFileToIdx(2, 1)] = Pieces.W_PAWN
            game.board[rankAndFileToIdx(2, 3)] = Pieces.W_PAWN
            game.board[rankAndFileToIdx(2, 6)] = Pieces.B_BISHOP
            game.board[rankAndFileToIdx(3, 5)] = Pieces.B_PAWN
            game.board[rankAndFileToIdx(3, 6)] = Pieces.W_KING
            game.board[rankAndFileToIdx(4, 1)] = Pieces.B_PAWN
            game.board[rankAndFileToIdx(4, 4)] = Pieces.B_KING
            game.board[rankAndFileToIdx(5, 0)] = Pieces.W_ROOK
            game.board[rankAndFileToIdx(5, 4)] = Pieces.B_PAWN
            game.board[rankAndFileToIdx(6, 5)] = Pieces.W_KNIGHT
            gameToFen(game)
        }
    }
}