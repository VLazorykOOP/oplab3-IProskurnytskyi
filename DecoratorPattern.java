public class DecoratorPattern {
  public static void main(String[] args) {
      Component component = new ConcreteComponent();
      Component decoratedComponent = new ConcreteDecorator(component);

      decoratedComponent.operation();
  }

  interface Component {
      void operation();
  }

  static class ConcreteComponent implements Component {
      @Override
      public void operation() {
          System.out.println("ConcreteComponent operation");
      }
  }

  static abstract class Decorator implements Component {
      protected Component component;

      public Decorator(Component component) {
          this.component = component;
      }

      @Override
      public void operation() {
          component.operation();
      }
  }

  static class ConcreteDecorator extends Decorator {
      public ConcreteDecorator(Component component) {
          super(component);
      }

      @Override
      public void operation() {
          super.operation();
          addedBehavior();
      }

      private void addedBehavior() {
          System.out.println("ConcreteDecorator added behavior");
      }
  }
}
