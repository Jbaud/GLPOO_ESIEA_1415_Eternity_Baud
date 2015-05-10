package csv.com.dao;

import java.awt.List;
import java.util.Iterator;


public class Verification {

	public Verification(){
	}

	public boolean checkBoardEdge(Partie[][] board){

		boolean state= true;
		// tests des bords
		if (!(board[0][0].piece.list_face.get(0).type=='B' && board[0][0].piece.list_face.get(3).type=='B')){ 
			state= false;
			return state;
		}
		if (!(board[3][0].piece.list_face.get(0).type=='B' && board[3][0].piece.list_face.get(3).type=='B')){ 
			state= false;
			return state;
		}
		if (!(board[0][3].piece.list_face.get(2).type=='B' && board[0][3].piece.list_face.get(3).type=='B')){ 
			state= false;
			return state;
		}	
		if (!(board[3][3].piece.list_face.get(1).type=='B' && board[3][3].piece.list_face.get(2).type=='B')){ 
			state= false;
			return state;
		}	
		//test haut
		for (int i = 1; i < board.length-1; i++) {

			if (!(board[i][0].piece.list_face.get(0).type=='B') ){ 
				state= false;
				break;
			}
		}
		int i;
		// test gauche
		for (i = 1; i < board.length-1; i++) {

			if (!(board[0][i].piece.list_face.get(3).type=='B') ){ 
				state= false;
				break;
			}
		}
		// test bas
		for (i = 1; i < board.length-1; i++) {

			if (!(board[i][3].piece.list_face.get(2).type=='B') ){ 
				state= false;
				break;
			}
		}
		// test droite
		for (i = 1; i < board.length-1; i++) {

			if (!(board[3][i].piece.list_face.get(1).type=='B') ){ 
				state= false;
				break;
			}
		}
		return state;
	}


	public boolean checkBoard(Partie[][] board){
		boolean state= true;

		if(checkBoard(board) == false)
			return false;

		// les bords ont etes verifies
		for (int i = 0; i < board.length-1; i++) {
			for (int j = 0; j < board.length-1; j++) {
				if (checkOrientationFacesHorizontal(board[i][j],board[i][j+1]) ) {
					return true;
				}
				if (checkOrientationFacesHorizontal(board[i][j],board[i+1][j]) ) {
					return true;
				}
			}
		}
		return state;
	}
	// cette methodte verifie que les deux faces comarees le son bien dans la meme orientation
	public boolean checkOrientationFacesHorizontal(Partie piece1 , Partie piece2){
		char myOr = piece1.position;
		char tempOr = piece2.position;

		for (Face temp : piece1.piece.list_face) {
			if(myOr==tempOr){
				if(!( temp.equals(piece2.piece.list_face.get(3))))
					return true;
			}
			if (tempOr=='N') {
				tempOr='E';
			}
			if (tempOr=='E') {
				tempOr='S';
			}
			if (tempOr=='S') {
				tempOr='O';
			}
			if (tempOr=='O') {
				tempOr='N';
			}
		  }
		return false;
		}
		public boolean checkOrientationFacesVertical(Partie piece1 , Partie piece2){
			char myOr = piece1.position;
			char tempOr = piece2.position;

			for (Face temp : piece1.piece.list_face) {
				if(myOr==tempOr){

					if(!( temp.equals(piece2.piece.list_face.get(0))))
						return true;
				}
				if (tempOr=='N') {
					tempOr='E';
				}
				if (tempOr=='E') {
					tempOr='S';
				}
				if (tempOr=='S') {
					tempOr='O';
				}
				if (tempOr=='O') {
					tempOr='N';
				}
			}

			return false;
		}


}
