package com.aurora.consumer.admin.remote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aurora.consumer.admin.entity.Menu;
import com.aurora.consumer.admin.entity.Page;

/**
 * 创建RemoteHystrix类继承与Remote实现回调的方法
 */
@Component
public class MenuRemoteHystrix implements MenuRemote{
 
	/**@Title: getMenuList 
	 * @Description: 分页查询菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午4:53:40 
	 */
	@Override
	public List<Menu> getMenuList(Page page){
		List<Menu> menuList = new ArrayList<>();
		return menuList;
	} 
 

	/**@Title: getMenuNum 
	 * @Description: 分页查询菜单数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:58:14 
	 */
	@Override
	public int getMenuNum(Page page) {
		return 0;
	}
 
	/**
	 * @Title: getSecondMenuList 
	 * @Description: 查询所有二级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:48:20 
	 */
	@Override
	public List<Menu> getSecondMenuList(){
		List<Menu> menuList = new ArrayList<>();
		return menuList;
	} 

	/**@Title: getFirstMenuList 
	 * @Description:查询所有一级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:48:27 
	 */
	@Override
	public List<Menu> getFirstMenuList(){
		List<Menu> menuList = new ArrayList<>();
		return menuList;
	} 
 
	/**
	 * @Title: saveMenu 
	 * @Description: 新增菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午6:05:44 
	 */
	@Override
	public int saveMenu(Menu menu) {
		return 0;
	}
	
	/**@Title: getMenuByID 
	 * @Description: TODO 
	 * @param    
	 * @return Menu  
	 * @author SSY
	 * @date 2018年4月17日 下午6:17:18 
	 */
	@Override
	public Menu getMenuByID(Integer menuID){
		Menu menu = new Menu();
		menu.setFallBack(Boolean.TRUE);
		return menu;
	}
	
	/**
	 * @Title: updateMenu 
	 * @Description: 更新菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:19:09 
	 */
	@Override
	public int updateMenu(Menu menu){
		return 0;
	}
	
	/**@Title: deleteMenu 
	 * @Description:批量删除菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:28:58 
	 */
	@Override
	public int deleteMenu(String menuIDs){
		return 0;
	}
	
	/**@Title: geAllMenu 
	 * @Description: 查询所有的菜单集合
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月18日 上午9:49:34 
	 */
	@Override
	public List<Menu> getAllMenu(){
		List<Menu> allMenu = new ArrayList<>();
		return allMenu;
	}
	
}
