package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;



public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        Cell expected = bishopBlack.position();
        Assert.assertEquals(expected, Cell.A1);
    }

    @Test
    public void testCopy() {
        BishopBlack firstBishopBlack = new BishopBlack(Cell.A1);
        Figure secondBishopBlack = firstBishopBlack.copy(Cell.B2);
        Cell expected = secondBishopBlack.position();
        Assert.assertEquals(expected, Cell.B2);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, result);
    }
}