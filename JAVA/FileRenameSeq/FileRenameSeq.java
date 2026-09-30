import java.io.File;
import java.util.Scanner;

class FileRenameSeq{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the folder path :");
        String folderPath = sc.nextLine();
        
        
        File folder = new File(folderPath);
        // check the folder exist or not 
        if(!folder.exists()){
            System.out.println("The folder is not exist");
            return;
        }
        if(!folder.isDirectory()){
            System.out.println("the is not the directory");
            return;
        }
        
        System.out.print("Enter the base name :");
        String baseName = sc.nextLine();
        
        File[] files = folder.listFiles();

        if(files == null){
            System.out.println(" Can't read These folder ");
            return;
        }
        
        int count = 1;

        for(File file : files){

            String oldName = file.getName();

            int dotIndex = oldName.lastIndexOf(".");

            String extension = " ";

            if(dotIndex != -1){
                extension = oldName.substring(dotIndex);

                String newName = baseName + count + extension;
    
                File newFile = new File(folder , newName);
    
                boolean renamed = file.renameTo(newFile);
    
                if (renamed) {
                        System.out.println(
                            oldName + " -> " + newName
                        );
                    } else {
                        System.out.println(
                            "Failed to rename: " + oldName
                        );
                    }
                    count++;
                }

            }
            sc.close();
            System.out.println("Renaming completed...!");
    }
}