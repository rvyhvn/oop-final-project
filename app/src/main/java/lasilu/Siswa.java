package lasilu;

/**
 * Siswa
 */
public class Siswa extends User{

  private int nis;

  public Siswa(int id, String username, String nama, char gender, String email, String password, int nis){
    super(id, username, nama, gender, email, password);
    this.nis = nis;
  }

  public int getId(){
    return id; 
  }

  public String getUsername(){
    return username;
  }

  public String getNama(){
    return nama;
  }

  public char getGender(){
    return gender;
  }

  public String getEmail(){
    return email;
  }

  public String getPassword(){
    return password;
  }

  public int getNis(){
    return nis;
  }

  public void setNis(int nis){
    this.nis = nis;
  }
}
