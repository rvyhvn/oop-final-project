package lasilu;

import java.sql.Date;
import java.text.DateFormat;

/**
 * Ujian
 */
public class Ujian {

  private Date tglUjian;
  private DateFormat jamUjian;

  public Ujian(Date tglUjian, DateFormat jamUjian){
    this.tglUjian = tglUjian;
    this.jamUjian = jamUjian;
  }

  public Date getTglUjian(){
    return tglUjian;
  }

  public DateFormat getJamUjian(){
    return jamUjian;
  }

  public void setTglUjian(Date tglUjian){
    this.tglUjian = tglUjian;
  }

  public void setJamUjian(DateFormat jamUjian){
    this.jamUjian = jamUjian;
  }
}
