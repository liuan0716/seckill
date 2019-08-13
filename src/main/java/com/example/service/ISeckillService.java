package com.example.service;

import com.example.bean.Seckill;
import com.example.dto.Exposer;
import com.example.dto.SeckillExcution;
import com.example.service.ex.RepeatKillExcption;
import com.example.service.ex.SeckillCloseException;
import com.example.service.ex.SeckillException;

import java.util.List;

public interface ISeckillService {
	
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 查找单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getById(Long seckillId);
	
	/**
	 * 时间到时开启秒杀接口,
	 * 否则显示秒杀时间和现在时间
	 * @param seckillId
	 * @return
	 */
	Exposer ExportSeckillUrl(long seckillId);
	
	/**
	 * 根据秒杀商品id和用户手机号码定位秒杀商品,
	 * 通过md5与url暴露的md5对比,不一致则拒绝秒杀
	 * @param seckillId
	 * @param phone
	 * @param md5
	 */
	SeckillExcution executeSeckill(long seckillId, long phone, String md5) throws RepeatKillExcption,SeckillCloseException,SeckillException;
	
	

}
