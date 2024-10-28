import hashtable.*;

public class Main {

    public static void main(String[] args) {

        HashTable<String, String> table = new HashTable1<>(50);

        String filePath = "names_5000.csv";
        table.loadFromCSV(filePath);

        System.out.println("Conteúdo da HashTable após carregar o CSV:");
        table.display();

    }
}
