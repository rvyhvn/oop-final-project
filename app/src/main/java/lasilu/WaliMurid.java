package lasilu;

public class WaliMurid extends User {

  public WaliMurid(int id, String username, String nama, char gender, String email, String password) {
    super(id, username, nama, gender, email, password);
  }

  // Setter dan Getter
  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public String getNama() {
    return nama;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public char getGender() {
    return gender;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  // ToString
  @Override
  public String toString() {
    return "WaliMurid [id=" + id + ", username=" + username + ", nama=" + nama + ", gender=" + gender + ", email=" + email
        + ", password=" + password + "]";
  }
}
