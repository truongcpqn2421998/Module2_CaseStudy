package model.book;

public class BookFactory {
    public static Book getBook(BookType type,String title,String category,String code){
        switch (type){
            case ECONOMICBOOK:
                return new EconomicBook(title,category,code,true);
            case TECHNICALBOOK:
                return new TechnicalBooks(title,category,code,true);
            default:
                throw new IllegalArgumentException("ERROR");
        }
    }
}
