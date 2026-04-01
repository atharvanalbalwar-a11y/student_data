public class professor extends Setuser implements user {
    private String password;
    boolean login = false;
    String name;
    public boolean login(String s,int ID,String pass,database d){
        String p = d.data(ID,"professor");
        if(p.equals(s)) return true;
        return false;
    }
    public void setPassword(String s){
        password = s;
    }

    public void register(database d){
        d.adduser("professor",ID, name, password);
    }
}