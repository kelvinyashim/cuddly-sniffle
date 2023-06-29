import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Credentials {
    public void readFromFile() {
        try {
            File myFile = new File("Student_File.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNext()) {
                String dataInFile = myReader.nextLine();
                System.out.println(dataInFile);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the credentials file");
            e.printStackTrace();
        }
    }

    public void writeToFile(String name, String mat, String fac, String dep, String psw, String lapNum) {
        try (FileWriter fileWriter = new FileWriter("Student_File.txt", true)) {
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();

            fileWriter.write(currentTime + "\n");
            fileWriter.write("Date: " + currentDate + "\n");
            fileWriter.write("Student name: " + name + "\n");
            fileWriter.write("Student Faculty: " + fac + "\n");
            fileWriter.write("Student Department: " + dep + "\n");
            fileWriter.write("Matric Number: " + mat + "\n");
            fileWriter.write("Password: " + psw + "\n");
            fileWriter.write("Serial Num: " + lapNum + "\n");
            fileWriter.write("\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file");
            e.printStackTrace();
        }
    }


    public boolean checkCredentials(String matNum, String password) {
        try (Scanner scanner = new Scanner(new File("Student_File.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Matric Number: " + matNum)) {
                    // Check if the matric number matches
                    line = scanner.nextLine(); // Move to the next line
                    if (line.startsWith("Password: " + password)) {
                        return true; // Credentials are valid
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false; // Credentials are invalid
    }
    public String searchBySerialNumber(String serialNumber) {
        try (Scanner scanner = new Scanner(new File("Student_File.txt"))) {
            StringBuilder studentFile = new StringBuilder();
            boolean foundSerialNumber = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Serial Num: " + serialNumber)) {
                    foundSerialNumber = true;
                } else if (foundSerialNumber) {
                    if (line.isEmpty()) {
                        break;  // End of the student file for the serial number
                    }
                    studentFile.append(line).append("\n");
                }
            }

            if (studentFile.length() > 0) {
                return studentFile.toString();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return "Student file not found for the serial number."; // Serial number not found
    }

    public String getOwnerCredentials(String serialNumber) {
        try (Scanner scanner = new Scanner(new File("Student_File.txt"))) {
            StringBuilder credentials = new StringBuilder();
            boolean foundSerialNumber = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("Serial Num: " + serialNumber)) {
                    foundSerialNumber = true;
                } else if (foundSerialNumber) {
                    if (line.isEmpty()) {
                        break;  // End of the credentials for the serial number
                    }
                    credentials.append(line).append("\n");
                }
            }

            if (credentials.length() > 0) {
                return credentials.toString();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return "Owner credentials not found."; // Serial number not found
    }




}

