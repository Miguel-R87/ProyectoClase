package co.edu.uco.nose;

import co.edu.uco.nose.data.dao.factory.postgresql.PostgreSqlDaoFactory;

public class TestConnection {
    public static void main(String[] args) {
        try {
            var factory = new PostgreSqlDaoFactory(); 
            System.out.println("✅ Conexión establecida correctamente con PostgreSQL.");
        } catch (Exception e) {
            System.err.println("❌ Error al conectar con PostgreSQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
