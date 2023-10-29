package com.polygon.chess

typealias Board = ByteArray
class ChessGame {
    val board: Board = ByteArray(64)
    var activeSide: Byte = 0
    var castlingOptions: Byte = CastlingOptions.ALL
    var enPassantTargetSquare: Int = -1
    var halfMoveClock = 0
    var moveNumber = 1
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