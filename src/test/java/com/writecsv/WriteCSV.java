package com.writecsv;

import com.person.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCSV {
    private static String Person;

    public static void main(String [] args) throws IOException {
        String filePath = "filepath";
        Write(filePath);
        System.out.print(filePath);
        String filepath = "filepath";
        Read(filePath);
        System.out.print(filePath);


    }

    private static void Read(String filePath) throws IOException {
        BufferedReader reader = null;
        try {
            List<Person> PersonList = new ArrayList<Person>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length > 0 ) {
                Person person = new Person();
                person.setFirstname(fields[0]);
                person.setLastname(fields[1]);
                person.setAdress(fields[2]);
                person.setCity(fields[3]);
                person.setState(fields[4]);
            }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            reader.close();
        }
    }


    private static void Write(String filePath) throws IOException {
        List<Person> PersonList = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setFirstname("Suyash");
        person1.setLastname("Gaikwad");
        person1.setAdress("Nashik Road");
        person1.setCity("nashik");
        person1.setState("Maharashtra");
        PersonList.add(person1);

        Person person2 = new Person();
        person2.setFirstname("Sagar");
        person2.setLastname("Gaikwad");
        person2.setAdress("Nashik Road");
        person2.setCity("nashik");
        person2.setState("Maharashtra");
        PersonList.add(person2);

        Person person3 = new Person();
        person3.setFirstname("Sumit");
        person3.setLastname("gosavi");
        person3.setAdress("Nashik Road");
        person3.setCity("nashik");
        person3.setState("Maharashtra");
        PersonList.add(person3);

        FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(filePath);
                fileWriter.append("firstname, lastname, adress, city, state");
                fileWriter.append("\n");
                for (Person person : PersonList) {
                    fileWriter.append(person.getFirstname());
                    fileWriter.append(",");
                    fileWriter.append(person.getLastname());
                    fileWriter.append(",");
                    fileWriter.append(person.getAdress());
                    fileWriter.append(",");
                    fileWriter.append(person.getCity());
                    fileWriter.append(",");
                    fileWriter.append(person.getState());
                    fileWriter.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fileWriter.flush();
                fileWriter.close();
            }


        }


    }



