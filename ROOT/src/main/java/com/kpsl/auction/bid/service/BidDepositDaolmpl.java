package com.kpsl.auction.bid.service;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpsl.auction.bid.vo.BidDepositVo;
import com.kpsl.auction.user.vo.UserDetailVo;
@Repository
public class BidDepositDaolmpl implements BidDepositDao {
	Logger log = Logger.getLogger(this.getClass());

	final String NS = "com.kpsl.auction.bid.service.BidDepositMapper.";
	@Autowired private SqlSessionTemplate sessionTemplate;
	
	//보증금 insert 
	@Override
	public int insertBidDeposit(BidDepositVo BidDepositVo) {
		log.info("BidDepositDao insertBidDeposit 확인");
		return sessionTemplate.insert(NS + "insertBidDeposit", BidDepositVo);

	}
	// 보증금 차감
	@Override
	public int updateUserCashWithdraw(BidDepositVo BidDepositVo) {
		 log.info("BidDao updateUserCashWithdraw 확인");
		return sessionTemplate.insert(NS + "updateUserCashWithdraw", BidDepositVo);
	}

}
