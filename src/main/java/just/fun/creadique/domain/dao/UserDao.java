package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();
    Optional<User> get(String username);
    void create(User user);
    void delete(String username);
    boolean isPresent(String username);
    void update(String username, User user);

}
