package testdome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class Movie {
    public String name;
    public int year;
    public int rating;

    public Movie(){

    }
    public Movie(String name, int year, int rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setRating(int rating){
        this.rating =rating;
    }

}
@Configuration
@Import(MovieRepository.class)
class Config {
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        return ds;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource ds) {
        return new JdbcTemplate(ds);
    }
}
@Repository
public class MovieRepository {

    @Autowired
    private JdbcTemplate template;

    private String name;
    private int year;
    private int rating;

    @PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
    }

    @Transactional
    public void createMovie(String name, int year, int rating) {
        template.update("INSERT INTO MOVIES (NAME ,YEAR , RATING) VALUES (?, ?, ?)",
                new Object[]{name, year, rating});
    }

    public List<Movie> findMoviesByName(String likeName) {
        Object[] params = {likeName};
        String sql = "select * from movies where name like ?";
        return template.query(sql, params, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
                Movie movie = new Movie();
                movie.setName(resultSet.getString("name"));
                movie.setYear(resultSet.getInt("year"));
                movie.setRating(resultSet.getInt("rating"));

                return movie;
            }
        });
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
        config.register(Config.class);
        config.refresh();
        MovieRepository repository = config.getBean(MovieRepository.class);

        repository.createMovie("Some movie", 1974, 3);
        repository.createMovie("Some other movie", 1993, 2);

        List<Movie> movies = repository.findMoviesByName("Some%");
        for(Movie movie : movies) {
            System.out.println(movie.name + " - " + movie.year + " - " + movie.rating);
        }
    }
}