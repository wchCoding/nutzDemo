package com.wch.nutz;

import java.util.Date;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.Setup;

import com.wch.nutz.bean.User;
/**
 * 整个应用启动以及关闭的时候需要做的额外逻辑
 * 
 * @author zozoh(zozohtnt@gmail.com)
 */
public class MainSetup implements Setup {


	@Override
	public void destroy(org.nutz.mvc.NutConfig conf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(org.nutz.mvc.NutConfig conf) {

		 	Ioc ioc = conf.getIoc();
	        Dao dao = ioc.get(Dao.class);
	        Daos.createTablesInPackage(dao, "com.wch.nutz", false);
	        
	        // 初始化默认根用户
	        if (dao.count(User.class) == 0) {
	            User user = new User();
	            user.setName("admin");
	            user.setPassword("123456");
	            user.setCreateTime(new Date());
	            user.setUpdateTime(new Date());
	            dao.insert(user);
	        }
	}

}
