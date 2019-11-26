package FirstBook;

import java.util.HashSet;

public class HashSetDemo {
    class A{
        public boolean equals(Object o){
            return true;
        }
    }
    class B{
        public int hashCode(){
            return 1;
        }
    }
    class C{
        public int hashCode(){
            return 2;
        }
        public boolean equals(Object o){
            return false;
        }
    }

    public static void main(String[] args) {
        HashSet books = new HashSet();
        books.add(new HashSetDemo().new A());
        books.add(new HashSetDemo().new A());
        books.add(new HashSetDemo().new B());
        books.add(new HashSetDemo().new B());
        books.add(new HashSetDemo().new C());
        books.add(new HashSetDemo().new C());
        System.out.println(books);
    }
}
