import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HellMachine {

    public static ArrayList<String> prepareToDieInCode(String line){

        line = line.replaceAll("[^А-яA-z0-9]+", " "); //не понял как именно, добавляет в начало пробел. Но без этого первое слово попадает в конец листа и криво считается отдельно.

        //вспомогательный просмотр произошедшего
            /*System.out.println("Что получилось после replaceAll: ");
            System.out.println(line);*/

        //разбиваем строку на массив слов, обрезая пробелы.
        String[] edLine = line.split(" ", -1);

        //вспомогательный просмотр произошедшего
            /*for (int i = 0; i < edLine.length; i++) {
                System.out.printf(edLine[i]); }*/
        ArrayList<String> wordList = new ArrayList<>();

        for (int i = 0; i < edLine.length; i++) {
            if (!edLine[i].equals(""))wordList.add(edLine[i]); }
        return wordList;
    }

    public static void someHashMapMagic(ArrayList<String> wordsOfPain) {
        //ХэшМэп, где String ключ - это слово, а значение Integer - счетчик повторения слова
        HashMap<String, Integer> wordToCount = new HashMap<>();
        String mostPopularWord = null;

        //Берем слова из нашего листа
        for (String word : wordsOfPain) {
            if (wordToCount.containsKey(word)) {
                wordToCount.put(word, wordToCount.get(word) + 1);
                //если наше слово на итерации совпадает с существующим ключом, перезаписываем его и увеличиваем значение счетчика повторения на 1

            } else {  //иначе если наше слово на итерации не совпадает с существующим ключом, то...
                if (mostPopularWord == null) mostPopularWord = word; //...если самое популярное слово ещё не задано, задаем его текущим словом
                wordToCount.put(word, 1); //...записываем слово в ХэщМэп и задаем значение счетчика = 1
            }
            if (wordToCount.get(word) > wordToCount.get(mostPopularWord)) mostPopularWord = word;
            // если значение счетчика у текущего слова больше значение счетчика самого популярного слова, то самое популярное слово = текущее

            //вспомогательный просмотр произошедшего
            /*System.out.println("hashmap: " + wordToCount);
            System.out.println("Самое популярное слово - : " + mostPopularWord);*/
        }

        //вспомогательный просмотр произошедшего
        //System.out.println("hashmaps");
        //System.out.println(wordToCount);

        //превращаем ХэшТаблицу в массив строк (без повторений).
        //сортируем полученный массив
        String[] sortedArray = wordToCount.keySet().toArray(new String[0]);
        Arrays.sort(sortedArray);

        //выводим всё в консоль.
        System.out.println("Самое популярное слово - " + mostPopularWord + "\nОно повторяется " + wordToCount.get(mostPopularWord) + " раз(а)\n");
        for (int index = 0; index < sortedArray.length; index++) {
            System.out.print(sortedArray[index] + "(" + wordToCount.get(sortedArray[index]) + ") ");
            if ((index + 1) % 10 == 0) System.out.println();
        }

    }
}