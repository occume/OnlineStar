package com.os.mapper;

import java.util.List;

import com.os.model.City;
import com.os.model.Group;
import com.os.model.JobType;
import com.os.model.Province;

public interface CommonMapper {

	List<City> cityList();
	
	List<City> cityListByProvinceId(int provinceId);
	
	List<Province> provinceList();
	
	List<Group> groupList();
	
	List<JobType> jobTypeList();
}
