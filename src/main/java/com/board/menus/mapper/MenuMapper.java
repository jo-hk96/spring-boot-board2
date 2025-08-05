package com.board.menus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.menus.domain.MenuDTO;

@Mapper
public interface MenuMapper {
	void insertMenu(MenuDTO menuDto);
	//void insertMenu(@Param("menu_id") String menu_id,@Param("menu_name") String menu_name , @Param("menu_seq") String menu_seq);

	List<MenuDTO> getMenuList();
	
	

}
