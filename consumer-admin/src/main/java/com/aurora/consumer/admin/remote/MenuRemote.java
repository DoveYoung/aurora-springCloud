package com.aurora.consumer.admin.remote;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aurora.consumer.admin.entity.Menu;
import com.aurora.consumer.admin.entity.Page;

/**
 * @FeignClient(name= "zuul")对应spring:application:name: zuul
 * 通过网关统一访问
 */
@FeignClient(name= "server-zuul1", fallback=MenuRemoteHystrix.class)
public interface MenuRemote {

	/**@Title: getMenuList 
	 * @Description: 分页查询菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午4:53:40 
	 */
	@RequestMapping(value = "/provider-user/menu/getMenuList")
	List<Menu> getMenuList(@RequestBody Page page);

	/**@Title: getMenuNum 
	 * @Description: 分页查询菜单数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:58:14 
	 */
	@RequestMapping(value = "/provider-user/menu/getMenuNum")
	int getMenuNum(@RequestBody Page page);

	/**
	 * @Title: getSecondMenuList 
	 * @Description: 查询所有二级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:48:20 
	 */
	@RequestMapping(value = "/provider-user/menu/getSecondMenuList")
	List<Menu> getSecondMenuList();

	/**@Title: getFirstMenuList 
	 * @Description:查询所有一级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:48:27 
	 */
	@RequestMapping(value = "/provider-user/menu/getFirstMenuList")
	List<Menu> getFirstMenuList();

	/**
	 * @Title: saveMenu 
	 * @Description: 新增菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午6:05:44 
	 */
	@RequestMapping(value = "/provider-user/menu/saveMenu")
	int saveMenu(@RequestBody Menu menu);

	/**@Title: getMenuByID 
	 * @Description: TODO 
	 * @param    
	 * @return Menu  
	 * @author SSY
	 * @date 2018年4月17日 下午6:17:18 
	 */
	@RequestMapping(value = "/provider-user/menu/getMenuByID")
	Menu getMenuByID(@RequestParam(value = "menuID") Integer menuID);

	/**@Title: updateMenu 
	 * @Description: 更新菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:19:09 
	 */
	@RequestMapping(value = "/provider-user/menu/updateMenu")
	int updateMenu(@RequestBody Menu menu);

	/**@Title: deleteMenu 
	 * @Description:批量删除菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:28:58 
	 */
	@RequestMapping(value = "/provider-user/menu/deleteMenu")
	int deleteMenu(@RequestParam(value = "menuIDs") String menuIDs);

	/**@Title: geAllMenu 
	 * @Description: 查询所有的菜单集合
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月18日 上午9:49:34 
	 */
	@RequestMapping(value = "/provider-user/menu/geAllMenu")
	List<Menu> getAllMenu();
 
	
     
	
	
	
    
}
