import model.User;
import repositories.UsersRepository;
import repositories.UsersRepositoryMemoryImpl;

import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UsersRepository repository = new UsersRepositoryMemoryImpl();

        User user1 = new User("id1", LocalDateTime.now(), "login1", "password1", "Иванов", "Иван", "Иванович", 30, true);
        User user2 = new User("id2", LocalDateTime.now(), "login2", "password2", "Петров", "Петр", "Петрович", 40, false);
        User user3 = new User("id3", LocalDateTime.now(), "login3", "password3", "Сидоров", "Алексей", "Александрович", 50, true);

        // Добавление пользователей в хранилище
        repository.create(user1);
        repository.create(user2);
        repository.create(user3);

        // Поиск пользователя по идентификатору
        User foundUser = repository.findById("id1");
        System.out.println("Найденный пользователь по ID: " + foundUser);

        // Выгрузка всех пользователей
        List<User> allUsers = repository.findAll();
        System.out.println("Все пользователи:");
        allUsers.forEach(System.out::println);

        // Обновление данных пользователя
        user1.setAge(35);
        repository.update(user1);
        System.out.println("Обновленный пользователь: " + repository.findById("id1"));

        // Удаление пользователя по идентификатору
        repository.deleteById("id2");
        System.out.println("Пользователь с ID=id2 удалён");

        // Поиск по полю (возрасту)
        List<User> usersByAge = repository.findByAge(35);
        System.out.println("Пользователи с возрастом 35 лет:");
        usersByAge.forEach(System.out::println);

        // Удаление всех пользователей
        repository.deleteAll();
        System.out.println("Все пользователи удалены");

    }
}
