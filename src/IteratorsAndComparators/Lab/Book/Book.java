package IteratorsAndComparators.Lab.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        int resTitle = this.title.compareTo(o.title);
        if (resTitle == 0) {
            if (this.year > o.year) {
                return 1;
            } else if (this.year<o.year) {
                return -1;
            }
            return 0;
        } else {
            return resTitle;
        }
    }
}
//
//package IteratorsAndComparators.Lab.Book;
//
//        import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.List;
//        import java.util.stream.Collectors;
//
//public class Book {
////    -
////    title: String
////-
////    year: int
////-
////    authors: List<String>
//
//    private String title;
//    private int year;
//    private List<String> authors;
//
////
////    setTitle(String)
////-
////    setYear(String)
////-
////    setAuthors(String…)
////+
////    getTitle(): String
////+
////    getYear(): int
////+
////    getAuthors(): List<String>
//
//
//    public Book(String title, int year, String... authors) {
//        this.title = title;
//        this.year = year;
//        this.authors = new ArrayList<>(Arrays.asList(authors));
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public List<String> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(List<String> authors) {
//        this.authors = authors;
//    }
//}
