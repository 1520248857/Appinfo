package cn.kgc.ssm.appsys.service.impl;
import java.util.List;
import javax.annotation.Resource;
import cn.kgc.ssm.appsys.mapper.AppCategoryMapper;
import cn.kgc.ssm.appsys.pojo.AppCategory;
import cn.kgc.ssm.appsys.service.AppCategoryService;
import org.springframework.stereotype.Service;
@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryMapper mapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			 {
		// TODO Auto-generated method stub
		return mapper.getAppCategoryListByParentId(parentId);
	}

}
