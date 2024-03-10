package ru.netology.statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

//    @BeforeAll
//    public void setup(){
//        todos.add(simpleTask);
//        todos.add(epic);
//        todos.add(meeting);
//    }
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnMatchedNotEmptyArray() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        SimpleTask simpleTask2 = new SimpleTask(6, "Хлеб купить");

        String[] subtasks = { "Джем", "Конфеты", "Яйца" };
        Epic epic2 = new Epic(56, subtasks);

        Meeting meeting2 = new Meeting(
                556,
                "Выкатка 2й версии приложения",
                "Приложение ХлебоБанка",
                "В среду до обеда"
        );

        todos.add(simpleTask2);
        todos.add(epic2);
        todos.add(meeting2);

        String query = "Хлеб";

        Task[] expected = { epic, simpleTask2, meeting2 };
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnMatchedEmptyArray() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        SimpleTask simpleTask2 = new SimpleTask(6, "Хлеб купить");

        String[] subtasks = { "Джем", "Конфеты", "Яйца" };
        Epic epic2 = new Epic(56, subtasks);

        Meeting meeting2 = new Meeting(
                556,
                "Выкатка 2й версии приложения",
                "Приложение ХлебоБанка",
                "В среду до обеда"
        );

        todos.add(simpleTask2);
        todos.add(epic2);
        todos.add(meeting2);

        String query = "яйца";

        Task[] expected = {};
        Task[] actual = todos.search(query);

        Assertions.assertArrayEquals(expected, actual);
    }
}
