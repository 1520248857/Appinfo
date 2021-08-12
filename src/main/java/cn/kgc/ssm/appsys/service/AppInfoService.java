package cn.kgc.ssm.appsys.service;

import cn.kgc.ssm.appsys.pojo.AppInfo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
public interface AppInfoService {
	public PageInfo<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus,
											Integer queryCategoryLevel1, Integer queryCategoryLevel2,
											Integer queryCategoryLevel3, Integer queryFlatformId,
											Integer devId, Integer pageNum, Integer pageSize);

	AppInfo getAppInfo( Integer id,String APKName);

	public int updateSatus(@Param(value = "status") Integer status, @Param(value = "id") Integer id);
}
