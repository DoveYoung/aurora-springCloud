package com.aurora.consumer.admin.controller.system;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.aurora.consumer.admin.controller.base.BaseController;
import com.aurora.consumer.admin.entity.Menu;
import com.aurora.consumer.admin.entity.Page;
import com.aurora.consumer.admin.entity.Result;
import com.aurora.consumer.admin.entity.Role;
import com.aurora.consumer.admin.entity.User;
import com.aurora.consumer.admin.util.Const;
import com.aurora.consumer.admin.util.DateUtil;
import com.aurora.consumer.admin.util.Jurisdiction;
import com.aurora.consumer.admin.util.PageData;
import com.aurora.consumer.admin.util.Tools;

/**
 * @Title: RoleController.java 
 * @Package com.aurora.consumer.admin.controller.system 
 * @Description: 角色列表
 * @author SSY  
 * @date 2018年4月16日 下午1:35:32 
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/systemRole")
public class RoleController extends BaseController{
	
	/**
	 * @Title: getRoleList 
	 * @Description: 获取角色列表; 
	 * @param    Page page, String roleName
	 * @return    page, pd(回显), roleList, allMenu,(全部菜单集合,用于角色回显新增时使用)
	 * @author SSY
	 * @date 2018年4月16日 下午1:40:43
	 */
	@RequestMapping(value = "/getRoleList")
	public String getRoleList(ModelMap map, Page page, String roleName)throws Exception{
		PageData pd = new PageData();
		pd.put("roleName",Tools.notEmpty(roleName)?roleName.replace(" ", ""):null);
		page.setPd(pd);
		try {
			page.setFromIndex(0);
			page.setPageSize(10); 
			List<Menu> allMenu = menuRemote.getAllMenu(); 					//查询所有菜单集合
			List<Role> roleList = roleRemote.getRoleList(page);	//列出角色列表
			int totalRecord = roleRemote.getRoleNum(page);
			page.setTotalRecord(totalRecord);
			map.put("allMenu", JSON.toJSON(allMenu));
			map.put("roleList", JSON.toJSON(roleList));
			map.put("page", JSON.toJSON(page));
		} catch (Exception e) {
			logger.info("【ERROR："+DateUtil.getTime()+"条件查询角色列表系统异常！】");
			throw new Exception("查询角色列表执行异常");
		}
		map.put("pd", JSON.toJSON(pd));
		return "admin/manager/roleList";
	}
	
//	/**
//	 * @Title: addRolePage 
//	 * @Description: 新增角色页面
//	 * @param    String roleName,String roleRights, String roleRemark 
//	 * @return Result<Object>  
//	 * @author SSY
//	 * @date 2018年4月17日 下午8:22:28
//	 */
//	@RequestMapping(value="/addRolePage",produces="application/json;charset=UTF-8")
//	@ResponseBody
// 	public Result<List<Menu>> addRolePage() throws Exception {
//		Result<List<Menu>> result = new Result<List<Menu>>();
//		try {
//			List<Menu> allMenu = menuRemote.getAllMenu(); 					//查询所有菜单集合
//			result.setResult(allMenu);
//			result.setState(Result.STATE_SUCCESS);
//		} catch (Exception e) {
//			e.printStackTrace();
//			result.setMsg("系统异常! ");
//			result.setState(Result.STATE_ERROR);
//			logger.info("【ERROR："+DateUtil.getTime()+"菜单集合查询系统执行异常！】");
//		}
//		return result;
//	}
	
	
	 
	
	/**
	 * @Title: saveNewRole 
	 * @Description: 新增保存角色
	 * @param    String roleName,String roleRights, String roleRemark 
	 * @return Result<Object>  
	 * @author SSY
	 * @date 2018年4月17日 下午8:22:28
	 */
	@RequestMapping(value="/saveNewRole",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> saveNewRole(String roleName,String roleRights, String roleRemark ) throws Exception {
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(roleName)||Tools.isEmpty(roleRights)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		Role role = new Role();
		role.setRoleName(roleName.replace(" ", ""));
		role.setRoleRights(roleRights.replace(" ", ""));
		role.setRoleRemark(roleRemark);
		role.setCreateTime(DateUtil.getTime());
		role.setCreator(Jurisdiction.getUser().getUserEmail());
		try {
			int addNum = roleRemote.saveRole(role); 					//执行保存
			result.setState(addNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
			result.setMsg(addNum>=1?"操作成功! ":"操作失败!系统异常!");
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"新增角色系统执行异常！】");
		}
		return result;
	}
	
	
	/**
	 * @Title: getRole 
	 * @Description: 查看角色
	 * @param    String userEmail
	 * @return Result<String[]>   roleMenuIDs (该角色拥有的菜单id数组)
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/getRole",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<String[]> getRole(Integer roleID) throws Exception {
		
		Result<String[]> result = new Result<String[]>();
		if (null == roleID) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			Role role = roleRemote.getRoleByID(roleID);
			String roleRights = role.getRoleRights();
			String[] roleMenuIDs = roleRights.split(",");
			result.setResult(roleMenuIDs);
			result.setState(Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"角色查询系统执行异常！】");
		}
		return result;
	}
	
	/**
	 * @Title: updateRole 
	 * @Description: 修改更新角色
	 * @param     Integer roleID, String roleName,String roleRights, String roleRemark
	 * @return Result<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/updateRole",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> updateRole(Integer roleID, String roleName,String roleRights, String roleRemark) throws Exception {
		Result<Object> result = new Result<Object>();
		if (null == roleID||Tools.isEmpty(roleName)||Tools.isEmpty(roleRights)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		Role role = new Role();
		role.setRoleID(roleID);
		role.setRoleName(roleName.replace(" ", ""));
		role.setRoleRights(roleRights.replace(" ", ""));
		role.setRoleRemark(roleRemark.replace(" ", ""));
		role.setUpdateTime(DateUtil.getTime());
		role.setUpdator(Jurisdiction.getUser().getUserEmail());
		try {
			int updateNum = roleRemote.updateRole(role);
			result.setMsg(updateNum>=1?"操作成功!":"操作失败!");
			result.setState(updateNum>=1?Result.STATE_SUCCESS:Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"更新角色系统执行异常！】");
		}
		return result;
	}
	
	/**
	 * @Title: deleteRole 
	 * @Description: 批量删除角色
	 * @param    String roleIDs(逗号拼接)
	 * @return Result<User>  
	 * @author SSY
	 * @date 2018年4月16日 下午8:22:28
	 */
	@RequestMapping(value="/deleteRole",produces="application/json;charset=UTF-8")
	@ResponseBody
 	public Result<Object> deleteRole(String roleIDs) throws Exception {
		
		Result<Object> result = new Result<Object>();
		if (Tools.isEmpty(roleIDs)) {
			result.setMsg("参数错误!");
			result.setState(Result.STATE_ERROR);
			return result;
		}
		try {
			int deleteNum = roleRemote.deleteRole(roleIDs);//支持批量删除
			result.setMsg(deleteNum>=1 ? "操作成功！ ": "操作失败！ ");
			result.setState(deleteNum>=1 ? Result.STATE_SUCCESS : Result.STATE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg("系统异常! ");
			result.setState(Result.STATE_ERROR);
			logger.info("【ERROR："+DateUtil.getTime()+"删除角色系统执行异常！】");
		}
		return result;
	}
	
	
	
	
}
