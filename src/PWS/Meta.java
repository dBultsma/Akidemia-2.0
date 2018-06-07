package PWS;

public class Meta {

    private String key; //variables
    private String value;

    //constructor
    public Meta(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    } //getters

    public String getValue() {
        return value;
    }
}
