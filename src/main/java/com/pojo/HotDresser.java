package com.pojo;

import org.apache.log4j.Logger;

import com.constants.GlobalConstant;
import com.util.DocusignUtil;



public class HotDresser extends Dresser {

	final static Logger logger = Logger.getLogger(HotDresser.class);
	public static DocusignUtil util = DocusignUtil.getInstance();

	private String temperature;
	
	public HotDresser(String temperature){
		this.temperature = temperature;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String putFootWear(){
		return  util.readProperty(GlobalConstant.HOT_FOOT.name());
	}
	public String putHeadWear(){
		return util.readProperty(GlobalConstant.HOT_HEAD.name());
	}
	public String putSocks(){
		return util.readProperty(GlobalConstant.HOT_SOCKS.name());
	}
	public String putShirt(){
		return util.readProperty(GlobalConstant.HOT_SHIRT.name());
	}
	public String putJacket(){
		return util.readProperty(GlobalConstant.HOT_JACKET.name());
	}
	public String putPants(){
		return util.readProperty(GlobalConstant.HOT_PANT.name());
	}
	public String leaveHouse(){
		return util.readProperty(GlobalConstant.HOT_LEAVE.name());
	}
	public String takeOffPajamas(){
		return util.readProperty(GlobalConstant.HOT_RMVPJ.name());
	}
}
