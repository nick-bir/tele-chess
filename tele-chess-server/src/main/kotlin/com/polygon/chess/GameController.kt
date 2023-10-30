package com.polygon.chess

typealias Board = ByteArray
class ChessGame {
    val board: Board = startingPosition.clone()
    var activeSide: Byte = 0
    var castlingOptions: Byte = CastlingOptions.ALL
    var enPassantTargetSquare: Int = -1
    var halfMoveClock = 0
    var moveNumber = 1

    companion object {
        val startingPosition: Board = byteArrayOf(
            Pieces.W_ROOK, Pieces.W_KNIGHT, Pieces.W_BISHOP, Pieces.W_QUEEN, Pieces.W_KING, Pieces.W_BISHOP, Pieces.W_KNIGHT, Pieces.W_ROOK,
            Pieces.W_PAWN, Pieces.W_PAWN, Pieces.W_PAWN, Pieces.W_PAWN, Pieces.W_PAWN, Pieces.W_PAWN, Pieces.W_PAWN, Pieces.W_PAWN,
            Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK,
            Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK,
            Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK,
            Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK, Pieces.BLANK,
            Pieces.B_PAWN, Pieces.B_PAWN, Pieces.B_PAWN, Pieces.B_PAWN, Pieces.B_PAWN, Pieces.B_PAWN, Pieces.B_PAWN, Pieces.B_PAWN,
            Pieces.B_ROOK, Pieces.B_KNIGHT, Pieces.B_BISHOP, Pieces.B_QUEEN, Pieces.B_KING, Pieces.B_BISHOP, Pieces.B_KNIGHT, Pieces.B_ROOK,
        )
    }
}

enum class MoveUpdateStatus {
    OK,
    UNPARSED,
    ILLEGAL_MOVE
}

class GameController {
    fun makeMove(game: ChessGame, move: String): Pair<MoveUpdateStatus, String> {
        return MoveUpdateStatus.OK to ""
    }
}