package javaapi.javaapicrudspringboot.Repo;

import javaapi.javaapicrudspringboot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
