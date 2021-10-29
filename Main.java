import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Scanner; //import for doing inputs

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    //Ask for name of file and format
    System.out.print("Enter the name of the file along with the format: ");
    String name = input.nextLine();

    // try to find the file //
    try {
      File myFile = new File(name); 

      //ask to create new file
      if (myFile.createNewFile()) {
        System.out.print("This file does not exists enter \"y\" if you would like to create this file: ");
        String in = input.nextLine();
        if (!in.equals("y")){
          myFile.delete();
        }else{
          System.out.println("File created: " + myFile.getName());
        }

      //output that the file already exists
      } else {
        System.out.println("File exists.");
      }
      System.out.print("Enter the text you would like to add: ");
      String text = input.nextLine();

      //Try to write to file, true to not overwrite data
      try {
        FileWriter writer = new FileWriter(name,true);
        //write the information into the file and append to next line
        writer.write(text + "\n");
        //close the file
        writer.close();
        //output that it was successful
        System.out.println("Successfully wrote to the file.");
          //To catch any errors
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace(); //print error details
        }

      //Catch any errors incase file cannot be created
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace(); //output errors
    }
  }
}