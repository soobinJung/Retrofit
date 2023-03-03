package com.rsn.test.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLabelQna is a Querydsl query type for LabelQna
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLabelQna extends EntityPathBase<LabelQna> {

    private static final long serialVersionUID = 1561748428L;

    public static final QLabelQna labelQna = new QLabelQna("labelQna");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lqnAnswer = createString("lqnAnswer");

    public final StringPath lqnContent = createString("lqnContent");

    public final StringPath lqnTitle = createString("lqnTitle");

    public final DatePath<java.time.LocalDate> regDate = createDate("regDate", java.time.LocalDate.class);

    public final NumberPath<Long> regSeq = createNumber("regSeq", Long.class);

    public final DatePath<java.time.LocalDate> updDate = createDate("updDate", java.time.LocalDate.class);

    public final NumberPath<Long> updSeq = createNumber("updSeq", Long.class);

    public final StringPath useYn = createString("useYn");

    public QLabelQna(String variable) {
        super(LabelQna.class, forVariable(variable));
    }

    public QLabelQna(Path<? extends LabelQna> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLabelQna(PathMetadata metadata) {
        super(LabelQna.class, metadata);
    }

}

