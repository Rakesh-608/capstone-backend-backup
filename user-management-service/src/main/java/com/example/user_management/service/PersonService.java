package com.example.user_management.service;

import com.example.user_management.domain.Person;
import com.example.user_management.exceptions.UserNotFoundException;
import com.example.user_management.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository userRepository;

    public PersonService(PersonRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Person saveUser(Person person) {
        return userRepository.save(person);
    }

    public Person getUserById(String id) {
        Optional<Person> optionalPerson = userRepository.findById(id);
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }
        throw new UserNotFoundException("User not Found: "+id);
    }

    public Person getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public Person getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Person getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

}
