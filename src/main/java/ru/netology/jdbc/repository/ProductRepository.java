package ru.netology.jdbc.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.netology.jdbc.util.FileUtils;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private static final String PATH = "jdbc/";
    private static final String GET_PRODUCT_NAME_SQL = "findProductNameByCustomerName.sql";

    public String getProductName(String customerName) {
        String sql = FileUtils.readResourceAsString(PATH + GET_PRODUCT_NAME_SQL);
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("customer", customerName);
        return jdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }
}
