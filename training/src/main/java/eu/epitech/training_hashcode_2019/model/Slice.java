package eu.epitech.training_hashcode_2019.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slice {
    private int row0;
    private int row1;
    private int column0;
    private int column1;

    public int getCellCount() {
        return (Math.abs(row1 - row0) + 1) * (Math.abs(column1 - column0) + 1);
    }
}
