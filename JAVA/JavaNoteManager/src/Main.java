import java.io.*;
import java.util.Scanner;

public class Main{
    //function for the file info that shows the file info 
    public static void info_file(String a){
        File file = new File(a);
        System.out.println("Status : " + file.exists());
        System.out.println("File Name : " + file.getName());
        System.out.println("File : " + file.isFile());
        System.out.println("Directory : " + file.isDirectory());
        System.out.println("File Path : " + file.getPath());
        System.out.println("File Absolute Path : " + file.getAbsolutePath());
        // System.out.println("Delete : " + file.delete());
        System.out.println("File Exist : " + file.exists());
    }
    //function for the reading the file ( Using the BufferReader ) 
    public static void ReadFile(String a){
        System.out.println("These File contain :");
        try (BufferedReader reader = new BufferedReader(new FileReader(a))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    // function for the writing in the file 
    public static void WriteFile(String a , Scanner sc){
        try(FileWriter writer = new FileWriter(a)){
            while(true){
                int n = 1;
                System.out.println("To Stop Enter 'Done' ");
                System.out.print("Enter the line (" + n +") : " );
                String line = sc.nextLine();
                if(line.equals("Done")){
                    break;
                }
                writer.write("\n"+line);
                n++;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        File dataDirectory = new File("../data");
        if(!dataDirectory.exists()){
            dataDirectory.mkdirs();
        }

        File file = new File(dataDirectory ,"data.txt");
        System.out.println("Current Directory :");
        System.out.println(System.getProperty("user.dir"));
        System.out.println("\nTrying to Create :");
        System.out.println(file.getAbsolutePath());
        try{
            if(file.createNewFile()){
                System.out.println("File has created Succesfully");
            } else {
                System.out.println("File has alredy Exists");
            }
        } catch (IOException e) {
            System.out.println("Something Went Wrong");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        WriteFile("../data/data.txt" , sc);
        info_file("../data/data.txt");
        ReadFile("../data/data.txt");
    }
}