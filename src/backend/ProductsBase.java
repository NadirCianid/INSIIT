package backend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ProductsBase {
    public static List<Product> products = new ArrayList<>();
    public static List<String> categories = new ArrayList<>();
    public static Product selectedProduct;

    public static void populateProductList() {
        products.add(new Product("Шампунь Жумайсынба",
                categories.get(1),
                "От перхоти",
                150,
                "Производитель - Казахстан",
                "Тот самый шампунь Жумайсынба. Попробуйте всемирно известную классику и ощутите свежесть и отсутствие перхоти."));

        products.get(0).addReview(new Review(5, "Уже после первого применения я увидел результат. Теперь я могу спокойно здороваться с братками и радоваться жизни!", "Браток"));
        products.get(0).addReview(new Review(2, "Заказывала мужу. Приехало быстро. Продавца рекомендую.", "Яжемать"));
    }

    public static void populateCategoriesList() {
        categories.add("Лицо");
        categories.add("Волосы");
        categories.add("Тело");
        categories.add("Ногти");
        categories.add("Все");
    }

    public static ObservableList<String> getCategories() {
        ObservableList<String> categoriesList = FXCollections.observableArrayList();
        categoriesList.addAll(categories);
        return categoriesList;
    }

    public static ObservableList<Product> getProducts() {
        ObservableList<Product> productObservableList = FXCollections.observableArrayList();
        productObservableList.addAll(products);
        return productObservableList;
    }

    public static ObservableList<Product> filter(String categoryFilter, String nameToBeDisplayed) {
        ObservableList<Product> productObservableList =  FXCollections.observableArrayList();

        List<Product> filteredProducts = products.stream()
                .filter(product -> (product.getCategory().equals(categoryFilter) || categoryFilter.equals("Все")) && product.getName().matches(nameToBeDisplayed + ".*"))
                .toList();

        productObservableList.addAll(filteredProducts);

        return productObservableList;
    }

}
