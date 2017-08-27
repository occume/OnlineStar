package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.AdvertCompanyMapper;
import com.os.model.AdvertCompany;
import com.os.model.AdvertCompanyExample;

@Service
public class AdvertCompanyService {

	@Autowired
	private AdvertCompanyMapper acvertMapper;
	
	public int update(AdvertCompany advert){
		return acvertMapper.updateByPrimaryKeySelective(advert);
	}
	
	public int insert(AdvertCompany advert){
		return acvertMapper.insert(advert);
	}
	
	public AdvertCompany getByAuthId(long authId){
		AdvertCompanyExample example = new AdvertCompanyExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		List<AdvertCompany> list = acvertMapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}
}
