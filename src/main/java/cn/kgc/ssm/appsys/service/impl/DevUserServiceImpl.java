package cn.kgc.ssm.appsys.service.impl;

import javax.annotation.Resource;

import cn.kgc.ssm.appsys.mapper.DevUserMapper;
import cn.kgc.ssm.appsys.pojo.DevUser;
import cn.kgc.ssm.appsys.service.DevUserService;
import org.springframework.stereotype.Service;



@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;
	@Override
	public DevUser login(String devCode, String devPassword)  {

		DevUser user = mapper.getLoginUser(devCode);
		//匹配密码
		if(null != user){
			if(!user.getDevPassword().equals(devPassword))
				user = null;
		}
		return user;
	}

}
