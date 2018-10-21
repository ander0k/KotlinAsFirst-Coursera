package lesson2.task2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun pointInsideCircle() {
        // (1, 1) inside circle: center = (0, 0), r = 2
        assertTrue(pointInsideCircle(1.0, 1.0, 0.0, 0.0, 2.0))
        // (2, 2) NOT inside circle: center = (0, 0), r = 2
        assertFalse(pointInsideCircle(2.0, 2.0, 0.0, 0.0, 2.0))
    }

    @Test
    @Tag("Easy")
    fun isNumberHappy() {
        assertTrue(isNumberHappy(1533))
        assertTrue(isNumberHappy(9009))
        assertFalse(isNumberHappy(3644))
    }

    @Test
    @Tag("Easy")
    fun queenThreatens() {
        assertTrue(queenThreatens(3, 6, 7, 6))
        assertTrue(queenThreatens(8, 1, 1, 8))
        assertFalse(queenThreatens(7, 6, 5, 7))
        /*
          1) You failed in lesson2.task2.queenThreatens:
          Test failed on input:
            x1 -> 1, y1 -> 8, x2 -> 7, y2 -> 1
          Your output:
            true
          Expected output:
            false
         */
        assertFalse(queenThreatens(1, 8, 7, 1))
    }

    @Test
    @Tag("Easy")
    fun daysInMonth() {
        assertEquals(31, daysInMonth(1, 1990))
        assertEquals(28, daysInMonth(2, 1990))
        assertEquals(31, daysInMonth(3, 1990))
        assertEquals(30, daysInMonth(4, 1990))
        assertEquals(31, daysInMonth(5, 1990))
        assertEquals(30, daysInMonth(6, 1990))
        assertEquals(31, daysInMonth(7, 1990))
        assertEquals(31, daysInMonth(8, 1990))
        assertEquals(29, daysInMonth(2, 1992))
        assertEquals(29, daysInMonth(2, 1996))
        assertEquals(28, daysInMonth(2, 1900))
        assertEquals(29, daysInMonth(2, 2000))
        assertEquals(28, daysInMonth(2, 2100))
        assertEquals(28, daysInMonth(2, 1700))
        assertEquals(28, daysInMonth(2, 1800))
        assertEquals(29, daysInMonth(2, 1600))

    }

    @Test
    @Tag("Normal")
    fun circleInside() {
        assertFalse(circleInside(0.0, 0.0, 6.0, 0.0, 0.0, 5.0))
        assertFalse(circleInside(0.0, 0.0, 1.0, 10.0, 10.0, 9.0))
        assertTrue(circleInside(2.0, 2.0, 2.0, 2.0, 2.0, 2.0))
        assertTrue(circleInside(-2.0, 3.0, 2.0, -2.0, 0.0, 5.0))
        assertFalse(circleInside(1.0, 2.0, 3.0, 4.0, 5.0, 6.0))
        assertTrue(circleInside(
                2.220446049250313E-16,
                0.2635497075301749,
                0.01,
                -4.9E-324,
                0.7970980305735597,
                0.6258690225407179
        ))
    }

    @Test
    @Tag("Normal")
    fun brickPasses() {
        assertTrue(brickPasses(2, 10, 5, 6, 3))
        assertTrue(brickPasses(4, 4, 4, 4, 4))
        assertFalse(brickPasses(6, 5, 4, 3, 6))
        assertTrue(brickPasses(3, 2, 1, 1, 2))
    }
}