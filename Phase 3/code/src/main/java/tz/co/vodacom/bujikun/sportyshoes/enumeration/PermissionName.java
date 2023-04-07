package tz.co.vodacom.bujikun.sportyshoes.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum PermissionName {
    ADMIN_ADD("admin:add"),
    ADMIN_REVOKE("admin:revoke"),

    CART_VIEW("cart:view"),

    CATEGORY_ADD("category:add"),
    CATEGORY_DELETE("category:delete"),
    CATEGORY_EDIT("category:edit"),
    CATEGORY_LINK_PRODUCT("category:link:product"),
    CATEGORY_VIEW("category:view"),
    CATEGORY_VIEW_ALL("category:view:all"),

    MANAGE_VIEW("manage:view"),

    ORDER_CREATE("order:create"),
    ORDER_VIEW("order:view"),
    ORDER_VIEW_ALL("order:view:all"),

    PRODUCT_ADD("product:add"),
    PRODUCT_DELETE("product:delete"),
    PRODUCT_EDIT("product:edit"),
    PRODUCT_LINK_CATEGORY("product:link:category"),
    PRODUCT_VIEW("product:view"),

    REPORT_VIEW("report:view"),

    STOCK_VIEW("stock:view"),

    USER_CHANGE_PASSWORD("user:change-password"),
    USER_DELETE("user:delete"),
    USER_EDIT("user:edit"),
    USER_VIEW("user:view"),
    USER_VIEW_ALL("user:view:all");

    private String value;
}
