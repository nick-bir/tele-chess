package com.polygon.chess

fun squareIdxToStr(idx: Int): String {
    if (idx < 0) {
        return "-"
    }
    val rank = idx / 8 + 1
    val file = (idx % 8 + 97).toChar()
    return "$file$rank"
}

/**
 * @param rankIdx 0-based rank idx (1..8)
 * @param fileIdx 0-based rank idx (a..h)
 * @return squareIdx on the board or -1 for invalid
 */
fun rankAndFileToIdx(rankIdx: Int, fileIdx: Int): Int {
    if (rankIdx < 0 || fileIdx < 0 || rankIdx > 7 || fileIdx > 7) {
        return -1
    }
    return rankIdx * 8 + fileIdx
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