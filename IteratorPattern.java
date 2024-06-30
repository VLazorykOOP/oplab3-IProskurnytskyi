import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorPattern {
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>(Arrays.asList("Item 1", "Item 2", "Item 3"));
        Iterator<String> iterator = aggregate.createIterator();

        while (iterator.hasNext()) {
            try {
                System.out.println(iterator.next());
            } catch (NoSuchElementException e) {
                System.err.println("No such element exception occurred.");
            }
        }
    }

    interface Iterator<T> {
        boolean hasNext();
        T next();
    }

    interface Aggregate<T> {
        Iterator<T> createIterator();
    }

    static class ConcreteAggregate<T> implements Aggregate<T> {
        private List<T> items;

        public ConcreteAggregate(List<T> items) {
            this.items = items;
        }

        @Override
        public Iterator<T> createIterator() {
            return new ConcreteIterator<>(items);
        }
    }

    static class ConcreteIterator<T> implements Iterator<T> {
        private List<T> items;
        private int position = 0;

        public ConcreteIterator(List<T> items) {
            this.items = items;
        }

        @Override
        public boolean hasNext() {
            return position < items.size();
        }

        @Override
        public T next() {
            try {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return items.get(position++);
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("No more elements available.");
            }
        }
    }
}
