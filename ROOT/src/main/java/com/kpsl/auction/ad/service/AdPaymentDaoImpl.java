package com.kpsl.auction.ad.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpsl.auction.ad.vo.AdApplyAndAdImageAndAdPaymentVo;
import com.kpsl.auction.ad.vo.AdPaymentVo;

@Repository
public class AdPaymentDaoImpl implements AdPaymentDao {
	
	Logger log = Logger.getLogger(this.getClass());
	final String AdPaymentMapperNS = "com.kpsl.auction.ad.service.AdPaymentMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int insertAdPayment(AdPaymentVo adPaymentVo) {
		
		log.info("insertAdPayment 호출 확인");
		
		return sqlSessionTemplate.insert(AdPaymentMapperNS+"insertAdPayment", adPaymentVo);
	}

	@Override
	public int updateUserTotalcashByUserId(AdPaymentVo adPaymentVo) {
		
		log.info("updateUserTotalcashByUserId 호출 확인");
		
		return sqlSessionTemplate.update(AdPaymentMapperNS+"updateUserTotalcash", adPaymentVo);
	}

	@Override
	public List<AdApplyAndAdImageAndAdPaymentVo> selectAdApplyAndAdImageAndAdPaymentByUserIdAndAdApplyEndDate() {
		
		log.info("selectAdApplyAndAdImageAndAdPaymentByUserIdAndAdApplyEndDate 호출 확인");
		
		return sqlSessionTemplate.selectList(AdPaymentMapperNS+"selectAdApplyAndAdImageAndAdPaymentByUserIdAndAdApplyEndDate");
	}

}
