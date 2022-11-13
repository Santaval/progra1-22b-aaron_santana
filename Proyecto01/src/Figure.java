import java.util.ArrayList;

public class Figure {
// atributes 
// set figure = Cell[]
public ArrayList <Cell> figure = new ArrayList<>(0);
// set type := '\0'
public char type = '\0';

// constructor Figure(type) do 
public Figure (char type) {
    // type := type
    this.type = type;
}// end

// function items() do 
public int items () {
    //return figure(col)
    return figure.size();
}// end


// public void print(){
//     for (int counter = 0; counter < this.figure.size(); counter++){
//         Cell currentCell = figure.get(counter);
//         System.out.printf("%s%s ", currentCell, currentCell.colIndex);
//     }
// }
}
