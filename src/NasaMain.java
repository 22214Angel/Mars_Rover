import java.util.Scanner;

public class NasaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gridLength = scanner.nextInt();
        int gridWidth = scanner.nextInt();
        Rover rover = new Rover(scanner.nextInt(), scanner.nextInt(), scanner.next().charAt(0));
        String sequenceOfMoves = scanner.next();
        char ch;
        char currentDirection;
        int newX, newY;

        final char NORTH_DIRECTION = 'N';
        final char SOUTH_DIRECTION = 'S';
        final char EAST_DIRECTION = 'E';
        final char WEST_DIRECTION = 'W';
        final char MOVE_LEFT = 'L';
        final char MOVE_RIGHT = 'R';
        final char MOVE_AHEAD = 'M';

        for (int i = 0; i < sequenceOfMoves.length(); i++) {
            ch = sequenceOfMoves.charAt(i);
            switch (ch) {
                case MOVE_LEFT:
                    currentDirection = rover.getDirection();
                    if (currentDirection == NORTH_DIRECTION)
                        rover.setDirection(WEST_DIRECTION);
                    if (currentDirection == WEST_DIRECTION)
                        rover.setDirection(SOUTH_DIRECTION);
                    if (currentDirection == SOUTH_DIRECTION)
                        rover.setDirection(EAST_DIRECTION);
                    if (currentDirection == EAST_DIRECTION)
                        rover.setDirection(NORTH_DIRECTION);
                    break;
                case MOVE_RIGHT:
                    currentDirection = rover.getDirection();
                    if (currentDirection == NORTH_DIRECTION)
                        rover.setDirection(EAST_DIRECTION);
                    if (currentDirection == EAST_DIRECTION)
                        rover.setDirection(SOUTH_DIRECTION);
                    if (currentDirection == SOUTH_DIRECTION)
                        rover.setDirection(WEST_DIRECTION);
                    if (currentDirection == WEST_DIRECTION)
                        rover.setDirection(NORTH_DIRECTION);
                    break;
                case MOVE_AHEAD:
                    currentDirection = rover.getDirection();
                    switch (currentDirection) {
                        case EAST_DIRECTION:
                        case WEST_DIRECTION:
                            newX = rover.moveAhead(currentDirection);
                            rover.setX(newX, gridWidth);
                            break;
                        case NORTH_DIRECTION:
                        case SOUTH_DIRECTION:
                            newY = rover.moveAhead(currentDirection);
                            rover.setY(newY, gridLength);
                            break;
                    }
                    break;
            }
        }
        System.out.println(rover.getX() + ", " + rover.getY() + ", " + rover.getDirection());
    }
}