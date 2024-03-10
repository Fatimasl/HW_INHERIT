package ru.netology.statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void SimpleTaskMatchesTestTrue(){
        SimpleTask simpleTask = new SimpleTask(6, "Вынести мусор");

        String query = "мусор";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SimpleTaskMatchesTestFalse(){
        SimpleTask simpleTask = new SimpleTask(6, "Вынести мусор");

        String query = "пакет";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicMatchesTestTrue(){
        String[] subtasks = { "Джем", "Конфеты", "Яйца" };
        Epic epicTask = new Epic(56, subtasks);

        String query = "Яйца";

        boolean expected = true;
        boolean actual = epicTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicMatchesTestFalse(){
        String[] subtasks = { "Джем", "Конфеты", "Яйца" };
        Epic epicTask = new Epic(56, subtasks);

        String query = "яйца";

        boolean expected = false;
        boolean actual = epicTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingMatchesTestTrueByTopic(){
        Meeting meetingTask = new Meeting(556, "Собрание жильцов дома", "Жилищно-коммунальное хозяйство", "11.03.2024 12:00");

        String query = "Собрание";

        boolean expected = true;
        boolean actual = meetingTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingMatchesTestTrueByProject(){
        Meeting meetingTask = new Meeting(556, "Собрание жильцов дома", "Жилищно-коммунальное хозяйство", "11.03.2024 12:00");

        String query = "хозяйство";

        boolean expected = true;
        boolean actual = meetingTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingMatchesTestFalse(){
        Meeting meetingTask = new Meeting(556, "Собрание жильцов дома", "ЖКХ", "11.03.2024 12:00");

        String query = "мусор";

        boolean expected = false;
        boolean actual = meetingTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}
