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
}
