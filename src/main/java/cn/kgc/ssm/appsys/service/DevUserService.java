package cn.kgc.ssm.appsys.service;

import cn.kgc.ssm.appsys.pojo.DevUser;

public interface DevUserService {
	/**
	 * 用户登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public DevUser login(String devCode, String devPassword);
}
