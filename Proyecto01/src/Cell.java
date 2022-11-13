public class Cell {
  //atributes 
	// set rowIndex := 0
	private int rowIndex = 0;
  // set colIndex := 0
	private int colIndex  = 0;
  // set type := '\0'
	private char type = '\0';
  // set color := '\0'
	private char color = '\0';
  // set TYPES := "RVHWB"
	private final String TYPES = "RVHWB";
  // set COLORS := "123456"
	private final String COLORS = "123456";

  // constructor Cell(cellString, rowIndex, colIndex) do
	public Cell (String cellString, int rowIndex, int colIndex){ 
  // rowIndex := rowIndex
	this.rowIndex = rowIndex;
  // colIndex := colIndex
	this.colIndex = colIndex;
  // type := cellString[0]
	this.type = cellString.charAt(0);
  // color := cellString[1]
	this.color = cellString.charAt(1);
  }// end

  // function validate () do
	public boolean validate(){
		// if TYPES have type AND COLORS have color do 
		if (TYPES.contains(this.type + "") && COLORS.contains(this.color + "")){
			// return true
			return true;
		}// end
		// return false
		return false;
  }

	public char getType(){
		return this.type;
	}

	public char getColor(){
		return this.color;
	}

}
