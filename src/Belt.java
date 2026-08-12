public enum Belt {
    GBS(0),
    WHITE(1),
    YELLOW(2),
    ORANGE(3),
    GREEN(4),
    BLUE(5),
    PURPLE(6),
    BROWN(7),
    RED(8),
    BLACK(9);

    private int beltNum;

    Belt(int beltNum) {
        this.beltNum = beltNum;
    }

    public int getBeltNum(){
        return this.beltNum;
    }
}