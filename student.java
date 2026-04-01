public class student extends Setuser implements user {
    private String password;
    boolean login = false;
    String name;
    public boolean login(String s,int ID,String password,database d){
        if(s.equals(password)){
            return d.data(ID);
        }
        return false;
    }
    public void setPassword(String s){
        password = s;
    }
    public void getName(String name){
        this.name = name;
    }
    public void register(database d){
        d.adduser("students",ID, name, password);
    }
    
}
