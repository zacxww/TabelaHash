import hashtable.*;

public class Main {

    public static void main(String[] args) {

        HashTable<String, String> tabela = new HashTable1<>(100);

        String caminho = "female_names.txt";
        tabela.lerTXT(caminho);

        tabela.display();
    }
}
