package ma.Kiddy204.treasurefinder.domain;

import java.util.ArrayList;
import java.util.List;

import ma.Kiddy204.treasurefinder.model.User;

public class UserConverter {
	public static UserVo toValueObject(User user) {
		if (user == null || user.getId() ==null) return null;
		UserVo vo = new UserVo(); 
		vo.setId(user.getId()); 
		vo.setUsername(user.getUsername()); 
		vo.setMail(user.getMail()); 
		vo.setPassword(user.getPassword()); 
		return vo;
	}
	public static User toUser (UserVo vo) {
		User bo = new User(); 
		bo.setId(vo.getId()); 
		bo.setUsername(vo.getUsername()); 
		bo.setMail(vo.getMail());	
		bo.setPassword(vo.getPassword());
		return bo;
	}
	
	public static List<UserVo> toListVo(List<User> listBo) {
		List<UserVo> listVo = new ArrayList<>();
		for (User User : listBo) {
			listVo.add(toValueObject(User)); 
		}
		return listVo; 
	}

}
