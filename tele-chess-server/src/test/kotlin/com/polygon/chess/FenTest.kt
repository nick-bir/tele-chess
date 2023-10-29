package com.polygon.chess

import kotlin.test.*

class FenTest {

    @Test
    fun pieceToStringTest() {
        expect('k') { pieceToString(Pieces.B_KING) }
    }
}