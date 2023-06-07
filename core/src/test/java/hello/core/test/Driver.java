package hello.core.test;

import hello.core.test.DIP.Database;

public class Driver {
    private final Database database;

    public Driver(Database database) {
        this.database = database;
    }

}
