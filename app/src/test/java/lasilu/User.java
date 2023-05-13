package lasilu;

/**
 * User
 */
public class User {

  public int id;
  public String username;
  public String nama;
  public char gender;
  public String email; 
  public String password;

  public User(int id, String username, String nama, char gender, String email, String password){
    this.id = id;
    this.username = username;
    this.nama = nama;
    this.gender = gender;
    this.email = email;
    this.password = password;
  }

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public String getUsername(){
    return username;
  }

  public void setUsername(String username){
    this.username = username;
  }

  public String getNama(){
    return nama;
  }

  public void setNama(String nama){
    this.nama = nama;
  }

  public char getGender(){
    return gender;
  }

  public void setGender(char gender){
    this.gender = gender;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getPassword(){
    return password;
  }

  public void setPassword(String password){
    this.password = password;
  }
}
