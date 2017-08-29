package com.os.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.os.model.BannerImage;
import com.os.model.City;
import com.os.model.Feedback;
import com.os.model.Group;
import com.os.model.JobType;
import com.os.model.Province;
import com.os.model.WalletBankcardType;

public interface CommonMapper {

	List<City> cityList();
	
	List<City> cityListByProvinceId(int provinceId);
	
	List<Province> provinceList();
	
	List<Group> groupList();
	
	List<JobType> jobTypeList();
	
	List<BannerImage> bannerImageList();
	
	List<WalletBankcardType> bankcardTypeList(@Param("prefix")String prefix);
	
	int feedbackAdd(Feedback feedback);
}
