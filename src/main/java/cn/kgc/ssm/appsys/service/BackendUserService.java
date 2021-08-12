package cn.kgc.ssm.appsys.service;
import cn.kgc.ssm.appsys.pojo.BackendUser;

public interface BackendUserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser login(String userCode, String userPassword);
}
