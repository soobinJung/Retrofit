package com.rsn.test.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTestBoard is a Querydsl query type for TestBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTestBoard extends EntityPathBase<TestBoard> {

    private static final long serialVersionUID = 570325880L;

    public static final QTestBoard testBoard = new QTestBoard("testBoard");

    public final StringPath testName = createString("testName");

    public final NumberPath<Long> testSeq = createNumber("testSeq", Long.class);

    public QTestBoard(String variable) {
        super(TestBoard.class, forVariable(variable));
    }

    public QTestBoard(Path<? extends TestBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTestBoard(PathMetadata metadata) {
        super(TestBoard.class, metadata);
    }

}

