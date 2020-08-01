package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest extends TestCase {

    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        Cell result = bishopBlack.position();
        assertEquals(result, (Cell.A8));
    }

    public void testWay() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(result.length,4);
    }

    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        Figure result = bishopBlack.copy(Cell.H1);
        assertEquals(result.position(), (Cell.H1));
    }

}