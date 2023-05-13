package lasilu;

/**
 * Soal
 */
public class Soal {

  private byte[] file;
  private MataPelajaran mataPelajaran;

  public Soal(byte[] file, MataPelajaran mataPelajaran){
    this.file = file;
    this.mataPelajaran = mataPelajaran;
  }

  public byte[] getFile(){
    return file;
  }

  public MataPelajaran getMapel(){
    return mataPelajaran;
  }

  public void setFile(byte[] file){
    this.file = file;
  }
}
