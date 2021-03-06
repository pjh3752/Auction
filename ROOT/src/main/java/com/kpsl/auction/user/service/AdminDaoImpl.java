package com.kpsl.auction.user.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpsl.auction.user.vo.AdminUserSearchVo;
import com.kpsl.auction.user.vo.UserDetailVo;
import com.kpsl.auction.user.vo.UserRemoveVo;

@Repository
public class AdminDaoImpl implements AdminUserDao {
	final String NS ="com.kpsl.auction.user.service.AdminUserMapper.";

	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<AdminUserSearchVo> selectUserSearch(UserDetailVo userDetailVo) {
		log.info("AdminUserDao Class selectUserSearch : "+ userDetailVo);
		return sqlSessionTemplate.selectList(NS+"selectUserSearch", userDetailVo);
	}

}
