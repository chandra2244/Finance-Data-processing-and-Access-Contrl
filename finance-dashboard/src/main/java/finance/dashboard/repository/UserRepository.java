package finance.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import finance.dashboard.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}