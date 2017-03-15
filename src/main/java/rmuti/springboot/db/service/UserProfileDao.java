package rmuti.springboot.db.service;

import org.springframework.data.repository.CrudRepository;

import rmuti.springboot.db.table.UserProfile;

public interface UserProfileDao extends CrudRepository<UserProfile, Integer> {

}
