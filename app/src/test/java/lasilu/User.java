package lasilu;

/**
 * User
 */
public class User {

  private int id;
  private String username;
  private String nama;
  private char gender;
  private String email; 
  private String password;

  public User(int id, String username, String nama, char gender, String email, String password){
    this.id = id;
    this.username = username;
    this.nama = nama;
    this.gender = gender;
    this.email = email;
    this.password = password;
  }
}
