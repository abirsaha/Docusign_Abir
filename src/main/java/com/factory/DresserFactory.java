package com.factory;

import com.constants.GlobalConstant;
import com.pojo.ColdDresser;
import com.pojo.Dresser;
import com.pojo.HotDresser;
import com.util.DocusignUtil;

/* Factory Pattern for creating Dresser Instances*/

public class DresserFactory {
	
	static DocusignUtil docusignUtil = DocusignUtil.getInstance();

	public static Dresser getDresser(String temperature){
		if (docusignUtil.readProperty(GlobalConstant.HOT.name()).equalsIgnoreCase(temperature)) {
			return new HotDresser(docusignUtil.readProperty(GlobalConstant.HOT.name()));
		} else if (docusignUtil.readProperty(GlobalConstant.COLD.name()).equalsIgnoreCase(temperature)) {
			return new ColdDresser(docusignUtil.readProperty(GlobalConstant.COLD.name()));
		} else {
			return null;
		}
	}
}
