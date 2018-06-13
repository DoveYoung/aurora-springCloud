//package com.aurora.consumer.admin.config;  
//  
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener; 
//
///**
// * session监听,统计网站访客ip和时间
// * @author SSY 2017-11-14
// *
// */
//public class MySessionListener implements HttpSessionListener {
//	
////	@Resource(name = "statisticsServiceImpl")
////	StatisticsService statisticsServiceImpl;
//	/* Session创建事件 */  
//	public void sessionCreated(HttpSessionEvent se) {
////		HttpSession session = se.getSession();
////		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
////		StatisticsServiceImpl statisticsServiceImpl = (StatisticsServiceImpl)ac.getBean("statisticsServiceImpl");
//		 
//	}
//	
//	/* Session失效事件  ———— 用户直接关闭浏览器后状态不改变，通过session失效事件改变用户状态*/
//	public void sessionDestroyed(HttpSessionEvent se) {
////		HttpSession session = se.getSession();
////		Object customerID = session.getAttribute("customerID");
////		PageData pd = new PageData();
////		pd.put("customerID", customerID);
////		pd.put("customerStatus", 3);			//1.新注册未登陆；2在线；3离线；4禁用
//////		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
////		CustomerService customerServiceImpl = (CustomerService) MyBeanUtil.getBean("customerServiceImpl");
////		try {
////			customerServiceImpl.updateCustomerStatus(pd);
////		} catch (Exception e) {
////			e.printStackTrace();
////		} 
//	}
//	
//}  