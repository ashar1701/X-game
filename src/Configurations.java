//configurations class
public class Configurations {
	int boardSize;
	private char[][] board;
	private int lengthToWin;
	private int maxLevels;
	//constructor 
	public Configurations(int board_size,int lengthToWin,int max_levels) {
		
		this.boardSize=board_size;
		this.lengthToWin=lengthToWin;
		this.maxLevels=max_levels;
		
		this.board=new char[boardSize][boardSize];
		for (int i=0;i<boardSize;i++) {
			for (int j=0;j<boardSize;j++) {
				this.board[i][j]=' ';
			}
		}
	}
	//returns an empty hash dictionary
	public HashDictionary createDictionary() {
		int size=7559;
		HashDictionary dict=new HashDictionary(size);
		return dict;
		
	}
	//returns the score of the current configuration in the hashtable
	public int repeatedConfiguration(HashDictionary hashTable) {
		String boardString="";
		for (int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				boardString+=this.board[i][j];
			}
		}
		if (hashTable.get(boardString)!=-1) {
			return hashTable.get(boardString);
		}
		else {
			return -1;
		}
	}
	//adds a configuration into the hash dictionary
	public void addConfiguration(HashDictionary hashDictionary,int score) {
		String boardString="";
		for (int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				boardString+=this.board[i][j];
			}
		}
		Data newData=new Data(boardString,score);
		hashDictionary.put(newData);
	}
	//stores the symbol into a row and column
	public void savePlay(int row, int col, char symbol) {
		this.board[row][col]=symbol;
	}
	
	//returns true or false if a sqaure is empty or no
	public boolean squareIsEmpty(int row, int col) {
		if (this.board[row][col]==' ') {
			return true;	
		}else {
			return false;
		}
	}
	public boolean wins(char symbol) {
	    int k = board.length; // Assume k is the size of the board

	    // Check for X-shape
	    for (int i = 0; i < k; i++) {
	        for (int j = 0; j < k; j++) {
	            if (board[i][j] == symbol) {
	                // Check horizontally right
	                if (j + k - 1 < board.length) {
	                    boolean xHorizontal = true;
	                    for (int c = 1; c < k; c++) {
	                        if (board[i][j + c] != symbol) {
	                            xHorizontal = false;
	                            break;
	                        }
	                    }
	                    if (xHorizontal) return true;
	                }

	                // Check vertically down
	                if (i + k - 1 < board.length) {
	                    boolean xVertical = true;
	                    for (int r = 1; r < k; r++) {
	                        if (board[i + r][j] != symbol) {
	                            xVertical = false;
	                            break;
	                        }
	                    }
	                    if (xVertical) return true;
	                }

	                // Check diagonally down-right
	                if (i + k - 1 < board.length && j + k - 1 < board.length) {
	                    boolean xDiagonalDownRight = true;
	                    for (int d = 1; d < k; d++) {
	                        if (board[i + d][j + d] != symbol) {
	                            xDiagonalDownRight = false;
	                            break;
	                        }
	                    }
	                    if (xDiagonalDownRight) return true;
	                }

	                // Check diagonally down-left
	                if (i + k - 1 < board.length && j - k + 1 >= 0) {
	                    boolean xDiagonalDownLeft = true;
	                    for (int d = 1; d < k; d++) {
	                        if (board[i + d][j - d] != symbol) {
	                            xDiagonalDownLeft = false;
	                            break;
	                        }
	                    }
	                    if (xDiagonalDownLeft) return true;
	                }
	            }
	        }
	    }

	    // Check for +shape
	    for (int i = 0; i < k; i++) {
	        for (int j = 0; j < k; j++) {
	            if (board[i][j] == symbol) {
	                // Check horizontally right
	                if (j + k - 1 < board.length) {
	                    boolean plusHorizontal = true;
	                    for (int c = 1; c < k; c++) {
	                        if (board[i][j + c] != symbol) {
	                            plusHorizontal = false;
	                            break;
	                        }
	                    }
	                    if (plusHorizontal) return true;
	                }

	                // Check vertically down
	                if (i + k - 1 < board.length) {
	                    boolean plusVertical = true;
	                    for (int r = 1; r < k; r++) {
	                        if (board[i + r][j] != symbol) {
	                            plusVertical = false;
	                            break;
	                        }
	                    }
	                    if (plusVertical) return true;
	                }
	            }
	        }
	    }

	    return false; // No X-shape or +shape of at least k length found
	}
}