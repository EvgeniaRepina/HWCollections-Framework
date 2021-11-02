package ru.netology.domain;

public class Issue implements Comparable<Issue> {
    private int id;
    private String title;
    private String content;
    private String author;
    private String assignee;
    private String label;
    private String milestones;
    private boolean opened;


    public Issue(int id, String title, String content, String author, String assignee, String label, String milestones, boolean opened) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.assignee = assignee;
        this.label = label;
        this.milestones = milestones;
        this.opened = opened;
    }


//___  геттеры и сеттеры_______________


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMilestones() {
        return milestones;
    }

    public void setMilestones(String milestones) {
        this.milestones = milestones;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    //________________алгоритм сравнения для Comparable_________________
    @Override
    public int compareTo(Issue o) {
        Issue p = o;
        return id - p.id;
    }


}
