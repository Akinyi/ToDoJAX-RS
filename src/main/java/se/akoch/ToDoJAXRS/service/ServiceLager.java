package se.akoch.ToDoJAXRS.service;

import org.springframework.stereotype.Service;
import se.akoch.ToDoJAXRS.model.User;
import se.akoch.ToDoJAXRS.repository.DataRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;

@Service
public class ServiceLager {
    private final DataRepository dataRepository;
    private static final AtomicLong ids = new AtomicLong(1000);

    public ServiceLager(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public User createUser(User user) {
        return dataRepository.add(new User(ids.incrementAndGet(),
                user.getFirstName(), user.getLastName()));
    }

    public Optional<User> getUser(Long id) {

        return dataRepository.get(id);
    }

    public User updateUser(User user) {

        return dataRepository.update(user);
    }

    public Optional <User> deleteUser(Long id) {

        return dataRepository.delete(id);
    }

    public List<User> getAllUsers(int limit, boolean desc) {
        return dataRepository.getAll().collect(toList());
    }
}
