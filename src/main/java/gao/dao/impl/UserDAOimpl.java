package gao.dao.impl;

import gao.dao.*;
import gao.entity.Users;
import gao.util.XJdbc;
import gao.util.XQuery;
import java.util.List;

public class UserDAOimpl implements UserDAO {

    private final String insertSql = "INSERT INTO Users (Username, Password, Enabled, Fullname, Manager) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Users SET Password = ?, Enabled = ?, Fullname = ?, Manager = ? WHERE Username = ?";
    private final String deleteSql = "DELETE FROM Users WHERE Username = ?";
    private final String findAllSql = "SELECT * FROM Users";
    private final String findByIdSql = "SELECT * FROM Users WHERE Username = ?";
    private final String findByUsernameSql = "SELECT * FROM Users WHERE Username = ?";

    @Override
    public Users create(Users entity) {
        Object[] args = {
            entity.getUsername(),
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.isManager()
        };
        XJdbc.executeUpdate(insertSql, args);
        return entity;
    }

    @Override
    public void update(Users entity) {
        Object[] args = {
            entity.getPassword(),
            entity.isEnabled(),
            entity.getFullname(),
            entity.isManager(),
            entity.getUsername()
        };
        XJdbc.executeUpdate(updateSql, args);
    }

    @Override
    public void deleteById(String username) {
        XJdbc.executeUpdate(deleteSql, username);
    }

    @Override
    public List<Users> findAll() {
        return XQuery.getBeanList(Users.class, findAllSql);
    }

    @Override
    public Users findById(String username) {
        return XQuery.getSingleBean(Users.class, findByIdSql, username);
    }

    @Override
    public Users findByUsername(String username) {
        return XQuery.getSingleBean(Users.class, findByUsernameSql, username);
    }
}
