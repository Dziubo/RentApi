package com.example.demo.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User , Long> {
    List<User> findAll();
    Optional<User> findUserByPesel(String pesel);
    List<User> findAllByLastNameContaining(String lastName);
    Optional<User> findUserById(Long id);
    @Query(value = "SELECT u FROM User u  where u.id <>?2  and u.pesel=?1")
    Optional<User> findUserByPeselWhereIdIsDifferent(String pesel , Long id);
}
