package ph.edu.dlsu.mobidev.communipic;

/**
 * Created by Cristopher on 11/10/2016.
 */
public class Pics {

    private String name;
    private int icon;


    public Pics(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
