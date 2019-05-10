package com.donn.leet;

public class P463 {
    public static void main(String[] args) {
        System.out.println(new P463().islandPerimeter(new int[][] {
            { 0, 1, 0, 0 },
            { 1, 1, 1, 0 },
            { 0, 1, 0, 0 },
            { 1, 1, 0, 0 } }));
    }

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        if (grid.length == 1 && grid[0].length == 1) {
            if (grid[0][0] == 1) {
                return 4;
            } else {
                return 0;
            }
        }

        if (grid.length == 1 || grid[0].length == 1) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        sum += 1;
                    }
                }
            }
            return sum * 2 + 2;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum += 4;
                    if (i == 0 && j == 0) {
                        if (grid[i][j + 1] == 1) {
                            sum -= 1;
                        }
                        if (grid[i + 1][j] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }
                    if (i == 0 && j == grid[0].length - 1) {
                        if (grid[i + 1][j] == 1) {
                            sum -= 1;
                        }
                        if (grid[i][j - 1] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }
                    if (i == grid.length - 1 && j == 0) {
                        if (grid[i][j + 1] == 1) {
                            sum -= 1;
                        }
                        if (grid[i - 1][j] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }
                    if (i == grid.length - 1 && j == grid[0].length - 1) {
                        if (grid[i - 1][j] == 1) {
                            sum -= 1;
                        }
                        if (grid[i][j - 1] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }

                    if (i == 0) {
                        if (grid[i][j - 1] == 1) {
                            sum -= 1;
                        }
                        if (grid[i][j + 1] == 1) {
                            sum -= 1;
                        }
                        if (grid[i + 1][j] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }
                    if (i == grid.length - 1) {
                        if (grid[i][j - 1] == 1) {
                            sum -= 1;
                        }
                        if (grid[i][j + 1] == 1) {
                            sum -= 1;
                        }
                        if (grid[i - 1][j] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }
                    if (j == 0) {
                        if (grid[i + 1][j] == 1) {
                            sum -= 1;
                        }
                        if (grid[i - 1][j] == 1) {
                            sum -= 1;
                        }
                        if (grid[i][j + 1] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }
                    if (j == grid[0].length - 1) {
                        if (grid[i + 1][j] == 1) {
                            sum -= 1;
                        }
                        if (grid[i - 1][j] == 1) {
                            sum -= 1;
                        }
                        if (grid[i][j - 1] == 1) {
                            sum -= 1;
                        }
                        continue;
                    }

                    if (grid[i + 1][j] == 1) {
                        sum -= 1;
                    }
                    if (grid[i - 1][j] == 1) {
                        sum -= 1;
                    }
                    if (grid[i][j + 1] == 1) {
                        sum -= 1;
                    }
                    if (grid[i][j - 1] == 1) {
                        sum -= 1;
                    }
                }
            }
        }

        return sum;
    }
}
