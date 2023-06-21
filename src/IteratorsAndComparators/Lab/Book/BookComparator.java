package IteratorsAndComparators.Lab.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book bookOne, Book bookTwo) {
        int resTitle = bookOne.getTitle().compareTo(bookTwo.getTitle());
        if (resTitle == 0) {
            if (bookOne.getYear() > bookTwo.getYear()) {
                return 1;
            } else if (bookOne.getYear() < bookTwo.getYear()) {
                return -1;
            }
            return 0;
        } else {
            return resTitle;
        }
    }
}
