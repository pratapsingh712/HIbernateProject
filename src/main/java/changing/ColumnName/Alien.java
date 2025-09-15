package changing.ColumnName;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Alien {

    @Id
    private int aid;
    private String aname;
    private String tech;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptop;


//    @Transient // when you do not want to perform database rather some business logic on the field you can mark it as transient
//    private String tech;

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

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
