package com.jpa.repository;

import com.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //    custom finder methos use case
    List<User> findByIdOrName(int id, String name);

    List<User> findByIdBetween(int start, int end);

    List<User> findTop5ByIdGreaterThan(int id);

    List<User> findByIdIn(List<Integer> ids);

//    query and param anntotations for creating the query

    //    JPQL query
    @Query(value = "select U from User U where id>=:id")
    List<User> getUserGreaterThan(@Param("id") int id);

    @Query(value = "select U from User U where id IN(:ids)")
    List<User> getUsersInProvidedId(@Param("ids") List<Integer> ids);

    //    SQL queries
    @Query(value = "select * from user where id<=:id", nativeQuery = true)
    List<User> getUserLessThanNative(@Param("id") int id);

    @Query(value = "select * from user where id IN(:ids)", nativeQuery = true)
    List<User> getUsersInProvidedIdNative(@Param("ids") List<Integer> ids);

//    Named Queries
    List<User> selectByIdInUser(int id);
    List<User> selectInProvidedId(List<Integer> ids);

//    Native Named Queries
    List<User> selectByIdInUserNative(int id);
    List<User> selectInProvidedIdNative(List<Integer> ids);
}
