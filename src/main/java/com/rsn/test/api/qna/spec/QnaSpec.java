package com.rsn.test.api.qna.spec;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.rsn.test.common.dsl.QueryDslUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.rsn.test.domain.QLabelQna.labelQna;

@Component
public class QnaSpec {

    public static final QnaSpec spec = new QnaSpec();

    public OrderSpecifier[] getAllOrderSpecifiers(Pageable pageable) {
        List<OrderSpecifier> ORDERS = new ArrayList<>();

        if (!(pageable.getSort().isEmpty())) {
            for (Sort.Order order : pageable.getSort()) {
                Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;

                switch (order.getProperty()) {
                    case "lqnTitle":
                        ORDERS.add(QueryDslUtil.getSortedColumn(direction, labelQna.lqnTitle, "lqnTitle"));
                        break;
                    case "lqnContent":
                        ORDERS.add(QueryDslUtil.getSortedColumn(direction, labelQna.lqnContent, "lqnContent"));
                        break;
                    case "lqnAnswer":
                        ORDERS.add(QueryDslUtil.getSortedColumn(direction, labelQna.lqnAnswer, "lqnAnswer"));
                        break;
                    default:
                        break;
                }
            }
        }
        return ORDERS.stream().toArray(OrderSpecifier[]::new);
    }

    /**
     * 제목 검색
     */
    public BooleanExpression lqnTitleEq(String lqnTitle) {
        return !StringUtils.isBlank(lqnTitle) ? labelQna.lqnTitle.contains(lqnTitle) : null;
    }

    /**
     * 내용 검색
     */
    public BooleanExpression lqnContentEq(String lqnContent) {
        return !StringUtils.isBlank(lqnContent) ? labelQna.lqnContent.contains(lqnContent) : null;
    }

    /**
     * 답변 검색
     */
    public BooleanExpression lqnAnswerEq(String lqnAnswer) {
        return !StringUtils.isBlank(lqnAnswer) ? labelQna.lqnAnswer.contains(lqnAnswer) : null;
    }
}
