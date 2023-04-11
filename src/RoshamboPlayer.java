public class RoshamboPlayer {
    String name, choice;
    int RoLimit, ShamboLimit;
    public RoshamboPlayer(String x, int y, int z) {
        name = x;
        RoLimit = y;
        ShamboLimit = z;
    }
    public String getName() {
        return this.name;
    }
    public boolean playRound(String x) {
        int objChoice = (int) (Math.random() * 100);
        if (objChoice < RoLimit) {//if obj chooses Ro (rock)
            choice = "Ro";
            if(x.equalsIgnoreCase("sham")) { //if player chooses sham (paper)
                return true;
            }
        }
        else if (objChoice >= RoLimit && objChoice < ShamboLimit) {//if obj chooses sham (paper)
            choice = "Sham";
            if (x.equalsIgnoreCase("bo")) { //if player chooses bo (scissors)
                return true;
            }
        }
        else { //if obj chooses Bo
            choice = "Bo";
            if (x.equalsIgnoreCase("Ro")) { //if player chooses Ro (rock)
                return true;
            }
        }
        return false; //player loses or ties obj
    }
}
