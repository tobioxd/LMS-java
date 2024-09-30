import java.util.Scanner;

public class B31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter author name: ");
        String authorName = sc.nextLine();
        Author author = new Author(authorName);

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter number of pages: ");
        int noOfPages = sc.nextInt();

        System.out.print("Is it fiction (true/false): ");
        boolean fiction = sc.nextBoolean();

        Book book = new Book(author, title, noOfPages, fiction);

        System.out.println(book);

        sc.close();
    }
}

class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "author{name=" + name + "}";
    }
}

class Book {
    private Author author;
    private String title;
    private int noOfPages;
    private boolean fiction;

    public Book() {
    }

    public Book(Author author, String title, int noOfPages, boolean fiction) {
        this.author = author;
        this.title = title;
        this.noOfPages = noOfPages;
        this.fiction = fiction;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public boolean isFiction() {
        return fiction;
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }

    @Override
    public String toString() {
        return "Book{author=" + author + ", title=" + title + ", noOfPages=" + noOfPages + ", fiction=" + fiction + "}";
    }
}