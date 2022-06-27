import java.util.Scanner;

class Main {
	  
	public static void main(String[] args) {
		
		char[][] board = new char[3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '∙';
			}
		}

		Scanner in = new Scanner(System.in);
    System.out.println("Wpisz nick:");
		System.out.print("Gracz1 (x): ");
		String p1 = in.nextLine();
		System.out.print("Gracz2 (o): ");
		String p2 = in.nextLine();


		boolean player1 = true;


		boolean gameEnded = false;
		while(!gameEnded) {


			drawBoard(board);


			if(player1) {
				System.out.println("Tura "+ p1 + " (x):");
			} else {
				System.out.println("Tura "+ p2 + " (o):");
			}


			char c = '∙';
			if(player1) {
				c = 'x';
			} else {
				c = 'o';
			}


			int row = 0;
			int col = 0;


			while(true) {
				

				System.out.println("Podaj współrzędne (rząd->kolumna): ");
				row = in.nextInt()-1;
				col = in.nextInt()-1;

				if(row < 0 || col < 0 || row > 2 || col > 2) {
					System.out.println("Pole poza planszą");

				} else if(board[row][col] != '∙') {
					System.out.println("Pole zajęte");
				
				} else {
					break;
				}
			
			}

			board[row][col] = c;

			if(playerHasWon(board) == 'x') {
        System.out.println();
				System.out.println(p1 + " wygrywa!");
				gameEnded = true;
			} else if(playerHasWon(board) == 'o') {
        System.out.println();
				System.out.println(p2 + " wygrywa!");
				gameEnded = true;
			} else {
				if(boardIsFull(board)) {
          System.out.println();
					System.out.println("Remis!");
					gameEnded = true;
				} else {

					player1 = !player1;
				}

			}

		}
		drawBoard(board);

  }
	public static void drawBoard(char[][] board) {
    System.out.println();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
        if(j<2)System.out.print("|");
			}
			System.out.println();
      if(i<2)System.out.println("-+-+-");
		}
    System.out.println();
	}

	public static char playerHasWon(char[][] board) {
		
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '∙') {
				return board[i][0];
			}
		}

		for(int j = 0; j < 3; j++) {
			if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '∙') {
				return board[0][j];
			}
		}

		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '∙') {
			return board[0][0];
		}
		if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '∙') {
			return board[2][0];
		}

		return ' ';

	}

	public static boolean boardIsFull(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == '∙') {
					return false;
				}
			}
		}
		return true;
	}
}