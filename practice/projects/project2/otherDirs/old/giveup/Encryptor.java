public interface Encryptor {
  public String getAlgName();
  public void   init(char[] key) throws ASCIIOutOfRangeException;
  public String encrypt(String plain) throws ASCIIOutOfRangeException;
  public String decrypt(String cipher) throws ASCIIOutOfRangeException;
}
