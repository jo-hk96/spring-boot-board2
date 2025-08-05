package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.menus.domain.MenuDTO;
import com.board.menus.mapper.MenuMapper;

@Controller
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;

	@RequestMapping("/Menus/List")
	public String list() {
		
		List<MenuDTO> menuList = menuMapper.getMenuList();
		System.out.println(menuList);
		return "menus/list";
	}
	
	@RequestMapping("/Menus/WriteForm")
	public String writeForm() {
		return"menus/write";
		
	}
	
	@RequestMapping("/Menus/Write")
	public String write(MenuDTO menuDTO) {

		menuMapper.insertMenu(menuDTO);
		return "menus/list";
		
	}
	
	
	
	
	
}
