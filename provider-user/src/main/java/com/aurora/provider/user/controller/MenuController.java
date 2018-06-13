/**
 * 
 */
package com.aurora.provider.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurora.provider.user.entity.Menu;
import com.aurora.provider.user.service.RoleService;
import com.aurora.provider.user.util.Page;

/**
 * @Title: UserController.java 
 * @Package com.aurora.provider.user.controller 
 * @Description: 用户管理
 * @author SSY  
 * @date 2018年4月12日 上午11:37:53 
 * @version V1.0
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController extends BaseController{


	/**@Title: getMenuList 
	 * @Description: 分页查询菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午4:53:40 
	 */
	@RequestMapping(value = "/getMenuList")
	List<Menu> getMenuList(@RequestBody Page page) {
		return menuService.getMenuList(page);
	}

	/**@Title: getMenuNum 
	 * @Description: 分页查询菜单数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:58:14 
	 */
	@RequestMapping(value = "/getMenuNum")
	int getMenuNum(@RequestBody Page page) {
		return menuService.getMenuNum(page);
	}
 

	/**
	 * @Title: getSecondMenuList 
	 * @Description: 查询所有二级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:48:20 
	 */
	@RequestMapping(value = "/getSecondMenuList")
	List<Menu> getSecondMenuList(){
		return menuService.getNoParamSecondMenuList();
	}

	/**@Title: getFirstMenuList 
	 * @Description:查询所有一级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:48:27 
	 */
	@RequestMapping(value = "/getFirstMenuList")
	List<Menu> getFirstMenuList(){
		return menuService.getNoParamFirstMenuList();
	}
 
	/**
	 * @Title: saveMenu 
	 * @Description: 新增菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午6:05:44 
	 */
	@RequestMapping(value = "/saveMenu")
	int saveMenu(@RequestBody Menu menu){
		return menuService.saveMenu(menu);
	}
	

	/**@Title: getMenuByID 
	 * @Description: TODO 
	 * @param    
	 * @return Menu  
	 * @author SSY
	 * @date 2018年4月17日 下午6:17:18 
	 */
	@RequestMapping(value = "/getMenuByID")
	Menu getMenuByID(Integer menuID){
		return menuService.getMenuByID(menuID);
	}
 
	/**@Title: updateMenu 
	 * @Description: 更新菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:19:09 
	 */
	@RequestMapping(value = "/updateMenu")
	int updateMenu(@RequestBody Menu menu){
		return menuService.updateMenu(menu);
	}
	
	/**@Title: deleteMenu 
	 * @Description:批量删除菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:28:58 
	 */
	@RequestMapping(value = "/deleteMenu")
	int deleteMenu(String menuIDs){
		return menuService.deleteMenu(menuIDs);
	}
	
	/**@Title: geAllMenu 
	 * @Description: 查询所有的菜单集合
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月18日 上午9:49:34 
	 */
	@RequestMapping(value = "/geAllMenu")
	List<Menu> getAllMenu(){
		return menuService.getAllMenu();
	}
	
	
	
	
}
