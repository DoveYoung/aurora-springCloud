package com.aurora.consumer.admin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Title: Menu.java 
 * @Package com.aurora.consumer.admin.entity 
 * @Description: 菜单实体类
 * @author SSY  
 * @date 2018年4月11日 下午2:43:47 
 * @version V1.0
 */
public class Menu extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1392964201176571362L;
	
	/**
	 * 菜单id
	 */
	private Integer menuID;		

	/**
	 * 菜单名称
	 */
	private String menuName;	

	/**
	 * 菜单路径
	 */
	private String menuURL;		

	/**
	 * 上级菜单id
	 */
	private Integer menuParentID;	

	/**
	 * 菜单编号
	 */
	private Integer menuOrder;	

	/**
	 * 菜单等级
	 */
	private Integer menuLevel;		

	/**
	 * 菜单状态
	 */
	private Integer menuState;
	
	/**
	 * 父级菜单
	 */
	private Menu parentMenu;	

	/**
	 * 子菜单
	 */
	private List<Menu> subMenu;

	/**
	 * 获取: menuID
	 * @return the menuID
	 */
	public Integer getMenuID() {
		return menuID;
	}

	/**
	 * 设置: menuID
	 * @param menuID the menuID to set
	 */
	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}

	/**
	 * 获取: menuName
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * 设置: menuName
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * 获取: menuURL
	 * @return the menuURL
	 */
	public String getMenuURL() {
		return menuURL;
	}

	/**
	 * 设置: menuURL
	 * @param menuURL the menuURL to set
	 */
	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	/**
	 * 获取: menuParentID
	 * @return the menuParentID
	 */
	public Integer getMenuParentID() {
		return menuParentID;
	}

	/**
	 * 设置: menuParentID
	 * @param menuParentID the menuParentID to set
	 */
	public void setMenuParentID(Integer menuParentID) {
		this.menuParentID = menuParentID;
	}

	/**
	 * 获取: menuOrder
	 * @return the menuOrder
	 */
	public Integer getMenuOrder() {
		return menuOrder;
	}

	/**
	 * 设置: menuOrder
	 * @param menuOrder the menuOrder to set
	 */
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	/**
	 * 获取: menuLevel
	 * @return the menuLevel
	 */
	public Integer getMenuLevel() {
		return menuLevel;
	}

	/**
	 * 设置: menuLevel
	 * @param menuLevel the menuLevel to set
	 */
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	/**
	 * 获取: menuState
	 * @return the menuState
	 */
	public Integer getMenuState() {
		return menuState;
	}

	/**
	 * 设置: menuState
	 * @param menuState the menuState to set
	 */
	public void setMenuState(Integer menuState) {
		this.menuState = menuState;
	}

	/**
	 * 获取: parentMenu
	 * @return the parentMenu
	 */
	public Menu getParentMenu() {
		return parentMenu;
	}

	/**
	 * 设置: parentMenu
	 * @param parentMenu the parentMenu to set
	 */
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	/**
	 * 获取: subMenu
	 * @return the subMenu
	 */
	public List<Menu> getSubMenu() {
		return subMenu;
	}

	/**
	 * 设置: subMenu
	 * @param subMenu the subMenu to set
	 */
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", menuName=" + menuName + ", menuURL=" + menuURL + ", menuParentID="
				+ menuParentID + ", menuOrder=" + menuOrder + ", menuLevel=" + menuLevel + ", menuState=" + menuState
				+ ", parentMenu=" + parentMenu + ", subMenu=" + subMenu + "]";
	} 
	
}
