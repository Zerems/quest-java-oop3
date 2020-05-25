public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    //le décollage se fait à partir du sol : 
    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0){
            this.flying = true;
            System.out.printf("%s take off in the sky.%n", this.getName());
        }

    }

    /**
     * prise d'altitude
     * @param meters altitude augmente
     * @return atitude
     */
    @Override   
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude + meters, 0);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    // glisse dans les airs
    @Override
    public void glide(){
        if (!this.flying && this.altitude > 0){
            this.flying = true;
            System.out.printf("It glide into the air.");
        }
    }

    /**
     * baisse d'altitude
     * @param meters altitude diminue
     * @return altitude
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }
    //l'aterrisage se fait sur le sol :
    @Override
    public void land() {
        if (this.flying && this.altitude == 1) {
            System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't lands.%n", this.getName());
        }
    }

}
