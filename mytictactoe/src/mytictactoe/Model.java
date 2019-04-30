/*
         * To change this license header, choose License Headers in Project Properties.
         * To change this template file, choose Tools | Templates
         * and open the template in the editor.
 */
package mytictactoe;

/**
 *
 * @author Dell
 */
public class Model {

    char[][] board = new char[3][3];
    static int turn;
    int count;
    //x for p1 and 0 for p2

    public Model() {
        count=0;
        for (int i = 0; i < 3; i++) {

            for (int k = 0; k < 3; k++) {
                board[i][k] = '\0';
            }

        }
    }

    void setTurn(int a) {
        turn = a;

    }
    
    int getTurn(){
        return turn;
    
    }

    boolean updateboard(int x, int y) {
        boolean confirm = false;
        count--;
        if (turn == 1) {
            if (board[x][y] != '\0') {
                board[x][y] = 'X';
                confirm = true;
                turn = 2;
            }
        } else if (turn == 2) {
            if (board[x][y] != '\0') {
                board[x][y] = 'O';
                confirm = true;
                turn = 1;
            }

        }

        return confirm;

    }

    int checkstatus() { //-1 no win , 0 for p1 win , 1 for p2 win, 2 for draw, 3 for undecided
        int num = -1;
        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') {
            num = 0;

        } else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') {
            num = 0;

        } else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][1] == 'X') {
            num = 0;

        } else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            num = 0;

        } else if (board[2][2] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            num = 0;

        } else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') {
            num = 0;

        } else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') {
            num = 0;

        } else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') {
            num = 0;

        } else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') {
            num = 1;

        } else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') {
            num = 1;

        } else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][1] == 'O') {
            num = 1;

        } else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
            num = 1;

        } else if (board[2][2] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            num = 1;

        } else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') {
            num = 1;

        } else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') {
            num = 1;

        } else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') {
            num = 1;

        } else {
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    if (board[i][k] != '\0') {
                        num = 3;
                        break;

                    }
                    num = 2;
                }
            }
        }

        return num;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Welcome obj= new Welcome();
        obj.setVisible(true);
        // TODO code application logic here
    }

}
