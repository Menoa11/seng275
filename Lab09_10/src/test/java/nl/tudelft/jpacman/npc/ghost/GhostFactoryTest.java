package nl.tudelft.jpacman.npc.ghost;

import static org.assertj.core.api.Assertions.assertThat;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GhostFactoryTest {

    private GhostFactory ghostFactory;

    @BeforeEach
    public void setUp() {
        PacManSprites sprites = new PacManSprites();
        ghostFactory = new GhostFactory(sprites);
    }

    @Test
    public void testCreateBlinky() {
        Ghost blinky = ghostFactory.createBlinky();
        assertThat(blinky).isInstanceOf(Blinky.class);
    }

    @Test
    public void testCreatePinky() {
        Ghost pinky = ghostFactory.createPinky();
        assertThat(pinky).isInstanceOf(Pinky.class);
    }

    @Test
    public void testCreateInky() {
        Ghost inky = ghostFactory.createInky();
        assertThat(inky).isInstanceOf(Inky.class);
    }

    @Test
    public void testCreateClyde() {
        Ghost clyde = ghostFactory.createClyde();
        assertThat(clyde).isInstanceOf(Clyde.class);
    }
}



