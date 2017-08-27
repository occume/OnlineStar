package com.os.mapper;

import com.os.model.WalletBankcard;
import com.os.model.WalletBankcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WalletBankcardMapper {
    long countByExample(WalletBankcardExample example);

    int deleteByExample(WalletBankcardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WalletBankcard record);

    int insertSelective(WalletBankcard record);

    List<WalletBankcard> selectByExampleWithBLOBs(WalletBankcardExample example);

    List<WalletBankcard> selectByExample(WalletBankcardExample example);

    WalletBankcard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WalletBankcard record, @Param("example") WalletBankcardExample example);

    int updateByExampleWithBLOBs(@Param("record") WalletBankcard record, @Param("example") WalletBankcardExample example);

    int updateByExample(@Param("record") WalletBankcard record, @Param("example") WalletBankcardExample example);

    int updateByPrimaryKeySelective(WalletBankcard record);

    int updateByPrimaryKeyWithBLOBs(WalletBankcard record);

    int updateByPrimaryKey(WalletBankcard record);
}