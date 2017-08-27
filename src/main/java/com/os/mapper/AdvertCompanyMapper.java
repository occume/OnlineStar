package com.os.mapper;

import com.os.model.AdvertCompany;
import com.os.model.AdvertCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertCompanyMapper {
    long countByExample(AdvertCompanyExample example);

    int deleteByExample(AdvertCompanyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdvertCompany record);

    int insertSelective(AdvertCompany record);

    List<AdvertCompany> selectByExample(AdvertCompanyExample example);

    AdvertCompany selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdvertCompany record, @Param("example") AdvertCompanyExample example);

    int updateByExample(@Param("record") AdvertCompany record, @Param("example") AdvertCompanyExample example);

    int updateByPrimaryKeySelective(AdvertCompany record);

    int updateByPrimaryKey(AdvertCompany record);
}