package com.loadpage.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.loadpage.model.User;
import com.loadpage.model.UserException;

@Controller
@RequestMapping("/user")
public class UserController {
	private Map<String, User> users = new HashMap<String, User>();
	
	public UserController(){
		users.put("zxd", new User("zxd","34146","张晓单","34146@126"));
		users.put("zx", new User("zxd","34147","张鑫","34147@126"));
	}
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users",users);
		return "/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute(new User());
		return "/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br, MultipartFile attach,HttpServletRequest request) throws Exception{//紧跟valida之后写验证
		if(br.hasErrors()){
			return "/add";
		}
		System.out.println(attach.getName() + "," + attach.getOriginalFilename() +
				"," + attach.getContentType());
		
		String realpath = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realpath);
		File f = new File(realpath+"/" + attach.getOriginalFilename());
		FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
		users.put(user.getUsername(),user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String show(@PathVariable String username, Model model){
		model.addAttribute(users.get(username));
		
		return "/show";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET,params="json")
	@ResponseBody
	public User show(@PathVariable String username){
		
		return users.get(username);
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.GET)
	public String update(@PathVariable String username, Model model){
		model.addAttribute(users.get(username));
		return "/update";
	}
	
	@RequestMapping(value="/{username}/update",method=RequestMethod.POST)
	public String update(@PathVariable String username,@Validated User user,
			BindingResult br){
		if(br.hasErrors()){
			return "/update";
		}
		users.put(username, user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{username}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable String username, Model model){
		users.remove(username);
		
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username, String password,HttpSession session){
		if(!users.containsKey(username)){
			throw new UserException("用户名不存在");
		}
		User u = users.get(username);
		if(!password.equals(u.getPassword())){
			throw new UserException("用户密码不正确");
		}
		
		session.setAttribute("loginUser", u);
		return "redirect:/user/users";
	}
	/*
	@ExceptionHandler(value={UserException.class})
	public String handlerException(UserException e,HttpServletRequest request){
		request.setAttribute("e", e);
		return "/error";
	}*/
}
