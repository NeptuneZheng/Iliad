package utils;
import org.apache.commons.io.FileUtils

public class DivideFile {
    private String oriFolder
    private String desFolder
    private String desI
    private String desO
    private String desXml

    DivideFile() {
    }

    DivideFile(String oriFolder, String desFolder) {
        this.oriFolder = oriFolder
        this.desFolder = desFolder
        this.desI = desFolder + "/I"
        this.desO = desFolder + "/O"
        this.desXml = desFolder + "/XML"
    }

    DivideFile(String oriFolder, String desI, String desO, String desXml) {
        this.oriFolder = oriFolder
        this.desI = desI
        this.desO = desO
        this.desXml = desXml
    }

    public void divide(){
        if(!this.oriFolder){
            throw new FileNotFoundException("must provide original folder path for file divide ")
        }
        createFolder(this.desI,this.desO,this.desXml)
        doDevid(this.desFolder,this.desI,this.desO,this.desXml)
    }

    public static void main(String[] args) throws IOException {
        String data_path = "D:\\1_B2BEDI_Revamp\\DOCUIF\\OUT_310\\HASHASUK\\resources\\data\\20190417_20190516";
        String dest_path_I = "D:\\1_B2BEDI_Revamp\\DOCUIF\\OUT_310\\HASHASUK\\InputData";
        String dest_path_O = "D:\\1_B2BEDI_Revamp\\DOCUIF\\OUT_310\\HASHASUK\\ExpectedComplete";
        String dest_path_XML = "D:\\1_B2BEDI_Revamp\\DOCUIF\\OUT_310\\HASHASUK\\resources\\data\\XML";

        DivideFile divide = new DivideFile(data_path,dest_path_I,dest_path_O,dest_path_XML)

        divide.createFolder(dest_path_I,dest_path_O,dest_path_XML);

        divide.doDevid(data_path,dest_path_I,dest_path_O,dest_path_XML);

    }

    private void createFolder(String... paths){
        File file;
        for (String path : paths){
            file = new File(path);
            file.mkdirs();
        }
    }

    private void doDevid(String data_path, String dest_path_i, String dest_path_o, String dest_path_XML) throws IOException {
        File files = new File(data_path);
        System.out.println("total file size: " + files.listFiles().length);
        int count = 0;
        for(File file: files.listFiles()){
            count ++;
            System.out.println("Copy : " + count + ", " + file.getName());
            if(file.isFile()){
                if(file.getName().endsWith(".out") && dest_path_o != null){
                    FileUtils.copyFile(file,new File(dest_path_o+"/"+file.getName()));
                }else if(file.getName().endsWith(".xml") && dest_path_XML != null){
                    FileUtils.copyFile(file,new File(dest_path_XML+"/"+file.getName()));
                }else{
                    FileUtils.copyFile(file,new File(dest_path_i+"/"+file.getName()));
                }
            }else if(file.isDirectory()){
                doDevid(file.getAbsolutePath(),dest_path_i,dest_path_o,dest_path_XML);
            }
        }
    }
}
