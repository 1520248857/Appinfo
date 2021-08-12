package cn.kgc.ssm.appsys.controller.backend;
import java.util.List;
import javax.annotation.Resource;
import cn.kgc.ssm.appsys.pojo.AppCategory;
import cn.kgc.ssm.appsys.pojo.AppInfo;
import cn.kgc.ssm.appsys.pojo.AppVersion;
import cn.kgc.ssm.appsys.pojo.DataDictionary;
import cn.kgc.ssm.appsys.service.*;
import cn.kgc.ssm.appsys.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manager/backend/app")
public class AppCheckController {
    @Resource
    DataDictionaryService dataDictionaryService;
    @Resource
    AppCategoryService appCategoryService;
    @Resource
    AppInfoService appInfoService;
    @Resource
    AppVersionService appVersionService;

    @RequestMapping("/list")
    public String getAppInfoList(Model model,
                                 @RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
                                 @RequestParam(value="queryCategoryLevel1",required=false) String _queryCategoryLevel1,
                                 @RequestParam(value="queryCategoryLevel2",required=false) String _queryCategoryLevel2,
                                 @RequestParam(value="queryCategoryLevel3",required=false) String _queryCategoryLevel3,
                                 @RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
                                 @RequestParam(value="pageIndex",required=false,defaultValue = "1") Integer pageNum) {
        //加载平台属性
        List<DataDictionary> flatForm = dataDictionaryService.getDataDictionaryList("APP_FLATFORM");
        model.addAttribute("flatFormList", flatForm);

        //加载一级分类
        List<AppCategory>  categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
        model.addAttribute("categoryLevel1List", categoryLevel1List);

        Integer queryCategoryLevel1 = null;
        if (_queryCategoryLevel1 != null && _queryCategoryLevel1 != "") {
            queryCategoryLevel1 = Integer.parseInt(_queryCategoryLevel1);
        }
        Integer queryCategoryLevel2 = null;
        if (_queryCategoryLevel2 != null && _queryCategoryLevel2 != "") {
            queryCategoryLevel2 = Integer.parseInt(_queryCategoryLevel2);
        }
        Integer queryCategoryLevel3 = null;
        if (_queryCategoryLevel3 != null && _queryCategoryLevel3 != "") {
            queryCategoryLevel3 = Integer.parseInt(_queryCategoryLevel3);
        }

        Integer queryFlatformId = null;
        if (_queryFlatformId != null && _queryFlatformId != "") {
            queryFlatformId = Integer.parseInt(_queryFlatformId);
        }

        PageInfo<AppInfo>  appInfoList = appInfoService.getAppInfoList(querySoftwareName, null, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, null, pageNum, Constants.pageSize);
        model.addAttribute("appInfoList", appInfoList);

        //回显数据
        model.addAttribute("querySoftwareName", querySoftwareName);
        model.addAttribute("queryFlatformId", queryFlatformId);
        model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);

        //回显二级分类
        List<AppCategory> categoryLevel2List = appCategoryService.getAppCategoryListByParentId(queryCategoryLevel1);
        model.addAttribute("categoryLevel2List", categoryLevel2List);
        model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);

        //回显三级分类
        List<AppCategory> categoryLevel3List = appCategoryService.getAppCategoryListByParentId(queryCategoryLevel2);
        model.addAttribute("categoryLevel3List", categoryLevel3List);
        model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);

        return "backend/applist";
    }

    @RequestMapping("/categorylevellist")
    @ResponseBody
    public List<AppCategory> categorylist(Integer parentId) {
        List<AppCategory> appCategoryListByParentId = appCategoryService.getAppCategoryListByParentId(parentId);
        return appCategoryListByParentId;

    }


    @RequestMapping("/check")
    public String check(Model model,Integer aid,Integer vid){
        AppInfo appInfo= appInfoService.getAppInfo(aid,null);
        AppVersion appVersion = appVersionService.getAppVersionById(vid);
        model.addAttribute(appVersion);
        model.addAttribute(appInfo);
        return "backend/appcheck";
    }


    @RequestMapping("/checksave")
    public String checksave(AppInfo appInfo){
        appInfoService.updateSatus(appInfo.getStatus(),appInfo.getId());
        return "redirect:/manager/backend/app/list";
    }

}
