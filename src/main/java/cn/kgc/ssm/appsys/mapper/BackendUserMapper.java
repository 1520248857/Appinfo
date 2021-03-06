package cn.kgc.ssm.appsys.mapper;
import cn.kgc.ssm.appsys.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;


public interface BackendUserMapper {

	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getLoginUser(@Param("userCode") String userCode);

}
