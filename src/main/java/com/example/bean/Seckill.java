package com.example.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


public class Seckill implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2139692141365090235L;
	private long seckilledId;
	private String objName;
	private int number;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	

	public Seckill() {
		super();
	}
	
	public Seckill(long seckilledId, String objName, int number, Date startTime, Date endTime, Date createTime) {
		super();
		this.seckilledId = seckilledId;
		this.objName = objName;
		this.number = number;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createTime = createTime;
	}

	public long getSeckilledId() {
		return seckilledId;
	}
	public void setSeckilledId(long seckilledId) {
		this.seckilledId = seckilledId;
	}
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + number;
		result = prime * result + ((objName == null) ? 0 : objName.hashCode());
		result = prime * result + (int) (seckilledId ^ (seckilledId >>> 32));
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Seckill other = (Seckill) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (number != other.number)
			return false;
		if (objName == null) {
			if (other.objName != null)
				return false;
		} else if (!objName.equals(other.objName))
			return false;
		if (seckilledId != other.seckilledId)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Seckill [seckilledId=" + seckilledId + ", objName=" + objName + ", number=" + number + ", startTime="
				+ startTime + ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}
	
	

}
