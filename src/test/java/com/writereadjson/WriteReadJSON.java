package com.writereadjson;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteReadJSON {
    public static void main(String[] args) {
        JsonObject emps = new JsonObject();
        emps.addProperty("firstname", "Suyash");
        emps.addProperty("lastname", "Gaikwad");
        emps.addProperty("Adress", "nashik road");
        emps.addProperty("cityname", "Nashik");
        emps.addProperty("StateName", "Maharashtra");

        JsonObject empObj1 = new JsonObject();
        empObj1.addProperty( "AdressBook1", String.valueOf(emps));

        JsonObject emps2 = new JsonObject();
        emps.addProperty("firstname", "suya");
        emps.addProperty("lastname", "Gaikwad");
        emps.addProperty("Adress", "nashik road");
        emps.addProperty("cityname", "Nashik");
        emps.addProperty("StateName", "Maharashtra");

        JsonObject empObj2 = new JsonObject();
        empObj2.addProperty( "AdressBook2", String.valueOf(emps2));


        JsonArray empList = new JsonArray();
        empList.add(empObj1);
        empList.add(empObj2);
        try (FileWriter file  = new FileWriter("filepath.json")){
            file.write(empList.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
