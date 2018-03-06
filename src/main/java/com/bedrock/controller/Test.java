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
	@RequestMapping("/login.do")
	public ModelAndView test1(HttpServletRequest request,ModelAndView mv)
	{
		request.setAttribute("test", "胜多负少的12");
		request.getSession().setAttribute("test1", "11134dfdfdfdfd");
		mv.addObject("test", "对方答复12");
		mv.addObject("helper",new FreemarkerHelper());
		mv.setViewName("NewFile");
		return mv;
	}
}
