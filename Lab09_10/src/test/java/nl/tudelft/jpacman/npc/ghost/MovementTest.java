package nl.tudelft.jpacman.npc.ghost;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import nl.tudelft.jpacman.board.*;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovementTest {

    private Board board;
    private Square from;
    private Square to;

    @BeforeEach
    public void setUp() {
        PacManSprites sprites = new PacManSprites();
        GhostFactory ghostFactory = new GhostFactory(sprites);
        LevelFactory levelFactory = new LevelFactory(null, ghostFactory, null);
        BoardFactory boardFactory = new BoardFactory(sprites);
        MapParser mapParser = new GhostMapParser(levelFactory, boardFactory, ghostFactory);

        char[][] map = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        board = mapParser.parseMap(map).getBoard();
        from = board.squareAt(0, 0);
        to = board.squareAt(2, 2);
    }

    @Test
    public void testShortestPath() {
        List<Direction> path = Navigation.shortestPath(from, to, null);
        assertThat(path).isNotNull();
        assertThat(path).isNotEmpty();
    }
}

