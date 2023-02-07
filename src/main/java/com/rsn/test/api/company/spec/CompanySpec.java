package com.rsn.test.api.company.spec;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.rsn.test.common.dsl.QueryDslUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static com.rsn.test.domain.QCompany.company;

public class CompanySpec {

    public static final CompanySpec spec = new CompanySpec();

    public OrderSpecifier[] getAllOrderSpecifiers(Pageable pageable) {
        List<OrderSpecifier> ORDERS = new ArrayList<>();

        if (!(pageable.getSort().isEmpty())) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;

                switch (order.getProperty()) {
                    case "comName":
                        ORDERS.add(QueryDslUtil.getSortedColumn(direction, company.comName, "comName"));
                        break; 
                    default:
                        break;
                }
            }
        }
        return ORDERS.stream().toArray(OrderSpecifier[]::new);
    }

    /**
     * 고객사명 검색
     */
    public BooleanExpression comNameEq(String comName) {
        return !StringUtils.isBlank(comName) ? company.comName.contains(comName) : null;
    }
}
