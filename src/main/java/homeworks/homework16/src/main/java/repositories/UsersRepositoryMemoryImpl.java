package repositories;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.User;

public class UsersRepositoryMemoryImpl implements UsersRepository {
    private List<User> users = new ArrayList<>(); // Для хранения данных

    @Override
    public void create(User user) {
        users.add(user);
    }

    @Override
    public User findById(String id) {
        Optional<User> result = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        return result.orElseThrow(() -> new IllegalArgumentException("Пользователь с указанным идентификатором не найден"));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users); // Копия списка для безопасности
    }

    @Override
    public void update(User user) {
        Optional<User> existingUser = users.stream()
                .filter(u -> u.getId().equals(user.getId()))
                .findFirst();
        if (existingUser.isPresent()) {
            users.remove(existingUser.get());
            users.add(user);
        } else {
            throw new IllegalArgumentException("Пользователь с указанным идентификатором не найден");
        }
    }

    @Override
    public void deleteById(String id) {
        Optional<User> userToRemove = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if (userToRemove.isPresent()) {
            users.remove(userToRemove.get());
        } else {
            throw new IllegalArgumentException("Пользователь с указанным идентификатором не найден");
        }
    }

    @Override
    public void deleteAll() {
        users.clear();
    }

    public List<User> findByAge(int age) {
        return users.stream()
                .filter(user -> user.getAge() == age)
                .collect(Collectors.toList()); // Используем Stream API для фильтрации и сбора результатов
    }

    public List<User> findByIsWorker(boolean isWorker) {
        return users.stream()
                .filter(user -> user.isWorker() == isWorker)
                .collect(Collectors.toList());
    }
}
