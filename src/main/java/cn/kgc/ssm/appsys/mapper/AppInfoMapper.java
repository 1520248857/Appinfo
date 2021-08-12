package cn.kgc.ssm.appsys.mapper;

import java.util.List;

import cn.kgc.ssm.appsys.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

public interface AppInfoMapper {
	AppInfo getAppInfo(@Param("id") Integer id);


	
	public List<AppInfo> getAppInfoList( @Param(value="softwareName")String querySoftwareName,
										 @Param(value="status")Integer queryStatus,
										 @Param(value="categoryLevel1")Integer queryCategoryLevel1,
										 @Param(value="categoryLevel2")Integer queryCategoryLevel2,
										 @Param(value="categoryLevel3")Integer queryCategoryLevel3,
										 @Param(value="flatformId")Integer queryFlatformId,
										 @Param(value="devId")Integer devId);
	
	public int getAppInfoCount(@Param(value = "softwareName") String querySoftwareName,
                               @Param(value = "status") Integer queryStatus,
                               @Param(value = "categoryLevel1") Integer queryCategoryLevel1,
                               @Param(value = "categoryLevel2") Integer queryCategoryLevel2,
                               @Param(value = "categoryLevel3") Integer queryCategoryLevel3,
                               @Param(value = "flatformId") Integer queryFlatformId,
                               @Param(value = "devId") Integer devId);
	
	public AppInfo getAppInfo(@Param(value = "id") Integer id, @Param(value = "APKName") String APKName);


	public int updateSatus(@Param(value = "status") Integer status, @Param(value = "id") Integer id);

}
