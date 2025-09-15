package changing.ColumnName;

import jakarta.persistence.*;

@Entity
@Table(name = "alien_table")
public class Alien {

    @Id
    @Column(name = "alien_Id")
    private int aid;
    @Column(name = "alien_Name")
    private String aname;


    @Transient
    private String tech;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
