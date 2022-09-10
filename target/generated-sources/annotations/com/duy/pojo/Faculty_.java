package com.duy.pojo;

import com.duy.pojo.Council;
import com.duy.pojo.Thesis;
import com.duy.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-10T17:17:43")
@StaticMetamodel(Faculty.class)
public class Faculty_ { 

    public static volatile SetAttribute<Faculty, Council> councilSet;
    public static volatile SingularAttribute<Faculty, String> name;
    public static volatile SetAttribute<Faculty, Thesis> thesisSet;
    public static volatile SingularAttribute<Faculty, Integer> id;
    public static volatile SetAttribute<Faculty, User> userSet;

}