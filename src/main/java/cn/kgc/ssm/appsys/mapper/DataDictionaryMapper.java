package cn.kgc.ssm.appsys.mapper;
import java.util.List;
import cn.kgc.ssm.appsys.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

public interface DataDictionaryMapper {
	
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode);
}
