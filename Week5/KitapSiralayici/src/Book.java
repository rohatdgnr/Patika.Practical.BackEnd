public class Book implements Comparable<Book> {

    int year, pageCount;
    String author, name;

    public Book(String author, String name, int year, int page) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.pageCount = page;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int compareTo(Book o) {
        return o.getName().compareTo(getName());
    }
}