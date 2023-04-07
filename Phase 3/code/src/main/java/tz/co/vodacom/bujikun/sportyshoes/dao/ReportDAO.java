package tz.co.vodacom.bujikun.sportyshoes.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.sportyshoes.dto.ReportDTO;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class ReportDAO {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    public List<ReportDTO> getAll(){

        var query = """
                SELECT orders.created_on as createdOn,orders.id as orderId,username 
                FROM orders
                INNER JOIN users ON orders.fk_user_id = users.id
                ORDER BY orders.created_on DESC;
      """;
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ReportDTO.class));
    }
    public List<ReportDTO> queryAll(String startDate,String endDate){
        //fetch all orders in the given range from all categories
        var query = """
                SELECT orders.created_on as createdOn,orders.id as orderId,username 
                FROM products_categories
                INNER JOIN line_items on line_items.product_id = products_categories.fk_product_id
                INNER JOIN orders_line_items on orders_line_items.fk_item_id=line_items.id
                INNER JOIN orders on orders.id= orders_line_items.fk_order_id
                INNER JOIN users on users.id = orders.fk_user_id
                WHERE orders.created_on  between date(:startDate) and date(:endDate)
                GROUP BY orders.created_on,orders.id, username
                ORDER BY orders.created_on DESC;
                """;
        var params = new MapSqlParameterSource()
                .addValue("startDate",startDate)
                .addValue("endDate",endDate);
        return jdbcTemplate.query(query,params, BeanPropertyRowMapper.newInstance(ReportDTO.class));
    }

    public List<ReportDTO> queryPerCriteria(Integer categoryId,String startDate, String endDate){
        //fetch all orders in the given range from specified category
        var query = """
                SELECT orders.created_on as createdOn,orders.id as orderId,username 
                FROM products_categories
                INNER JOIN line_items on line_items.product_id = products_categories.fk_product_id
                INNER JOIN orders_line_items on orders_line_items.fk_item_id=line_items.id
                INNER JOIN orders on orders.id= orders_line_items.fk_order_id
                INNER JOIN users on users.id = orders.fk_user_id
                WHERE products_categories.fk_category_id= :categoryId and orders.created_on  between date(:startDate) and date(:endDate)
                GROUP BY orders.created_on,orders.id, username
                ORDER BY orders.created_on DESC;
                """;
        var params = new MapSqlParameterSource()
                .addValue("categoryId",categoryId)
                .addValue("startDate",startDate)
                .addValue("endDate",endDate);
        return jdbcTemplate.query(query,params, BeanPropertyRowMapper.newInstance(ReportDTO.class));

    }



}
