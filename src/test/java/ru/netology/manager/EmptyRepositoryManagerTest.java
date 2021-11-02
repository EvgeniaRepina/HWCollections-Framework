package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class EmptyRepositoryManagerTest {
    private IssueRepository repository = new IssueRepository();
    private Manager manager = new Manager(repository);


//     _________________ searchByAuthor____________________________________

    @Test
    public void shouldSearchByAuthorNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAuthor("True");
        assertArrayEquals(expected, actual);
    }
    //     _________________ searchByLabel____________________________________

    @Test
    public void shouldSearchByLabelNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByLabel("fg4sf");
        assertArrayEquals(expected, actual);
    }
//     _________________ searchByAssignee____________________________________

    @Test
    public void shouldSearchByAssigneeNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAssignee("999999999999999999");
        assertArrayEquals(expected, actual);
    }

    //   ___________________________open/closeById (update)___________________

    @Test
    public void shouldCloseByIdNotExist() {

        manager.closeById(7);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldOpenByIdNotExist() {

        manager.openById(7);

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);

    }

//     _________________ searchByOpened____________________________________


    @Test
    public void shouldSearchByOpenedNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByOpened();
        assertArrayEquals(expected, actual);
    }

//      _________________ searchByClosed____________________________________

    @Test
    public void shouldSearchByClosedNotExist() {

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByClosed();
        assertArrayEquals(expected, actual);
    }
}