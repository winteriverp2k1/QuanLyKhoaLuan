package com.duy.pojo;

import com.duy.pojo.Council;
import com.duy.pojo.Position;
import com.duy.pojo.Score;
import com.duy.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-10T17:17:43")
@StaticMetamodel(CouncilPosition.class)
public class CouncilPosition_ { 

    public static volatile SingularAttribute<CouncilPosition, Position> positionId;
    public static volatile SingularAttribute<CouncilPosition, Council> councilId;
    public static volatile SingularAttribute<CouncilPosition, Integer> id;
    public static volatile SingularAttribute<CouncilPosition, User> userId;
    public static volatile SetAttribute<CouncilPosition, Score> scoreSet;

}