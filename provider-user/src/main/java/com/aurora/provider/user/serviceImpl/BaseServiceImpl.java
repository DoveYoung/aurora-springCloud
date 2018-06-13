/**
 * 
 */
package com.aurora.provider.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurora.provider.user.mapper.MenuReadMapper;
import com.aurora.provider.user.mapper.MenuWriteMapper;
import com.aurora.provider.user.mapper.RoleReadMapper;
import com.aurora.provider.user.mapper.RoleWriteMapper;
import com.aurora.provider.user.mapper.UserReadMapper;
import com.aurora.provider.user.mapper.UserWriteMapper;

/**管理用户接口实现类
 * @author BYG 2018.4.2
 * @version 1.0
 */
@Service
@Transactional
public class BaseServiceImpl{
	@Autowired
	protected UserReadMapper userReadMapper;
	@Autowired
	protected UserWriteMapper userWriteMapper;
	@Autowired
	protected RoleReadMapper roleReadMapper;
	@Autowired
	protected RoleWriteMapper roleWriteMapper;
	@Autowired
	protected MenuReadMapper menuReadMapper;
	@Autowired
	protected MenuWriteMapper menuWriteMapper;
}
