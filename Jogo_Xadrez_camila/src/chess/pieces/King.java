package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	public boolean testRookCastling(Position position) {
		ChessPiece rook = (ChessPiece)getBoard().piece(position);
		return rook != null && rook instanceof Rook &&  rook.getMoveCount() == 0;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		//acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		//abaixo
		p.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		//esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		//direita
		p.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		//esquerda e para baixo
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		//esquerda e para cima
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		//direita e para baixo
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		//direita e para cima
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().PositionExists(p)) {
			if(!getBoard().ThereIsAPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			} else if(isThereOpponentPiece(p)){
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		
		//jogada especial Castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			//roque pequeno
			p.setValues(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(p)) {
				Position p1 = new Position(position.getRow(),position.getColumn() + 2);
				Position p2 = new Position(position.getRow(),position.getColumn() + 1);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			//roque grande
			p.setValues(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(p)) {
				Position p1 = new Position(position.getRow(),position.getColumn() - 3);
				Position p2 = new Position(position.getRow(),position.getColumn() - 2);
				Position p3 = new Position(position.getRow(),position.getColumn() - 1);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}
		
		return mat;
	}	
	
	@Override
	public String toString() {
		return "K";
	}

}
