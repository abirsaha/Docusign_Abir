package com.util;

import java.io.IOException;
import java.util.Properties;


/*Utility Singleton class created for retrieving properties 
  from docusign.properties file in resource folder
 */

public class DocusignUtil {

    private static DocusignUtil instance = null;
    private Properties properties;


    private DocusignUtil() throws IOException{

        properties = new Properties();
        properties.load(getClass().getResourceAsStream("/docusign.properties"));

    }

    public static DocusignUtil getInstance() {
        if(instance == null) {
            try {
                instance = new DocusignUtil();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
    
   

}