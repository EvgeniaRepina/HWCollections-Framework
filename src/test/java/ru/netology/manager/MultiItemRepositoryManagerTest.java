package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiItemRepositoryManagerTest {
    private IssueRepository repository = new IssueRepository();
    private Manager manager = new Manager(repository);

    Issue issue1 = new Issue(1, " Имя1", "содержание1", "Иванов", "Ковпак", "старое", "", true);
    Issue issue2 = new Issue(2, " Имя2", "содержание2", "Иванов", "Ковпак", "старое", "", true);
    Issue issue3 = new Issue(3, " Имя3", "содержание3", "Петров", "Пупкин", "новое", "", true);
    Issue issue4 = new Issue(4, " Имя4", "содержание4", "Иванов", "Ковпак", "старое", "", false);
    Issue issue5 = new Issue(5, " Имя5", "содержание5", "Сидоров", "Брежнев", "", "", false);


    @BeforeEach
    public void setUp() {
        manager.add(issue1);
        manager.add(issue2);
        manager.add(issue3);
        manager.add(issue4);
        manager.add(issue5);

    }


    //  _________________ add________________________________
    @Test
    public void shouldSaveOneItem() {

        Issue[] expected = new Issue[]{issue1, issue2, issue3, issue4, issue5};
        Issue[] actual = repository.getItems().toArray(new Issue[0]);
        assertArrayEquals(expected, actual);
    }

    //_________________ Match ____________________________________
    @Test
    public void shouldMatchPositive() {

        boolean expected = true;
        boolean actual = manager.matchesAuthor(issue3, "Петров");
        assertEquals(expected, actual);
    }


//     _________________ searchByAuthor____________________________________

    @Test
    public void shouldSearchByAuthorExistSeveral() {

        Issue[] expected = new Issue[]{issue1, issue2, issue4};
        Issue[] actual = manager.searchByAuthor("Иванов");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorExistOne() {

        Issue[] expected = new Issue[]{issue5};
        Issue[] actual = manager.searchByAuthor("Сидоров");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthorNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAuthor("Жаботович");
        assertArrayEquals(expected, actual);
    }
    //     _________________ searchByLabel____________________________________

    @Test
    public void shouldSearchByLabelExistSeveral() {

        Issue[] expected = new Issue[]{issue1, issue2, issue4};
        Issue[] actual = manager.searchByLabel("старое");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLabelExistOne() {

        Issue[] expected = new Issue[]{issue3};
        Issue[] actual = manager.searchByLabel("новое");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByLabelNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByLabel("fgsf");
        assertArrayEquals(expected, actual);
    }
//     _________________ searchByAssignee____________________________________

    @Test
    public void shouldSearchByAssigneeExistSeveral() {

        Issue[] expected = new Issue[]{issue1, issue2, issue4};
        Issue[] actual = manager.searchByAssignee("Ковпак");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAssigneeExistOne() {

        Issue[] expected = new Issue[]{issue3};
        Issue[] actual = manager.searchByAssignee("Пупки");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAssigneeNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAssignee("0");
        assertArrayEquals(expected, actual);
    }

    //   ___________________________open/closeById (update)___________________
    @Test
    public void shouldCloseByIdExist() {
        manager.closeById(2);

        Boolean expected = false;
        boolean actual = issue2.isOpened();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldCloseByIdNotExist() {
        manager.closeById(7);

        Issue[] expected = new Issue[]{issue1, issue2, issue3};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldOpenByIdExist() {
        manager.openById(4);

        Boolean expected = true;
        boolean actual = issue4.isOpened();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldOpenByIdNotExist() {
        manager.openById(7);

        Issue[] expected = new Issue[]{issue1, issue2, issue3};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);

    }
//     _________________ searchByOpened____________________________________

    @Test
    public void shouldSearchByOpenedExistSeveral() {

        Issue[] expected = new Issue[]{issue1, issue2, issue3};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByOpenedExistOne() {
        manager.closeById(2);
        manager.closeById(3);

        Issue[] expected = new Issue[]{issue1};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByOpenedNotExist() {
        manager.closeById(1);
        manager.closeById(2);
        manager.closeById(3);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);
    }

//      _________________ searchByClosed____________________________________

    @Test
    public void shouldSearchByClosedExistSeveral() {

        Issue[] expected = new Issue[]{issue4, issue5};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByClosedExistOne() {
        manager.openById(5);

        Issue[] expected = new Issue[]{issue4};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByClosedNotExist() {
        manager.openById(5);
        manager.openById(4);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);
    }
}