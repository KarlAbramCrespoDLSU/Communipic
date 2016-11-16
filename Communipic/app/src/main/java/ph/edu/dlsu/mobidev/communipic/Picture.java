package ph.edu.dlsu.mobidev.communipic;

/**
 * Created by Cristopher on 11/14/2016.
 */
public class Picture {

    public static final String TABLE = "picture";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PICTUREKEY = "picturekey";
    public static final String CATEGORY = "address";

    private int id;
    private int pictureKey;
    private String name;
    private String category;

    public Picture(){
        // empty
    }

    public Picture(int id, int pictureKey, String name, String category) {
        this.id = id;
        this.pictureKey = pictureKey;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPictureKey() {
        return pictureKey;
    }

    public void setPictureKey(int pictureKey) {
        this.pictureKey = pictureKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
