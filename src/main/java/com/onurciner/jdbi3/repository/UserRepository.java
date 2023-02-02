package com.onurciner.jdbi3.repository;

import com.onurciner.jdbi3.model.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RegisterBeanMapper(User.class)
public interface UserRepository {
    @SqlQuery("select * from user")
    List<User> findAll();

    @SqlQuery("select * from user where id = :id")
    User findById(@Bind("id") long id);

    @Transaction
    @SqlUpdate("delete from user where id = :id")
    int deleteById(@Bind("id") long id);

    @Transaction
    @SqlUpdate("update user set name=:name, surname=:surname, age=:age where id = :id")
    int update(@BindBean User book);

    @Transaction
    @GetGeneratedKeys
    @SqlUpdate("insert into user (name, surname, age) values (:name, :surname, :age)")
    int insert(@BindBean User book);
}