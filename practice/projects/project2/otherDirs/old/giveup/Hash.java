public interface Hash{
  public String getAlgName();
  public String hash(String password);
  public void init(String password);
}
