package nl.tudelft.jpacman.level;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.Ghost;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MapParserTest {
    @Mock
    private LevelFactory levelFactory;

    @Mock
    private BoardFactory boardFactory;

    @InjectMocks
    private MapParser mapParser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testParseMapSingleWall() {

        char[][] map = {{'#'}};
        Board mockBoard = mock(Board.class);
        Level mockLevel = mock(Level.class);

        when(boardFactory.createBoard(any(Square[][].class))).thenReturn(mockBoard);
        when(levelFactory.createLevel(any(Board.class), any(List.class), any(List.class))).thenReturn(mockLevel);

        Level level = mapParser.parseMap(map);

        assertNotNull(level);
        verify(boardFactory).createBoard(any(Square[][].class));
        verify(levelFactory).createLevel(any(Board.class), any(List.class), any(List.class));
    }
}


