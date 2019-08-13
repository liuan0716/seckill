package com.example.bean;

import java.io.Serializable;
import java.util.Date;

public class SuccessKilled implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3822798593501010686L;
	private long killedId;
	private long userPhone;
	private short state;
	private Date createTime;
	//多对一
	private Seckill seckill;

	public SuccessKilled() {
		super();
	}

	public SuccessKilled(long killedId, long userPhone, short state, Date createTime, Seckill seckill) {
		super();
		this.killedId = killedId;
		this.userPhone = userPhone;
		this.state = state;
		this.createTime = createTime;
		this.seckill = seckill;
	}

	public long getKilledId() {
		return killedId;
	}

	public void setKilledId(long killedId) {
		this.killedId = killedId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + (int) (killedId ^ (killedId >>> 32));
		result = prime * result + ((seckill == null) ? 0 : seckill.hashCode());
		result = prime * result + state;
		result = prime * result + (int) (userPhone ^ (userPhone >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuccessKilled other = (SuccessKilled) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (killedId != other.killedId)
			return false;
		if (seckill == null) {
			if (other.seckill != null)
				return false;
		} else if (!seckill.equals(other.seckill))
			return false;
		if (state != other.state)
			return false;
		if (userPhone != other.userPhone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SuccessKilled [killedId=" + killedId + ", userPhone=" + userPhone + ", state=" + state + ", createTime="
				+ createTime + ", seckill=" + seckill + "]";
	}
	
	

}
