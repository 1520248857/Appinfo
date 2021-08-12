package cn.kgc.ssm.appsys.service.impl;

import javax.annotation.Resource;
import cn.kgc.ssm.appsys.mapper.BackendUserMapper;
import cn.kgc.ssm.appsys.pojo.BackendUser;
import cn.kgc.ssm.appsys.service.BackendUserService;
import org.springframework.stereotype.Service;

@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	private BackendUserMapper backendUserMapper;
	
	@Override
	public BackendUser login(String userCode, String userPassword)  {
		// TODO Auto-generated method stub
		BackendUser user = backendUserMapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

}
