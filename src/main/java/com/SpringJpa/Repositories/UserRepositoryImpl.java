package com.SpringJpa.Repositories;

import com.SpringJpa.Entities.Users;
import com.SpringJpa.Exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private static final String SQL_CREATE = "INSERT INTO users(first_name, last_name, email, password) VALUES(?, ?, ?, ?)";

    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM USERS WHERE EMAIL = ?";

    private static final String SQL_FIND_BY_ID = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD FROM USERS WHERE USER_ID=?";

    private static final String SQL_FIND_BY_EMAIL = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD FROM USERS WHERE EMAIL = ?";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String firstName, String lastName, String email, String password) throws EtAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, email);
                ps.setString(4, password);

                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("user_id");
        }catch (Exception e){
            throw new EtAuthException("Invalid Details. Failed to create Account");
        }
    }

    @Override
    public Users findByEmailAndPassword(String email, String password) throws EtAuthException {
        try {
            System.out.println("Executing SQL QUERY " + SQL_FIND_BY_EMAIL);
            Users users = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[]{email}, userRowMapper);

            System.out.println("Email from DB: " + users.getEmail());
            System.out.println("Password from DB: " + users.getPassword());

            if (password.equals(users.getPassword())) {
                return users;
            }else {
                throw new EtAuthException("Invalid Password");
            }

        }catch (EmptyResultDataAccessException e){
            throw new EtAuthException("User Not Found");
        }
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email}, Integer.class);
    }

    @Override
    public Users findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId}, userRowMapper);
    }

    private RowMapper<Users> userRowMapper = ((rs, rowNum) -> {
        return new Users(rs.getInt("USER_ID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"));
    });
}
