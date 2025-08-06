package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.menus.domain.MenuDTO;
import com.board.menus.mapper.MenuMapper;

@Controller
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;

	@RequestMapping("/Menus/List")
	public String list(Model model) {
		List<MenuDTO> menuList = menuMapper.getMenuList();
		System.out.println(menuList);
		//                 key(jstl)    value
		model.addAttribute("menuList", menuList);
		return "menus/list";
	}
	
	@RequestMapping("/Menus/WriteForm")
	public String writeForm() {
		return"menus/write";
		
	}
	
	@RequestMapping("/Menus/Write")
	public String write(MenuDTO menuDTO , Model model) {
		menuMapper.insertMenu(menuDTO);
		/*
			List<MenuDTO> menuList = menuMapper.getMenuList(); 
			model.addAttribute("menuList", menuList); // menuList 조회
		*/
		return "redirect:/Menus/List";
	}
	
	//http://localhost:8080/Menus/Delete?menu_id=menu05
	@RequestMapping("Menus/Delete")
	public String Delete(@RequestParam("menu_id") String menu_id) {
	menuMapper.delete(menu_id);
		
	return "redirect:/Menus/List";
	}
	@RequestMapping("Menus/UpdateForm")
	public String UpdateForm() {
		
		return "menus/update";
	}
	@PostMapping("Menus/Update")
	public String Update(MenuDTO menuDTO) {
		
		menuMapper.updateMenu(menuDTO);
		
		
		return "redirect:/Menus/List";
	}
	
	
	
}
	

