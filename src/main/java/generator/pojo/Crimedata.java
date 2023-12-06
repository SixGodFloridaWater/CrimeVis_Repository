package generator.pojo;

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
    @TableId
    private Integer drNo;

    /**
     * 
     */
    private String daterptd;

    /**
     * 
     */
    private String dateocc;

    /**
     * 
     */
    private Integer timeocc;

    /**
     * 
     */
    private Integer area;

    /**
     * 
     */
    private String areaname;

    /**
     * 
     */
    private Integer rptdistno;

    /**
     * 
     */
    private Integer part12;

    /**
     * 
     */
    private Integer crmcd;

    /**
     * 
     */
    private String crmcddesc;

    /**
     * 
     */
    private String mocodes;

    /**
     * 
     */
    private Integer victage;

    /**
     * 
     */
    private String victsex;

    /**
     * 
     */
    private String victdescent;

    /**
     * 
     */
    private Integer premiscd;

    /**
     * 
     */
    private String premisdesc;

    /**
     * 
     */
    private Integer weaponusedcd;

    /**
     * 
     */
    private String weapondesc;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String statusdesc;

    /**
     * 
     */
    private Integer crmcd1;

    /**
     * 
     */
    private Integer crmcd2;

    /**
     * 
     */
    private Integer crmcd3;

    /**
     * 
     */
    private String crmcd4;

    /**
     * 
     */
    private String location;

    /**
     * 
     */
    private String crossstreet;

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
            && (this.getDaterptd() == null ? other.getDaterptd() == null : this.getDaterptd().equals(other.getDaterptd()))
            && (this.getDateocc() == null ? other.getDateocc() == null : this.getDateocc().equals(other.getDateocc()))
            && (this.getTimeocc() == null ? other.getTimeocc() == null : this.getTimeocc().equals(other.getTimeocc()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getAreaname() == null ? other.getAreaname() == null : this.getAreaname().equals(other.getAreaname()))
            && (this.getRptdistno() == null ? other.getRptdistno() == null : this.getRptdistno().equals(other.getRptdistno()))
            && (this.getPart12() == null ? other.getPart12() == null : this.getPart12().equals(other.getPart12()))
            && (this.getCrmcd() == null ? other.getCrmcd() == null : this.getCrmcd().equals(other.getCrmcd()))
            && (this.getCrmcddesc() == null ? other.getCrmcddesc() == null : this.getCrmcddesc().equals(other.getCrmcddesc()))
            && (this.getMocodes() == null ? other.getMocodes() == null : this.getMocodes().equals(other.getMocodes()))
            && (this.getVictage() == null ? other.getVictage() == null : this.getVictage().equals(other.getVictage()))
            && (this.getVictsex() == null ? other.getVictsex() == null : this.getVictsex().equals(other.getVictsex()))
            && (this.getVictdescent() == null ? other.getVictdescent() == null : this.getVictdescent().equals(other.getVictdescent()))
            && (this.getPremiscd() == null ? other.getPremiscd() == null : this.getPremiscd().equals(other.getPremiscd()))
            && (this.getPremisdesc() == null ? other.getPremisdesc() == null : this.getPremisdesc().equals(other.getPremisdesc()))
            && (this.getWeaponusedcd() == null ? other.getWeaponusedcd() == null : this.getWeaponusedcd().equals(other.getWeaponusedcd()))
            && (this.getWeapondesc() == null ? other.getWeapondesc() == null : this.getWeapondesc().equals(other.getWeapondesc()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStatusdesc() == null ? other.getStatusdesc() == null : this.getStatusdesc().equals(other.getStatusdesc()))
            && (this.getCrmcd1() == null ? other.getCrmcd1() == null : this.getCrmcd1().equals(other.getCrmcd1()))
            && (this.getCrmcd2() == null ? other.getCrmcd2() == null : this.getCrmcd2().equals(other.getCrmcd2()))
            && (this.getCrmcd3() == null ? other.getCrmcd3() == null : this.getCrmcd3().equals(other.getCrmcd3()))
            && (this.getCrmcd4() == null ? other.getCrmcd4() == null : this.getCrmcd4().equals(other.getCrmcd4()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getCrossstreet() == null ? other.getCrossstreet() == null : this.getCrossstreet().equals(other.getCrossstreet()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLon() == null ? other.getLon() == null : this.getLon().equals(other.getLon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrNo() == null) ? 0 : getDrNo().hashCode());
        result = prime * result + ((getDaterptd() == null) ? 0 : getDaterptd().hashCode());
        result = prime * result + ((getDateocc() == null) ? 0 : getDateocc().hashCode());
        result = prime * result + ((getTimeocc() == null) ? 0 : getTimeocc().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getAreaname() == null) ? 0 : getAreaname().hashCode());
        result = prime * result + ((getRptdistno() == null) ? 0 : getRptdistno().hashCode());
        result = prime * result + ((getPart12() == null) ? 0 : getPart12().hashCode());
        result = prime * result + ((getCrmcd() == null) ? 0 : getCrmcd().hashCode());
        result = prime * result + ((getCrmcddesc() == null) ? 0 : getCrmcddesc().hashCode());
        result = prime * result + ((getMocodes() == null) ? 0 : getMocodes().hashCode());
        result = prime * result + ((getVictage() == null) ? 0 : getVictage().hashCode());
        result = prime * result + ((getVictsex() == null) ? 0 : getVictsex().hashCode());
        result = prime * result + ((getVictdescent() == null) ? 0 : getVictdescent().hashCode());
        result = prime * result + ((getPremiscd() == null) ? 0 : getPremiscd().hashCode());
        result = prime * result + ((getPremisdesc() == null) ? 0 : getPremisdesc().hashCode());
        result = prime * result + ((getWeaponusedcd() == null) ? 0 : getWeaponusedcd().hashCode());
        result = prime * result + ((getWeapondesc() == null) ? 0 : getWeapondesc().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStatusdesc() == null) ? 0 : getStatusdesc().hashCode());
        result = prime * result + ((getCrmcd1() == null) ? 0 : getCrmcd1().hashCode());
        result = prime * result + ((getCrmcd2() == null) ? 0 : getCrmcd2().hashCode());
        result = prime * result + ((getCrmcd3() == null) ? 0 : getCrmcd3().hashCode());
        result = prime * result + ((getCrmcd4() == null) ? 0 : getCrmcd4().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getCrossstreet() == null) ? 0 : getCrossstreet().hashCode());
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
        sb.append(", daterptd=").append(daterptd);
        sb.append(", dateocc=").append(dateocc);
        sb.append(", timeocc=").append(timeocc);
        sb.append(", area=").append(area);
        sb.append(", areaname=").append(areaname);
        sb.append(", rptdistno=").append(rptdistno);
        sb.append(", part12=").append(part12);
        sb.append(", crmcd=").append(crmcd);
        sb.append(", crmcddesc=").append(crmcddesc);
        sb.append(", mocodes=").append(mocodes);
        sb.append(", victage=").append(victage);
        sb.append(", victsex=").append(victsex);
        sb.append(", victdescent=").append(victdescent);
        sb.append(", premiscd=").append(premiscd);
        sb.append(", premisdesc=").append(premisdesc);
        sb.append(", weaponusedcd=").append(weaponusedcd);
        sb.append(", weapondesc=").append(weapondesc);
        sb.append(", status=").append(status);
        sb.append(", statusdesc=").append(statusdesc);
        sb.append(", crmcd1=").append(crmcd1);
        sb.append(", crmcd2=").append(crmcd2);
        sb.append(", crmcd3=").append(crmcd3);
        sb.append(", crmcd4=").append(crmcd4);
        sb.append(", location=").append(location);
        sb.append(", crossstreet=").append(crossstreet);
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}