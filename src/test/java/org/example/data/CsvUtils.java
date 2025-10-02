package org.example.data;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.example.model.UserData;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvUtils {

    public static List<UserData> readCsvWithHeader(File file) {
        List<UserData> users = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(file)).build()) {
            List<String[]> allData = csvReader.readAll();

            // First row is header
            String[] headers = allData.get(0);
            Map<String, Integer> headerMap = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
//                System.out.println("Data printing "+headers[i]);
                headerMap.put(headers[i].trim().toLowerCase(), i);
                System.out.println("Data printing "+headers[i] + " Mapping " + headerMap.get("run"));
            }

            // Read all rows starting from index 1
            for (int i = 1; i < allData.size(); i++) {
                String[] row = allData.get(i);

                // Filter rows where run = yes
                if (!"yes".equalsIgnoreCase(row[headerMap.get("run")])) {
                    continue;
                }

                UserData user = UserData.builder()
                        .scenarioID(row[headerMap.get("scenarioid")])
                        .run(row[headerMap.get("run")])
                        .gender(row[headerMap.get("gender")])
                        .firstName(row[headerMap.get("firstname")])
                        .lastName(row[headerMap.get("lastname")])
                        .email(row[headerMap.get("email")])
                        .password(row[headerMap.get("password")])
                        .build();

                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    // Convert List<UserData> → Object[][] for TestNG
    public static Object[][] getTestData(File file) {
        List<UserData> users = readCsvWithHeader(file);
        Object[][] data = new Object[users.size()][1]; // one param = UserData
        for (int i = 0; i < users.size(); i++) {
            data[i][0] = users.get(i);
        }
        return data;
    }
}

