
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class AllWereStolenBeforeUs {
    public static void main(String[] args) {

        String line = new String();
        try {
            Scanner sc = new Scanner(new FileReader(new File("G:\\GitHub\\CollectionsL\\SomeText.txt")));
            line = sc.nextLine();

            //вспомогательный просмотр произошедшего
            /*System.out.println("Что получилось прочитать из файла: ");
            System.out.println(line);*/


        } catch (IOException ex)
        {
            System.out.println(ex);
        }


        ArrayList<String> wordsOfPain = HellMachine.prepareToDieInCode(new String(line));
        System.out.println("Результат анализа ниже:");
        HellMachine.someHashMapMagic(wordsOfPain);

    }
}