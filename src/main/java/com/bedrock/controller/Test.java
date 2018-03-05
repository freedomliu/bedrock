package com.bedrock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test
{
	@RequestMapping("/login.do")
	public ModelAndView test1(HttpServletRequest request,ModelAndView mv)
	{
		request.setAttribute("test", "11111111111111111111111");
		mv.addObject("test", "11111111111111111111111");
		mv.setViewName("NewFile");
		return mv;
	}
}
