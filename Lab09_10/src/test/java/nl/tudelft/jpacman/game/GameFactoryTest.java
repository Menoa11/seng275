package nl.tudelft.jpacman.game;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameFactoryTest {

    private GameFactory gameFactory;
    private PlayerFactory playerFactory;
    private Level level;
    private PointCalculator pointCalculator;

    @BeforeEach
    void setUp() {
        playerFactory = mock(PlayerFactory.class);
        gameFactory = new GameFactory(playerFactory);
        level = mock(Level.class);
        pointCalculator = mock(PointCalculator.class);
    }

    @Test
    void testCreateSinglePlayerGame() {
        Player player = mock(Player.class);
        when(playerFactory.createPacMan()).thenReturn(player);

        Game game = gameFactory.createSinglePlayerGame(level, pointCalculator);
        assertNotNull(game);
        assertTrue(game instanceof SinglePlayerGame);
    }

    @Test
    void testGetPlayerFactory() {
        assertEquals(playerFactory, gameFactory.getPlayerFactory());
    }
}