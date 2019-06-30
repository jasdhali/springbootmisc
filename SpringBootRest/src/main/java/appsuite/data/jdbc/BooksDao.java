package appsuite.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import appsuite.domain.Book;

@Repository
public class BooksDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Book getStudent(Integer id) {
	      SimpleJdbcCall jdbcCall = new 
	         SimpleJdbcCall( jdbcTemplate ).withProcedureName("getRecord");

	      SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
	      Map<String, Object> out = jdbcCall.execute(in);

	      Book student = new Book();
	      student.setId(id);
	      student.setName( (String) out.get("out_name"));
	      student.setAuthor( (String) out.get("out_author"));
	      return student;      
	   }
	
	public Book getBooksById(long id) {
		/*
		 * jdbcTemplate
		 * .query("SELECT id, name,  author , price FROM Book WHERE name = ?", new
		 * Object[] { "Josh" }, (rs, rowNum) -> new Book(rs.getLong("id"),
		 * rs.getString("name"), rs.getString("name"))) .forEach(customer ->
		 * System.out.print(customer.toString()));
		 */
		String query = "SELECT * FROM Book WHERE ID = ?";
		Book employees = jdbcTemplate.queryForObject(query, new Object[] { id }, new BookRowMapper());
		return employees;
	}

	private class BookRowMapper implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book employee = new Book();

			employee.setId(rs.getInt("ID"));
			employee.setName(rs.getString("NAME"));
			employee.setAuthor(rs.getString("author"));
			employee.setPrice(100l);

			return employee;
		}
	}
}
