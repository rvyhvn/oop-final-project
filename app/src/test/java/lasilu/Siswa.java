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
}
