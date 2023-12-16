package just.fun.creadique.domain.dao;

import just.fun.creadique.domain.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserDaoForTest implements UserDao {

    private final Map<String, User> db;

    public UserDaoForTest() {
        this.db = new HashMap<>();
    }

    @Override
    public List<User> findAll() {
        return db.values().stream().toList();
    }

    @Override
    public Optional<User> get(String username) {
        return Optional.ofNullable(db.get(username));
    }

    @Override
    public void create(User user) {
        db.put(user.getUsername(), user);
    }

    @Override
    public void delete(String username) {
        db.remove(username);
    }

    @Override
    public boolean isPresent(String username) {
        return db.containsKey(username);
    }

    @Override
    public void update(String username, User user) {
        db.put(username, user);
    }
}
