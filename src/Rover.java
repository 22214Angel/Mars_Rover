public class Rover {
    int x;
    int y;
    char direction;

    final static int minX = 0, minY = 0;
    final char NORTH_DIRECTION = 'N';
    final char SOUTH_DIRECTION = 'S';
    final char EAST_DIRECTION = 'E';
    final char WEST_DIRECTION = 'W';

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    protected int getX() {
        return x;
    }

    protected void setX(int x, int maxX) {
        if (x < minX || x > maxX) {
            System.out.println("Value of x should be between " + minX + " and " + maxX);
            return;
        }
        this.x = x;
    }

    protected int getY() {
        return y;
    }

    protected void setY(int y, int maxY) {
        if (x < minY || x > maxY) {
            System.out.println("Value of y should be between " + minY + " and " + maxY);
            return;
        }
        this.y = y;
    }

    protected char getDirection() {
        return direction;
    }

    protected void setDirection(char direction) {
        this.direction = direction;
    }

    protected int moveAhead(char direction) {
        switch(direction) {
            case NORTH_DIRECTION:
                return ++y;
            case WEST_DIRECTION:
                return --x;
            case SOUTH_DIRECTION:
                return --y;
            case EAST_DIRECTION:
                return ++x;
        }
        return -1;
    }
}
