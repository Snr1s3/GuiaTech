/*Aquest programa a una pilota que cau per el taulell*/
public class Pilota {

    public static  final int N_FILES = 8;

    public static final int N_COLS = 40;

    public static  boolean files=false;
    public static  boolean cols=false;
    

    public static void netejaPantalla() {

        System.out.print("\033[H\033[2J");

        System.out.flush();

    }

    public static void mostraCamp(char[][] camp) {

        for (int i = 0; i < N_FILES; i++) {

            for (int j = 0; j < N_COLS; j++) {

                System.out.print(camp[i][j]);

            }

            System.out.println();

        }

    }

    public static void netejaCamp(char[][] camp) {

        for (int r = 0; r <N_FILES; r++) {
            for (int i = 0; i <N_COLS; i++) {
                if(i==0 || i == N_COLS-1){
                    camp[r][i]='║';
                }
                else if(r==0 || r == N_FILES-1){
                    camp[r][i]='≡';
                }
                else{
                    camp[r][i]=' ';
                }
                
            }
        }

    }

    public static void netejaPosicio(char[][] camp, int fila, int col) {

        netejaCamp(camp);

    }

    public static void posicionaPilota(char[][] camp, int fila, int col) {
        if(fila%2==0){
            camp[fila][col]='0';
        }
        else{  
            camp[fila][col]='O';
        }

    }

    public static int seguentFila(int actual) {
        

        if(actual == N_FILES-2){
            files = true;
        }
        else if(actual == 1){
            files = false;
        }


        if(files == false){
            return actual+1;
        }
        else{
            return actual-1;
        }

       
    }

    public static int seguentCol(int actual) {
        if(actual == N_COLS-2){
           cols = true;
        }
        else if(actual == 1){
            cols = false;
        }


        if(cols == false){
            return actual+1;
        }
        else{
            return actual-1;
        }
    }

    public static void main(String[] args) {
     /*   System.out.println("Files?");
        N_FILES=Integer.parseInt(Entrada.readLine());
        System.out.println("Columnes?");
        N_COLS=Integer.parseInt(Entrada.readLine());*/
        char[][] camp = new char[N_FILES][N_COLS];

        netejaCamp(camp);
        int fila = 0;
        int col =0;

        while(true) {

            posicionaPilota(camp, fila, col);

            netejaPantalla();

            mostraCamp(camp);

            netejaPosicio(camp, fila, col);

            fila = seguentFila(fila);

            col = seguentCol(col);
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // Handle exception
            }
        }

    }

}