package com.sp.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sp.app.mapper.DemoMapper;
import com.sp.app.model.Demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
@Slf4j
public class DemoServiceImpl implements DemoService {

	private final DemoMapper mapper;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public void insertDemo(Demo dto) throws Exception {
		
		try {
			
			mapper.insertDemo1(dto);
			mapper.insertDemo2(dto);
			mapper.insertDemo3(dto);
			
		} catch (Exception e) {
			log.info("insertDemo", e);
			throw e;
		}
		
	}
	
}
