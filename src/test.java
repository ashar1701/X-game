
public class test {
	public static boolean plusMethod(char symbol) {
		int boardSize=4;
		int lengthToWin=5;
		char [][]board= {{'X','O','O','O'},{'O','X','O','O'},{'X','X','X','O'},{'X','X','X','O'}};
		int k=board.length;
		int countHr=0;
		int countHl=0;
		int countVd=0;
		int countVu=0;
		for(int i=1;i<k;i++) {
			for (int j=1;j<k;j++) {
				if (board[i][j]==symbol) {
					int cRight=1;
					while (cRight<k) {
						if (board[i][j+cRight]==symbol) {
							countHr++;
							cRight++;
						}else {
							break;
						}
					}
					int cLeft=1;
					while(cLeft<j) {
						if(board[i][j-cLeft]==symbol) {
							countHl++;
							cLeft++;
						}else {
							break;
						}
					}
					countHl--;
					
					int vDown=1;
					while(vDown<i+1) {
						if(board[i+vDown][j]==symbol) {
							countVd++;
							vDown++;
						}else {
							break;
						}
					}
					int vUp=1;
					while(vUp<i) {
						if (board[i-vUp][j]==symbol) {
							countVu++;
							vUp++;
							
						}else {
							break;
						}
					}
					countVu--;
				}
			}
		}
	
		
		int countTotal=countVu+countVd+countHr+countHl;
		System.out.println(countHr);
		System.out.println(countHl);
		System.out.println(countVd);
		System.out.println(countVu);
		if (countTotal>lengthToWin) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public static void main(String args[]) {
		System.out.print(plusMethod('X'));
	}

}
