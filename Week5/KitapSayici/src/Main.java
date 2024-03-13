import java.util.TreeSet;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> book = new TreeSet<>();

        book.add(new Book("\nDoğuş Çetinoğlu", "\nKALEM ", 2000, 321));
        book.add(new Book("\nFurkan Aydemir", "\nMardinde Bir Gün ", 2002, 444));
        book.add(new Book("\nSemih Turan ", "\nSolo Türk ", 2020, 241));


        for (Book i : book.reversed()) {
            System.out.println(i.getName() + " " + i.getPageCount() + " " + i.getAuthor() + " " + i.getYear());
        }
        TreeSet<Book> book2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageCount() - o2.getPageCount();
            }
        });

        book.add(new Book("\nDoğuş Çetinoğlu", "\nKALEM ", 2000, 321));
        book.add(new Book("\nFurkan Aydemir", "\nMardinde Bir Gün ", 2002, 444));
        book.add(new Book("\nSemih Turan ", "\nSolo Türk ", 2020, 241));


        for (Book i : book2.reversed()) {
            System.out.println(i.getName() + " " + i.getPageCount() + " " + i.getAuthor() + " " + i.getYear());
        }
    }

}
