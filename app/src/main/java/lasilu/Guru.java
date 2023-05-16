package lasilu;

import lasilu.MataPelajaran;
/**
 * Guru
 */
public class Guru extends User{

  private int nip;
  private MataPelajaran mataPelajaran;

  public Guru(int id, String username, String nama, char gender, String email, String password, int nip, MataPelajaran mataPelajaran){
    super(id, username, nama, gender, email, password);
    this.nip = nip;
    this.mataPelajaran = mataPelajaran;
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

  public MataPelajaran getMapel(){
    return mataPelajaran;
  }

  public int getNip(){
    return nip;
  }

  public void setNip(int nip){
    this.nip = nip;
  }
}
