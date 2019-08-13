package com.example.dto;

import com.example.bean.StatusEnum;
import com.example.bean.SuccessKilled;

import java.util.Objects;

public class SeckillExcution {
	
	//id
	private long seckillId;

	private StatusEnum status;
	//秒杀成功对象
	private SuccessKilled successKilled;

	public SeckillExcution() {
	}

	public SeckillExcution(long seckillId, StatusEnum status) {
		this.seckillId = seckillId;
		this.status = status;
	}

	public SeckillExcution(long seckillId, StatusEnum status, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.status = status;
		this.successKilled = successKilled;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SeckillExcution that = (SeckillExcution) o;
		return seckillId == that.seckillId &&
				status == that.status &&
				Objects.equals(successKilled, that.successKilled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(seckillId, status, successKilled);
	}

	@Override
	public String toString() {
		return "SeckillExcution{" +
				"seckillId=" + seckillId +
				", status=" + status +
				", successKilled=" + successKilled +
				'}';
	}
}
