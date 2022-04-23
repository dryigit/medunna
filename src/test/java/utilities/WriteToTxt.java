package utilities;

import pojos.Registrant;
import pojos.StaffApi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void saveStaffApiData(StaffApi staffApi) {

        try {
            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("api_staff_data"), true);


            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.append(staffApi.toString() + ", \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


