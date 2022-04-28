package utilities;

import pojos.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToTxt {

//    public static void saveRegistrantData(Registrant registrant, String fileName){
//
//        try {
//
//            FileWriter fileWriter = new FileWriter(fileName, true);
//            //src/resource/feature/testdata/PatientData
//
//            BufferedWriter writer = new BufferedWriter(fileWriter);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void saveRegistrantData(Registrant registrant){

        try {
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("registrantFile"), true);


            BufferedWriter writer = new BufferedWriter(fileWriter);

//            writer.append(registrant.getFirstName() + "," + registrant.getLastName() + ","
//                            + registrant.getUsername() + "," + registrant.getEmail() + ","
//                            + registrant.getPassword() + "," + registrant.getSSN() + ", \n");

            writer.append(registrant.toString() + ", \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveRegistrantApiData(Registrant registrant){

        try {
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_registrant_data"), true);


            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(registrant.toString() + ", \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveTestItemData(TestItem testItem) {
        try {
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_test_items_data"), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.append(testItem + "\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveTestItemsData(List<Object> testItemIds){
        try{
            //src/resources/testdata/Registrantdata.txt
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("database_test_items_data"), false);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            for(Object eachItemIds: testItemIds) {
                writer.append(eachItemIds + ",\n");
            }

            writer.close();



        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void saveNewUserApiData(CreateNewUser createNewUser){

        try {
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_user_data"), true);


            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(createNewUser.toString() + ", \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}