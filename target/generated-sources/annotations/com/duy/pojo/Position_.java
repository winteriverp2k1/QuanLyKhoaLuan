package com.duy.pojo;

import com.duy.pojo.CouncilPosition;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-08T18:46:29")
@StaticMetamodel(Position.class)
public class Position_ { 

    public static volatile SingularAttribute<Position, String> name;
    public static volatile SetAttribute<Position, CouncilPosition> councilPositionSet;
    public static volatile SingularAttribute<Position, Integer> id;

}