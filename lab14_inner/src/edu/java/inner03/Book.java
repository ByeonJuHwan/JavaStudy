package edu.java.inner03;

public class Book {
    // Builder(Factory)패턴
    public static class BookBuilder{
        private String title;
        private String author;
        private String category;
        
        private BookBuilder() {}
        
        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }
        
        public BookBuilder category(String category) {
            this.category = category;
            return this;
        }
        
        public Book build() {
            return new Book(title,author,category);
        }
    }
    
    public static BookBuilder builder() {
        // 외부 클래스에서 내부 클래스의 private 생성자를 호출할 수 있음.
        return new BookBuilder();
    }
    
    private String title;
    private String author;
    private String category;
    
    private Book() {}

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    @Override
    public String toString() {
        
        return String.format("Book(title = %s, author = %s, category =%s)", title, author, category);
    }
    
}
