package com.polygon.chess

fun squareIdxToStr(idx: Int): String {
    if (idx < 0) {
        return "-"
    }
    val rank = idx / 8 + 1
    val file = (idx % 8 + 97).toChar()
    return "$rank$file"
}