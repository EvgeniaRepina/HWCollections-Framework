package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

public class Manager {

    private IssueRepository repository;


    //    ____________ конструктор________________________
    public Manager(IssueRepository repository) {
        this.repository = repository;
    }

//____________________добавление товаров_______

    public void add(Issue item) {
        repository.add(item);
    }

// ______________ поиск по автору______________________________

    public Issue[] searchByAuthor(String text) {
        Issue[] result = new Issue[0];
        for (Issue issues : repository.getItems()) {
            if (matchesAuthor(issues, text)) {
                Issue[] tmp = new Issue[result.length + 1];

                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = issues;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matchesAuthor(Issue issue, String search) {


        if (issue.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
            return true;
        }
        return false;

    }
// ______________ поиск по тегу______________________________

    public Issue[] searchByLabel(String text) {
        Issue[] result = new Issue[0];
        for (Issue issues : repository.getItems()) {
            if (matchesLabel(issues, text)) {
                Issue[] tmp = new Issue[result.length + 1];

                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = issues;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matchesLabel(Issue issue, String search) {
        if (issue.getLabel().contains(search)) { // проверим есть ли поисковое слово в данных
            return true;
        }
        return false;
    }
// ______________ поиск по ответственному______________________________

    public Issue[] searchByAssignee(String text) {
        Issue[] result = new Issue[0];
        for (Issue issues : repository.getItems()) {
            if (matchesAssignee(issues, text)) {
                Issue[] tmp = new Issue[result.length + 1];

                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = issues;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matchesAssignee(Issue issue, String search) {


        if (issue.getAssignee().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
            return true;
        }
        return false;

    }
// ______________ Отображение списка открытых/закрытых Issue______________________________

    public Issue[] searchByOpened() {
        Issue[] result = new Issue[0];
        for (Issue issues : repository.getItems()) {
            if (issues.isOpened()) {
                Issue[] tmp = new Issue[result.length + 1];

                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = issues;
                result = tmp;
            }
        }
        return result;
    }

    public Issue[] searchByClosed() {
        Issue[] result = new Issue[0];
        for (Issue issues : repository.getItems()) {
            if (issues.isOpened() == false) {
                Issue[] tmp = new Issue[result.length + 1];

                // используйте System.arraycopy, чтобы скопировать всё из result в tmp
                System.arraycopy(result, 0, tmp, 0, result.length);

                tmp[tmp.length - 1] = issues;
                result = tmp;
            }
        }
        return result;
    }

    // ______________ Закрытие/открытие Issue по id (update)______________________________
    public void closeById(int id) {
        for (Issue issues : repository.getItems()) {
            if (issues.getId() == id) {
                issues.setOpened(false);
            }
        }
    }

    public void openById(int id) {
        for (Issue issues : repository.getItems()) {
            if (issues.getId() == id) {
                issues.setOpened(true);
            }
        }
    }


}
