package com.example.Jpademo.repository;

import com.example.Jpademo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByFirstName(String firstName);
//    public List<User> findByLastName(String lastName);

}
// here we are using JpaRepository instead of CrudRepository  because in future if we want to perform bulk crud functon it will manage them easily
// Jpa will internally create all methods internally we dont have to create manually.
// all methods like crud, paging , sorting , batch transaction, flush of records means objects,
// bulk transaction not done by crud repository so we are using JpaRepository
// @Repository provide metadata
// crudRepository only do single task not multiple, delete all not happen here
// can I write our own method -- yes
//    findByLastName() it is a user defined method
//    findBy-> this should be same
//    LastName--> your class property Name