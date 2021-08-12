package cn.kgc.ssm.appsys.mapper;

import java.util.List;

import cn.kgc.ssm.appsys.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;


public interface AppVersionMapper {
	
	public List<AppVersion> getAppVersionList(@Param("appId") Integer appId);
	
	public int add(AppVersion appVersion)throws Exception;
	
	public int getVersionCountByAppId(@Param("appId") Integer appId);
	
	public int deleteVersionByAppId(@Param("appId") Integer appId);
	
	public AppVersion getAppVersionById(@Param("id") Integer id);
	
	public int modify(AppVersion appVersion);
	
	public int deleteApkFile(@Param("id") Integer id);
}
