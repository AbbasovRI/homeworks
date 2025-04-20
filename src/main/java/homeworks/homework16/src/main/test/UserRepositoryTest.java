import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryMemoryImpl;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {

    private UsersRepository repository;

    @BeforeEach
    void setup() {
        repository = new UsersRepositoryMemoryImpl();
    }

    @Test
    void testCreateAndFindById() {
        // Arrange
        User user = new User(
                "id1",
                LocalDateTime.now(),
                "login1",
                "password1",
                "Иванов",
                "Иван",
                "Иванович",
                30,
                true
        );

        // Act
        repository.create(user);
        User foundUser = repository.findById("id1");

        // Assert
        assertEquals(user, foundUser);
    }

    @Test
    void testUpdate() {
        // Arrange
        User user = new User(
                "id1",
                LocalDateTime.now(),
                "login1",
                "password1",
                "Иванов",
                "Иван",
                "Иванович",
                30,
                true
        );
        repository.create(user);

        // Update data
        user.setAge(35);

        // Act
        repository.update(user);
        User updatedUser = repository.findById("id1");

        // Assert
        assertEquals(35, updatedUser.getAge());
    }

    @Test
    void testFindAll() {
        // Arrange
        User user1 = new User(
                "id1",
                LocalDateTime.now(),
                "login1",
                "password1",
                "Иванов",
                "Иван",
                "Иванович",
                30,
                true
        );
        User user2 = new User(
                "id2",
                LocalDateTime.now(),
                "login2",
                "password2",
                "Петров",
                "Петр",
                "Петрович",
                40,
                false
        );
        repository.create(user1);
        repository.create(user2);

        // Act
        List<User> allUsers = repository.findAll();

        // Assert
        assertEquals(2, allUsers.size(), "Должно быть найдено два пользователя.");
        assertTrue(allUsers.contains(user1), "Список должен содержать первого пользователя.");
        assertTrue(allUsers.contains(user2), "Список должен содержать второго пользователя.");
    }

    @Test
    void testFindByAge() {
        // Arrange
        User user1 = new User(
                "id1",
                LocalDateTime.now(),
                "login1",
                "password1",
                "Иванов",
                "Иван",
                "Иванович",
                30,
                true
        );
        User user2 = new User(
                "id2",
                LocalDateTime.now(),
                "login2",
                "password2",
                "Петров",
                "Петр",
                "Петрович",
                30,
                false
        );
        User user3 = new User(
                "id3",
                LocalDateTime.now(),
                "login3",
                "password3",
                "Сидоров",
                "Алексей",
                "Александрович",
                40,
                true
        );
        repository.create(user1);
        repository.create(user2);
        repository.create(user3);

        // Act
        List<User> usersByAge = repository.findByAge(30);

        // Assert
        assertEquals(Arrays.asList(user1, user2), usersByAge);
    }
}