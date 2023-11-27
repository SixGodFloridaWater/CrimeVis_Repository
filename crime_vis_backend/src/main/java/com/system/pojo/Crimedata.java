package com.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName crimedata
 */
@TableName(value ="crimedata")
@Data
public class Crimedata implements Serializable {
    /**
     * 
     */
    private Integer drNo;

    /**
     * 
     */
    private String dateRptd;

    /**
     * 
     */
    private String dateOcc;

    /**
     * 
     */
    private Integer timeOcc;

    /**
     * 
     */
    private Integer area;

    /**
     * 
     */
    private String areaName;

    /**
     * 
     */
    private Integer rptDistNo;

    /**
     * 
     */
    private Integer part12;

    /**
     * 
     */
    private Integer crmCd;

    /**
     * 
     */
    private String crmCdDesc;

    /**
     * 
     */
    private String mocodes;

    /**
     * 
     */
    private Integer victAge;

    /**
     * 
     */
    private String victSex;

    /**
     * 
     */
    private String victDescent;

    /**
     * 
     */
    private Integer premisCd;

    /**
     * 
     */
    private String premisDesc;

    /**
     * 
     */
    private Integer weaponUsedCd;

    /**
     * 
     */
    private String weaponDesc;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String statusDesc;

    /**
     * 
     */
    private Integer crmCd1;

    /**
     * 
     */
    private Integer crmCd2;

    /**
     * 
     */
    private Integer crmCd3;

    /**
     * 
     */
    private String crmCd4;

    /**
     * 
     */
    private String location;

    /**
     * 
     */
    private String crossStreet;

    /**
     * 
     */
    private Double lat;

    /**
     * 
     */
    private Double lon;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Crimedata other = (Crimedata) that;
        return (this.getDrNo() == null ? other.getDrNo() == null : this.getDrNo().equals(other.getDrNo()))
            && (this.getDateRptd() == null ? other.getDateRptd() == null : this.getDateRptd().equals(other.getDateRptd()))
            && (this.getDateOcc() == null ? other.getDateOcc() == null : this.getDateOcc().equals(other.getDateOcc()))
            && (this.getTimeOcc() == null ? other.getTimeOcc() == null : this.getTimeOcc().equals(other.getTimeOcc()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getRptDistNo() == null ? other.getRptDistNo() == null : this.getRptDistNo().equals(other.getRptDistNo()))
            && (this.getPart12() == null ? other.getPart12() == null : this.getPart12().equals(other.getPart12()))
            && (this.getCrmCd() == null ? other.getCrmCd() == null : this.getCrmCd().equals(other.getCrmCd()))
            && (this.getCrmCdDesc() == null ? other.getCrmCdDesc() == null : this.getCrmCdDesc().equals(other.getCrmCdDesc()))
            && (this.getMocodes() == null ? other.getMocodes() == null : this.getMocodes().equals(other.getMocodes()))
            && (this.getVictAge() == null ? other.getVictAge() == null : this.getVictAge().equals(other.getVictAge()))
            && (this.getVictSex() == null ? other.getVictSex() == null : this.getVictSex().equals(other.getVictSex()))
            && (this.getVictDescent() == null ? other.getVictDescent() == null : this.getVictDescent().equals(other.getVictDescent()))
            && (this.getPremisCd() == null ? other.getPremisCd() == null : this.getPremisCd().equals(other.getPremisCd()))
            && (this.getPremisDesc() == null ? other.getPremisDesc() == null : this.getPremisDesc().equals(other.getPremisDesc()))
            && (this.getWeaponUsedCd() == null ? other.getWeaponUsedCd() == null : this.getWeaponUsedCd().equals(other.getWeaponUsedCd()))
            && (this.getWeaponDesc() == null ? other.getWeaponDesc() == null : this.getWeaponDesc().equals(other.getWeaponDesc()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStatusDesc() == null ? other.getStatusDesc() == null : this.getStatusDesc().equals(other.getStatusDesc()))
            && (this.getCrmCd1() == null ? other.getCrmCd1() == null : this.getCrmCd1().equals(other.getCrmCd1()))
            && (this.getCrmCd2() == null ? other.getCrmCd2() == null : this.getCrmCd2().equals(other.getCrmCd2()))
            && (this.getCrmCd3() == null ? other.getCrmCd3() == null : this.getCrmCd3().equals(other.getCrmCd3()))
            && (this.getCrmCd4() == null ? other.getCrmCd4() == null : this.getCrmCd4().equals(other.getCrmCd4()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getCrossStreet() == null ? other.getCrossStreet() == null : this.getCrossStreet().equals(other.getCrossStreet()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLon() == null ? other.getLon() == null : this.getLon().equals(other.getLon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrNo() == null) ? 0 : getDrNo().hashCode());
        result = prime * result + ((getDateRptd() == null) ? 0 : getDateRptd().hashCode());
        result = prime * result + ((getDateOcc() == null) ? 0 : getDateOcc().hashCode());
        result = prime * result + ((getTimeOcc() == null) ? 0 : getTimeOcc().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getRptDistNo() == null) ? 0 : getRptDistNo().hashCode());
        result = prime * result + ((getPart12() == null) ? 0 : getPart12().hashCode());
        result = prime * result + ((getCrmCd() == null) ? 0 : getCrmCd().hashCode());
        result = prime * result + ((getCrmCdDesc() == null) ? 0 : getCrmCdDesc().hashCode());
        result = prime * result + ((getMocodes() == null) ? 0 : getMocodes().hashCode());
        result = prime * result + ((getVictAge() == null) ? 0 : getVictAge().hashCode());
        result = prime * result + ((getVictSex() == null) ? 0 : getVictSex().hashCode());
        result = prime * result + ((getVictDescent() == null) ? 0 : getVictDescent().hashCode());
        result = prime * result + ((getPremisCd() == null) ? 0 : getPremisCd().hashCode());
        result = prime * result + ((getPremisDesc() == null) ? 0 : getPremisDesc().hashCode());
        result = prime * result + ((getWeaponUsedCd() == null) ? 0 : getWeaponUsedCd().hashCode());
        result = prime * result + ((getWeaponDesc() == null) ? 0 : getWeaponDesc().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStatusDesc() == null) ? 0 : getStatusDesc().hashCode());
        result = prime * result + ((getCrmCd1() == null) ? 0 : getCrmCd1().hashCode());
        result = prime * result + ((getCrmCd2() == null) ? 0 : getCrmCd2().hashCode());
        result = prime * result + ((getCrmCd3() == null) ? 0 : getCrmCd3().hashCode());
        result = prime * result + ((getCrmCd4() == null) ? 0 : getCrmCd4().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getCrossStreet() == null) ? 0 : getCrossStreet().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLon() == null) ? 0 : getLon().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drNo=").append(drNo);
        sb.append(", dateRptd=").append(dateRptd);
        sb.append(", dateOcc=").append(dateOcc);
        sb.append(", timeOcc=").append(timeOcc);
        sb.append(", area=").append(area);
        sb.append(", areaName=").append(areaName);
        sb.append(", rptDistNo=").append(rptDistNo);
        sb.append(", part12=").append(part12);
        sb.append(", crmCd=").append(crmCd);
        sb.append(", crmCdDesc=").append(crmCdDesc);
        sb.append(", mocodes=").append(mocodes);
        sb.append(", victAge=").append(victAge);
        sb.append(", victSex=").append(victSex);
        sb.append(", victDescent=").append(victDescent);
        sb.append(", premisCd=").append(premisCd);
        sb.append(", premisDesc=").append(premisDesc);
        sb.append(", weaponUsedCd=").append(weaponUsedCd);
        sb.append(", weaponDesc=").append(weaponDesc);
        sb.append(", status=").append(status);
        sb.append(", statusDesc=").append(statusDesc);
        sb.append(", crmCd1=").append(crmCd1);
        sb.append(", crmCd2=").append(crmCd2);
        sb.append(", crmCd3=").append(crmCd3);
        sb.append(", crmCd4=").append(crmCd4);
        sb.append(", location=").append(location);
        sb.append(", crossStreet=").append(crossStreet);
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}