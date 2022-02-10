public interface Hasher {
  public String getAlgName();
  public String hash(String plain);
}
