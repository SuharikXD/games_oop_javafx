package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(String.format("Could not move by diagonal from %s to %s", position, dest));
        }
        int size = dest.getX() > position.getX() ? dest.getX() - position.getX() : position.getX() - dest.getX();
        Cell[] steps = new Cell[size];
        int deltaX = position.getX();
        int deltaY = position.getY();
        if (deltaX > dest.getX()) {
            if (deltaY > dest.getY()) {
                for (int index = 0; index < size; index++) {
                    deltaX -= 1;
                    deltaY -= 1;
                    steps[index] = Cell.findBy(deltaX, deltaY);
                }
            } else {
                for (int index = 0; index < size; index++) {
                    deltaX -= 1;
                    deltaY += 1;
                    steps[index] = Cell.findBy(deltaX, deltaY);
                }
            }
        } else {
            if (deltaY > dest.getY()) {
                for (int index = 0; index < size; index++) {
                    deltaX += 1;
                    deltaY -= 1;
                    steps[index] = Cell.findBy(deltaX, deltaY);
                }
            } else {
                for (int index = 0; index < size; index++) {
                    deltaX += 1;
                    deltaY += 1;
                    steps[index] = Cell.findBy(deltaX, deltaY);
                }
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        for (int x = source.getX(),  y = source.getY(); x <= dest.getX() && y <= dest.getY(); x++, y++) {
            if (Cell.findBy(x, y) == dest) {
                rsl = true;
                break;
            }
        }
        for (int x = source.getX(),  y = source.getY(); x >= dest.getX() && y <= dest.getY(); x--, y++) {
            if (Cell.findBy(x, y) == dest) {
                rsl = true;
                break;
            }
        }
        for (int x = source.getX(),  y = source.getY(); x >= dest.getX() && y >= dest.getY(); x--, y--) {
            if (Cell.findBy(x, y) == dest) {
                rsl = true;
                break;
            }
        }
        for (int x = source.getX(),  y = source.getY(); x <= dest.getX() && y >= dest.getY(); x++, y--) {
            if (Cell.findBy(x, y) == dest) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
