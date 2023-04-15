
//import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;




public abstract  class Tile {
    protected final int tileCoordinate;
    private static final Map<Integer,EmptyTile>EmptyTile=createAllPossibleEmptyTiles();
    
    Tile(int tileCoordinate){
        this.tileCoordinate=tileCoordinate;

    }
    
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer,EmptyTile> EmptyTileMap=new HashMap<>();
        for(int i=0;i<64;i++){
            EmptyTileMap.put(i,new EmptyTile(i));

        }
        Collections.unmodifiableMap(EmptyTileMap);
        Map<Integer, Tile.EmptyTile> ImmutableMap;
        return Map.copyOf(EmptyTileMap);
    }
/*public static Tile createTile(final int tileCoordinate,final Piece piece){
    return piece !=null ? new  OccupiedTile(tileCoordinate,piece) : EmptyTile.createTile(tileCoordinate, piece);
}*/
    public abstract boolean IsTileOcupied();
    public abstract Piece  getPiece();
    public static final class EmptyTile extends Tile{
        EmptyTile(final int coordinate){
            super(coordinate);
        }
        @Override
        public boolean IsTileOcupied(){
            return false;
        }
        @Override
        public Piece getPiece(){
            return null;
        }
        public static final class OccupiedTile extends Tile{
           private final Piece pieceonTile;
            OccupiedTile(int tileCoordinate,Piece pieceOnTile){
                super(tileCoordinate);
                this.pieceonTile=pieceOnTile;
            }
            @Override
            public boolean IsTileOcupied(){
                return true;
            }
            @Override
            public Piece getPiece(){
                return this.pieceonTile;
            }
        }
    }
    
}
