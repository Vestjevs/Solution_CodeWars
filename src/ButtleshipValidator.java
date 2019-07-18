public class ButtleshipValidator {

    // FIXME: 04.07.19

    public boolean fieldValidator(int[][] field) {
        boolean result = false;
        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if ((x > 0 && y > 0) && (x < field.length - 1 && y < field.length - 2)) {
                    result = checkSubmarines(y, x, field) || result;
                } else if ((field.length - y - 1 >= 2 && y > 0) && (x > 0 && x < field.length - 2)) {
                    result = checkDestroyersHorizontal(y, x, field) || result;
                } else if ((field.length - y - 1 >= 3 && y > 0) && (x > 0 && x < field.length - 2)) {
                    result = checkCruisersHorizontal(y, x, field) || result;
                } else if ((field.length - y - 1 >= 4 && y > 0) && (x > 0 && x < field.length - 2)) {
                    result = checkButtleshipHorizontal(y, x, field) || result;
                } else if ((field.length - 1 - x >= 2 && x > 0) && (y > 0 && y < field.length - 2)) {
                    result = checkDestroyersVertical(y, x, field);
                } else if ((field.length - 1 - x >= 3 && x > 0) && (y > 0 && y < field.length - 2)) {
                    result = checkCruisersVertical(y, x, field);
                } else if ((field.length - 1 - x >= 4 && x > 0) && (y > 0 && y < field.length - 2)) {
                    result = checkButtleshipVertical(y, x, field);
                }
            }
        }

        return result;
    }


    // direction :: true <- Horizontal ; false <- Vertical
    private boolean checkWayOnEmptiness(int y, int x, int[][] field, int length, boolean direction) {
        boolean result = true;
        if (direction) {
            for (int i = 0; i < length; i++) {
                if (field[y][x + i] == 1) {
                    result = false;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (field[y + i][x] == 1) {
                    result = false;
                }
            }
        }
        return result;
    }

    // direction :: true <- Horizontal ; false <- Vertical
    private boolean checkWayOnBusy(int y, int x, int[][] field, int length, boolean direction) {
        boolean result = true;
        if (direction) {
            for (int i = 0; i < length; i++) {
                if (field[y][x + i] == 0) {
                    result = false;
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (field[y + i][x] == 0) {
                    result = false;
                }
            }
        }
        return result;
    }


    private boolean checkLeftAndRight(int y, int x, int[][] field) {
        return field[y - 1][x] == 0 && field[y][x] == 1 && field[y + 1][x] == 0;
    }

    private boolean checkLeftOrRight(int x, int y, int[][] field) {
        return ((field[x - 1][y] == 0 && field[x][y] == 1) || field[x + 1][y] == 0) ||
                (field[x - 1][y] == 0 || (field[x][y] == 1 && field[x + 1][y] == 0));
    }

    private boolean checkUpAndDown(int y, int x, int[][] field) {
        return field[y][x - 1] == 0 && field[y][x] == 1 && field[y][x + 1] == 0;
    }

    private boolean checkUpOrDown(int x, int y, int[][] field) {
        return ((field[x][y - 1] == 0 && field[x][y] == 1) || field[x][y + 1] == 0) ||
                (field[x][y - 1] == 0 || (field[x][y] == 1 && field[x][y + 1] == 0));
    }

    private boolean checkBorder(int x, int y, int[][] field) {
        return x >= 0 && y >= 0 && x < field.length && y < field.length;
    }

    private boolean checkSubmarines(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x - 1][y] == 0 && field[x][y - 1] == 0 && field[x][y - 1] == 0 && field[x + 1][y] == 0 &&
                field[x - 1][y - 1] == 0 && field[x - 1][y + 1] == 0 && field[x + 1][y + 1] == 0 && field[x + 1][y - 1] == 0;
    }

//    private boolean checkAdjacentByAngleSubmarines(int x, int y, int[][] field) {
//        return (field[x][y] == 1 && field[x + 1][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x - 1][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x - 1][y - 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y - 1] == 1);
//    }

    private boolean checkDestroyersHorizontal(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x + 1][y] == 1 && field[x - 1][y] == 0 && field[x - 1][y - 1] == 0 &&
                field[x][y - 1] == 0 && field[x + 1][y - 1] == 0 && field[x + 2][y - 1] == 0 && field[x + 2][y] == 0 &&
                field[x + 2][y + 1] == 0 && field[x + 1][y + 1] == 0 && field[x][y + 1] == 0 && field[x - 1][y + 1] == 0;
    }

//    private boolean checkAdjacentByAngleDestroyersHorizontal(int x, int y, int[][] field) {
//        return (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y - 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x - 1][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x - 1][y - 1] == 1);
//    }
//
//    private boolean checkAdjacentByEdgeDestroyersHorizontal(int x, int y, int[][] field) {
//        return checkUpAndDown(x, y, field) || checkUpAndDown(x + 1, y, field);
//    }

    private boolean checkDestroyersVertical(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x - 1][y] == 0 && field[x + 1][y] == 0 &&
                field[x][y + 1] == 1 && field[x - 1][y + 1] == 0 && field[x + 1][y + 1] == 0 &&
                field[x][y - 1] == 0 && field[x - 1][y - 1] == 0 && field[x + 1][y - 1] == 0 &&
                field[x][y + 2] == 0 && field[x - 1][y + 2] == 0 && field[x + 1][y + 2] == 0;
    }

//    private boolean checkAdjacentByEdgeDestroyersVertical(int x, int y, int[][] field) {
//        return checkLeftAndRight(x, y, field) || checkLeftAndRight(x, y + 1, field);
//    }
//
//    private boolean checkAdjacentByAngleDestroyersVertical(int x, int y, int[][] field) {
//        return (field[x][y] == 1 && field[x][y + 1] == 1 && field[x + 1][y - 1] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x + 1][y - 2] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x - 1][y - 2] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x - 1][y - 1] == 1);
//    }

    private boolean checkCruisersVertical(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x - 1][y] == 0 && field[x + 1][y] == 0 &&
                field[x][y + 1] == 1 && field[x - 1][y + 1] == 0 && field[x + 1][y + 1] == 0 &&
                field[x][y - 1] == 0 && field[x - 1][y - 1] == 0 && field[x + 1][y - 1] == 0 &&
                field[x][y + 2] == 1 && field[x - 1][y + 2] == 0 && field[x + 1][y + 2] == 0 &&
                field[x][y + 3] == 0 && field[x - 1][y + 3] == 0 && field[x + 1][y + 3] == 0;
    }

//    private boolean checkAdjacentByAngleCruisersVertical(int x, int y, int[][] field) {
//        return (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x + 1][y - 1] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x + 1][y + 3] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x - 1][y + 3] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x - 1][y - 1] == 1);
//    }
//
//    private boolean checkAdjacentByEdgeCruisersVertical(int x, int y, int[][] field) {
//        return checkLeftAndRight(x, y, field) || checkLeftAndRight(x, y + 1, field) ||
//                checkLeftAndRight(x, y + 2, field);
//    }

    private boolean checkCruisersHorizontal(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y + 1] == 0 && field[x][y - 1] == 0 &&
                field[x + 1][y] == 1 && field[x + 1][y + 1] == 0 && field[x + 1][y - 1] == 0 &&
                field[x + 2][y] == 1 && field[x + 2][y + 1] == 0 && field[x + 2][y - 1] == 0 &&
                field[x - 1][y] == 0 && field[x - 1][y - 1] == 0 && field[x - 1][y + 1] == 0 &&
                field[x + 3][y] == 0 && field[x + 3][y - 1] == 0 && field[x + 3][y + 1] == 0;
    }

//    private boolean checkAdjacentByAngleCruisersHorizontal(int x, int y, int[][] field) {
//        return (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x + 3][y - 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x + 3][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x - 1][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x - 1][y - 1] == 1);
//    }
//
//    private boolean checkAdjacentByEdgeCruisersHorizontal(int x, int y, int[][] field) {
//        return checkUpAndDown(x, y, field) || checkUpAndDown(x + 1, y, field) || checkUpAndDown(x + 2, y, field);
//    }

    private boolean checkButtleshipHorizontal(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y + 1] == 0 && field[x][y - 1] == 0 &&
                field[x + 1][y] == 1 && field[x + 1][y + 1] == 0 && field[x + 1][y - 1] == 0 &&
                field[x + 2][y] == 1 && field[x + 2][y + 1] == 0 && field[x + 2][y - 1] == 0 &&
                field[x + 3][y] == 1 && field[x + 3][y + 1] == 0 && field[x + 3][y - 1] == 0 &&
                field[x - 1][y] == 0 && field[x - 1][y - 1] == 0 && field[x - 1][y + 1] == 0 &&
                field[x + 3][y] == 0 && field[x + 4][y - 1] == 0 && field[x + 4][y + 1] == 0;

    }

//    private boolean checkAdjacentByAngleButtleshipHorizontal(int x, int y, int[][] field) {
//        return (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x + 3][y] == 1 &&
//                field[x + 4][y - 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x + 3][y] == 1 &&
//                        field[x + 4][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x + 3][y] == 1 &&
//                        field[x - 1][y + 1] == 1) ||
//                (field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 1 && field[x + 3][y] == 1 &&
//                        field[x - 4][y - 1] == 1);
//    }
//
//    private boolean checkAdjacentByEdgeButtleshipHorizontal(int x, int y, int[][] field) {
//        return checkUpAndDown(x, y, field) || checkUpAndDown(x + 1, y, field) || checkUpAndDown(x + 2, y, field) ||
//                checkUpAndDown(x + 3, y, field);
//    }

    private boolean checkButtleshipVertical(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x - 1][y] == 0 && field[x + 1][y] == 0 &&
                field[x][y + 1] == 1 && field[x - 1][y + 1] == 0 && field[x + 1][y + 1] == 0 &&
                field[x][y - 1] == 0 && field[x - 1][y - 1] == 0 && field[x + 1][y - 1] == 0 &&
                field[x][y + 2] == 1 && field[x - 1][y + 2] == 0 && field[x + 1][y + 2] == 0 &&
                field[x][y + 3] == 1 && field[x - 1][y + 3] == 0 && field[x + 1][y + 3] == 0 &&
                field[x][y + 4] == 0 && field[x - 1][y + 4] == 0 && field[x + 1][y + 4] == 0;
    }

//    private boolean checkAdjacentByAngleButtleshipVertical(int x, int y, int[][] field) {
//        return (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x][y + 3] == 1 &&
//                field[x + 1][y - 1] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x][y + 3] == 1 &&
//                        field[x + 1][y + 4] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x][y + 3] == 1 &&
//                        field[x - 1][y + 4] == 1) ||
//                (field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 1 && field[x][y + 3] == 1 &&
//                        field[x - 1][y - 1] == 1);
//    }
//
//    private boolean checkAdjacentByEdgeButtleshipVertical(int x, int y, int[][] field) {
//        return checkLeftAndRight(x, y, field) || checkLeftAndRight(x, y + 1, field) ||
//                checkLeftAndRight(x, y + 2, field) || checkLeftAndRight(x, y + 3, field);
//    }

    private boolean checkSubmarinesOnAndle1(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x + 1][y] == 0 && field[x][y + 1] == 0 && field[x + 1][y + 1] == 0;
    }

    private boolean checkSubmarinesOnAngle2(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x - 1][y] == 0 && field[x - 1][y + 1] == 0 && field[x][y + 1] == 0;
    }

    private boolean checkSubmarinesOnAngle3(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y - 1] == 0 && field[x - 1][y - 1] == 0 && field[x - 1][y] == 0;
    }

    private boolean checkSubmarinesOnAngle4(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y - 1] == 0 && field[x + 1][y - 1] == 0 && field[x + 1][y] == 0;
    }

    private boolean checkSubmarinesOnEdge1(int y, int x, int[][] field) {
        return checkLeftAndRight(y, x, field) && field[y][x + 1] == 0;
    }

    private boolean checkSubmarinesOnEdge2(int y, int x, int[][] field) {
        return checkUpAndDown(y, x, field) && field[y - 1][x] == 0;
    }

    private boolean checkSubmarinesOnEdge3(int y, int x, int[][] field) {
        return checkLeftAndRight(y, x, field) && field[y][x - 1] == 0;
    }

    private boolean checkSubmarinesOnEdge4(int y, int x, int[][] field) {
        return checkUpAndDown(y, x, field) && field[y + 1][x] == 0;
    }


    private boolean checkDestroyersOnAngleHorizontal1(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 0 && field[x][y + 1] == 0
                && field[x + 1][y + 1] == 0 && field[x + 2][y + 1] == 0;
    }

    private boolean checkDestroyersOnAngleHorizontal2(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x - 1][y] == 1 && field[x - 2][y] == 0 && field[x][y + 1] == 0
                && field[x - 1][y + 1] == 0 && field[x - 2][y + 1] == 0;
    }

    private boolean checkDestroyersOnAngleHorizontal3(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x - 1][y] == 1 && field[x - 2][y] == 0 && field[x][y - 1] == 0
                && field[x - 1][y - 1] == 0 && field[x - 2][y - 1] == 0;
    }

    private boolean checkDestroyersOnAngleHorizontal4(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 0 && field[x][y - 1] == 0
                && field[x + 1][y - 1] == 0 && field[x + 2][y - 1] == 0;
    }


    private boolean checkDestroyersOnEdgeHorizontal1(int x, int y, int[][] field) {
        return field[x - 1][y] == 0 && field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 0 &&
                field[x - 1][y + 1] == 0 && field[x][y + 1] == 0 && field[x + 1][y + 1] == 0 && field[x + 2][y + 1] == 0;
    }

    private boolean checkDestroyersOnEdgeHorizontal2(int y, int x, int[][] field) {
        return checkUpAndDown(y, x, field) && checkUpAndDown(y - 1, x, field) && field[y - 2][x - 1] == 0 &&
                field[y - 2][x] == 0 && field[y - 2][x + 1] == 0;
    }

    private boolean checkDestroyersOnEdgeHorizontal3(int x, int y, int[][] field) {
        return field[x - 1][y] == 0 && field[x][y] == 1 && field[x + 1][y] == 1 && field[x + 2][y] == 0 &&
                field[x - 1][y - 1] == 0 && field[x][y - 1] == 0 && field[x + 1][y - 1] == 0 && field[x + 2][y - 1] == 0;
    }

    private boolean checkDestroyersOnEdgeHorizontal4(int y, int x, int[][] field) {
        return checkUpAndDown(y, x, field) && checkUpAndDown(y + 1, x, field) && field[y + 1][x - 1] == 0 &&
                field[y + 1][x] == 0 && field[y + 1][x + 1] == 0;
    }


    private boolean checkDestroyersOnAngleVertical1(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 0
                && field[x + 1][y] == 0 && field[x + 1][y + 1] == 0 && field[x + 1][y + 2] == 0;
    }

    private boolean checkDestroyersOnAngleVertical2(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 0
                && field[x - 1][y] == 0 && field[x - 1][y + 1] == 0 && field[x - 1][y + 2] == 0;
    }

    private boolean checkDestroyersOnAngleVertical3(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y - 1] == 1 && field[x][y - 2] == 0
                && field[x - 1][y] == 0 && field[x - 1][y - 1] == 0 && field[x - 1][y - 2] == 0;
    }

    private boolean checkDestroyersOnAngleVertical4(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y - 1] == 1 && field[x][y - 2] == 0
                && field[x + 1][y] == 0 && field[x + 1][y - 1] == 0 && field[x + 1][y - 2] == 0;
    }


    private boolean checkDestroyersOnEdgeVertical1(int y, int x, int[][] field) {
        return checkLeftAndRight(y, x, field) && checkLeftAndRight(y, x + 1, field) && field[y - 1][x + 2] == 0 &&
                field[y][x + 2] == 0 && field[y + 1][x + 2] == 0;
    }

    private boolean checkDestroyersOnEdgeVertical2(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y + 1] == 1 && field[x][y + 2] == 0
                && field[x - 1][y] == 0 && field[x - 1][y + 1] == 0 && field[x - 1][y + 2] == 0;
    }

    private boolean checkDestroyersOnEdgeVertical3(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y - 1] == 1 && field[x][y - 2] == 0
                && field[x - 1][y] == 0 && field[x - 1][y - 1] == 0 && field[x - 1][y - 2] == 0;
    }

    private boolean checkDestroyersOnEdgeVertical4(int x, int y, int[][] field) {
        return field[x][y] == 1 && field[x][y - 1] == 1 && field[x][y - 2] == 0
                && field[x + 1][y] == 0 && field[x + 1][y - 1] == 0 && field[x + 1][y - 2] == 0;
    }


}
