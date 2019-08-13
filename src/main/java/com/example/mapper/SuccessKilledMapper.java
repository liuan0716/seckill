package com.example.mapper;

import com.example.bean.SuccessKilled;
import org.apache.ibatis.annotations.Param;

public interface SuccessKilledMapper {
	/**
	 * 插入购买明细,可过滤重复,建库时设定了联合主键
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	/**
	 * 根据id查询SuccessKilled并携带秒杀产品对象
	 * @param seckillId
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("phone") Long phone);

}
