package com.polygon.chess

import kotlin.test.*

class UtilsTest {

    @Test
    fun pieceToStringTest() {
        // Black pieces
        expect('p') { pieceToString(Pieces.B_PAWN) }
        expect('r') { pieceToString(Pieces.B_ROOK) }
        expect('n') { pieceToString(Pieces.B_KNIGHT) }
        expect('b') { pieceToString(Pieces.B_BISHOP) }
        expect('q') { pieceToString(Pieces.B_QUEEN) }
        expect('k') { pieceToString(Pieces.B_KING) }

        // White pieces
        expect('P') { pieceToString(Pieces.W_PAWN) }
        expect('R') { pieceToString(Pieces.W_ROOK) }
        expect('N') { pieceToString(Pieces.W_KNIGHT) }
        expect('B') { pieceToString(Pieces.W_BISHOP) }
        expect('Q') { pieceToString(Pieces.W_QUEEN) }
        expect('K') { pieceToString(Pieces.W_KING) }
    }

    @Test
    fun squareIdxToStrTest() {
        expect("-") { squareIdxToStr(-1) }
        expect("a1") { squareIdxToStr(0) }
        expect("b2") { squareIdxToStr(9) }
        expect("c3") { squareIdxToStr(18) }
        expect("d4") { squareIdxToStr(27) }
        expect("e5") { squareIdxToStr(36) }
        expect("f6") { squareIdxToStr(45) }
        expect("g7") { squareIdxToStr(54) }
        expect("h8") { squareIdxToStr(63) }
    }

    @Test
    fun rankAndFileToIdxTest() {
        expect(-1) { rankAndFileToIdx(-1, 0) }
        expect(-1) { rankAndFileToIdx(0, -1) }
        expect(-1) { rankAndFileToIdx(8, 0) }
        expect(-1) { rankAndFileToIdx(0, 8) }

        expect(0) { rankAndFileToIdx(0, 0) }
        expect(9) { rankAndFileToIdx(1, 1) }
        expect(18) { rankAndFileToIdx(2, 2) }
        expect(27) { rankAndFileToIdx(3, 3) }
        expect(36) { rankAndFileToIdx(4, 4) }
        expect(45) { rankAndFileToIdx(5, 5) }
        expect(54) { rankAndFileToIdx(6, 6) }
        expect(63) { rankAndFileToIdx(7, 7) }
    }
}