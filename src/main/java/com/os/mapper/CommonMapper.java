package com.os.mapper;

import java.util.List;

import com.os.model.City;
import com.os.model.Province;

public interface CommonMapper {

	List<City> cityList();
	
	List<City> cityListByProvinceId(int provinceId);
	
	List<Province> provinceList();
}
