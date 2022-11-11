package kz.tomik.thirdblock.service;


import kz.tomik.thirdblock.model.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> findAll();
    public User findOne(int id);
    public void save(User user);
    public void update(int id,User user);
    public void delete(int id);
}
