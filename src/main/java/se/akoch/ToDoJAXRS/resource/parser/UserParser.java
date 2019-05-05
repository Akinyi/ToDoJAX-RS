package se.akoch.ToDoJAXRS.resource.parser;

import se.akoch.ToDoJAXRS.model.User;

public class UserParser {
    private UserParser() {
    }

    public static User fromTextString(String text) {
        String[] parts = text.split(",");
        Long id = Long.parseLong(parts[0]);
        String firstName = parts[1];
        String lastName = parts[2];


        return new User(id, firstName, lastName);
    }

    public static String toTextString(User user) {
        return String.format("%s, %s, %s, %s", user.getId(), user.getFirstName(),
                user.getLastName());
    }

}
