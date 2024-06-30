public class PrototypePattern {

  public static void main(String[] args) {
      ConcretePrototype original = new ConcretePrototype("Original");
      ConcretePrototype clone = (ConcretePrototype) original.clone();

      System.out.println("Original: " + original);
      System.out.println("Clone: " + clone);
  }

  interface Prototype {
      Prototype clone();
  }

  static class ConcretePrototype implements Prototype {
      private String field;

      public ConcretePrototype(String field) {
          this.field = field;
      }

      @Override
      public Prototype clone() {
          return new ConcretePrototype(this.field);
      }

      @Override
      public String toString() {
          return "ConcretePrototype{field='" + field + "'}";
      }
  }
}
