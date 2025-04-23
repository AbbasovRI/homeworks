package jpademo.service;

import jpademo.model.Users;
import jpademo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public Users getUser(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Transactional
    public void deleteAllUsers() {
        usersRepository.deleteAll();
    }
}
