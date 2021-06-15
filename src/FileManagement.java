import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagement {
    public void writeToFile(String path , List<DanhBa>list){
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter =new FileWriter(path);
            bw = new BufferedWriter(fileWriter);
            bw.write("PHONE,GROUP,NAME,GENDER,ADDRESS,DATE OF BIRTH,EMAIL");
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i).getPhoneNumber()+","+list.get(i).getGroup()+","+list.get(i).getName()+","+list.get(i).getGender()+","+list.get(i).getAddress()+","+list.get(i).getDateOfBirth()+","+list.get(i).getEmail()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<DanhBa>readFile(String path){
        List<DanhBa>list=new ArrayList<>();
        FileReader fileReader;
        BufferedReader br = null ;
        try {
            fileReader = new FileReader(path);
            br = new BufferedReader(fileReader);
            String line = br.readLine();
            while ((line=br.readLine())!=null){
                String[] str = line.split(",");
                list.add(new DanhBa(str[0],str[1],str[2],str[3],str[4],str[5],str[6]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
