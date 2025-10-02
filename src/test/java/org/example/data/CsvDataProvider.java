package org.example.data;

import org.testng.annotations.DataProvider;

import java.io.File;

public class CsvDataProvider {

    @DataProvider(name = "csvUserData")
    public Object[][] provideUserData() {
        File file = new File("./src/test/resources/csv/userdata.csv");
        return CsvUtils.getTestData(file);
    }
}
