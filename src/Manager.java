public interface Manager<T> {
    void add(T t);
    void edit(T t,String phoneNumber);
    void delete(String phoneNumber);
    void disPlay();
    int checkIndex(String phoneNumber);
}
