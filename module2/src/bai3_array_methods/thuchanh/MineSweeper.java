package bai3_array_methods.thuchanh;

import bai5_accessmodifier_static.baitap.Circle;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    public static String[][] insertMatrix(String[][] matrix, int x, int y) {
        int count = 0;
        String boom = "*";
        if (x == 0 & y == 0) {
            if (matrix[y][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x + 1].equals(boom)) {
                count++;
            }
        } else if (x == matrix.length - 1 && y == matrix.length - 1) {
            if (matrix[y - 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y][x - 1].equals(boom)) {
                count++;
            }
        } else if (x == matrix.length - 1 && y == 0) {
            if (matrix[y][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x].equals(boom)) {
                count++;
            }
        } else if (x == 0 && y == matrix.length - 1) {
            if (matrix[y - 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y][x + 1].equals(boom)) {
                count++;
            }
        } else if (x == 0) {
            if (matrix[y + 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x + 1].equals(boom)) {
                count++;
            }
        } else if (y == 0) {
            if (matrix[y][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x + 1].equals(boom)) {
                count++;
            }
        } else if (x == matrix.length - 1) {
            if (matrix[y + 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y][x - 1].equals(boom)) {
                count++;
            }
        } else if (y == matrix.length - 1) {
            if (matrix[y][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x + 1].equals(boom)) {
                count++;
            }
        } else {
            if (matrix[y][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y - 1][x + 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x - 1].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x].equals(boom)) {
                count++;
            }
            if (matrix[y + 1][x + 1].equals(boom)) {
                count++;
            }
        }
        matrix[y][x] = count + "";
        return matrix;
    }

    public static String[][] getMapView(String[][] mapView, String map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("*")) {
                    continue;
                }
                mapView[i][j] = map[i][j];
            }
        }
        return mapView;
    }

    public static String[][] getNewMap(int length) {
        String map[][] = new String[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j] = ".";
            }
        }
        return map;
    }

    public static void printMap(String[][] map) {
        for (String arr[] : map) {
            for (String element : arr) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(String[][] map) {
        for (String arr[] : map) {
            for (String element : arr) {
                if (element.equals(".")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int boomX;
        int boomY;
        String map[][];
        int length;
        do {
            System.out.println("Nhập vào số hàng và cột trong ma trận trò chơi : ");
            length = scanner.nextInt();
        } while (length < 3 || length > 10);
        map = getNewMap(length);
        for (int i = 0; i < map.length; i++) {
            do {
                boomX = random.nextInt(map.length);
                boomY = random.nextInt(map.length);
                if (map[boomY][boomX].equals(".")) {
                    map[boomY][boomX] = "*";
                    break;
                }
            } while (true);
        }
        String mapView[][] = getNewMap(length);
        printMap(mapView);
        do {
            System.out.printf("Nhập X(theo phương ngang 0 -> %d)\n", length - 1);
            int xPosition = scanner.nextInt();
            System.out.printf("Nhập Y(theo phương thẳng đứng 0 -> %d)\n", length - 1);
            int yPosition = scanner.nextInt();
            if (map[yPosition][xPosition].equals("*")) {
                printMap(map);
                System.out.println("You Lose");
                break;
            } else {
                map = insertMatrix(map, xPosition, yPosition);
                mapView = getMapView(mapView, map);
                if (checkWinner(map)) {
                    System.out.println("You Win");
                    printMap(map);
                    break;
                }
            }
            printMap(mapView);
        } while (true);
    }
}
