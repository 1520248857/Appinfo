package cn.kgc.ssm.appsys.mapper;

import java.util.List;

import cn.kgc.ssm.appsys.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

public interface AppCategoryMapper {
	
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId);
}
