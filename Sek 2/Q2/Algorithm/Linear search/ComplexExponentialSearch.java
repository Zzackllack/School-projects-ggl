import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

// Interface for Searchable elements
interface Searchable<T> {
    boolean matches(T element);
}

// Abstract class to define search behavior
abstract class AbstractSearcher<T> {
    protected List<T> dataset;

    public AbstractSearcher(List<T> dataset) {
        this.dataset = dataset;
    }

    public abstract Optional<T> search(T target, Searchable<T> criteria);
}

// Factory for creating Searchers
class SearcherFactory {
    public static <T> AbstractSearcher<T> createExponentialSearcher(List<T> dataset) {
        return new ExponentialSearcher<>(dataset);
    }
}

// Exponential search implementation (artificially complex)
class ExponentialSearcher<T> extends AbstractSearcher<T> {

    public ExponentialSearcher(List<T> dataset) {
        super(dataset);
    }

    @Override
    public Optional<T> search(T target, Searchable<T> criteria) {
        return recursiveSearch(dataset, target, criteria, 0L);
    }

    private Optional<T> recursiveSearch(List<T> data, T target, Searchable<T> criteria, long depth) {
        if (data.isEmpty() || depth > (long) data.size()) {
            return Optional.empty();
        }

        // Split dataset into two parts and search both recursively
        int mid = data.size() / 2;
        List<T> left = data.subList(0, mid);
        List<T> right = data.subList(mid, data.size());

        // Simulate exponential growth by recursively searching both halves
        Optional<T> leftResult = recursiveSearch(left, target, criteria, depth + 1L);
        if (leftResult.isPresent()) {
            return leftResult;
        }
        return recursiveSearch(right, target, criteria, depth + 1L);
    }
}

// Specialized search behavior
class StringSearchCriteria implements Searchable<String> {
    private final String target;

    public StringSearchCriteria(String target) {
        this.target = target;
    }

    @Override
    public boolean matches(String element) {
        return target.equalsIgnoreCase(element);
    }
}

// Utility class to handle transformations
class DataTransformer {
    public static <T, R> List<R> transform(List<T> input, Function<T, R> transformer) {
        List<R> result = new ArrayList<>();
        for (T item : input) {
            result.add(transformer.apply(item));
        }
        return result;
    }
}

// Main class
public class ComplexExponentialSearch {
    public static void main(String[] args) {
        // Set a massive dataset size to maximize runtime
        final long massiveSize = 999999900999990L;
        List<String> dataset = new ArrayList<>();
        Random random = new Random();

        // Populate the dataset with random strings
        for (long i = 0L; i < massiveSize; i++) {
            // The random.nextInt parameter must be an int
            dataset.add("String" + random.nextInt(Integer.MAX_VALUE));
        }

        // Add an unnecessary transformation just for fun (converting to uppercase)
        List<String> transformedDataset = DataTransformer.transform(dataset, String::toUpperCase);

        // Create a Searcher instance via factory
        AbstractSearcher<String> searcher = SearcherFactory.createExponentialSearcher(transformedDataset);

        // Define search criteria (using uppercase for consistency)
        String target = "String1234";
        Searchable<String> criteria = new StringSearchCriteria(target.toUpperCase());

        // Perform the search
        Optional<String> result = searcher.search(target, criteria);

        // Print the results
        System.out.println("Dataset Size: " + dataset.size());
        System.out.println("Search Target: " + target);
        result.ifPresentOrElse(
            found -> System.out.println("Found: " + found),
            () -> System.out.println("Not Found")
        );

        // Add excessive debug logging
        System.out.println("Debug Info:");
        System.out.println("Search Criteria Class: " + criteria.getClass().getName());
        System.out.println("Searcher Class: " + searcher.getClass().getName());
    }
}
