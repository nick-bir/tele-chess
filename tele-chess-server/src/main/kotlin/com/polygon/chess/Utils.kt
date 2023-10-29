package com.polygon.chess

fun squareIdxToStr(idx: Int): String {
    if (idx < 0) {
        return "-"
    }
    val rank = idx / 8 + 1
    val file = (idx % 8 + 97).toChar()
    return "$rank$file"
}

/**
 * @param rankIdx 0-based rank idx (1..8)
 * @param fileIdx 0-based rank idx (a..h)
 * @return squareIdx on the board or -1 for invalid
 */
fun rankAndFileToIdx(rankIdx: Int, fileIdx: Int): Int {
    return rankIdx * 8 + fileIdx
}