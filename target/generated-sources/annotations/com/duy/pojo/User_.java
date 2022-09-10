package com.duy.pojo;

import com.duy.pojo.CouncilPosition;
import com.duy.pojo.Faculty;
import com.duy.pojo.ThesisPosition;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-10T17:17:43")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Faculty> facultyId;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Date> createdDate;
    public static volatile SetAttribute<User, CouncilPosition> councilPositionSet;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> fullname;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SetAttribute<User, ThesisPosition> thesisPositionSet;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}