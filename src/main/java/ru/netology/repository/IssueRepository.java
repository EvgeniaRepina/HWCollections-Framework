package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class IssueRepository {

    //  создаем коллекцию вместо массива
    private Collection<Issue> items = new ArrayList<>();

//    используем методы из коллекции (из ArrayList)

    public void add(Issue item) {

        items.add(item);
    }

    public Collection<Issue> getItems() {
        return items;
    }

//    private Set<Issue> labels = new HashSet<>();
//
//    public void setLabeles(Set<Issue> labeles) {
//        this.labels = labeles;
//    }
//    public Set<labels> getLabeles() {
//        return labels;
//    }
}
