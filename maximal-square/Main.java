public class Main {
  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int maxSideLength = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int slideLength = 0;
        if (matrix[i][j] == '1') {
          int slideLengthDown = 0;
          while(j + slideLength < cols && matrix[i][j + slideLength] == '1') {
            slideLength++;
          }

          while(i + slideLengthDown < rows && matrix[i + slideLengthDown][j] == '1' && slideLengthDown < slideLength) {
            int slideRight = 0;
            while(j + slideRight < cols && matrix[i + slideLengthDown][j + slideRight] == '1') slideRight++;
            slideLength = Math.min(slideLength, slideRight);
            slideLengthDown++;
          }
          slideLength = Math.min(slideLength, slideLengthDown);
        }
        maxSideLength = Math.max(maxSideLength, slideLength);
      }
    }
    return maxSideLength * maxSideLength;
  }
  public static void main(String[] args) {
    Main main = new Main();
    char[][] matrix = new char[300][300];
    for(int i = 0; i < 300; i++) {
      for(int j = 0; j < 300; j++) {
        matrix[i][j] = '1';
      }
    }
    // System.out.println(main.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}})); // output 4
    System.out.println(main.maximalSquare(matrix)); // output 900000
  }
}