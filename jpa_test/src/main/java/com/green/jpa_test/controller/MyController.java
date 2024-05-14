package com.green.jpa_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.jpa_test.entity.Board;
import com.green.jpa_test.entity.User;
import com.green.jpa_test.repository.BoardRepository;
import com.green.jpa_test.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping("/")
	public String root() {
		 return "index" ;
	}
	
	@RequestMapping("/regForm")
	public void regForm() {
		
	}
	@RequestMapping("/reg")
	public String reg(@RequestParam("username")String username, 
			@RequestParam("password") String password, 
			@RequestParam("name")String name, 
			@RequestParam("tel")String tel) {
		User user = User.builder()
				.username(username)
				.password(password)
				.name(name)
				.tel(tel)
				.build();
		userRepository.save(user);
	  
		return "redirect:/loginForm";
	}
	
	@RequestMapping("/loginForm")
	public void loginForm(){
		
	}
	
	@RequestMapping("/main")
	public String main(Model model) {
		List<Board> list = boardRepository.findAll();
		model.addAttribute("list", list);
		return "main";
	}
	
	@RequestMapping("/regBoard")
	public void regBoard() {
		
	}
	
	@RequestMapping("/login")
	public String loginForm(HttpServletRequest request,
		@RequestParam("username")String username,
		@RequestParam("password")String password) {
			User user = userRepository.findByUsernameAndPassword(username, password);
			
			if(user != null){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				return "redirect:/main";
			}else {
				return "redirect:/loginForm";
			}
	}
	
	@RequestMapping("/Board")
	public String Board(HttpServletRequest request,
			@RequestParam("title")String title, 
		@RequestParam("content")String content) {
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
			
			User user = User.builder().username(username).build();
			Board board = Board.builder()
					.title(title)
					.content(content)
					.username(user)
					.build();
			
			boardRepository.save(board);
			
			return "redirect:/main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
}
