package lasilu;

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
}
