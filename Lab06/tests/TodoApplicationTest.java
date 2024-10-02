import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

class TodoApplicationTest {

    private TodoApplication todoApp;
    private PersonService personServiceMock;
    private TodoService todoServiceMock;

    private final String userName = "SomeUser";
    private final Long userID = 1L;
    private final List<String> todos = List.of("Wake up", "Test the code", "Celebrate the victory!");

    @BeforeEach
    void setUp() {
        personServiceMock = mock(PersonService.class);
        todoServiceMock = mock(TodoService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);
    }

    @Test
    void addTodo() {
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.addTodo(userName, "New Todo")).thenReturn(true);

        boolean result = todoApp.addTodo(userID, "New Todo");

        assertTrue(result);
        verify(personServiceMock).findUsernameById(userID);
        verify(todoServiceMock).addTodo(userName, "New Todo");
        verifyNoMoreInteractions(personServiceMock, todoServiceMock);
    }

    @Test
    void retrieveTodos() {
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(todos);

        List<String> result = todoApp.retrieveTodos(userID, "Test");

        assertThat(result).containsExactly("Test the code");
        verify(personServiceMock).findUsernameById(userID);
        verify(todoServiceMock).retrieveTodos(userName);
        verifyNoMoreInteractions(personServiceMock, todoServiceMock);
    }

    @Test
    void completeAllWithNoTodos() {
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(List.of());

        todoApp.completeAllTodos(userID);

        verify(personServiceMock).findUsernameById(userID);
        verify(todoServiceMock).retrieveTodos(userName);
        verify(todoServiceMock, never()).completeTodo(anyString());
        verifyNoMoreInteractions(personServiceMock, todoServiceMock);
    }

    @Test
    void completeAllWithThreeTodos() {
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(todos);

        todoApp.completeAllTodos(userID);

        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock, times(1)).retrieveTodos(userName);
        verify(todoServiceMock, times(1)).completeTodo("Wake up");
        verify(todoServiceMock, times(1)).completeTodo("Test the code");
        verify(todoServiceMock, times(1)).completeTodo("Celebrate the victory!");
        verifyNoMoreInteractions(personServiceMock, todoServiceMock);
    }
}
