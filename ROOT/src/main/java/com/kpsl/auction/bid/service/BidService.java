package com.kpsl.auction.bid.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.kpsl.auction.bid.vo.BidVo;

@Transactional
public interface BidService {

		/**입찰자 리스트 인터페이스 **/
	List<BidVo> getBidList();
		/**입찰버튼 클릭시 인터페이스**/
		int setBidPrice(BidVo bidvo);
		
}
