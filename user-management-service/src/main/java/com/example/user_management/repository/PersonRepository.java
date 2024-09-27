package com.example.user_management.repository;

import com.example.user_management.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    boolean existsByEmailAndPassword(String email,String passwrd);
    Person findByEmail(String email);
    Person findByPhone(String phone);
    Person findByEmailAndPassword(String email, String password);
    Person findByPhoneAndPassword(String email, String name);
    Person findByEmailAndPhone(String email, String phone);

}
