package nl.tudelft.jpacman.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    private Game game;
    private Level level;
    private Player player;
    private PointCalculator pointCalculator;

    @BeforeEach
    void setUp() {
        pointCalculator = mock(PointCalculator.class);
        level = mock(Level.class);
        player = mock(Player.class);

        game = new Game(pointCalculator) {
            @Override
            public List<Player> getPlayers() {
                return Collections.singletonList(player);
            }

            @Override
            public Level getLevel() {
                return level;
            }
        };
    }

    @Test
    void testGameInitialState() {
        assertFalse(game.isInProgress(), "Game should not be in progress initially.");
    }

    @Test
    void testStartGame() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(1);

        game.start();

        assertTrue(game.isInProgress(), "Game should be in progress after starting.");
        verify(level, times(1)).addObserver(game);
        verify(level, times(1)).start();
    }

    @Test
    void testStartGameWhenAlreadyInProgress() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(1);

        game.start();
        game.start();

        assertTrue(game.isInProgress(), "Game should still be in progress after starting twice.");
        verify(level, times(1)).addObserver(game);
        verify(level, times(1)).start();
    }

    @Test
    void testStartGameNoPlayersAlive() {
        when(level.isAnyPlayerAlive()).thenReturn(false);
        when(level.remainingPellets()).thenReturn(1);

        game.start();

        assertFalse(game.isInProgress(), "Game should not start if no players are alive.");
        verify(level, never()).addObserver(game);
        verify(level, never()).start();
    }

    @Test
    void testStartGameNoPellets() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(0);

        game.start();

        assertFalse(game.isInProgress(), "Game should not start if no pellets are remaining.");
        verify(level, never()).addObserver(game);
        verify(level, never()).start();
    }

    //User requirement test
    //Player starts game
    //player stops game
    //game is not in progress
    @Test
    void testStopGame() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(1);

        game.start();
        game.stop();

        assertFalse(game.isInProgress(), "Game should not be in progress after stopping.");
        verify(level, times(1)).stop();
    }

    @Test
    void testStopGameWhenNotInProgress() {
        game.stop();

        assertFalse(game.isInProgress(), "Game should not be in progress after calling stop on a non-started game.");
        verify(level, never()).stop();
    }

    @Test
    void testMovePlayer() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(1);

        game.start();
        game.move(player, Direction.NORTH);

        verify(level, times(1)).move(player, Direction.NORTH);
        verify(pointCalculator, times(1)).pacmanMoved(player, Direction.NORTH);
    }

    @Test
    void testMovePlayerWhenNotInProgress() {
        game.move(player, Direction.NORTH);

        verify(level, never()).move(player, Direction.NORTH);
        verify(pointCalculator, never()).pacmanMoved(player, Direction.NORTH);
    }

    @Test
    void testLevelWon() {
        game.levelWon();

        assertFalse(game.isInProgress(), "Game should not be in progress after level is won.");
        verify(level, never()).stop();
    }

    @Test
    void testLevelLost() {
        game.levelLost();

        assertFalse(game.isInProgress(), "Game should not be in progress after level is lost.");
        verify(level, never()).stop();
    }
}
