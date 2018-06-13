/**
 * 
 */
package com.aurora.provider.user.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.aurora.provider.user.entity.Menu;
import com.aurora.provider.user.util.Page;

/**
 * @Title: MenuReadMapper.java 
 * @Package com.aurora.provider.user.mapper 
 * @Description: 菜单
 * @author SSY  
 * @date 2018年4月12日 下午8:05:18 
 * @version V1.0
 */
public interface MenuReadMapper {

	/**@Title: getMenu
	 * @Description: 根据菜单id查询菜单
	 * @param    
	 * @return Menu 
	 * @author SSY
	 * @date 2018年4月13日 下午4:11:13 
	 */
	@Select("SELECT * FROM admin_menu WHERE menu_id = #{menuID}")     
	@Results(id = "menu",value = {
		       @Result(property = "menuID",  column = "menu_id"),
		       @Result(property = "menuName", column = "menu_name"),
		       @Result(property = "menuURL", column = "menu_url"),
		       @Result(property = "menuParentID",  column = "menu_parent_id"),
		       @Result(property = "menuOrder", column = "menu_order"),
		       @Result(property = "menuLevel",  column = "menu_level"),
		       @Result(property = "menu_state", column = "menuState")
		    })   
	Menu getMenu(Integer menuID);
	
	/**@Title: getMenuUrl 
	 * @Description: 批量查询菜单url;
	 * @param     
	 * @return Set<String>  
	 * @author SSY
	 * @date 2018年4月13日 下午4:11:13 
	 */
	@Select("<script>SELECT menu_url FROM admin_menu WHERE menu_id IN "
			+ "<foreach collection='collection' item='id' open='(' separator=',' close=')'>"
			+ "#{id}</foreach></script>")     
	Set<String> getMenuUrl(Set<String> userMenuID);

	/**@Title: getMenuList 
	 * @Description: 根据菜单id查询一级菜单列表 
	 * @param    
	 * @return void  
	 * @author SSY
	 * @date 2018年4月16日 下午6:16:09 
	 */
	@Select("<script>SELECT * FROM admin_menu WHERE menu_state = 1 AND menu_id IN"
			+ "<foreach collection='collection' item='id' open='(' separator=',' close=')'>"
			+ "#{id}</foreach>"
			+ "AND menu_level = ${@com.aurora.provider.user.util.Const@MENU_LEVEL_FIRST}</script>")     
	@ResultMap(value = "menu")
	List<Menu> getFirstMenuList(Set<String> userMenuID);
	 
	/**@Title: getMenuList 
	 * @Description: 查询一级菜单列表 
	 * @param    
	 * @return void  
	 * @author SSY
	 * @date 2018年4月16日 下午6:16:09 
	 */
	@Select("<script>SELECT * FROM admin_menu WHERE menu_state = 1 AND "
			+ "menu_level = ${@com.aurora.provider.user.util.Const@MENU_LEVEL_FIRST}</script>")     
	@ResultMap(value = "menu")
	List<Menu> getNoParamFirstMenuList();
	
	/**@Title: getMenuList 
	 * @Description: 根据菜单id查询二级菜单列表 
	 * @param    
	 * @return void  
	 * @author SSY
	 * @date 2018年4月16日 下午6:16:09 
	 */
	@Select("<script>SELECT * FROM admin_menu WHERE menu_state = 1 AND menu_id IN"
			+ "<foreach collection='collection' item='id' open='(' separator=',' close=')'>"
			+ "#{id}</foreach>"
			+ "AND menu_level = ${@com.aurora.provider.user.util.Const@MENU_LEVEL_SECOND}</script>")     
	@ResultMap(value = "menu")
	List<Menu> getSecondMenuList(Set<String> userMenuID);
	
	/**@Title: getMenuList 
	 * @Description: 查询二级菜单列表 
	 * @param    
	 * @return void  
	 * @author SSY
	 * @date 2018年4月16日 下午6:16:09 
	 */
	@Select("<script>SELECT * FROM admin_menu WHERE menu_state = 1 AND "
			+ "menu_level = ${@com.aurora.provider.user.util.Const@MENU_LEVEL_SECOND}</script>")     
	@ResultMap(value = "menu")
	List<Menu> getNoParamSecondMenuList();
	
	/**
	 * @Title: getMenuList 
	 * @Description: 查询三级菜单列表 
	 * @param    
	 * @return void  
	 * @author SSY
	 * @date 2018年4月16日 下午6:16:09 
	 */
	@Select("<script>SELECT * FROM admin_menu WHERE menu_state = 1 AND "
			+ "menu_level = ${@com.aurora.provider.user.util.Const@MENU_LEVEL_THIRD}</script>")     
	@ResultMap(value = "menu")
	List<Menu> getNoParamThirdMenuList();
	
	/**
	 * @Title: getMenuNum 
	 * @Description: 分页条件查询菜单数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午5:12:48 
	 */
	@Select("<script>SELECT count(menu_id) FROM admin_menu "
			+ "<if test='pd.menuName!=null'>WHERE menu_name LIKE CONCAT ('%',#{pd.menuName},'%') </if>"
			+ "<if test='pd.menuLevel!=null'>WHERE menu_level = #{pd.menuLevel} </if> </script>") 
	int getMenuNum(Page page);

	/**
	 * @Title: getMenuList 
	 * @Description: 分页查询菜单列表;
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:13:01 
	 */
	@Select("<script>SELECT * FROM admin_menu "
			+ "<if test='pd.menuName!=null'>WHERE menu_name LIKE CONCAT ('%',#{pd.menuName},'%') </if>"
			+ "<if test='pd.menuLevel!=null'>WHERE menu_level = #{pd.menuLevel} </if>"
			+ "ORDER BY menu_id ASC "
			+ "LIMIT #{fromIndex}, #{pageSize}</script>") 
	@ResultMap(value="menu")
	List<Menu> getMenuList(Page page);

	/**
	 * @Title: getMenuByID 
	 * @Description: TODO 
	 * @param    
	 * @return Menu  
	 * @author SSY
	 * @date 2018年4月17日 下午6:26:46 
	 */
	@Select("<script>SELECT * FROM admin_menu WHERE menu_id = #{menuID}</script>") 
	@ResultMap(value="menu")
	Menu getMenuByID(Integer menuID);


	 
	
	
	
	
	
	
	
	
	
}
