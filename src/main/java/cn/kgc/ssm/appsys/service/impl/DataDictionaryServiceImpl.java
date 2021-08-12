package cn.kgc.ssm.appsys.service.impl;

import java.util.List;

import javax.annotation.Resource;
import cn.kgc.ssm.appsys.mapper.DataDictionaryMapper;
import cn.kgc.ssm.appsys.pojo.DataDictionary;
import cn.kgc.ssm.appsys.service.DataDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Resource
	private DataDictionaryMapper mapper;
	
	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode) {
		// TODO Auto-generated method stub
		return mapper.getDataDictionaryList(typeCode);
	}

}
