package ma.Kiddy204.treasurefinder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.Kiddy204.treasurefinder.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByMail(String mail);
	List<User> findByUsername(String username);
//	@Query(" SELECT e from User )") List<User> findAll();
}