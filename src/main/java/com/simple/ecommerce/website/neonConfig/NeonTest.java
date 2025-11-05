package com.simple.ecommerce.website.neonConfig;




import java.sql.Connection;
import java.sql.DriverManager;




public class NeonTest {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://ep-summer-bonus-abbhha3k-pooler.eu-west-2.aws.neon.tech/neondb?sslmode=require";
        String user = "neondb_owner";
        String password = "npg_9voEGR7TmjtO";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connection successful!");
        } catch (Exception e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
    }
}
