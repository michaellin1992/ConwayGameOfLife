import GameOfLife.ConwayGameOfLife;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConwayGameOfLifeTests {

    private ConwayGameOfLife mGame;

    @Before
    public void setUp() {
        mGame = new ConwayGameOfLife();
    }
    
    @Test
    public void testAdd() {
        Assert.assertEquals(5, mGame.add(3, 2));
    }
}