package com.os.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.mapper.OnlineStarMapper;
import com.os.mapper.WalletBankcardMapper;
import com.os.mapper.WalletMapper;
import com.os.model.OnlineStar;
import com.os.model.OnlineStarExample;
import com.os.model.Wallet;
import com.os.model.WalletBankcard;
import com.os.model.WalletBankcardExample;
import com.os.model.WalletExample;

@Service
public class WalletService {

	@Autowired
	private WalletMapper walletMapper;
	@Autowired
	private WalletBankcardMapper bankcardMapper;
	
	public int insert(Wallet wallet){
		return walletMapper.insert(wallet);
	}
	
	public int update(Wallet wallet){
		return walletMapper.updateByPrimaryKeySelective(wallet);
	}
	
	public Wallet getByOsId(long authId){
		WalletExample example = new WalletExample();
		example.createCriteria().andAuthIdEqualTo(authId);
		return walletMapper.selectByExample(example).get(0);
	}
	
	public void setPassword(Wallet wallet){
		walletMapper.updateByPrimaryKeySelective(wallet);
	}
	
	public List<WalletBankcard> getBankcardList(long osId){
		WalletBankcardExample example = new WalletBankcardExample();
		WalletBankcardExample.Criteria c = example.createCriteria();
		c.andOsIdEqualTo(osId);
		return bankcardMapper.selectByExample(example);
	}
}
