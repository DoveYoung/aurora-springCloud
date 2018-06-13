/**
 * 
 */
package com.aurora.provider.user.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurora.provider.user.entity.Menu;
import com.aurora.provider.user.service.MenuService;
import com.aurora.provider.user.util.Page;

/**
 * @Title: MenuServiceImpl.java 
 * @Package com.aurora.provider.user.serviceImpl 
 * @Description: 菜单service
 * @author SSY  
 * @date 2018年4月17日 下午5:02:31 
 * @version V1.0
 */
@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl implements MenuService{
	/**@Title: getMenuList 
	 * @Description: 分页查询菜单列表
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午4:53:40 
	 */
	@Override
	public List<Menu> getMenuList(Page page){
		return menuReadMapper.getMenuList(page);
	}

	
	
	/**@Title: getMenuNum 
	 * @Description: 分页查询菜单数量
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午4:58:14 
	 */
	@Override
	public int getMenuNum(Page page){
		
		return menuReadMapper.getMenuNum(page);
	}
	 
	/**@Title: getThirdMenuList 
	 * @Description: 查询所有三级级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:52:46 
	 */
	@Override
	public List<Menu> getNoParamThirdMenuList() {
		return menuReadMapper.getNoParamThirdMenuList();
	}
	
	/**@Title: getSecondMenuList 
	 * @Description: 查询所有二级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:52:46 
	 */
	@Override
	public List<Menu> getNoParamSecondMenuList() {
		return menuReadMapper.getNoParamSecondMenuList();
	}
 
	/**@Title: getFirstMenuList 
	 * @Description: 查询所有一级菜单
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月17日 下午5:52:46 
	 */
	@Override
	public List<Menu> getNoParamFirstMenuList() {
		return menuReadMapper.getNoParamFirstMenuList();
	}
	
	/**@Title: getAllMenu 
	 * @Description:查询所有菜单集合
	 * @param    
	 * @return List<Menu>  
	 * @author SSY
	 * @date 2018年4月18日 上午9:52:34 
	 */
	public List<Menu> getAllMenu(){
		List<Menu> firstMenuList = this.getNoParamFirstMenuList();
		List<Menu> secondMenuList = this.getNoParamSecondMenuList();
		List<Menu> thirdMenuList = this.getNoParamThirdMenuList();
		for (Iterator iterator = firstMenuList.iterator(); iterator.hasNext();) {
			Menu menuFirst = (Menu) iterator.next();
			List<Menu> subMenuFirst = new ArrayList<Menu>(15);//二级菜单
			int firstMenuID = menuFirst.getMenuID();
			for (Iterator iterator2 = secondMenuList.iterator(); iterator2.hasNext();) {
				Menu menuSecond = (Menu) iterator2.next();
				if (firstMenuID!=menuSecond.getMenuParentID().intValue()) {
					continue;
				} 
				int secondMenuID = menuSecond.getMenuID();
				List<Menu> subMenuSecond = new ArrayList<Menu>(15);//三级菜单
				for (Iterator iterator3 = thirdMenuList.iterator(); iterator3.hasNext();) {
					Menu menuThird = (Menu) iterator3.next();
					if (secondMenuID==menuThird.getMenuParentID().intValue()) {
						subMenuSecond.add(menuThird);
					}
				}
				menuSecond.setSubMenu(subMenuSecond);
				subMenuFirst.add(menuSecond);
			}
			menuFirst.setSubMenu(subMenuFirst);
		}
		return firstMenuList;
	}
	
	
	
	
	
	
	/**@Title: saveMenu 
	 * @Description: 新增菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月17日 下午6:10:13 
	 */
	@Override
	public int saveMenu(Menu menu){
		return menuWriteMapper.saveMenu(menu);
	}
	

	/**@Title: getMenuByID 
	 * @Description: TODO 
	 * @param    
	 * @return Menu  
	 * @author SSY
	 * @date 2018年4月17日 下午6:26:04 
	 */
	@Override
	public Menu getMenuByID(Integer menuID){
		return menuReadMapper.getMenuByID(menuID);
	}
	
	/**@Title: updateMenu 
	 * @Description: 修改更新菜单
	 * @param    
	 * @return int  
	 * @author SSY
	 * @date 2018年4月18日 上午9:21:44 
	 */
	@Override
	public int updateMenu(Menu menu){
		
		return menuWriteMapper.updateMenu(menu);
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
		String[] menuIDArray = menuIDs.split(",");
		return menuWriteMapper.deleteMenu(menuIDArray);
	}
	

	
	
	
	
	
}
