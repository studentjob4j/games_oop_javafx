package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if(!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", source, dest));
        }
        Cell[] steps = new Cell[Math.abs(source.getX() - dest.getX())];
        int deltaX = dest.getX() > source.getX()? 1 : -1;
        int deltaY = dest.getY() > source.getY() ? 1 : -1;
        int x = source.getX();
        int y = source.getY();
        for (int i = 0; i < steps.length; i++) {
             x += deltaX;
             y += deltaY;
            steps[i] = Cell.findBy(x, y);
        }
        return steps;

    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
