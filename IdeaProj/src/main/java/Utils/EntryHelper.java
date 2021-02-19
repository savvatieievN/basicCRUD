package Utils;

import args.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EntryHelper implements EntityHelperInterface {
    private Properties properties;
    private List<String> keysList;
    private List<String> classList;

    public EntryHelper() {
        this.properties = new Properties();
        this.classList = new ArrayList<String>();
    }

    @Override
    public List getClassListFromDirectory() {
        System.out.println(String.format("Read from the directory %s",Constant.MODEL_DIRECTORY));
        try(InputStream readFromPackage = getClass().getClassLoader().getResourceAsStream(Constant.MODEL_DIRECTORY)) {
            try(BufferedReader br = new BufferedReader(new InputStreamReader(readFromPackage))) {
                while (br.ready()) {
                    classList.add(Constant.MODEL_DIRECTORY
                            + Constant.PATH_DELIMETER + br.readLine().replace(Constant.CLASS_SUFFIX,Constant.EMPTY));
                }
            }
        } catch (IOException e) {
            System.out.println(Constant.MODEL_DIRECTORY_EMPTY);
        }
        return classList;
    }

    @Override
    public List getClassListFromFile() {
        System.out.println(String.format("Read from configuration file %s",Constant.CLASS_PROPERTY));
        try(InputStream ip = getClass().getClassLoader().getResourceAsStream(Constant.CLASS_PROPERTY)) {
            properties.load(ip);
            keysList = Collections.list((Enumeration<String>) properties.propertyNames());
            keysList.forEach((x) -> {
                classList.add(properties.getProperty(x));
            } );
        } catch (IOException e) {
            System.out.println(Constant.PROPERTY_FILE_NOT_FOUND);
        }
        return classList;
    }
}
