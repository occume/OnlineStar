package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.MerchantMapper;
import com.os.model.Merchant;
import com.os.model.MerchantExample;

@Service
public class MerchantService {

	@Autowired
	private MerchantMapper merchantMapper;
	
	public int insert(Merchant merchant){
		return merchantMapper.insert(merchant);
	}
	
	public Merchant getByAuthId(long authId){
		MerchantExample example = new MerchantExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		List<Merchant> list = merchantMapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}
}
