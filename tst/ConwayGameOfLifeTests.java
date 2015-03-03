import GameOfLife.ConwayGameOfLife;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConwayGameOfLifeTests {

    private ConwayGameOfLife mGame;

    @Before
    public void setUp() {
        ArrayList<Integer[]> startPosition = new ArrayList<Integer[]>();
        Integer[] startPos = {1, 2};
        startPosition.add(startPos);
        mGame = new ConwayGameOfLife(1, 1, startPosition);
    }
    
    @Test
    public void testAdd() {
        Assert.assertEquals(5, mGame.add(3, 2));
    }
}