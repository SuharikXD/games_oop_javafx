package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void testMoveOccupied() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack first = new BishopBlack(Cell.A1);
        BishopBlack second = new BishopBlack(Cell.C3);
        logic.add(first);
        logic.add(second);
        logic.move(Cell.A1, Cell.C3);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testMoveNotFound() throws OccupiedCellException, FigureNotFoundException {
        Logic firstLogic = new Logic();
        firstLogic.add(new BishopBlack(Cell.C1));
        firstLogic.move(Cell.C2, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testMoveImpossible() throws OccupiedCellException, FigureNotFoundException {
        Logic firstLogic = new Logic();
        firstLogic.add(new BishopBlack(Cell.C1));
        firstLogic.move(Cell.C1, Cell.H5);
    }

}