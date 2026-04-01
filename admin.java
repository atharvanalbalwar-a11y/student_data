public class admin extends Setuser implements user{
    private String password = "New_Admin@123";
    boolean login = false;
    String name;
    
    public boolean login(String s,int ID,String password,database d){
        String p = d.data(ID,"admins");
        if(s.equals(this.password) && this.password.equals(s)) return true;
        return false;
    }
    public void register(database d,String p){
        if(p.equals(password))
        d.adduser("admins", ID, name, password);
        else{
            System.out.println("WRONG PASSWORD NEW ADMIN WILL NOT BE REGISTERED!!");
            return;
        }
    }
}
