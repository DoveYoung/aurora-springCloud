/**
 * 
 */
package com.aurora.provider.user.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.aurora.provider.user.entity.Menu;

/**
 * @Title: MenuReadMapper.java 
 * @Package com.aurora.provider.user.mapper 
 * @Description: 菜单
 * @author SSY  
 * @date 2018年4月12日 下午8:05:18 
 * @version V1.0
 */
public interface MenuWriteMapper {
 

	/**@Title: saveMenu 
	 * @Description: 新增菜单
	 * @param     
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午6:11:05 
	 */
	@Insert("INSERT INTO admin_menu (menu_parent_id, menu_order, menu_name, menu_url, menu_level,menu_state)"
			+ " VALUES (#{menuParentID},#{menuOrder},#{menuName},#{menuURL},#{menuLevel},#{menuState})")
	int saveMenu(Menu menu);

	/**@Title: updateMenu 
	 * @Description: 修改更新菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:22:37 
	 */
	@Update("<script>UPDATE admin_menu SET menu_name = #{menuName}, menu_parent_id = #{menuParentID}, menu_order = #{menuOrder}, menu_url = #{menuURL},menu_level = #{menuLevel}, menu_state = #{menuState}"
			+ " WHERE menu_id = #{menuID}</script>")
	int updateMenu(Menu menu);

	/**@Title: deleteMenu 
	 * @Description:批量删除菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:32:39 
	 */
	@Delete("<script>DELETE FROM admin_menu WHERE menu_id IN <foreach collection='array' item='menuID' open='(' separator=',' close=')'>"
			+ "#{menuID}</foreach></script>")
	int deleteMenu(String[] menuIDArray);
	 
	
	
}
