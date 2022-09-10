package com.duy.pojo;

import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Faculty;
import com.duy.pojo.Thesis;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-08T18:46:29")
@StaticMetamodel(Council.class)
public class Council_ { 

    public static volatile SingularAttribute<Council, Faculty> facultyId;
    public static volatile SingularAttribute<Council, Date> createdDate;
    public static volatile SingularAttribute<Council, String> name;
    public static volatile SetAttribute<Council, CouncilPosition> councilPositionSet;
    public static volatile SingularAttribute<Council, Integer> active;
    public static volatile SetAttribute<Council, Thesis> thesisSet;
    public static volatile SingularAttribute<Council, Integer> id;

}