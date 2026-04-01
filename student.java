public class student extends Setuser implements user {
    private String password;
    String name;
    public boolean login(String s,int ID,String password,database d){
        String p = d.data(ID,"students");
        if(p.equals(s)) return true;
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
