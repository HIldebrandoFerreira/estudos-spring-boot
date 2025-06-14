package br.com.hildebrando.repository;

import br.com.hildebrando.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
