package se.akoch.ToDoJAXRS.repository;

import org.springframework.stereotype.Repository;
import se.akoch.ToDoJAXRS.model.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository
public class DataLager implements  DataRepository{
    private final Map<Long, User> users = new ConcurrentHashMap<>();

    @Override
    public User add(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.ofNullable(users.get(id)); // Returnar antingen en null eller ett värde
    }

    @Override
    public Stream<User> getAll() {
        return users.values().stream();
    }

    @Override
    public User update(User user) {
        if(users.containsKey(user.getId())){
            users.put(user.getId(), user);
        }

        return user;
    }

    @Override
    public Optional<User> delete(Long id) {
        return Optional.ofNullable(users.remove(id));
    }
}
