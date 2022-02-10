public class GenericTest<T>{
  public static T holderVar;
  public GenericTest(T holder){
    this.holderVar = holder;
  }

  public static void main(String[] args){
    GenericTest<String> gt = new GenericTest("hello");
    GenericTest<Exception> gte = new GenericTest(new Exception("oops"));

    System.out.println("Holder var " + GenericTest.holderVar);
  }
}
