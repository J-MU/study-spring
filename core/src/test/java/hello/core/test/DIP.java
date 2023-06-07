package hello.core.test;

import org.junit.jupiter.api.Test;

public class DIP {

    @Test
    void independentDataBase() {
        Database db=new MySQL();

        db.sendQuery();
    }

    
    interface Database{
        public void sendQuery();
    }

    static class MySQL implements Database {
        public void sendQuery() {
            System.out.println("query 보냄 from MySQL");
        }
    }

    static class Oracle implements Database{
        public void sendQuery() {
            System.out.println("query 보냄 from Oracle");
        }
    }

}
