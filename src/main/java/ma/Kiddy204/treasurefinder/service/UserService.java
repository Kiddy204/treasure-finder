package ma.Kiddy204.treasurefinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import ma.Kiddy204.treasurefinder.dao.UserRepository;
import ma.Kiddy204.treasurefinder.domain.UserConverter;
import ma.Kiddy204.treasurefinder.domain.UserVo;
import ma.Kiddy204.treasurefinder.model.User;

public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserVo> getUsers() {
		// TODO Auto-generated method stub
		 List<User> list = userRepository.findAll();
		 return UserConverter.toListVo(list);
		
	}

	@Override
	public void save(UserVo vo) {
		userRepository.save(UserConverter.toUser(vo));
		
	}

	@Override
	public UserVo getUserById(Long id) {
		boolean trouve = userRepository.existsById(id); 
		if (!trouve)
			return null;
		else return UserConverter.toValueObject(userRepository.getById(id));
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<UserVo> findByMail(String mail) {
		List <User> list = userRepository.findByMail(mail);
		return UserConverter.toListVo(list);
	}

	@Override
	public List<UserVo> findByUsername(String username) {
		List <User> list = userRepository.findByUsername(username);
		return UserConverter.toListVo(list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVo> findAll(int pageId, int size) {
		List <User> list = (List<User>) userRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "username"));
		return UserConverter.toListVo(list);
	}

	@Override
	public List<UserVo> sortBy(String fieldName) {
		return UserConverter.toListVo(userRepository.findAll(Sort.by(fieldName)));
	}
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		userRepository.save(new User("name1", "name1@mail.com", "12345"));
		userRepository.save(new User("name2", "name2@mail.com", "12345")); 
		userRepository.save(new User("name3", "name3@mail.com", "12345")); 
		userRepository.save(new User("name4", "name4@mail.com", "12345")); 
		userRepository.save(new User("name5", "name5@mail.com", "12345")); 
		userRepository.save(new User("name6", "name6@mail.com", "12345"));
		userRepository.save(new User("name7", "name7@mail.com", "12345")); 
		userRepository.save(new User("name8", "name8@mail.com", "12345"));
	}
	

}
