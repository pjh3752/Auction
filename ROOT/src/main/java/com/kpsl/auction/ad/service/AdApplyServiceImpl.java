package com.kpsl.auction.ad.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kpsl.auction.ad.vo.AdApplyVo;
import com.kpsl.auction.ad.vo.AdImageVo;
import com.kpsl.auction.auctiongoods.vo.AuctionGoodsVo;

@Service
@Transactional
public class AdApplyServiceImpl implements AdApplyService {
	Logger log = Logger.getLogger(this.getClass());
	@Autowired private AdApplyDao adApplyDao;
	
	@Override
	// adApplyVo에 셋팅된 adApplyCode를 겟팅후 adImageVo의 adApplyCode에 셋팅해준다.
	public void adApplyTransaction(AdApplyVo adApplyVo, AdImageVo adImageVo) {
		addAdApply(adApplyVo);
		String adApplyCode = adApplyVo.getAdApplyCode();
		adImageVo.setAdApplyCode(adApplyCode);
		addAdImage(adImageVo);
		log.info("adApplyTransaction 확인");
	}
	
	@Override
	public List<AuctionGoodsVo> getAuctionGoodsListByUserId(String userId) {
		log.info(userId+"확인");
		log.info("getAuctionGoodsListByUserId 호출 확인");
		return adApplyDao.selectAuctionGoodsListForAdApply(userId);
	}

	@Override
	public int addAdApply(AdApplyVo adApplyVo) {
		log.info("addAdApply 호출 확인");
		return adApplyDao.insertAdApply(adApplyVo);
	}

	@Override
	public int addAdImage(AdImageVo adImageVo) {
		log.info("adAdImage 호출 확인");
		return adApplyDao.insertAdImage(adImageVo);
	}

	@Override
	public List<AdApplyVo> getAdApplyList() {
		log.info("getAdApplyList 호출 확인");
		return adApplyDao.selectAdApplyList();
	}
}
