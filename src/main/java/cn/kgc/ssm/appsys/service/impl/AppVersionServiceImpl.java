package cn.kgc.ssm.appsys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.kgc.ssm.appsys.mapper.AppInfoMapper;
import cn.kgc.ssm.appsys.mapper.AppVersionMapper;
import cn.kgc.ssm.appsys.pojo.AppVersion;
import cn.kgc.ssm.appsys.service.AppVersionService;
import org.springframework.stereotype.Service;

@Service
public class AppVersionServiceImpl implements AppVersionService {
	
	@Resource
	private AppVersionMapper mapper;
	@Resource
	private AppInfoMapper appInfoMapper;
	
	@Override
	public List<AppVersion> getAppVersionList(Integer appId)  {
		// TODO Auto-generated method stub
		return mapper.getAppVersionList(appId);
	}

	@Override
	public boolean appsysadd(AppVersion appVersion) {
		return false;
	}




	@Override
	public AppVersion getAppVersionById(Integer id)  {
		// TODO Auto-generated method stub
		return mapper.getAppVersionById(id);
	}


	@Override
	public boolean modify(AppVersion appVersion)  {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.modify(appVersion) > 0){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean deleteApkFile(Integer id)  {
		// TODO Auto-generated method stub
		boolean flag = false;
		if(mapper.deleteApkFile(id) > 0){
			flag = true;
		}
		return flag;
	}

}
