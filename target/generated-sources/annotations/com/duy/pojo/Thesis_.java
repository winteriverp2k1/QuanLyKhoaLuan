package com.duy.pojo;

import com.duy.pojo.Council;
import com.duy.pojo.Faculty;
import com.duy.pojo.Score;
import com.duy.pojo.ThesisPosition;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-09-10T17:17:43")
@StaticMetamodel(Thesis.class)
public class Thesis_ { 

    public static volatile SingularAttribute<Thesis, Faculty> facultyId;
    public static volatile SingularAttribute<Thesis, Integer> year;
    public static volatile SingularAttribute<Thesis, Council> councilId;
    public static volatile SingularAttribute<Thesis, String> name;
    public static volatile SingularAttribute<Thesis, Integer> id;
    public static volatile SingularAttribute<Thesis, Float> totalScore;
    public static volatile SetAttribute<Thesis, ThesisPosition> thesisPositionSet;
    public static volatile SetAttribute<Thesis, Score> scoreSet;

}