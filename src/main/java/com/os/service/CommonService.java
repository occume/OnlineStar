package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.AlipayResultMapper;
import com.os.mapper.CommonMapper;
import com.os.mapper.ImageMapper;
import com.os.model.AlipayResult;
import com.os.model.BannerImage;
import com.os.model.City;
import com.os.model.District;
import com.os.model.Feedback;
import com.os.model.Group;
import com.os.model.Image;
import com.os.model.JobType;
import com.os.model.Order;
import com.os.model.Province;
import com.os.model.WalletBankcardType;

@Service
public class CommonService {
	
	@Autowired
	private CommonMapper commonMapper;
	@Autowired
	private ImageMapper workMapper;
	@Autowired
	private AlipayResultMapper alipayResultMapper;
	
	public void saveImage(Image image){
		workMapper.insert(image);
	}
	
	public void saveFiles(List<Image> images){
		for(Image work: images){
			saveImage(work);
		}
	}
	
	public List<JobType> getJobTypeList(){
		return commonMapper.jobTypeList();
	}
	
	public List<Group> getGroupList(){
		return commonMapper.groupList();
	}
	
	public List<City> getCityList(){
		return commonMapper.cityList();
	}
	
	public List<City> getCityList(int provinceId){
		return commonMapper.cityListByProvinceId(provinceId);
	}
	
	public List<District> getDistrictList(int cityId){
		return commonMapper.districtListByCityId(cityId);
	}
	
	public List<Province> getProvinceList(){
		return commonMapper.provinceList();
	}
	
	public List<BannerImage> getBannerImageList(){
		return commonMapper.bannerImageList();
	}
	
	public List<WalletBankcardType> getBankcardTypeList(String prefix){
		return commonMapper.bankcardTypeList(prefix);
	}
	
	public int feedbackAdd(Feedback feedback){
		return commonMapper.feedbackAdd(feedback);
	}
	
	public int createOrder(Order order){
		return commonMapper.createOrder(order);
	}
	
	public int updateOrder(Order order){
		return commonMapper.updateOrder(order);
	}
	
	public int createAlipayResult(AlipayResult result){
		return alipayResultMapper.insert(result);
	}
}
