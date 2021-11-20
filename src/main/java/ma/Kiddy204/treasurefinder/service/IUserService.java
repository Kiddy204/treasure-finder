package ma.Kiddy204.treasurefinder.service;

import java.util.List;

import ma.Kiddy204.treasurefinder.domain.UserVo;

public interface IUserService {
	
	List<UserVo> getUsers();
	void save(UserVo User);
	UserVo getUserById(Long id);
	void delete(Long id);
	List<UserVo> findByMail(String mail);
	List<UserVo> findByUsername(String username);
	//Pour la pagination
	List<UserVo> findAll(int pageId, int size);
	//pour le tri
	List<UserVo> sortBy(String fieldName);
}
