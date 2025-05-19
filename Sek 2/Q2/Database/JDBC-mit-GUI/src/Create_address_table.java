public class Create_address_table {
    public void createTable() {
        try {
            // Create a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/world;create=true");

            // Create a statement
            Statement stmt = conn.createStatement();

            // SQL query to create the address table
            String sql = "CREATE TABLE IF NOT EXISTS address " +
                         "(id INT AUTO_INCREMENT PRIMARY KEY, " +
                         " firstName VARCHAR(255), " + 
                         " lastName VARCHAR(255), " + 
                         " phoneNum VARCHAR(255))";

            // Execute the query
            stmt.executeUpdate(sql);

            // Close the connection
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

    