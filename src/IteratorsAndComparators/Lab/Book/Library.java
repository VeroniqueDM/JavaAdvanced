package IteratorsAndComparators.Lab.Book;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;

    @Override
    public Iterator iterator() {
        return new LibIterator();
    }

    public Library(Book... books) {
        this.books = books;
    }

    private final class LibIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter<books.length;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }
}
