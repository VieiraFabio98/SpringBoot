package io.github.vieirafabio98.domain.repository;

import io.github.vieirafabio98.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

    private static String INSERT = "insert into cliente (nome) values (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE ";
    private static String UPDATE = "UPDATE cliente set nome = ? where id = ? ";
    private static String DELETE = "DELETE from cliente where id = ? ";
    private static String SELECT_BY_NAME = "SELECT * FROM CLIENTE where nome like ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente create(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public Cliente update(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{
                cliente.getNome(),
                cliente.getId()});
        return cliente;
    }

    public void delete(Cliente cliente){
        delete(cliente.getId());
    }

    public void delete(Integer id) {
        jdbcTemplate.update(DELETE, new Object[]{id});
    }

    public List<Cliente> listByName(String nome){
        return jdbcTemplate.query(SELECT_BY_NAME,
                new Object[]{"%" + nome + "%"},
                ClienteMapper());
    }

    public List<Cliente> list(){
        return jdbcTemplate.query(SELECT_ALL, ClienteMapper());
    }

    private RowMapper<Cliente> ClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new Cliente (id, nome);
            }
        };
    }
}
