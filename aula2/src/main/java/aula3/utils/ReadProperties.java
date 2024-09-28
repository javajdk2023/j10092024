package aula3.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	
	//Implementar o padrão singleton
	public static Properties loadProperties() {
		Properties prop = new Properties();

<<<<<<< HEAD
=======
		
>>>>>>> branch 'aula3' of git@github.com:javajdk2023/j10092024.git
		ClassLoader classLoader = ReadProperties.class.getClassLoader();
		
		// Caminho para o arquivo de propriedades que está na pasta: /resources/application.properties
		String fileName = "application.properties";

		try (InputStream input = classLoader.getResourceAsStream(fileName)) {
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
