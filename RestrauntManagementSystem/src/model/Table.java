package model;

import enums.TableStatus;

public class Table {
    private int tableNumber;
    private TableStatus tableStatus;

    public Table(int tableNumber, TableStatus tableStatus) {
        this.tableNumber = tableNumber;
        this.tableStatus = TableStatus.VACANT;
    }

    public void updateStatus(TableStatus status) {
        this.tableStatus = status;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }
}
