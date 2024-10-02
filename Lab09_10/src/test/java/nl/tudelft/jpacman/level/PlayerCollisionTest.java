package nl.tudelft.jpacman.level;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.PlayerCollisions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class PlayerCollisionTest {
    private PointCalculator pointCalculator;
    private PlayerCollisions playerCollisions;
    private Player player;
    private Ghost ghost;
    private Pellet pellet;

    @BeforeEach
    public void setUp() {
        pointCalculator = Mockito.mock(PointCalculator.class);
        playerCollisions = new PlayerCollisions(pointCalculator);
        player = Mockito.mock(Player.class);
        ghost = Mockito.mock(Ghost.class);
        pellet = Mockito.mock(Pellet.class);
    }

    @Test
    public void testPlayerCollidesWithGhost() {
        playerCollisions.collide(player, ghost);
        verify(pointCalculator, times(1)).collidedWithAGhost(player, ghost);
        verify(player, times(1)).setAlive(false);
        verify(player, times(1)).setKiller(ghost);
    }

    @Test
    public void testPlayerCollidesWithPellet() {
        playerCollisions.collide(player, pellet);
        verify(pointCalculator, times(1)).consumedAPellet(player, pellet);
        verify(pellet, times(1)).leaveSquare();
    }

    @Test
    public void testGhostCollidesWithPlayer() {
        playerCollisions.collide(ghost, player);
        verify(pointCalculator, times(1)).collidedWithAGhost(player, ghost);
        verify(player, times(1)).setAlive(false);
        verify(player, times(1)).setKiller(ghost);
    }

    @Test
    public void testPelletCollidesWithPlayer() {
        playerCollisions.collide(pellet, player);
        verify(pointCalculator, times(1)).consumedAPellet(player, pellet);
        verify(pellet, times(1)).leaveSquare();
    }

    @Test
    public void testUnrelatedUnitsCollision() {
        Unit unrelatedUnit1 = Mockito.mock(Unit.class);
        Unit unrelatedUnit2 = Mockito.mock(Unit.class);

        playerCollisions.collide(unrelatedUnit1, unrelatedUnit2);

        Mockito.verifyNoInteractions(pointCalculator);
        Mockito.verifyNoInteractions(unrelatedUnit1);
        Mockito.verifyNoInteractions(unrelatedUnit2);
    }
}

