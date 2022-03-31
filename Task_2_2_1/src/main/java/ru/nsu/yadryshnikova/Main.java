package ru.nsu.yadryshnikova;

import ru.nsu.yadryshnikova.factory.PizzeriaFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nsu.yadryshnikova.config.PizzeriaConfiguration;

import java.io.File;
import java.io.IOException;

public class Main {

    private static PizzeriaConfiguration configuration;

    public static void main(String[] args) throws IOException {
        if(createIfNotExists()){
            return;
        }
        loadConfiguration();
        PizzeriaFactory.produce(configuration);
    }

    public static void loadConfiguration() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        configuration = mapper.readValue(
                new File("./conf.json"),
                PizzeriaConfiguration.class
        );
    }

    public static boolean createIfNotExists() throws IOException {
        var file = new File("./conf.json");
        if(!file.exists()){
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, new PizzeriaConfiguration());
            return true;
        }
        return false;
    }

}