package hello.core.test;

public class MySQL implements Database {
    @Override
    public void sendQuery() {
        System.out.println("send Query From MySQL");
    }
}
