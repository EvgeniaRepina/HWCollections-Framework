package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OneItemRepositoryManagerTest {
    private IssueRepository repository = new IssueRepository();
    private Manager manager = new Manager(repository);

    Issue issue1 = new Issue(1, " Имя1", "содержание1", "Иванов", "Ковпак", "старое", "", true);
    Issue issue2 = new Issue(2, " Имя2", "содержание2", "Иванов", "Ковпак", "старое", "", true);
    Issue issue3 = new Issue(3, " Имя3", "содержание3", "Петров", "Пупкин", "новое", "", true);
    Issue issue4 = new Issue(4, " Имя4", "содержание4", "Иванов", "Ковпак", "старое", "", false);
    Issue issue5 = new Issue(5, " Имя5", "содержание5", "Сидоров", "Брежнев", "", "", false);


//     _________________ searchByAuthor____________________________________

    @Test
    public void shouldSearchByAuthorExist() {
        manager.add(issue5);

        Issue[] expected = new Issue[]{issue5};
        Issue[] actual = manager.searchByAuthor("Сидоров");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorNotExist() {
        manager.add(issue1);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAuthor("Жаботович");
        assertArrayEquals(expected, actual);
    }
    //     _________________ searchByLabel____________________________________

    @Test
    public void shouldSearchByLabelExist() {
        manager.add(issue3);

        Issue[] expected = new Issue[]{issue3};
        Issue[] actual = manager.searchByLabel("новое");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLabelNotExist() {
        manager.add(issue2);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByLabel("fgsf");
        assertArrayEquals(expected, actual);
    }
//     _________________ searchByAssignee____________________________________

    @Test
    public void shouldSearchByAssigneeExist() {
        manager.add(issue3);

        Issue[] expected = new Issue[]{issue3};
        Issue[] actual = manager.searchByAssignee("Пупк");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAssigneeNotExist() {
        manager.add(issue5);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAssignee("0");
        assertArrayEquals(expected, actual);
    }

    //   ___________________________open/closeById (update)___________________
    @Test
    public void shouldCloseByIdExist() {
        manager.add(issue2);
        manager.closeById(2);

        Boolean expected = false;
        boolean actual = issue2.isOpened();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldCloseByIdNotExist() {
        manager.add(issue1);
        manager.closeById(7);

        Issue[] expected = new Issue[]{issue1};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldOpenByIdExist() {
        manager.add(issue4);
        manager.openById(4);

        Boolean expected = true;
        boolean actual = issue4.isOpened();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldOpenByIdNotExist() {
        manager.add(issue4);
        manager.openById(7);

        Issue[] expected = new Issue[]{issue4};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);

    }

//     _________________ searchByOpened____________________________________


    @Test
    public void shouldSearchByOpenedExistOne() {
        manager.add(issue1);

        Issue[] expected = new Issue[]{issue1};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByOpenedNotExist() {
        manager.add(issue5);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);
    }

//      _________________ searchByClosed____________________________________

    @Test
    public void shouldSearchByClosedExistOne() {
        manager.add(issue5);

        Issue[] expected = new Issue[]{issue5};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByClosedNotExist() {
        manager.add(issue1);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);
    }
}