package com.example.dto;

import java.io.Serializable;

/**
 * 暴露秒杀地址,秒杀之前不暴露
 * @author liuan
 *
 */
public class Exposer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8215770552924884270L;
	
	//是否开启秒杀
	private boolean exposed;
	//数据摘要,加密
	private String md5;
	//秒杀商品id
	private long seckillId;
	//现在时间
	private long now;
	//秒杀开始时间
	private long start;
	//秒杀结束时间
	private long end;
	
	public Exposer(boolean exposed, String md5, long seckillId, long now, long start, long end) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposed, long seckillId) {
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (end ^ (end >>> 32));
		result = prime * result + (exposed ? 1231 : 1237);
		result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
		result = prime * result + (int) (now ^ (now >>> 32));
		result = prime * result + (int) (seckillId ^ (seckillId >>> 32));
		result = prime * result + (int) (start ^ (start >>> 32));
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
		Exposer other = (Exposer) obj;
		if (end != other.end)
			return false;
		if (exposed != other.exposed)
			return false;
		if (md5 == null) {
			if (other.md5 != null)
				return false;
		} else if (!md5.equals(other.md5))
			return false;
		if (now != other.now)
			return false;
		if (seckillId != other.seckillId)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", seckillId=" + seckillId + ", now=" + now + ", start="
				+ start + ", end=" + end + "]";
	}
	
	
	
	

}
