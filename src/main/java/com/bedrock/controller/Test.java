package com.bedrock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bedrock.common.FreemarkerHelper;

@Controller
public class Test
{
	@GetMapping("/index.html")
	public ModelAndView test(HttpServletRequest request,ModelAndView mv)
	{
		request.getSession().setAttribute("sessionname", "lxt---------------->");
		request.setAttribute("test", "index0");
		request.getSession().setAttribute("test1", "index0");
		mv.addObject("test", "index0");
		mv.addObject("helper",new FreemarkerHelper());
		mv.setViewName("NewFile");
		return mv;
	}
	@GetMapping("/index1.html")
	public ModelAndView test1(HttpServletRequest request,ModelAndView mv)
	{
		request.setAttribute("test", "index1");
		request.getSession().setAttribute("test1", "index1");
		mv.addObject("test", "index1");
		mv.addObject("helper",new FreemarkerHelper());
		mv.setViewName("NewFile");
		return mv;
	}
}
