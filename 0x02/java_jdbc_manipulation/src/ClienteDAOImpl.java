import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public Connection connect(String urlConexao) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConexao);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public void createTable(String urlConexao) {
        try (Connection connection = DriverManager.getConnection(urlConexao);
             Statement stmt = connection.createStatement();
        ) {
            String createTable = "CREATE TABLE IF NOT EXISTS clientes(\n" +
                    "  id Integer PRIMARY KEY AUTOINCREMENT,\n" +
                    "  nome varchar(255) not NULL,\n" +
                    "  idade Integer not NULL,\n" +
                    "  cpf varchar(10) not NULL,\n" +
                    "  rg varchar(7) not NULL\n" +
                    ");";
            stmt.executeUpdate(createTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        try(Connection connection = DriverManager.getConnection(url_conexao);) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO clientes (nome, idade, cpf, rg) VALUES(?, ?, ?, ?);");
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getRg());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        try (Connection connection = DriverManager.getConnection(urlConexao);) {
            Statement stmt = connection.createStatement();
            stmt.execute("SELECT * FROM clientes;");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        try (Connection connection = DriverManager.getConnection(urlConexao);) {
            PreparedStatement stmt = connection.prepareStatement("UPDATE clientes\n" +
                    "SET nome = ?, idade = ?\n" +
                    "WHERE id = ?;");
            stmt.setString(1, name);
            stmt.setInt(2, idade);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String urlConexao, int id) {

    }
}
