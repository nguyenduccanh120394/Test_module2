import java.util.ArrayList;
import java.util.List;

public class QuanLyDanhBa implements Manager<DanhBa> {
    private List<DanhBa>list;
    public QuanLyDanhBa(){
        list=new ArrayList<>();
    }
    public List<DanhBa> getList(){
        return list;
    }
    @Override
    public void add(DanhBa danhBa) {
        list.add(danhBa);
    }

    @Override
    public void edit(DanhBa danhBa, String phoneNumber) {
        int index = checkIndex(phoneNumber);
        if (index==-1){
            System.out.println("Not Found");
        }else {
            list.set(index,danhBa);
        }
    }

    @Override
    public void delete(String phoneNumber) {
        int index = checkIndex(phoneNumber);
        if (index==-1){
            System.out.println("Not Found");
        }else {
            list.remove(index);
        }

    }

    @Override
    public void disPlay() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    @Override
    public int checkIndex(String phoneNumber) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phoneNumber)){
                return i;
            }
        }
        return -1;
    }
    public List<DanhBa> searchByPhone(String phoneNUmber){
        List<DanhBa>list = new ArrayList<>();
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).getPhoneNumber().contains(phoneNUmber)){
                list.add(getList().get(i));
            }
        }
        return list;
    }
    public boolean checkOnList(String phone){
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).getPhoneNumber().equals(phone)){
                return true;
            }
        }
        return false;
    }
    public List<DanhBa>searchByName(String name){
        List<DanhBa>list= new ArrayList<>();
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).getName().contains(name)){
                list.add(getList().get(i));
            }
        }
        return list;
    }

}
