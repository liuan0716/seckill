package com.example.service;

import com.example.bean.Seckill;
import com.example.bean.StatusEnum;
import com.example.bean.SuccessKilled;
import com.example.dto.Exposer;
import com.example.dto.SeckillExcution;
import com.example.mapper.SeckillMapper;
import com.example.mapper.SuccessKilledMapper;
import com.example.service.ex.RepeatKillExcption;
import com.example.service.ex.SeckillCloseException;
import com.example.service.ex.SeckillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class SeckillService implements ISeckillService {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired(required = false)
	SeckillMapper seckillMapper;
	
	@Autowired(required = false)
	SuccessKilledMapper successKilledMapper;

	@Override
	public List<Seckill> getSeckillList() {
		logger.debug("获取秒杀清单");
		return seckillMapper.queryAll(0, 10);
	}

	@Override
	public Seckill getById(Long seckillId) {
		return seckillMapper.queryById(seckillId);
	}

	@Override
	public Exposer ExportSeckillUrl(long seckillId) {
		Seckill seckill=seckillMapper.queryById(seckillId);
		long now=System.currentTimeMillis();

		if(seckill==null) {
			return new Exposer(false,seckillId);
		}else {
			long startTime=seckill.getStartTime().getTime();
			long endTime=seckill.getEndTime().getTime();
			if(startTime > now) {
				return new Exposer(false,seckillId);
			}else if(now >= endTime) {
				return new Exposer(false,seckillId);
			}
			String url=seckillId+"/";
			return new Exposer(true,getMD5(url),seckillId,now,seckill.getStartTime().getTime(),seckill.getEndTime().getTime());
			
		}
	}

	@Override
	@Transactional
	public SeckillExcution executeSeckill(long seckillId, long phone, String md5) {
		//秒杀时生成的md5与自动生成的不一致,跑出秒杀异常
		if(md5==null || !md5.equals(getMD5(seckillId+"/"))) {
			throw new SeckillException("seckill data rewrite!");
		}
		//执行秒杀:减库存+记录秒杀行为
		try{
			Date nowTime=new Date();
			int updateCount=seckillMapper.reduceNumber(seckillId, nowTime);
			if(updateCount<=0) {
				//不更新到记录，秒杀结束或库存为0，抛出异常
				throw new SeckillCloseException("seckill closed!");
			}else {
				int insertCount=successKilledMapper.insertSuccessKilled(seckillId, phone);
				//因为使用了repeat ignore,受影响行数为0的情况就是插入重复,抛出异常
				if(insertCount==0) {
					throw new RepeatKillExcption("seckill repeated!");
				}else {
					SuccessKilled sk=successKilledMapper.queryByIdWithSeckill(seckillId, phone);
					return new SeckillExcution(seckillId, StatusEnum.OK,sk);
				}
			}
		}catch(RepeatKillExcption | SeckillCloseException e1){
			throw e1;
		} catch(Exception e3){
			throw new SeckillException("inner fault:"+e3.getMessage());
		}

	}
	
	/**
	 * 加密秒杀url
	 * @param md5 秒杀url
	 * @return 加密后的url
	 */
	private String getMD5(String md5) {
		String slat = "aswdewfcwvdfvgggg####$$$";
		return DigestUtils.md5DigestAsHex((md5+ slat).getBytes());
	}




}
