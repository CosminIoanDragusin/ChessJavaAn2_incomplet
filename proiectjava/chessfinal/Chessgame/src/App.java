public class App {
    public class Pozitie{
        private Piece piece;
        private int x;
        private int y;
        public Spot(int x, int y,Piece piece){
            this.setPiece(piece);
            this.setX(x);
            this.setY(y);
        }
        public Piece getPiece(){
            return this.piece;
        }
        public void setPiece(Piece p){
            this.piece=p;
        }
        public int getX(){
            return this.x;
        }
        public void setX(int x){
            this.x=x;
        }
        public int getY(){
            return this.y;
        }
        public void sety(int y){
            this.y=y;
        }
    }
    public abstract class Piece{
        private boolean killed=false;
        private boolean white=false;
        public Piece(boolean white){
            this.setWhite(white);
        }
        public boolean isWhite(){
            return this.white;
        }
        public boolean iskilled(){
            return this.killed;
        }
        public void setkilled(boolean killed){
            this.killed=killed;
        }
        public abstract boolean canMove(Board board,Spot start,Spot end);
    }
    public class King extends Piece{
        private boolean castlingDone=false;
        public King(boolean white){
            super(white);
            public boolean isCastlingDone(){
                return this.castlingDone;
            }
            public void setCastlingDone(boolean castlingDone){
                this.castlingDone=castlingDone;
            }
            @Override
            public boolean canMove(Board board,Spot start,Spot end){
                if(end.getPiece().isWhite()==this.isWhite()){
                    return false;
                }
                int x=Math.abs(start.getX()-end.getX());
                int y=Math.abs(start.getY()-end.getY());
                if(x+y==1){
                    return true;
                }
                return this.isValidCastling(board,start,end);
            }
            private boolean isValidCastling(Board board,Spot start,Spot end){
                if(this.isCastlingDone()){
                    return false;
                }
            }
            public boolean isCastlingMove(Spot start,Spot end){
                if(start.Spot==end.Spot){
                    return Spot;
                }
            }
            

        }
    }
    
}
