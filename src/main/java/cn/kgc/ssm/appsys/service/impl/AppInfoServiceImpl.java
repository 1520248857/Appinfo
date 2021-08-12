package cn.kgc.ssm.appsys.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import cn.kgc.ssm.appsys.mapper.AppInfoMapper;
import cn.kgc.ssm.appsys.mapper.AppVersionMapper;
import cn.kgc.ssm.appsys.pojo.AppInfo;
import cn.kgc.ssm.appsys.pojo.AppVersion;
import cn.kgc.ssm.appsys.service.AppInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    private AppInfoMapper appInfoMapper;
    @Resource
    private AppVersionMapper appVersionMapper;


    @Override
    public PageInfo<AppInfo> getAppInfoList(String querySoftwareName,
                                            Integer queryStatus,
                                            Integer queryCategoryLevel1,
                                            Integer queryCategoryLevel2,
                                            Integer queryCategoryLevel3,
                                            Integer queryFlatformId,
                                            Integer devId,
                                            Integer pageNum,
                                            Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AppInfo> appInfoList = appInfoMapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
        PageInfo<AppInfo> pageInfo = new PageInfo<>(appInfoList);
        return pageInfo;
    }

    @Override
    public AppInfo getAppInfo(Integer id ,String APKName) {
        return appInfoMapper.getAppInfo(id, APKName);
    }

    @Override
    public int updateSatus(Integer status, Integer id)  {
        return appInfoMapper.updateSatus(status, id);
    }


    /**
     * set sale method to on or off
     *
     * @param appInfo
     * @param operator
     * @return
     * @throws Exception
     */
    private boolean setSaleSwitchToAppVersion(AppInfo appInfo, Integer operator, Integer saleStatus) throws Exception {
        AppVersion appVersion = new AppVersion();
        appVersion.setId(appInfo.getVersionId());
        appVersion.setPublishStatus(saleStatus);
        appVersion.setModifyBy(operator);
        appVersion.setModifyDate(new Date(System.currentTimeMillis()));
        appVersionMapper.modify(appVersion);
        return false;
    }

}
