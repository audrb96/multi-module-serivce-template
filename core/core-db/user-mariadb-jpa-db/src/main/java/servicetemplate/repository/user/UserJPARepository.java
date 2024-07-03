package servicetemplate.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import servicetemplate.repository.user.entity.UserEntity;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
}
