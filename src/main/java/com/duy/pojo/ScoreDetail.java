/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "score_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScoreDetail.findAll", query = "SELECT s FROM ScoreDetail s"),
    @NamedQuery(name = "ScoreDetail.findByScoreId", query = "SELECT s FROM ScoreDetail s WHERE s.scoreId = :scoreId"),
    @NamedQuery(name = "ScoreDetail.findByScore1", query = "SELECT s FROM ScoreDetail s WHERE s.score1 = :score1"),
    @NamedQuery(name = "ScoreDetail.findByScore2", query = "SELECT s FROM ScoreDetail s WHERE s.score2 = :score2"),
    @NamedQuery(name = "ScoreDetail.findByScore3", query = "SELECT s FROM ScoreDetail s WHERE s.score3 = :score3"),
    @NamedQuery(name = "ScoreDetail.findByScore4", query = "SELECT s FROM ScoreDetail s WHERE s.score4 = :score4")})
public class ScoreDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "score_id")
    private Integer scoreId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score_1")
    private float score1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score_2")
    private float score2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score_3")
    private float score3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score_4")
    private float score4;
    @JoinColumn(name = "score_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Score score;

    public ScoreDetail() {
    }

    public ScoreDetail(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public ScoreDetail(Integer scoreId, float score1, float score2, float score3, float score4) {
        this.scoreId = scoreId;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    public float getScore4() {
        return score4;
    }

    public void setScore4(float score4) {
        this.score4 = score4;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scoreId != null ? scoreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ScoreDetail)) {
            return false;
        }
        ScoreDetail other = (ScoreDetail) object;
        if ((this.scoreId == null && other.scoreId != null) || (this.scoreId != null && !this.scoreId.equals(other.scoreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.duy.pojo.ScoreDetail[ scoreId=" + scoreId + " ]";
    }
    
}
