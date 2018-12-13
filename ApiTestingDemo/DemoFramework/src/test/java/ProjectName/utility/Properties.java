package ProjectName.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by piyush on 7/3/17.
 */
public class Properties {

        private static java.util.Properties propFile=null;

        public static void loadPropertiesFile(String fileName) throws IOException {
            java.util.Properties prop=new java.util.Properties();
            InputStream inputStream=new FileInputStream(fileName);
            if(inputStream !=null ){
                prop.load(inputStream);
            }
            else {
                throw new FileNotFoundException("property file " + fileName + " not found in the resource folder");
            }
            propFile=prop;
        }

        public static String getPropertyValue(String key){
            return propFile.getProperty(key);
        }

    }

