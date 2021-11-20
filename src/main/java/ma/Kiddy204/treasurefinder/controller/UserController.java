package ma.Kiddy204.treasurefinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ma.Kiddy204.treasurefinder.domain.UserVo;
import ma.Kiddy204.treasurefinder.service.IUserService;
@Controller
public class UserController {

	@Autowired
	private IUserService service;
	
	@RequestMapping("/")
	public String showWelcomeFile(Model m) {
		return "index"; 
	}

	@RequestMapping("/userform") 
	public String showform(Model m) {
		m.addAttribute("userVo", new UserVo());
		return "userform"; 
	}
	
	@RequestMapping(
			value = "/save", 
			method = RequestMethod.POST) 
	public String save(@ModelAttribute("userVo") UserVo user) {
		service.save(user);
		return "redirect:/userlist";// will redirect to userlist request mapping 
	}

	@RequestMapping("/userlist") 
	public String userlist(Model m) {
		List<UserVo> list = service.getUsers();
		m.addAttribute("list", list);
		return "userlist";
	}

	@RequestMapping(value = "/edituser/{id}")
	public String edit(@PathVariable Long id, Model m) {
		UserVo user = service.getUserById(id);
		m.addAttribute("userVo", user); 
		return "usereditform";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST) 
	public String editsave(@ModelAttribute("userVo") UserVo user) {
		service.save(user);
		return "redirect:/userlist"; 
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET) 
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/userlist"; 
	}

	@RequestMapping("/username/{username}")
	public String getByusername(@PathVariable String username, Model m) {
		List<UserVo> list = service.findByUsername(username); 
		m.addAttribute("list", list);
		return "userlist";
	}

	@RequestMapping("/mail/{mail}")
	public String getBymail(@PathVariable String mail, Model m) {
		List<UserVo> list = service.findByMail(mail); m.addAttribute("list", list);
		return "userlist";
	}

	@RequestMapping("/pagination/{pageid}/{size}")
	public String pagination(@PathVariable int pageid, @PathVariable int size, Model m)
	{
		List<UserVo> list = service.findAll(pageid, size); m.addAttribute("list", list);
		return "userlist";
	}

	@RequestMapping("/sort/{fieldName}")
	public String sortBy(@PathVariable String fieldName, Model m) {
		List<UserVo> list = service.sortBy(fieldName); 
		m.addAttribute("list", list);
		return "userlist";
	} 
}


