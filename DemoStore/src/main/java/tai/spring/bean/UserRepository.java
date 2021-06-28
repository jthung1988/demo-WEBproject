package tai.spring.bean;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
//	@Query(value = "select user_no, username, password, enable from User where username= ?1")
	public List<User> findByUsername(String username);
}
