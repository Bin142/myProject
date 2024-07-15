package com.binhle.todoList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
	@GetMapping("")
	public String showHomePage() {
		return "index";
	}
}
