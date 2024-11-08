import hashtable.*;

public class Main {

    public static void main(String[] args) {

        HashTable<String, String> tabela1 = new HashTable1<>(5000);
        HashTable<String, String> tabela2 = new HashTable2<>(5000);

        String caminho = "female_names.txt";

        long inicioInsersao1 = System.nanoTime();
        tabela1.lerTXT(caminho);
        long fimInsersao1 = System.nanoTime();
        long totalInsercao1 = fimInsersao1 - inicioInsersao1;

        //tabela1.display(); // PRINT DA TABELA SE NECESSARIO

        System.out.println("TABELA 1:");
        System.out.println("----------------------------//----------------------------");
        System.out.println("Tempo de Insercao: " + totalInsercao1 + "ns");
        System.out.println("----------------------------//----------------------------");
        System.out.println("Colisoes: " + tabela1.getColisoes());
        System.out.println("----------------------------//----------------------------");
        tabela1.numChaves();

        long inicioInsersao2 = System.nanoTime();
        tabela2.lerTXT(caminho);
        long fimInsersao2 = System.nanoTime();
        long totalInsercao2 = fimInsersao2 - inicioInsersao2;

        //tabela2.display(); // PRINT DA TABELA SE NECESSARIO

        System.out.println("TABELA 2:");
        System.out.println("----------------------------//----------------------------");
        System.out.println("Tempo de Insercao: " + totalInsercao2 + "ns");
        System.out.println("----------------------------//----------------------------");
        System.out.println("Colisoes: " + tabela2.getColisoes());
        System.out.println("----------------------------//----------------------------");
        tabela2.numChaves();

        // COM MUITO AMOR LUCAS ZACARIAS
    }
}
