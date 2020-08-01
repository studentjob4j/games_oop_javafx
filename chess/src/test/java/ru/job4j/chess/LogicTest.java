package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.QueenBlack;


public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.D1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void move2()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H1);
    }

    @Test(expected = OccupiedCellException.class)
    public void move3()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack black = new BishopBlack(Cell.A1);
        logic.add(black);
        logic.add(new QueenBlack(Cell.B2));
        logic.move(Cell.A1, Cell.H8);
    }


}