class Init {

    companion object {

        fun createTables(client: Client) {
            val sql = """
                CREATE TABLE Book(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    publishYear INTEGER
                );
                    
                CREATE TABLE Author(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    birthYear INTEGER
                );
                    
                CREATE TABLE BookAuthor(
                    bookId INTEGER NOT NULL ,
                    authorId INTEGER NOT NULL,
                    FOREIGN KEY (bookId) REFERENCES Book(id)
                    FOREIGN KEY (authorId) REFERENCES Author(id)
                );
                    
                CREATE TABLE Customer(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    age INTEGER CHECK(age > 14)
                );
                
                CREATE TABLE BookBuying(
                    id INTEGER PRIMARY KEY,
                    bookId INTEGER NOT NULL,
                    customerID INTEGER NOT NULL,
                    date TEXT NOT NULL,
                    FOREIGN KEY (bookId) REFERENCES Book(id)
                    FOREIGN KEY (customerID) REFERENCES Customer(id)
                );"""
            client.executeUpdate(sql)
        }

        fun insertInto(client: Client){
            val sql = """
                INSERT INTO Book(name, publishYear)
                    VALUES
                        ("Преступление и наказание", 2002),
                        ("Идиот", 2001),
                        ("Мастер и Маргарита", 2001),
                        ("Капитанская дочка", 2003),
                        ("Двенадцать стульев", 2005);
                
                INSERT INTO Author(name, birthYear)
                    VALUES
                        ("Достоевский", 1821),
                        ("Булгаков", 1891),
                        ("Пушкин", 1799),
                        ("Ильф", 1897),
                        ("Петров", 1903);
                
                INSERT INTO BookAuthor(bookId, authorId)
                    VALUES
                        (1,1),
                        (2,1),
                        (3,2),
                        (4,3),
                        (5,4),
                        (5,5);
                
                INSERT INTO Customer(name, age)
                    VALUES
                        ("Сидоров", 20),
                        ("Иванов", 30),
                        ("Петров", 40),
                        ("Никитин", 50);
                        
                INSERT INTO BookBuying(bookId, customerId, date)
                    VALUES
                        (1, 1, "05.05.2020"),
                        (2, 1, "02.07.2019"),
                        (2, 2, "05.04.2020"),
                        (3, 4, "05.04.2020"),
                        (1, 3, "09.01.2021");
            """.trimIndent()

            client.executeUpdate(sql)
        }

        fun dropTable(client: Client){
            val sql = """
                DROP TABLE BookBuying;
                DROP TABLE Customer;
                DROP TABLE BookAuthor;
                DROP TABLE Author;
                DROP TABLE Book;
            """.trimIndent()
            client.executeUpdate(sql)
        }

    }

}