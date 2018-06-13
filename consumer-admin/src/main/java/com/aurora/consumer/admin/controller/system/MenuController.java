package com.aurora.consumer.admin.controller.system;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.aurora.consumer.admin.controller.base.BaseController;
import com.aurora.consumer.admin.entity.Menu;
import com.aurora.consumer.admin.entity.Page;
import com.aurora.consumer.admin.entity.Result;
import com.aurora.consumer.admin.util.DateUtil;
import com.aurora.consumer.admin.util.PageData;
import com.aurora.consumer.admin.util.Tools;

/**
 * @Title: MenuController.java 
 * @Package com.aurora.consumer.admin.controller.system 
 * @Description: 菜单列表
 * @author SSY  
 * @date 2018年4月16日 下午1:35:32 
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/systemMenu")
public class MenuController extends BaseController{
	
	/**
	 * @Title: getMenuList 
	 * @Description: 获取菜单列表; 
	 * @param    Page page, Integer menuLevel, String menuName, firstMenuList,secondMenuList(一/二级菜单,修改回显以及新增时候使用)
	 * @return    page, pd(回显), roleList, 
	 * @author SSY
	 * @date 2018年4月16日 下午1:40:43
	 */
	@RequestMapping(value = "/getMenuList")
	public String getMenuList(ModelMap map, Page page, Integer menuLevel, String menuName)throws Exception{
		PageData pd = new PageData();
		pd.put("menuName",Tools.notEmpty(menuName)?menuName.replace(" ", ""):null);
		pd.put("menuLevel",menuLevel);
		page.setPd(pd);
		try {
//			page.setFromIndex(0);
			page.setPageSize(10);
			List<Menu> menuList = menuRemote.getMenuList(page);	//列出菜单列表
			List<Menu> firstMenuList = menuRemote.getFirstMenuList();
			List<Menu> secondMenuList = menuRemote.getSecondMenuList();
			int totalRecord = menuRemote.getMenuNum(page);
			map.put("firstMenuList", firstMenuList);
			map.put("secondMenuList", secondMenuList);
			page.setTotalRecord(totalRecord);
			map.put("menuList", JSON.toJSON(menuList));
			map.put("firstMenuList", JSON.toJSON(firstMenuList));
			map.put("secondMenuList", JSON.toJSON(secondMenuList));
			map.put("page", JSON.toJSON(page));
		} catch (Exception e) {
			logger.info("【ERROR："+DateUtil.getTime()+"条件查询菜单列表系统异常！】");
			throw new Exception("查询菜单列表执行异常");
		}
		map.put("pd", JSON.toJSON(pd));
		return "admin/manager/menuList";
	}
	
//	/**
//	 * @Title: addMenuPage 
//	 * @Description: 新增菜单页--查询一级,二级菜单;
//	 * @param    
//	 * @return Result<Object>  .firstMenuList   ,secondMenuList
//	 * @author SSY
//	 * @date 2018年4月17日 下午8:22:28
//	 */
//	@RequestMapping(value="/addMenuPage",produces="application/json;charset=UTF-8")
//	@ResponseBody
// 	public Result<Object> addMenuPage() throws Exception {
//		Result<Object> result = new Result<Object>();
//		try {
//			List<Menu> firstMenuList = menuRemote.getFirstMenuList();
//			List<Menu> secondMenuList = menuRemote.getSecondMenuList();
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("firstMenuList", firstMenuList);
//			map.put("secondMenuList", secondMenuList);
//			result.setState(Result.STATE_SUCCESS);
//			result.setMsg("操作成功! ");
//			result.setResult(map);
//		} catch (Exception e) {
//			e.printStackTrace();
//			result.setMsg("系统异常! ");
//			result.setState(Result.STATE_ERROR);
//			logger.info("【ERROR："+DateUtil.getTime()+"一二级菜单查询系统执行异常！】");
//		}
//		return result;
//	}
	
	/**
	 * @Title: saveNewMenu 
	 * @Description: 新增新菜单
	 * @param   Integer menuParentID, String menuName, String menuURL, Integer menuOrder, Integer menuLevel, Integer menuState(1可用，4禁用)
	 * @return Result<Object>  
	 * @author SSY
	 * @date 2018年4月17日 下午8:22:28
	 */
	@RequestMapping(value="/saveNewMenu",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> saveNewMenu(Integer menuParentID, String menuName, String menuURL, Integer menuOrder, Integer menuLevel, Integer menuState) throws Exception {
		Result<Object> result = new Result<Object>();
		Menu menu = new Menu();
		menu.setMenuName(menuName.replace(" ", ""));
		menu.setMenuLevel(menuLevel);
		menu.setMenuOrder(menuOrder);
		menu.setMenuParentID(menuParentID);
		menu.setMenuState(menuState);
		menu.setMenuURL(menuURL.replace(" ", ""));
		if (null ==menuParentID||Tools.isEmpty(menuName)||Tools.isEmpty(menuURL)||null ==menuOrder||null==menuLevel||null==menuState) {
			result.setMsg("参数错误! ");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			int addNum = menuRemote.saveMenu(menu); 					//执行保存
			result.setState(addNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
			result.setMsg(addNum>=1?"操作成功! ":"操作失败!系统异常!");
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"新增菜单系统执行异常！】");
		}
		return result;
	}
	
	
	/**
	 * @Title: getMenu
	 * @Description: 查看菜单
	 * @param    
	 * @return Result<Menu>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/getMenu",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Menu> getMenu(Integer menuID) throws Exception {
		
		Result<Menu> result = new Result<Menu>();
		if (null == menuID) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			Menu menu = menuRemote.getMenuByID(menuID);
			result.setResult(menu);
			result.setState(Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"菜单查询系统执行异常！】");
		}
		return result;
	}
	
	/**
	 * @Title: updateMenu 
	 * @Description: 修改更新菜单
	 * @param    Integer menuID, Integer menuParentID, String menuName, String menuURL, Integer menuOrder, Integer menuLevel, Integer menuState
	 * @return Result<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/updateMenu",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> updateMenu(Integer menuID, Integer menuParentID, String menuName, String menuURL, Integer menuOrder, Integer menuLevel, Integer menuState) throws Exception {
		Result<Object> result = new Result<Object>();
	
		if (null==menuID||null ==menuParentID||Tools.isEmpty(menuName)||Tools.isEmpty(menuURL)||null ==menuOrder||null==menuLevel||null==menuState) {
			result.setMsg("参数错误! ");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		Menu menu = new Menu();
		menu.setMenuID(menuID);
		menu.setMenuName(menuName.replace(" ", ""));
		menu.setMenuLevel(menuLevel);
		menu.setMenuOrder(menuOrder);
		menu.setMenuParentID(menuParentID);
		menu.setMenuState(menuState);
		menu.setMenuURL(menuURL.replace(" ", ""));
		try {
			int updateNum = menuRemote.updateMenu(menu);
			result.setMsg(updateNum>=1?"操作成功!":"操作失败!");
			result.setState(updateNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"更新菜单系统执行异常！】");
		}
		return result;
	}
	
	/**
	 * @Title: deleteMenu
	 * @Description: 批量删除菜单
	 * @param    String menuIDs(逗号拼接)
	 * @return Result<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/deleteMenu",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> deleteMenu(String menuIDs) throws Exception {
		
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(menuIDs)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			int deleteNum = menuRemote.deleteMenu(menuIDs);//支持批量删除
			result.setMsg(deleteNum>=1 ? "操作成功！ ": "操作失败！ ");
			result.setState(deleteNum>=1 ? Result.STATE_SUCCESS : Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"删除菜单系统执行异常！】");
		}
		return result;
	}
	
	
	
	
	
	
}
