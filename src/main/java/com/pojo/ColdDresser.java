package com.pojo;

import org.apache.log4j.Logger;

import com.constants.GlobalConstant;
import com.util.DocusignUtil;

public class ColdDresser extends Dresser{
	final static Logger logger = Logger.getLogger(ColdDresser.class);
	public static DocusignUtil util = DocusignUtil.getInstance();

	private String temperature;
	
	public ColdDresser(String temperature){
		this.temperature = temperature;
	}
	
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String putFootWear(){
		return  util.readProperty(GlobalConstant.COLD_FOOT.name());
	}
	public String putHeadWear(){
		return util.readProperty(GlobalConstant.COLD_HEAD.name());
	}
	public String putSocks(){
		return util.readProperty(GlobalConstant.COLD_SOCKS.name());
	}
	public String putShirt(){
		return util.readProperty(GlobalConstant.COLD_SHIRT.name());
	}
	public String putJacket(){
		return util.readProperty(GlobalConstant.COLD_JACKET.name());
	}
	public String putPants(){
		return util.readProperty(GlobalConstant.COLD_PANT.name());
	}
	public String leaveHouse(){
		return util.readProperty(GlobalConstant.COLD_LEAVE.name());
	}
	public String takeOffPajamas(){
		return util.readProperty(GlobalConstant.COLD_RMVPJ.name());
	}
}
