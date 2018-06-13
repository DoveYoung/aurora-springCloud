package com.aurora.provider.user.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurora.provider.user.entity.Menu;
import com.aurora.provider.user.util.Page;

/**
 * @Title: MenuService.java 
 * @Package com.aurora.provider.user.service 
 * @Description: MenuService
 * @author SSY  
 * @date 2018年4月17日 下午5:01:48 
 * @version V1.0
 */
public interface MenuService {


	/**@Title: getMenuList 
	 * @Description: 分页查询菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午4:53:40 
	 */
	List<Menu> getMenuList(Page page);

	/**@Title: getMenuNum 
	 * @Description: 分页查询菜单数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:58:14 
	 */
	int getMenuNum(Page page);

	/**@Title: getSecondMenuList 
	 * @Description: 查询所有二级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:52:46 
	 */
	List<Menu> getNoParamSecondMenuList();
 
	/**@Title: getFirstMenuList 
	 * @Description: 查询所有一级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:52:46 
	 */
	List<Menu> getNoParamFirstMenuList();

	/**@Title: saveMenu 
	 * @Description: 新增菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午6:10:13 
	 */
	int saveMenu(Menu menu);

	/**@Title: getMenuByID 
	 * @Description: TODO 
	 * @param    
	 * @return Menu  
	 * @author SSY
	 * @date 2018年4月17日 下午6:26:04 
	 */
	Menu getMenuByID(Integer menuID);

	/**@Title: updateMenu 
	 * @Description: 修改更新菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:21:44 
	 */
	int updateMenu(Menu menu);

	/**@Title: deleteMenu 
	 * @Description:批量删除菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:28:58 
	 */
	int deleteMenu(String menuIDs);

	/**@Title: getAllMenu 
	 * @Description:查询所有菜单集合
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月18日 上午9:52:34 
	 */
	List<Menu> getAllMenu();

	/**@Title: getThirdMenuList 
	 * @Description: 查询所有三级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:52:46 
	 */
	public List<Menu> getNoParamThirdMenuList();
}
