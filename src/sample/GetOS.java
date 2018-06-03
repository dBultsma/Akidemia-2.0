package sample;

public class GetOS {

    public String returnOSType() {

        String operatingSystem = System.getProperty("operatingSystem.name").toLowerCase();
        System.out.println("OS system: " + operatingSystem);

        if (operatingSystem.equals("mac")){
            return "MAC";
        }
        else if (operatingSystem.equals("win")) {
            return "WIN";
        }
        else{
            return null;
        }
    }
}
