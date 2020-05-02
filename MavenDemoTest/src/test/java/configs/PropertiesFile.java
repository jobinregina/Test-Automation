package configs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.ebgames.saf.tests.TestCase;

public class PropertiesFile {

		
		public static void getProperties() {
			
			try {
			Properties prop = new Properties();
			String projectpath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(projectpath+"/src/test/java/configs/Configuration.properties");
			prop.load(input);
			TestCase.browserName = prop.getProperty("browser");
			TestCase.website = prop.getProperty("url");
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				e.printStackTrace();
			}
		}


}
