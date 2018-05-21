package ru.isa.catalogiser;

import java.io.*;
import java.util.Properties;

public class PropertiesWork {
    FileInputStream fis;
    FileOutputStream fos;
    InputStream is;
    Properties property = new Properties();

    public void readProps() {
        try {
            //fis = new FileInputStream("/src/main/resources/properties.xml");
            //fis = new FileInputStream("properties.xml");
            //is = getClass().getResourceAsStream("ru/isa/catalogiser/properties.xml");
            //is = PropertiesWork.class.getResourceAsStream("properties.xml");
            is = PropertiesWork.class.getClassLoader().getResourceAsStream("properties.xml");
            System.out.println(is.toString());
            property.loadFromXML(is);

//          String testkey = property.getProperty("testkey");
//          String message = property.getProperty("message");
//          System.out.println(testkey);
//          System.out.println(message);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProp(String key){
        return property.getProperty(key);
    }
}
