package se.akoch.ToDoJAXRS.repository;

import se.akoch.ToDoJAXRS.model.User;

import java.util.Optional;
import java.util.stream.Stream;

public interface DataRepository {
    User add(User user);

    Optional<User> get(Long id);

    //Stream<User> getAll(int limit);

    Stream<User> getAll();

    User update(User user);

    Optional<User> delete(Long id);
}
