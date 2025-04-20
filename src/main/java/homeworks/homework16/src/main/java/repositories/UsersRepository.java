package repositories;

import java.util.List;
import model.User;

public interface UsersRepository {
    void create(User user);
    User findById(String id);
    List<User> findAll();
    void update(User user);
    void deleteById(String id);
    void deleteAll();
    List<User> findByAge(int i);
}
