package lasilu;

/**
 * MataPelajaran
 */
public class MataPelajaran {

  private int idMapel;
  private byte[] fileSilabus;

  public MataPelajaran(int idMapel, byte[] fileSilabus){
    this.idMapel = idMapel;
    this.fileSilabus = fileSilabus;
  }

  public int getIdMapel(){
    return idMapel;
  }

  public byte[] getFileSilabus(){
    return fileSilabus;
  }

  public void setIdMapel(int idMapel){
    this.idMapel = idMapel;
  }

  public void setFileSilabus(byte[] fileSilabus){
    this.fileSilabus = fileSilabus;
  }
}
