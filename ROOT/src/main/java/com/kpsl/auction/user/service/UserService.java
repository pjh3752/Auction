package com.kpsl.auction.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.kpsl.auction.user.vo.UserDetailVo;

@Transactional
public interface UserService {
	UserDetailVo getUserLogin(UserDetailVo userDetailVo);
}