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

  public int getNis(){
    return nis;
  }

  public void setNis(int nis){
    this.nis = nis;
  }
}
