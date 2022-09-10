package com.duy.pojo;

import com.duy.pojo.CouncilPosition;
import com.duy.pojo.ScoreDetail;
import com.duy.pojo.Thesis;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-10T17:17:43")
@StaticMetamodel(Score.class)
public class Score_ { 

    public static volatile SingularAttribute<Score, Thesis> thesisId;
    public static volatile SingularAttribute<Score, ScoreDetail> scoreDetail;
    public static volatile SingularAttribute<Score, Integer> id;
    public static volatile SingularAttribute<Score, CouncilPosition> councilPositionId;

}