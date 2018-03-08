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
		request.getSession().setAttribute("sessionname1", "lxt---------------->1");
		request.getSession().setAttribute("sessionname2", "lxt---------------->2");

		mv.addObject("helper",new FreemarkerHelper());
		mv.setViewName("NewFile");
		return mv;
	}
	@GetMapping("/index1.html")
	public ModelAndView test1(HttpServletRequest request,ModelAndView mv)
	{
	 	String sessionname= request.getSession().getAttribute("sessionname1")+"";
		String test1= request.getSession().getAttribute("sessionname2")+"";
		System.out.println(sessionname);
		System.out.println(test1);
		mv.addObject("sessionname",sessionname);
		mv.addObject("test1",test1);
		mv.setViewName("NewFile");
		return mv;
	}
	
	@GetMapping("/index2.html")
	public ModelAndView test2(HttpServletRequest request,ModelAndView mv)
	{
		request.getSession().removeAttribute("sessionname");;
		request.getSession().removeAttribute("test1");;
		mv.setViewName("NewFile");
		return mv;
	}
}
