package tz.co.vodacom.bujikun.sportyshoes.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCategoryDAO {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public void linkProductCategory(Integer fkProductId, Integer fkCategoryId){
        var query = "INSERT INTO products_categories(fk_product_id, fk_category_id) VALUES (:fk_product_id , :fk_category_id)";
        var params = new MapSqlParameterSource()
                .addValue("fk_product_id",fkProductId)
                .addValue("fk_category_id",fkCategoryId);

        //TODO could generate exception in case of an existing pairing, handle for error
        jdbcTemplate.update(query,params);
    }
}
