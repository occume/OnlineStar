package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.OnlineStarMapper;
import com.os.mapper.WalletMapper;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarExample;
import com.os.model.Wallet;
import com.os.model.WalletExample;

@Service
public class WalletService {

	@Autowired
	private WalletMapper walletMapper;
	
	public int insert(Wallet wallet){
		return walletMapper.insert(wallet);
	}
	
	public int update(Wallet wallet){
		return walletMapper.updateByPrimaryKeySelective(wallet);
	}
	
	public Wallet getByOsId(long osId){
		WalletExample example = new WalletExample();
		example.createCriteria().andOsIdEqualTo(osId);
		return walletMapper.selectByExample(example).get(0);
	}
	
	public void setPassword(Wallet wallet){
		walletMapper.updateByPrimaryKeySelective(wallet);
	}
}
