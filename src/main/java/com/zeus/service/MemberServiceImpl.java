package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.domain.Member;
import com.zeus.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int register(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Member> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member read(Member member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
