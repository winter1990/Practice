package practice.interview;

import java.util.HashMap;

/**
 * @author Wang, Zihan
 */
public class ExcelDesign {

    HashMap<Integer, HashMap> cellsMap = new HashMap<>();
    public String getValue(int row, int col) {
        HashMap<Integer, Cell> colsMap = cellsMap.get(row);
        if (colsMap == null) {
            return "";
        }
        Cell cell = colsMap.get(col);
        if (cell == null) {
            return "";
        }
        return cell.getValue();

    }

    public void setValue(Cell cell) {
        int row = cell.getRow();
        int col = cell.getCol();

        HashMap<Integer, Cell> colsMap = cellsMap.get(row);
        if (colsMap == null) {
            colsMap = new HashMap<>();
            cellsMap.put(row, colsMap);
        }
        colsMap.put(col, cell);
    }

    class Cell {
        private int row;
        private int col;
        private String value;

        Cell(int row, int col, String value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

