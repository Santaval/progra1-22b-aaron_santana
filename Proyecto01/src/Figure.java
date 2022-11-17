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

	public static Figure combine(Figure first, Figure second, char type){
			Figure newFigure = new Figure(type);
			for (int index = 0; index < first.figure.size(); index++){
					if (type == 'L'){
						first.figure.get(index).LFigure = newFigure;
					}
					else {
						first.figure.get(index).TFigure = newFigure;
					}
					newFigure.figure.add(first.figure.get(index));
			}

			for (int index = 0; index < second.figure.size(); index++){
				if (type == 'L'){
					second.figure.get(index).LFigure = newFigure;
				}
				else {
					second.figure.get(index).TFigure = newFigure;
				}
					newFigure.figure.add(second.figure.get(index));
			}

			return newFigure;
	}

	// function isLastOrFirstCell(cell) do
	public boolean isLastOrFirstCell(Cell cell){
		//if cell equals figure[0] or figure[last] do );
		if (cell == this.figure.get(0) || cell == this.figure.get(this.figure.size() - 1)){
			//return true
			return true;
		}// end

		//return false
		return false;
	}//end


	// public void print(){
	//     for (int counter = 0; counter < this.figure.size(); counter++){
	//         Cell currentCell = figure.get(counter);
	//         System.out.printf("%s%s ", currentCell, currentCell.colIndex);
	//     }
	// }
}
