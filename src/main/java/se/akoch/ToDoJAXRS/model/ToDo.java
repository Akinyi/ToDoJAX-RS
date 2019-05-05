package se.akoch.ToDoJAXRS.model;


public class ToDo {
    private final Long id;
    private final String text;

    public ToDo(Long id, String text) { // consider making an incremental id here as well as in User
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("Id:%s, Text:%s", id, text);
    }
}
