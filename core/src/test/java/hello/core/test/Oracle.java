package hello.core.test;

public class Oracle implements Database {

    @Override
    public void sendQuery() {
        System.out.println("send Query From Oracle");
    }
}
