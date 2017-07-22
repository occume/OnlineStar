package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.CommonMapper;
import com.os.model.City;
import com.os.model.Province;

@Service
public class CommonService {
	
	@Autowired
	private CommonMapper commonMapper;
	
	public List<City> getCityList(){
		return commonMapper.cityList();
	}
	
	public List<City> getCityList(int provinceId){
		return commonMapper.cityListByProvinceId(provinceId);
	}
	
	public List<Province> getProvinceList(){
		return commonMapper.provinceList();
	}
}
